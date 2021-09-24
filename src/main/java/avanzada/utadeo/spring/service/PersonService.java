package avanzada.utadeo.spring.service;

import avanzada.utadeo.spring.domain.Person;
import avanzada.utadeo.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> getAll(){
        return repository.findAll();
    }

    public Person save(Person person){
        return repository.save(person);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Person getOne(Long id){
        Optional<Person> person = repository.findById(id);
        if(person.isPresent()){
            return person.get();
        }
        return null;
    }

}
