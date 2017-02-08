package com.anand.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class JavaTest {

	List<Integer> integers;
	
	@Before
	public void setup() {
		integers = createIntegerList(1, 5);
	}
	
	@Test
	public void createIntListFromOneToTen() {
		List<Integer> integers = createIntegerList(1, 10);
		assertThat(10, is(integers.size()));
	}
	
	@Test
	public void findMaxFromList() {
		Integer max = integers.stream().map(e->e).max(Integer::compareTo).get();
		assertThat(5, is(max));
	}
	
	@Test
	public void findMinFromList() {
		Integer min = integers.stream().map(e->e).min(Integer::compareTo).get();
		assertThat(1, is(min));
	}
	
	@Test
	public void sortListAsc() {
		integers.sort((o1,o2)->o1.compareTo(o2));
		assertThat(1, is(integers.get(0)));
		assertThat(5, is(integers.get(integers.size()-1)));
	}
	
	@Test
	public void sortListDesc() {
		integers.sort((o1,o2)->o2.compareTo(o1));
		assertThat(5, is(integers.get(0)));
		assertThat(1, is(integers.get(integers.size()-1)));
	}
	
	@Test
	public void filterAllNumberExceptOneFromList() {
		List<Integer> filteredList = integers.stream().filter(e-> e.equals(3)).collect(Collectors.toList());
		assertThat(1, is(filteredList.size()));
		assertThat(3, is(filteredList.get(0)));
	}
	
	@Test
	public void filterOldNumbersAndCollectOnlyEventNumbersFromList() {
		List<Integer> filteredList = integers.stream().filter(e-> e%2==0).collect(Collectors.toList());
		assertThat(2, is(filteredList.size()));
		assertThat(2, is(filteredList.get(0)));
		assertThat(4, is(filteredList.get(1)));
	}
	
	private List<Integer> createIntegerList(int from, int to) {
		return IntStream.rangeClosed(from, to).boxed().collect(Collectors.toList());
	}

}
