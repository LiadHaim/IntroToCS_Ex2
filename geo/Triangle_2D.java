package ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape{
	private Point_2D _p1;
	private Point_2D _p2;
	private Point_2D _p3;
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this._p1 = new Point_2D(p1);
		this._p2 = new Point_2D(p2);
		this._p3 = new Point_2D(p3);
	}
	public Triangle_2D(Triangle_2D t1) {
		this._p1 = new Point_2D(t1._p1);
		this._p2 = new Point_2D(t1._p2);
		this._p3 = new Point_2D(t1._p3);
	}
	/**
	 * Gets all the points of the triangle.
	 *
	 * @return An array containing all the points of the triangle.
	 */
	public Point_2D[] getAllPoints() {
		Point_2D[] points = {this._p1, this._p2, this._p3};
		return points;
	}
	/**
	 * Checks if the triangle contains the given point.
	 *
	 * @param ot The point to check.
	 * @return true if the point is inside the triangle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		double areaOriginal =  area();
		double area1 = new Triangle_2D(ot, _p2, _p1).area();
		double area2 = new Triangle_2D(ot, _p2, _p3).area();
		double area3 = new Triangle_2D(ot, _p1, _p3).area();
		double totalArea = area1 + area2 + area3;
		if (totalArea ==areaOriginal) {
			return true;}
			else {
			return false;
			}

		}
	/**
	 * Calculates the area of the triangle.
	 *
	 * @return The area of the triangle.
	 */
	@Override
	public double area() {
		return areaByPoints(_p1, _p2, _p3);
	}
	/**
	 * Checks if this triangle is equal to another object.
	 *
	 * @param o The object to compare to.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Triangle_2D that)) return false;
		return Objects.equals(_p1, that._p1) && Objects.equals(_p2, that._p2) && Objects.equals(_p3, that._p3);
	}
	/**
	 * Generates a hash code for this triangle.
	 *
	 * @return The hash code for this triangle.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(_p1, _p2, _p3);
	}
	/**
	 * Calculates the area of a triangle using the given points.
	 *
	 * @param p1 The first point of the triangle.
	 * @param p2 The second point of the triangle.
	 * @param p3 The third point of the triangle.
	 * @return The area of the triangle formed by the points.
	 */
	public double areaByPoints(Point_2D p1, Point_2D p2, Point_2D p3){
		double a = (p1.x()*(p3.y()-p2.y()));
		double b = (p2.x()*(p1.y()-p3.y()));
		double c = (p3.x()*(p2.y()-p1.y()));

		return 0.5*Math.abs(a+b+c);}
	/**
	 * Calculates the perimeter of the triangle.
	 *
	 * @return The perimeter of the triangle.
	 */
	@Override
	public double perimeter() {
		double segment1 = _p1.distance(_p2);
		double segment2 = _p2.distance(_p3);
		double segment3 = _p1.distance(_p3);
		return segment1 +segment2 +segment3;
	}
	/**
	 * Translates the triangle by the given vector.
	 *
	 * @param vec The vector by which to translate the triangle.
	 */
	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec);
		_p2.move(vec);
		_p3.move(vec);

	}
	/**
	 * Creates a copy of this triangle.
	 *
	 * @return A copy of this triangle.
	 */
	@Override
	public GeoShape copy() {
		return new Triangle_2D(_p1, _p2, _p3);
	}
	/**
	 * Scales the triangle relative to the given center point and ratio.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The ratio by which to scale the triangle.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center, ratio);
		_p2.scale(center, ratio);
		_p3.scale(center, ratio);

	}
	/**
	 * Rotates the triangle around the given center point by the specified angle.
	 *
	 * @param center        The center point for rotation.
	 * @param angleDegrees  The angle (in degrees) by which to rotate the triangle.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center, angleDegrees);
		_p2.rotate(center, angleDegrees);
		_p3.rotate(center, angleDegrees);

	}
}
