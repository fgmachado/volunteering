package ong.sitelgbt.volunteering.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Voluntary voluntary;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Availability> availabilities;

}
