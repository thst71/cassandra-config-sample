package de.beanfactory.cassandraconfigsample.cassandra.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class DateTimeReaderConverter implements Converter<Long, LocalDateTime> {
    @Override
    public LocalDateTime convert(Long source) {
        Instant timeOfSecond = Instant.ofEpochSecond(source);
        OffsetDateTime utcDateTime = OffsetDateTime.ofInstant(timeOfSecond, ZoneId.systemDefault());
        return LocalDateTime.from(utcDateTime);
    }
}
