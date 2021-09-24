package avanzada.utadeo.spring.controller;

import avanzada.utadeo.spring.domain.Person;
import avanzada.utadeo.spring.domain.Student;
import avanzada.utadeo.spring.service.PersonService;
import avanzada.utadeo.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class StudentController implements Serializable {

    @Autowired
    private StudentService service;

    @PostMapping("/students")
    public Student save (@RequestBody Student student ){
        return service.save(student);
    }

    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Student student){
        Student result = service.getOne(id);
        result.setName(student.getName());
        result.setCareer(student.getCareer());
        result.setAverage(student.getAverage());
        service.save(result);
    }

    @GetMapping("/students")
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/students/{id}")
    public Student getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
