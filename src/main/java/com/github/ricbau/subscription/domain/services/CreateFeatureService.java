package com.github.ricbau.subscription.domain.services;

import com.github.ricbau.subscription.domain.commands.FeatureCommand;
import com.github.ricbau.subscription.domain.core.Feature;
import com.github.ricbau.subscription.domain.exceptions.CreateFeatureException;
import com.github.ricbau.subscription.domain.mappers.FeatureDomainMapper;
import com.github.ricbau.subscription.domain.operations.CreateFeatureOperation;
import com.github.ricbau.subscription.domain.ports.PersistPort;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateFeatureService implements CreateFeatureOperation {

    private final PersistPort<Feature> featurePersistPort;
    private final FeatureDomainMapper featureDomainMapper;

    @Override
    public Either<CreateFeatureException, Feature> create(FeatureCommand featureCommand) {
        return Try.of(() -> featureDomainMapper.toFeature(featureCommand))
                .andThenTry(featurePersistPort::persist)
                .toEither()
                .mapLeft(CreateFeatureException::new);
    }
}
