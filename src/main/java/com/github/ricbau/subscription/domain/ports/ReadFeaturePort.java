package com.github.ricbau.subscription.domain.ports;

import com.github.ricbau.subscription.domain.core.Feature;
import com.github.ricbau.subscription.domain.operations.ReadFeatureOperation;

public interface ReadFeaturePort extends ReadPort<Feature>, ReadFeatureOperation {
}
