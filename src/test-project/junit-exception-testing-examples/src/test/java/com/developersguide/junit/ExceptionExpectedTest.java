package com.developersguide.junit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionExpectedTest {
	@Test
    public void testDivisionWithException() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 1 / 0;
        });
    }

    @Test
    public void testEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> new ArrayList<>().get(0));
    }
}
