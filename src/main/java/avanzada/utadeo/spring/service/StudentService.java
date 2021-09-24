package avanzada.utadeo.spring.service;

import avanzada.utadeo.spring.domain.Student;
import avanzada.utadeo.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAll(){
        return repository.findAll();
    }

    public Student save(Student student){
        return repository.save(student);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Student getOne(Long id){
        Optional<Student> student = repository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

}
