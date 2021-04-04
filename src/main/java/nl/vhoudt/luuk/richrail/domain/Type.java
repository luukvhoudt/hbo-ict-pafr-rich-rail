package nl.vhoudt.luuk.richrail.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.vhoudt.luuk.richrail.common.BaseEntity;

@Log4j2
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
@Entity
@Table(name = Type.TABLE_NAME)
public class Type extends BaseEntity {
    public static final String TABLE_NAME = "types";

    @NonNull
    @Getter
    @Column(name = "title")
    private String title;

    @Getter
    @OneToMany(mappedBy = "type")
    @JsonIgnore
    protected List<Component> components = new ArrayList<>();
    
    @Getter
    @OneToMany(mappedBy = "type")
    private List<TypeAttribute> attributes = new ArrayList<>();

    public void addComponent(Component component) {
        this.components.add(component);
        log.info("A component was added to the type: \"" + this.getTitle() + "\".");
    }

    public void removeComponent(Component component) {
        this.components.remove(component);
        log.info("A component was removed from the type: \"" + this.getTitle() + "\".");
    }

    public void addAttribute(TypeAttribute attribute) {
        this.attributes.add(attribute);
        log.info("An attribute was added to the type: \"" + this.getTitle() + "\".");
    }

    public void removeAttribute(TypeAttribute attribute) {
        this.attributes.remove(attribute);
        log.info("An attribute was removed from the type: \"" + this.getTitle() + "\".");
    }
}
