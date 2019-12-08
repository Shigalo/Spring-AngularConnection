import by.bsuir.Entities.Subsystem;
import by.bsuir.Repositories.CommandRepository;
import by.bsuir.Repositories.SubsystemRepository;
import by.bsuir.config.HibernateConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ReposytoryTest {

    @Autowired
    SubsystemRepository subsystemRepository;

    @Autowired
    CommandRepository commandRepository;


    @Before
    public void getEM() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        subsystemRepository = context.getBean(SubsystemRepository.class);
        commandRepository = context.getBean(CommandRepository.class);
    }

    @Test
    public void setSubsystem() {
        Subsystem subsystem = new Subsystem("Test");
        subsystemRepository.save(subsystem);
        getSubsystems();
    }

    @Test
    public void getSubsystems() {
//        for(Subsystem subsystem : subsystemRepository.findAll()) {
        for(Subsystem subsystem : new by.bsuir.Test().getSubsystems()) {
            System.out.println(subsystem);
        }
    }

    @Test
    public void deleteSubsystem() {
        System.out.println("Before:");
        setSubsystem();
        subsystemRepository.deleteByName("Test");
        System.out.println("After:");
        getSubsystems();
    }


}
