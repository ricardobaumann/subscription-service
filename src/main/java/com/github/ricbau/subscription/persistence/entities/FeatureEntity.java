package com.github.ricbau.subscription.persistence.entities;

import com.github.ricbau.subscription.domain.core.FeatureType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "features")
@EntityListeners(AuditingEntityListener.class)
public class FeatureEntity {

    @Id
    private String id;
    @NotNull
    @Column(name = "type")
    private FeatureType featureType;
    @NotNull
    @Min(1)
    @Column(name = "usage_limit")
    private Integer usageLimitInDays;
    @NotNull
    @Column(name = "default_price")
    private BigDecimal defaultPrice;
    @Embedded
    @Builder.Default
    private Audit audit = new Audit();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureEntity featureEntity = (FeatureEntity) o;
        return Objects.equals(id, featureEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
