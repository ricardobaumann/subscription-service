package com.github.ricbau.subscription.controllers.mappers;

import com.github.ricbau.subscription.controllers.results.FeatureDetails;
import com.github.ricbau.subscription.controllers.results.ResourcePostResult;
import com.github.ricbau.subscription.domain.core.Feature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface PostResultMapper {
    @Mapping(target = "location", source = "id")
    ResourcePostResult toResult(Feature feature);

    @Mapping(target = "location", source = "id")
    FeatureDetails toFeatureDetails(Feature feature);

    default URI toURI(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
