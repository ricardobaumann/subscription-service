package com.github.ricbau.subscription.domain.operations;

import com.github.ricbau.subscription.domain.commands.FeatureCommand;
import com.github.ricbau.subscription.domain.core.Feature;
import com.github.ricbau.subscription.domain.exceptions.CreateFeatureException;
import io.vavr.control.Either;

public interface CreateFeatureOperation {
    Either<CreateFeatureException, Feature> create(FeatureCommand featureCommand);
}
