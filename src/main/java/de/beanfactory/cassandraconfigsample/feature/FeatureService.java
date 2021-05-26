package de.beanfactory.cassandraconfigsample.feature;

import de.beanfactory.cassandraconfigsample.cassandra.model.Person;
import de.beanfactory.cassandraconfigsample.cassandra.repo.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FeatureService {

    private PersonRepository personRepository;

    public FeatureService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public Person create(String name, String firstName) {
        Person p = new Person();
        p.setId(UUID.randomUUID());
        p.setName(name);
        p.setFirstname(firstName);
        p.setDateOfAppraisal(LocalDateTime.now());

        return personRepository.save(p);
    }

    public Stream<Person> findAll() {
        return personRepository.findAll().stream();
    }
}
