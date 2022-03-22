package com.github.ricbau.subscription.domain.operations;

import java.util.List;
import java.util.Optional;

public interface ReadOperation<E> {
    Optional<E> findById(String id);

    List<E> findAll();
}
