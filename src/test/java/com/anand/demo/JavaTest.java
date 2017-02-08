package com.anand.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class JavaTest {

	
	@Test
	public void createIntListFromOneToFive() {
		List<Integer> integers = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
		assertThat(5, is(integers.size()));
	}
	
	@Test
	public void findMaxFromList() {
		List<Integer> integers = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
		Integer max = integers.stream().map(e->e).max(Integer::compareTo).get();
		assertThat(5, is(max));
	}
	
	@Test
	public void findMinFromList() {
		List<Integer> integers = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
		Integer max = integers.stream().map(e->e).min(Integer::compareTo).get();
		assertThat(1, is(max));
	}

}
