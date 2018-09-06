package com.in28minutes.springunittestingwithmockito;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	@Test
	public void jsonAssertTest() throws JSONException {
		String responseFromService = "[{\"id\":10001,\"name\":\"Chocolates\",\"quantity\":25,\"price\":2,\"value\":50},"
				+ "{\"id\":10002,\"name\":\"Biscuits\",\"quantity\":50,\"price\":2,\"value\":100},"
				+ "{\"id\":10003,\"name\":\"Pens\",\"quantity\":25,\"price\":3,\"value\":75},"
				+ "{\"id\":10004,\"name\":\"Pencils\",\"quantity\":25,\"price\":2,\"value\":50}]";

		JSONAssert.assertEquals("[{id:10004,name:Pencils},{},{},{}]", responseFromService, false);

		// Strict true 
		// 1. Checks all elements
		// 2. Order in arrays becomes important

		// Easy to read error messages
	}

}
