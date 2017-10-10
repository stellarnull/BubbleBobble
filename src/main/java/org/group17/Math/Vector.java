package org.group17.Math;

/**
 * This Class is used for all mathematical calculations concerning Vectors. This
 * includes: Multiplication, Adding and Subtracting and returning the vector
 * representation as a String.
 * 
 * @author Rob
 *
 */
public class Vector {

	private double dX, dY;

	/**
	 * Constructor for creating a Vector.
	 * 
	 * @param dX
	 *            - The X Coordinate of the Vector.
	 * @param dY
	 *            - The Y Coordinate of the Vector.
	 */
	public Vector(double dX, double dY) {
		this.dX = dX;
		this.dY = dY;
	}

	/**
	 * This method returns the X Coordinate of the vector.
	 * 
	 * @return this.dX - The X coordinate of the vector represented as a double.
	 */
	public double getX() {
		return this.dX;
	}

	/**
	 * This method sets the X Coordinate of the vector.
	 * 
	 * @param dX
	 *            - The X Coordinate of the vector represented as a double
	 *            value.
	 */
	public void setX(double dX) {
		this.dX = dX;
	}

	/**
	 * This method returns the Y Coordinate of the vector.
	 * 
	 * @return this.dY - The Y coordinate of the vector represented as a double.
	 */
	public double getY() {
		return this.dY;
	}

	/**
	 * This method sets the Y Coordinate of the vector.
	 * 
	 * @param dY
	 *            - The Y coordinate of the vector represented as a double
	 *            value.
	 */
	public void setY(double dY) {
		this.dY = dY;
	}

	/**
	 * This method lets you multiply the vector with a scalar represented as a
	 * double value.
	 * 
	 * @param dScalar
	 *            - A scalar represented as double value.
	 * @return - The vector multiplied with the scalar.
	 */
	public Vector multiply(double dScalar) {
		return new Vector(dScalar * this.dX, dScalar * this.dY);
	}

	/**
	 * This method lets you add two vectors together and returns two vectors
	 * added.
	 * 
	 * @param vOther
	 *            - A Vector.
	 * @return Vector - A Vector that is the addition of the two vectors
	 *         together.
	 */
	public Vector add(Vector vOther) {
		return new Vector(this.dX + vOther.dX, this.dY + vOther.dY);
	}

	/**
	 * This lets you add the values of another value to this vector.
	 * 
	 * @param vOther
	 *            - The other Vector
	 */
	public void addLocal(Vector vOther) {
		this.dX += vOther.dX;
		this.dY += vOther.dY;
	}

	/**
	 * This method lets you multiply a scalar with this vector.
	 * 
	 * @param dScalar
	 *            - The scalar represented as a double value.
	 */
	public void multiplyLocal(double dScalar) {
		this.dX *= dScalar;
		this.dY *= dScalar;
	}

	/**
	 * This method lets you subtract another vector from this vector.
	 * 
	 * @param vOther
	 *            - A vector.
	 * @return Vector which represents the subtracted vectors.
	 */
	public Vector subtract(Vector vOther) {
		return new Vector(this.dX - vOther.dX, this.dY - vOther.dY);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector) {
			return (((Vector) obj).dX - this.dX) < 0.00000001 
					&& (((Vector) obj).dY - this.dY) < 0.00000001;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Vector( " + this.dX + " , " + this.dY + " )";
	}
}