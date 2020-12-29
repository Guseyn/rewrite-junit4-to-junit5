package com.developersguide.junit;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThat;

public class TestCaseIgnoreTest {

	@Test
	public void test1() {
		assertThat(1 + 1, is(2));
	}
	
	
	@Test@Disabled
	public void test2() {
		assertThat(1 + 2, is(3));
	}

	@Test
	public void test3() {
		assertThat(1 + 3, is(4));
	}

	
	@Test@Disabled
	public void test4() {
		assertThat(1 + 4, is(5));
	}

	@Test
	public void test5() {
		assertThat(1 + 5, is(6));
	}

}
