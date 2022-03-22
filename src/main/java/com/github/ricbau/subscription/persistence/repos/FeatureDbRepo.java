package com.github.ricbau.subscription.persistence.repos;

import com.github.ricbau.subscription.persistence.entities.FeatureEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureDbRepo extends CrudRepository<FeatureEntity, String> {
    
}
