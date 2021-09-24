package avanzada.utadeo.spring.controller;

import avanzada.utadeo.spring.domain.Person;
import avanzada.utadeo.spring.domain.Student;
import avanzada.utadeo.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/people")
    public Person save (@RequestBody Person person ){
        return service.save(person);
    }

    @PutMapping("/people/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Person person){
        Person result = service.getOne(id);
        result.setName(person.getName());
        result.setApellido(person.getApellido());
        service.save(result);
    }

    @GetMapping("/people/{id}")
    public Person getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping("/people")
    public List<Person> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/people/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
