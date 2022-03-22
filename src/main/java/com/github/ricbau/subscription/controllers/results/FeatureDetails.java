package com.github.ricbau.subscription.controllers.results;

import com.github.ricbau.subscription.domain.core.FeatureType;

import java.math.BigDecimal;
import java.net.URI;

public record FeatureDetails(
        String id,
        FeatureType featureType,
        Integer usageLimitInDays,
        BigDecimal defaultPrice,
        URI location
) {
}
