package ex2.geo;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{/**
 * This class represents a 2D segment on the plane.
 */
	private Point_2D _p1, _p2;
	public Segment_2D(Point_2D a, Point_2D b) {
		this._p1 = new Point_2D(a);
		this._p2 = new Point_2D(b);

	}
	public Segment_2D(Segment_2D t1) {
		this._p1 = new Point_2D(t1.get_p1());
		this._p2 = new Point_2D(t1.get_p2());
	}

	public Point_2D get_p1() {
		return new  Point_2D(_p1);
	}
	public Point_2D get_p2() {
		return new Point_2D(_p2);
	}
	private boolean isVertival() {
		return _p1.x() == _p2.x();
	}
	/**
	 * Checks if the segment contains the given point.
	 *
	 * @param ot The point to check.
	 * @return true if the point is on the segment, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		return (this.get_p1().distance(ot) + this.get_p2().distance(ot) == this.get_p1().distance(this.get_p2()));
	}
	/**
	 * Calculates the area of the segment (which is 0).
	 *
	 * @return The area of the segment (always 0).
	 */
	@Override
	public double area() {
		return 0;
	}
	/**
	 * Calculates the perimeter of the segment.
	 *
	 * @return The perimeter of the segment (twice the distance between the start and end points).
	 */
	@Override
	public double perimeter() {
		double dista = _p1.distance(_p2);
		return 2 * dista;
	}
	/**
	 * Translates the segment by the given vector.
	 *
	 * @param vec The vector by which to translate the segment.
	 */
	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec); // Move the start point (p1) of the segment by the given vector
		_p2.move(vec);// Move the end point (p2) of the segment by the given vector

	}
	/**
	 * Creates a copy of this segment.
	 *
	 * @return A copy of this segment.
	 */
	@Override
	public GeoShape copy() {
		return new Segment_2D(this._p1, this._p2);
	}
	/**
	 * Scales the segment relative to the given center point and ratio.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The ratio by which to scale the segment.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center, ratio);
		_p2.scale(center, ratio);
	}
	/**
	 * Rotates the segment around the given center point by the specified angle.
	 *
	 * @param center       The center point for rotation.
	 * @param angleDegrees The angle (in degrees) by which to rotate the segment.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center, angleDegrees);
		_p2.rotate(center, angleDegrees);

	}
	/**
	 * Returns a string representation of the segment in the format "p1,p2".
	 *
	 * @return A string representation of the segment.
	 */
	@Override
	public String toString() {
		return _p1.toString() + "," + _p2.toString();
	}
}