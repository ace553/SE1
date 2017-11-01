package service;

import static org.junit.Assert.*;

import org.junit.Test;
import static service.DistanceClasses.*;


/**
 * Diese Klasse testet ob die IrDistanceClassificator-Klasse Distanzen größer 0 korrekt, in Abhängigkeit eines Modes,
 * in EntfernungsEnums übersetzt.
 * @author MAX
 */
public class DistanceClassesTest {
	private IDistanceClassificator _distanceService;

	public DistanceClassesTest() {
		_distanceService = new IrDistanceClassificator();
	}

	@Test
	public void id0() {
		char m = 'A';
		DistanceClasses c = CLOSE;
		assertEquals(c, _distanceService.determineDistanceClass(m, 5));
		// Grenzwerte
		assertEquals(c, _distanceService.determineDistanceClass(m, 0));
		assertEquals(c, _distanceService.determineDistanceClass(m, 7));
	}

	@Test
	public void id1() {
		char m = 'A';
		DistanceClasses c = MIDDLE;
		assertEquals(c, _distanceService.determineDistanceClass(m, 10));
		// Grenzwerte
		assertEquals(c, _distanceService.determineDistanceClass(m, 8));
		assertEquals(c, _distanceService.determineDistanceClass(m, 17));
	}

	@Test
	public void id2() {
		char m = 'A';
		DistanceClasses c = FAR;
		assertEquals(c, _distanceService.determineDistanceClass(m, 21));
		// Grenzwerte
		assertEquals(c, _distanceService.determineDistanceClass(m, 19));
		assertEquals(c, _distanceService.determineDistanceClass(m, 24));
	}

	@Test
	public void id3() {
		char m = 'A';
		DistanceClasses c = OFF;
		assertEquals(c, _distanceService.determineDistanceClass(m, 28));
		// Grenzwerte
		assertEquals(c, _distanceService.determineDistanceClass(m, 25));
	}

	@Test
	public void id4() {
		char m = 'B';
		DistanceClasses c = CLOSE;
		assertEquals(c, _distanceService.determineDistanceClass(m, 3));
		// Grenzwerte
		assertEquals(c, _distanceService.determineDistanceClass(m, 0));
		assertEquals(c, _distanceService.determineDistanceClass(m, 5));
	}

	@Test
	public void id5() {
		char m = 'B';
		DistanceClasses c = MIDDLE;
		assertEquals(c, _distanceService.determineDistanceClass(m, 7));
		// Grenzwerte
		assertEquals(c, _distanceService.determineDistanceClass(m, 6));
		assertEquals(c, _distanceService.determineDistanceClass(m, 9));
	}

	@Test
	public void id6() {
		char m = 'B';
		DistanceClasses c = FAR;
		assertEquals(c, _distanceService.determineDistanceClass(m, 12));
		// Grenzwerte
		assertEquals(c, _distanceService.determineDistanceClass(m, 10));
		assertEquals(c, _distanceService.determineDistanceClass(m, 13));
	}

	@Test
	public void id7() {
		char m = 'B';
		DistanceClasses c = OFF;
		assertEquals(c, _distanceService.determineDistanceClass(m, 20));
		// Grenzwerte
		assertEquals(c, _distanceService.determineDistanceClass(m, 14));
	}

	@Test(expected = Exception.class)
	public void id8() {
		char m = 'A';
		DistanceClasses c = OFF;
		_distanceService.determineDistanceClass(m, -30);
		// Grenzwerte
		_distanceService.determineDistanceClass(m, -1);
		_distanceService.determineDistanceClass(m, Integer.MIN_VALUE);
		
	}
	
	@Test(expected = Exception.class)
	public void id9() {
		char m = 'B';
		DistanceClasses c = OFF;
		_distanceService.determineDistanceClass(m, -30);
		// Grenzwerte
		_distanceService.determineDistanceClass(m, -1);
		_distanceService.determineDistanceClass(m, Integer.MIN_VALUE);
		
	}
	
	
	@Test(expected = Exception.class)
	public void id10() {
		char m = 'C';
		DistanceClasses c = OFF;
		_distanceService.determineDistanceClass(m, 1);
	}
}
