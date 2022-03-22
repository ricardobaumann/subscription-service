package com.github.ricbau.subscription.domain.ports;

import java.util.List;
import java.util.Optional;

public interface ReadPort<E> {

    Optional<E> findById(String id);

    List<E> findAll();
}
