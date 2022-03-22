package com.github.ricbau.subscription.domain.core;

import java.math.BigDecimal;

public record Feature(String id,
                      FeatureType featureType,
                      Integer usageLimitInDays,
                      BigDecimal defaultPrice) {
}
