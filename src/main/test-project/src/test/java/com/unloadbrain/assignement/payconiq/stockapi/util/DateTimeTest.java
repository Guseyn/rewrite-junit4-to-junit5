package com.unloadbrain.assignement.payconiq.stockapi.util;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateTimeTest {

    @Test
    public void shouldReturnCurrentTime() {

        // Given

        long timeDiffBetweenCalls = 10;
        DateTimeUtil dateTimeUtil = new DateTimeUtil();

        // When
        long nowInEpochMilli = dateTimeUtil.getCurrentTimeEpochMilli();

        // Then
        assertTrue(Instant.now().getEpochSecond() - nowInEpochMilli < timeDiffBetweenCalls);
    }
}
