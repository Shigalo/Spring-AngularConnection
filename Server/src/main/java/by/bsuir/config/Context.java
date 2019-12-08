package by.bsuir.config;

import by.bsuir.Repositories.CommandRepository;
import by.bsuir.Repositories.SubsystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Context {

    private static AnnotationConfigApplicationContext context = null;

    private Context(){}

    public static AnnotationConfigApplicationContext getContext() {
        if(context == null) {
            context = new AnnotationConfigApplicationContext(HibernateConfig.class);
            subsystemRepository = context.getBean(SubsystemRepository.class);
            commandRepository = context.getBean(CommandRepository.class);
        }
        return context;
    }

    @Autowired
    public static SubsystemRepository subsystemRepository;

    @Autowired
    public static CommandRepository commandRepository;

}
