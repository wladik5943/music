package by.tms.music.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.mapstruct.control.MappingControl;

import java.util.Collection;

@Data
@Entity
@Table(schema = "music",name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double price;
    @OneToMany(mappedBy = "rate")
    private Collection<Subscription> subscriptions;
}
