package de.beanfactory.cassandraconfigsample;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import de.beanfactory.cassandraconfigsample.cassandra.model.Person;
import de.beanfactory.cassandraconfigsample.cassandra.repo.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.cql.CqlTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CassandraConfigSampleApplicationTests {

    @Autowired
    PersonRepository personRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void theCqlTemplateIsProperlyInitialized() {
        List<Person> findAllResult = personRepository.findAll();
        assertEquals(0, findAllResult.size());
    }
}
