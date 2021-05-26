package de.beanfactory.cassandraconfigsample.cassandra.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeWriterConverter implements Converter<LocalDateTime, Long> {

    @Override
    public Long convert( LocalDateTime source) {
        return ZonedDateTime.of(source, ZoneId.systemDefault()).toEpochSecond();
    }
}
