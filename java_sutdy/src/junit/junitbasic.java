package junit;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class junitbasic {
	
	Calculator cal = new Calculator();
	/*
	@Test : 테스트할 코드
	@BeforEach : 각 테스트 유닛 실행전
	@AfterEach : 각 테스트 유닛 실행후
	@BeforeAll : 전체 테스트 유닛 실행전
	@AfterAll : 전체 테스트 유닛 실행후
	*/
	
	@Test
	@DisplayName("assertEquals 함수")
	public void assertEquals(){
		int n = 4;
		Assertions.assertEquals(4, n);
	}
	
	@Test
	@DisplayName("assertNotEquals 함수")
	public void assertNotEequlas(){
		int n = 3;
		Assertions.assertNotEquals(4, n);
	}
	
	@Test
	@DisplayName("assertArrayEquals 함수")
	public void assertArrayEquals(){
		int[] n = {1,2,3};
		int[] m = {1,2,3};
		Assertions.assertArrayEquals(n, m);
	}
	
	@Test
	@DisplayName("assertIterableEquals 함수")
	public void assertIterableEquals() {
		ArrayList<Integer> listOne = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> listTwo = new ArrayList<>(Arrays.asList(1,2,3));
		Assertions.assertIterableEquals(listOne, listTwo);
	}
	
	@Test
	@DisplayName("assertNotNull 함수")
	public void assertNotNullTest() {
		String notNullString = "ABC";
		
		Assertions.assertNotNull(notNullString);
	}
	
	@Test
	@DisplayName("assertNull 함수")
	public void assertNull(){		
		String nullString = null;
		Assertions.assertNull(nullString, "null이 되어야합니다.");
	}
	
	@Test
	@DisplayName("assertTrue 함수")
	public void assertTrue() {
		
		boolean bool = true;
		Assertions.assertTrue(bool, "true가 나와야해요");//false일경우 메세지
	}
	
	@Test
	@DisplayName("Assert Exception")
	public void assertExceptionTest() {
		NumberFormatException thrown = Assertions
				.assertThrows(NumberFormatException.class, () -> {
					Integer.parseInt("1");
				}, "NumberFormatException error was expected");
	
		Assertions.assertEquals("assertExceptionTest 에러반생", thrown.getMessage());
	}
	
	@Test
	@DisplayName("Assert Exception - ArithMetic")
	public void ArithmeticExceptionTest() {
		ArithmeticException thrown = Assertions
				.assertThrows(ArithmeticException.class, () -> {
					cal.divide(1, 0);
				}, "ArithmeticException error was expected");
	
		Assertions.assertEquals("ArithmeticExceptionTest 에러발생", thrown.getMessage());
	}
	
	@Test
	@DisplayName("Assert All 함수")
	public void assertAllTest() {
		Assertions.assertAll(
			() -> Assertions.assertEquals(4, cal.add(1, 3)),
			() -> Assertions.assertEquals(4, cal.divide(8, 2))
		);
	}
	
}
class Calculator{
	public int add(int a, int b) {return a+b;}
	public int divide(int a, int b) {
		return a/b;
	};
}
