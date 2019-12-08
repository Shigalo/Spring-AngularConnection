package by.bsuir;

import by.bsuir.Entities.Command;
import by.bsuir.Entities.Subsystem;
import by.bsuir.Repositories.CommandRepository;
import by.bsuir.Repositories.SubsystemRepository;
import by.bsuir.config.HibernateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test {

    @Autowired
    SubsystemRepository subsystemRepository;

    @Autowired
    CommandRepository commandRepository;

    public Subsystem getSubsystem(String name) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        subsystemRepository = context.getBean(SubsystemRepository.class);
//        commandRepository = context.getBean(CommandRepository.class);
        return subsystemRepository.getByName(name);
    }

    public List<Subsystem> getSubsystems() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        subsystemRepository = context.getBean(SubsystemRepository.class);
//        commandRepository = context.getBean(CommandRepository.class);
        return subsystemRepository.findAll();
    }

    public void save(Command command) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        subsystemRepository = context.getBean(SubsystemRepository.class);
        commandRepository = context.getBean(CommandRepository.class);
        commandRepository.save(command);
    }

    public Command getLastCommand() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        subsystemRepository = context.getBean(SubsystemRepository.class);
        commandRepository = context.getBean(CommandRepository.class);
        List<Command> list = commandRepository.findAll();
        return list.get(list.size()-1);
    }
}
