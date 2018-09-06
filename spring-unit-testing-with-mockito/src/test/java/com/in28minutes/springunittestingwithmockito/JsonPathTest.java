package com.in28minutes.springunittestingwithmockito;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class JsonPathTest {
	@Test
	public void jsonAssertTest() {
		String responseFromService = "[{\"id\":10001,\"name\":\"Chocolates\",\"quantity\":25,\"price\":2,\"value\":50},"
				+ "{\"id\":10002,\"name\":\"Biscuits\",\"quantity\":50,\"price\":2,\"value\":100},"
				+ "{\"id\":10003,\"name\":\"Pens\",\"quantity\":25,\"price\":3,\"value\":75},"
				+ "{\"id\":10004,\"name\":\"Pencils\",\"quantity\":25,\"price\":2,\"value\":50}]";
		
		ReadContext ctx = JsonPath.parse(responseFromService);
		
		List<Integer> allIds = ctx.read("$..id");
		assertThat(allIds).containsExactly(10001,10002,10003,10004);
		System.out.println(ctx.read("$.length()]").toString());
		System.out.println(ctx.read("$.[2]").toString());
		System.out.println(ctx.read("$.[0:2]").toString());//0 inclusive 2 exclusive
		System.out.println(ctx.read("$[?(@.quantity==50)]").toString());
	}

}
