package com.github.ricbau.subscription.domain.commands;

import com.github.ricbau.subscription.domain.core.FeatureType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record FeatureCommand(@NotNull FeatureType featureType,
                             @NotNull @Min(1) Integer usageLimitInDays,
                             @NotNull BigDecimal defaultPrice) {
}
