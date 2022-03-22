package com.github.ricbau.subscription.domain.ports;

public interface PersistPort<E> {
    void persist(E entity);
}
