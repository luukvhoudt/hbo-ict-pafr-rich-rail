package nl.vhoudt.luuk.richrail.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import nl.vhoudt.luuk.richrail.common.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE, onConstructor = @__(@PersistenceConstructor))
@Entity
@Table(name = Component.TABLE_NAME)
public class Component extends BaseEntity {
    public static final String TABLE_NAME = "components";

    @NonNull
    @Getter
    @Column(name = "spot")
    private Integer spot;

    @NonNull
    @Getter
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @NonNull
    @Getter
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
}
