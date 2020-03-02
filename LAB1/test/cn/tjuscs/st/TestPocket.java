package cn.tjuscs.st;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPocket {
	private int input;
	private boolean expected;
	private Pocket pocket = null;
	
	public TestPocket(int input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Before
	public void setUp() {
		pocket = new Pocket();
	}
	
	@Test
	public void testMoneyDecision() {
		assertEquals(this.expected, pocket.moneyDecision(input));
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{43, true},
			{53, true},
			{94, false},
			{48, false},
			{24, false}
		});
	}
}
