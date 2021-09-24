package avanzada.utadeo.spring.repository;

import avanzada.utadeo.spring.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
