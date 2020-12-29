package com.developersguide.junit;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExpectedExceptionByRuleAnnotation {

    @Test
    public void testDivisionWithException() {
        assertThrows(ArithmeticException.class, () -> {
            thrown.expectMessage(containsString("/ by zero"));

            int i = 1 / 0;
        });

    }

    @Test
    public void testNameNotFoundException() throws UserNotFoundException {
        assertThrows(UserNotFoundException.class, () -> {

		//test message
            thrown.expectMessage(is("Name is empty!"));

        //test detail
            thrown.expect(hasProperty("errCode"));  //make sure getters n setters are defined.
            thrown.expect(hasProperty("errCode", is(666)));

            UserService cust = new UserService();
            cust.findByName("");
        });

    }
}
