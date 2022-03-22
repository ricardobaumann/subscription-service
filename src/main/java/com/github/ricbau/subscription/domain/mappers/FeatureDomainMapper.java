package com.github.ricbau.subscription.domain.mappers;

import com.github.ricbau.subscription.domain.commands.FeatureCommand;
import com.github.ricbau.subscription.domain.core.Feature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FeatureDomainMapper {
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Feature toFeature(FeatureCommand featureCommand);
}
