package ong.sitelgbt.volunteering.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String schedule;

    @ManyToOne
    private DayOfWeek dayOfWeek;

}
