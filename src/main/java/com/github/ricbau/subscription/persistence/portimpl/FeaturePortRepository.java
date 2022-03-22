package com.github.ricbau.subscription.persistence.portimpl;

import com.github.ricbau.subscription.domain.core.Feature;
import com.github.ricbau.subscription.domain.ports.PersistFeaturePort;
import com.github.ricbau.subscription.domain.ports.ReadFeaturePort;
import com.github.ricbau.subscription.persistence.mappers.FeatureEntityMapper;
import com.github.ricbau.subscription.persistence.repos.FeatureDbRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@AllArgsConstructor
public class FeaturePortRepository implements PersistFeaturePort, ReadFeaturePort {

    private final FeatureDbRepo featureDbRepo;
    private final FeatureEntityMapper featureEntityMapper;

    @Override
    public void persist(Feature entity) {
        featureDbRepo.save(featureEntityMapper.toEntity(entity));
    }

    @Override
    public Optional<Feature> findById(String id) {
        return featureDbRepo.findById(id)
                .map(featureEntityMapper::toFeature);
    }

    @Override
    public List<Feature> findAll() {
        return StreamSupport.stream(featureDbRepo.findAll().spliterator(), false)
                .map(featureEntityMapper::toFeature)
                .collect(Collectors.toList());
    }
}
