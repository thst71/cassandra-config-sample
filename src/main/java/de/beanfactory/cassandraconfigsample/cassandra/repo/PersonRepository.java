package de.beanfactory.cassandraconfigsample.cassandra.repo;

import de.beanfactory.cassandraconfigsample.cassandra.model.Person;
import org.springframework.data.cassandra.repository.MapIdCassandraRepository;

public interface PersonRepository extends MapIdCassandraRepository<Person> {
}
