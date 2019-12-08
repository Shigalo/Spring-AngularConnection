package by.bsuir.Repositories;

import by.bsuir.Entities.Subsystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubsystemRepository extends JpaRepository<Subsystem, Long> {

    @Transactional
    void deleteByName(String test);

    Subsystem getByName(String name);
}
