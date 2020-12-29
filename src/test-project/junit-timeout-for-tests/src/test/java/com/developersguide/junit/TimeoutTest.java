package com.developersguide.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TimeoutTest {
	//This test will always failed :)
    @Test@Timeout(1000)
    public void infinity() {
        while (true) ;
    }

    //This test can't run more than 5 seconds, else failed
    @Test@Timeout(5000)
    public void testSlowMethod() {
        //...
    }
}
