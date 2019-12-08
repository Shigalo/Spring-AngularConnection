package by.bsuir.Repositories;

import by.bsuir.Entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CommandRepository extends JpaRepository<Command, Long> {

}
