package ong.sitelgbt.volunteering.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private Integer age;

    private String document;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    private boolean readTheTerm;

    private boolean agreeTheTerm;

    private LocalDateTime disabledOn;

    public void deactivate() {
        disabledOn = LocalDateTime.now();
    }

}
