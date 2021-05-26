package de.beanfactory.cassandraconfigsample.cassandra.converter;

import jnr.constants.platform.Local;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeReaderConverterTest {

    DateTimeReaderConverter dateTimeReaderConverter = new DateTimeReaderConverter();

    @Test
    public void itShouldCreateTheRightTimeFromALong() {
        Instant epoch = Instant.EPOCH;
        ZoneOffset systemOffset = ZoneId.systemDefault().getRules().getOffset(epoch);
        LocalDateTime expectedLocalDT = LocalDateTime.ofEpochSecond(0L, 0, systemOffset);
        LocalDateTime result = dateTimeReaderConverter.convert(expectedLocalDT.toEpochSecond(systemOffset));
        assertEquals(expectedLocalDT, result);
    }

}