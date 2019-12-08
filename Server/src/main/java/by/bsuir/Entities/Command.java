package by.bsuir.Entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Command {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsystem_id")
    private Subsystem subsystem;
    private String command;
    private String resault;
    private String timestamp;

    public Command() {
    }

    public Command(Subsystem subsystem, String command) {
        this.subsystem = subsystem;
        this.command = command;
    }

}
