package com.github.ricbau.subscription.persistence.mappers;

import com.github.ricbau.subscription.domain.core.Feature;
import com.github.ricbau.subscription.persistence.entities.FeatureEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeatureEntityMapper {
    FeatureEntity toEntity(Feature entity);

    Feature toFeature(FeatureEntity featureEntity);
}
