import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringsTest {

	@Test
	void uppercase_with4chars() {
		String str = "abcd";
		String actualResult = str.toUpperCase();
		String expectedResult = "ABCD";
		assertEquals(expectedResult, actualResult);
		assertNotNull(expectedResult);
	}

	@Test
	void contains() {
		String str = "abcdefgh";
		boolean actualResult = str.contains("abcd");
		// boolean expectedResult = true;
		// assertEquals(expectedResult, actualResult);
		assertTrue(actualResult);
	}

	@Test
	void arrayEquals() {
		String str = "this is awesome";
		String[] actualResult = str.split(" ");
		String[] expectedResult = new String[] { "this", "is", "awesome" };
		assertArrayEquals(expectedResult, actualResult);
		assertNotSame(actualResult, expectedResult);
	}

	@Test
	void uppercase_withNull_ThrowsException() {
		String str = null;
		assertThrows(NullPointerException.class, () -> {
			str.toUpperCase();
		});
	}

	// StringTest
	// toUpperCase
	// contains
	//

	class Mapping {

	}

	@ParameterizedTest
	@ValueSource(strings = { "Ranga", "Ravi" })
	void testWithStringParameter(String name) {
		assertTrue(name.length() > 0);
	}

	@ParameterizedTest(name = "\"{0}\" capitalized is {1}")
	@CsvSource({ "Hello, HELLO", "dummy, DUMMY" })
	void withCsvSource(String word, String capitalizedWord) {
		assertEquals(capitalizedWord, word.toUpperCase());
	}

	@Test
	@DisplayName("tips")
	void tips() {
		// Neither test classes nor test methods need to be public

	}

	@BeforeAll
	static void tip2() {
		System.out.println("Initialize Database");
		System.out.println("Initialize Framework");
	}

	@AfterAll
	static void tip3() {
		System.out.println("Clean up Database");
		System.out.println("Clean Framework");
	}

	@BeforeEach
	void tip4(TestInfo testInfo) {
		System.out.println("Initialize Data for Specific Tests " + testInfo.getTestMethod());
	}

	@AfterEach
	void tip5(TestInfo testInfo) {
		System.out.println("Clean up Data for Specific Tests " + testInfo.getTestMethod());
	}

	@Test
	@RepeatedTest(10)
	void tip8() {
		System.out.println("Write Readable Tests");
	}

	@Test
	@Disabled
	void timeSensitiveAction() {
		assertTimeout(Duration.ofSeconds(5), () -> {
			for (int i = 1; i < 1000000; i++) {
				int j = i;
				System.out.println(j);
			}
		});
	}

	@Test
	@Disabled
	void tip6() {
		System.out.println("This test is no longer in service");
		System.out.println("You can disable the entire test as well");
	}

	@Test
	@Tag("Production")
	// @IncludeTags("production")
	// @ExcludeTags("production")
	void tip7() {
		System.out.println("You can use tags with tests");
	}

	// Using Suites
	void tip9() {
		System.out.println("You can use tags with tests");
		/*
		 * @RunWith(JUnitPlatform.class)
		 * 
		 * @SelectPackages("com.in28minutes.rest") public class RestPackageSuite { } ```
		 * 
		 * ```
		 * 
		 * @RunWith(JUnitPlatform.class)
		 * 
		 * @SelectClasses({Class1.class, Class2.class, Class3.class}) public class
		 * ListOfClassesSuite { }
		 * 
		 */
	}

	@Nested
	class EmptyStringTests {

		private String str;

		@BeforeEach
		void beforeEach() {
			str = "";
		}

		@Test
		void lengthIsZero() {
			assertEquals(0, str.length());
		}

		@Test
		void uppercaseIsEmpty() {
			assertEquals("", str.toUpperCase());
		}

	}

	@Nested
	class BigStringTests {

		private String str;

		@BeforeEach
		void beforeEach() {
			str = "Some_Big_String";
		}

		@Test
		void lengthIsNotZero() {
			assertEquals(15, str.length());
		}

		@Test
		void uppercaseIsNotEmpty() {
			assertEquals("SOME_BIG_STRING", str.toUpperCase());
		}

	}

}
