package de.beanfactory.cassandraconfigsample.cassandra;

import de.beanfactory.cassandraconfigsample.cassandra.converter.DateTimeReaderConverter;
import de.beanfactory.cassandraconfigsample.cassandra.converter.DateTimeWriterConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;

@Configuration
@EnableCassandraRepositories(basePackages = "de.beanfactory.cassandraconfigsample")
public class CassandraConfiguration {
    @Bean
    CassandraCustomConversions customConversions(DateTimeWriterConverter dateTimeWriterConverter,
            DateTimeReaderConverter dateTimeReaderConverter) {
        return new CassandraCustomConversions(Arrays.asList(dateTimeReaderConverter, dateTimeWriterConverter));
    }

    @Bean
    DateTimeReaderConverter dateTimeReaderConverter() {
        return new DateTimeReaderConverter();
    }

    @Bean
    DateTimeWriterConverter dateTimeWriterConverter() {
        return new DateTimeWriterConverter();
    }
}