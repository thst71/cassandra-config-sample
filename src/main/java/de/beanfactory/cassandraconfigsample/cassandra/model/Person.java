package de.beanfactory.cassandraconfigsample.cassandra.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("person_by_id")
@Data
public class Person {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    UUID id;

    String name;
    String firstname;
    LocalDateTime dateOfAppraisal;

}
