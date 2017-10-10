package org.group17.Math;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.group17.Units.Enemy;
import org.group17.Map.GameMap;;

/**
 * This class tests the class Vector.
 * 
 * @author Cas
 *
 */
public class TestVector {

	/**
	 * This method checks if the constructor works.
	 */
	@Test
	public void testConstructor() {
		assertTrue(1.0 == new Vector(1.0, 2.0).getX());
		assertTrue(2.0 == new Vector(1.0, 2.0).getY());
	}

	/**
	 * This method tests if the Set Y gives the correct result.
	 */
	@Test
	public void testSetY() {
		Vector v = new Vector(1.0, 2.0);
		v.setY(1.0);
		assertTrue(1.0 == v.getY());
	}

	/**
	 * This method tests if the Set Y doesn't set a default value.
	 */
	@Test
	public void testSetYFalseValue() {
		Vector v = new Vector(1.0, 2.0);
		v.setY(1.0);
		assertFalse(2.0 == v.getY());
	}

	/**
	 * This tests if the Set X sets the right value.
	 */
	@Test
	public void testSetX() {
		Vector v = new Vector(1.0, 2.0);
		v.setX(2.0);
		assertTrue(2.0 == v.getX());
	}

	/**
	 * This tests if the Set X doesn't set default value.
	 */
	@Test
	public void testSetXFalseValue() {
		Vector v = new Vector(1.0, 2.0);
		v.setX(2.0);
		assertFalse(1.0 == v.getX());
	}

	/**
	 * This method tests if the toString() method returns the right string
	 * representation.
	 */
	@Test
	public void testToString() {
		assertEquals("Vector( 1.0 , 2.0 )", new Vector(1.0, 2.0).toString());
	}

	/**
	 * This method tests if the multiplication method returns the right Vector.
	 */
	@Test
	public void testMultiplyGivesCorrectResult() {
		Vector v = new Vector(1.0, 2.0);
		Vector v2 = v.multiply(2.0);
		assertEquals("Vector( 2.0 , 4.0 )", v2.toString());
	}

	/**
	 * This test checks if the multiplication method doesn't return a default
	 * value.
	 */
	@Test
	public void testMultiplyGivesFalseValue() {
		Vector v = new Vector(1.0, 2.0);
		v.multiply(2.0);
		assertFalse("Vector( 3.0 , 5.0 )".equals(v.toString()));
	}

	/**
	 * Thhis method tests if the addition method returns the right vector.
	 */
	@Test
	public void testAdditionGivesCorrectResult() {
		Vector v = new Vector(1.0, 2.0);
		Vector v2 = new Vector(2.0, 1.0);
		Vector v3 = v.add(v2);
		assertEquals("Vector( 3.0 , 3.0 )", v3.toString());
	}

	/**
	 * This test checks if the addition method doesn't return a default value.
	 */
	@Test
	public void testAdditionGivesFalseValue() {
		Vector v = new Vector(1.0, 2.0);
		Vector v2 = new Vector(2.0, 1.0);
		Vector v3 = v.add(v2);
		assertFalse("Vector( 2.0 , 2.0 )".equals(v3.toString()));
	}

	/**
	 * This test checks if the addition locally adds the other vector to the
	 * local vector.
	 */
	@Test
	public void testAdditionLocalGivesCorrectResult() {
		Vector v = new Vector(1.0, 2.0);
		Vector v2 = new Vector(2.0, 1.0);
		v.addLocal(v2);
		assertEquals("Vector( 3.0 , 3.0 )", v.toString());
	}

	/**
	 * This test checks if the addition locally doesn't add a default value.
	 */
	@Test
	public void testAdditionLocalGivesFalseValue() {
		Vector v = new Vector(1.0, 2.0);
		Vector v2 = new Vector(2.0, 1.0);
		v.addLocal(v2);
		assertFalse("Vector( 2.0 , 4.0 )".equals(v.toString()));
	}

	/**
	 * This test checks if the multiplication locally gives the correct result.
	 */
	@Test
	public void testMultiplyLocalGivesCorrectResult() {
		Vector v = new Vector(1.0, 2.0);
		v.multiplyLocal(2.0);
		assertEquals("Vector( 2.0 , 4.0 )", v.toString());
	}

	/**
	 * This test checks if the multiplication locally doesn't multiply with a
	 * default value.
	 */
	@Test
	public void testMultiplyLocalGivesFalseValue() {
		Vector v = new Vector(1.0, 2.0);
		v.multiplyLocal(2.0);
		assertFalse("Vector( 1.0 , 3.0 )".equals(v.toString()));
	}

	/**
	 * This method checks if the substract method returns the right vector.
	 */
	@Test
	public void testSubstractGivesCorrectResult() {
		Vector v = new Vector(1.0, 2.0);
		Vector v2 = new Vector(1.0, 2.0);
		Vector v3 = v.subtract(v2);
		assertEquals("Vector( 0.0 , 0.0 )", v3.toString());
	}

	/**
	 * This test checks if the substract method doesn't substract a default
	 * value.
	 */
	@Test
	public void testSubstractGivesFalseValue() {
		Vector v = new Vector(1.0, 2.0);
		Vector v2 = new Vector(1.0, 2.0);
		Vector v3 = v.subtract(v2);
		assertFalse("Vector( 1.0 , 2.0 )".equals(v3.toString()));
	}

	/**
	 * Tests if equals returns false when comparing two different objects.
	 */
	@Test
	public void testEqualsWithNoVector() {
		Enemy e = new Enemy(new Vector(1, 1), new GameMap());
		assertFalse(new Vector(1, 1).equals(e));
	}

	/**
	 * Tests if equals returns false if X is different.
	 */
	@Test
	public void testEqualsFalseX() {
		assertFalse(new Vector(1.0, 2.0).equals(new Vector(1.1, 2.0)));
	}

	/**
	 * Tests if equals returns false if Y is different.
	 */
	@Test
	public void testEqualsFalseY() {
		assertFalse(new Vector(1.0, 2.0).equals(new Vector(1.0, 2.1)));
	}

	/**
	 * Tests if equals returns true.
	 */
	@Test
	public void testEqualsTrue() {
		assertFalse(new Vector(1.0, 2.0).equals(new Vector(1.1, 2.0)));
	}
}