package de.beanfactory.cassandraconfigsample.cassandra.converter;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeWriterConverterTest {

    DateTimeWriterConverter dateTimeWriterConverter = new DateTimeWriterConverter();
    @Test
    void itShouldCreateTheRightLongFromTheDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime expectedLocalDT = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        Long expectedSeconds = expectedLocalDT.toEpochSecond();
        Long utcSeconds = dateTimeWriterConverter.convert(localDateTime);
        assertEquals(expectedSeconds, utcSeconds);
    }
}