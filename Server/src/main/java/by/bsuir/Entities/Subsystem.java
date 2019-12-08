package by.bsuir.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Subsystem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    String name;

    public Subsystem(String name) {
        this.name = name;
    }

    public Subsystem() {}
}
