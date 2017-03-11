package ru.job4j.condition;

/**
* Class Triangle.
* @author vivanov
* @since 08.03.2017
* version 1
*/

public class Triangle {

	/**
	* a point field.
	*/
	private Point a;

	/**
	* b point field.
	*/
	private Point b;

	/**
	* c point fied.
	*/
	private Point c;

	/**
	* Triangle class constructor.
	* @param a - point a
	* @param b = point b
	* @param c = point c
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* Calculating sides of triangle and it's area via Heron's formula.
	* @return result of square calculating
	*/
	public double area() {

		// Calculating sides of triangle
		double ab = getDistance(this.a, this.b);
		double bc = getDistance(this.b, this.c);
		double ca = getDistance(this.c, this.a);
		double result = 0.0;

		if ((ab + bc > ca) && (bc + ca > ab) && (ab + ca > bc)) {

			// Calculating semiperimeter
			double p = (ab + bc + ca) / 2;

			// Calculating triangle area
			result = Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
		}
		return result;
	}

	/**
	* Calculating distance between tops of triangle.
	* @param top1 - one of the triangle's top
	* @param top2 - another top of the triangle
	* @return result distance between two tops
	*/
	public double getDistance(Point top1, Point top2) {
		return Math.sqrt((top1.getX() - top2.getX()) * (top1.getX() - top2.getX()) + (top1.getY() - top2.getY()) * (top1.getY() - top2.getY()));
	}

}