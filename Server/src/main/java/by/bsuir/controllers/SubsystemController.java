package by.bsuir.controllers;

import by.bsuir.Entities.Command;
import by.bsuir.Entities.Subsystem;
import by.bsuir.Repositories.CommandRepository;
import by.bsuir.Repositories.SubsystemRepository;
import by.bsuir.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@Controller("/subsystem")
@CrossOrigin(origins = "http://localhost:4200")
public class SubsystemController {


    @Autowired
    SubsystemRepository subsystemRepository;

    @Autowired
    CommandRepository commandRepository;

    private List<Subsystem> list = new LinkedList<Subsystem>();
/*
    @GetMapping
    public @ResponseBody ResponseEntity<Subsystem> getMethod(@RequestBody String name) {
        return ResponseEntity.ok(new Subsystem(name*//*, "/subsystem/" + name*//*));
    }*/

    @PostMapping
    public @ResponseBody ResponseEntity<Command> save(@RequestParam String massage, String subsystem_name) {

        System.out.println(subsystem_name);
        Subsystem subsystem = new Test().getSubsystem(subsystem_name);
        System.out.println(massage);
        Command command = new Command(subsystem, massage);
        new Test().save(command);
        return ResponseEntity.ok(new Test().getLastCommand());
    }

    @GetMapping//("/get")
    public @ResponseBody ResponseEntity<List<Subsystem>> get() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        subsystemRepository = context.getBean(SubsystemRepository.class);
//        commandRepository = context.getBean(CommandRepository.class);
//        List<Subsystem> list = subsystemRepository.findAll();
        list = new Test().getSubsystems();
        return ResponseEntity.ok(list);
    }
}
