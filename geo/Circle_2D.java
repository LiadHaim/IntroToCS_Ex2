package ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 */

public class Circle_2D implements GeoShape{// This class represents a 2D circle in the plane.

	private Point_2D _center;
	private double _radius;
	
	public Circle_2D(Point_2D cen, double rad) {    // Constructs a circle with the given center and radius.
		this._center = new Point_2D(cen);
		this._radius = rad;
	}
	public Circle_2D(Circle_2D c) {    // Constructs a copy of the given circle.
		this(c.getCenter(), c.getRadius());
	}
	public double getRadius() {    // Gets the radius of the circle.
		return this._radius;}
	public Point_2D getCenter(){ return _center;}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Circle_2D circle2D)) return false;
		return Double.compare(circle2D._radius, _radius) == 0 && Objects.equals(_center, circle2D._center);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_center, _radius);
	}

	@Override
	 public String toString() {
		return this.getClass().getSimpleName() + ":" + _center.toString() + this.getRadius();
		}
	// Checks if the circle contains the given point.

	@Override
	public boolean contains(Point_2D ot) {// Check if the distance between the given point and the center is within the radius
		double dist = ot.distance(this._center);
		return dist<=this._radius;}

	// Calculates the area of the circle.

	@Override
	public double area() {
		double r = _radius*_radius;
		return Math.PI*r;

	}
	// Calculates the perimeter of the circle.

	@Override
	public double perimeter() {
		return Math.PI*2*_radius;
	}
	// Translates the circle by the given vector.
	@Override
	public void translate(Point_2D vec) {
		// Translate the center of the circle by adding the corresponding coordinates of the given vector
		_center = new Point_2D(_center.x() + vec.x(), _center.y() + vec.y());
	}
	@Override
	// Creates a copy of this circle.
	public GeoShape copy() {// Create and return a new Circle_2D object with the same center and radius
		return new Circle_2D(_center,_radius);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		_center.scale(center, ratio);
		_radius*=ratio;
	}
	@Override  // Rotates the circle around the given center point by the specified angle.
	public void rotate(Point_2D center, double angleDegrees) {// Rotate the center of the circle around the given center point by the specified angle
		this._center.rotate(center, angleDegrees);
	}
//	public Point_2D[] getAllPoints() {
//		Point_2D[] ans = new Point_2D[1];
//		ans[0] =new Point_2D(this._center);
//		return ans;
//	}
//	public void rotate(Point_2D center, double angleDegrees) {
//		// Calculate the distance from the center to the current point
//		double distance = Math.sqrt(Math.pow(this._center.x() - center.x(), 2) + Math.pow(this._center.y() - center.y(), 2));
//		// Calculate the angle in radians
//		double angleRadians = Math.toRadians(angleDegrees);
//		// Calculate the new coordinates after rotation
//		double newX = center.x() + distance * Math.cos(angleRadians);
//		double newY = center.y() + distance * Math.sin(angleRadians);
//		// Update the center coordinates
//		this._center = new Point_2D(newX, newY);
//	}

}
