package de.beanfactory.cassandraconfigsample.cassandra;

import de.beanfactory.cassandraconfigsample.cassandra.converter.DateTimeReaderConverter;
import de.beanfactory.cassandraconfigsample.cassandra.converter.DateTimeWriterConverter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCassandraRepositories(basePackages = "de.beanfactory.cassandraconfigsample")
public class CassandraCustomConverter extends AbstractCassandraConfiguration {
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

    @Override
    protected String getKeyspaceName() {
        return "testcase";
    }

    @Override
    public List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace("testcase")
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withNetworkReplication(DataCenterReplication.of("datacenter1", 1));

        return Arrays.asList(specification);
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace("testcase"));
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] { "de.beanfactory.cassandraconfigsample" };
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE;
    }
}