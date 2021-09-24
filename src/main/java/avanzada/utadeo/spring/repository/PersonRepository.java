package avanzada.utadeo.spring.repository;

import avanzada.utadeo.spring.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {



}
