package ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {
	/**
	 * This class represents a 2D axis parallel rectangle.
	 */
	private Point_2D _p1, _p2, _p3, _p4;
	// Constructs a rectangle with the given opposite corners.

	public Rect_2D(Point_2D p1, Point_2D p2) {
		this._p1 = new Point_2D(p1);
		this._p2 = new Point_2D(p2);
		this._p3 = new Point_2D(p1.x(), p2.y());
		this._p4 = new Point_2D(p2.x(),p1.y());

	}

	public Rect_2D(Rect_2D t1) {
		this._p1 = new Point_2D(t1._p1);
		this._p2 = new Point_2D(t1._p2);
		this._p3 = new Point_2D(t1._p3);
		this._p4 = new Point_2D(t1._p4);
	}
	// Checks if the rectangle contains the given point.
	public boolean contains(Point_2D ot) {
		double a =  this.area();
		Triangle_2D t1 = new Triangle_2D(ot, this._p1, this._p3);
		Triangle_2D t2 = new Triangle_2D(ot, this._p1, this._p4);
		Triangle_2D t3 = new Triangle_2D(ot, this._p2, this._p4);
		Triangle_2D t4 = new Triangle_2D(ot, this._p2, this._p3);
		double a1 = t1.area();
		double a2 = t2.area();
		double a3 = t3.area();
		double a4 = t4.area();
		return (a == a1 + a2 + a3 + a4);
	}
	// Calculates the area of the rectangle.

	@Override
	public double area() {
		double height = Math.abs(_p1.x() - _p2.x());
		double width = Math.abs(_p1.y() - _p2.y());
		return height * width;
	}
	// Calculates the perimeter of the rectangle.

	@Override
	public double perimeter() {
		double height = Math.abs(_p1.x() - _p2.x());
		double width = Math.abs(_p1.y() - _p2.y());
		return (2*height + 2*width);
	}
	// Translates the rectangle by the given vector.

	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec);
		_p2.move(vec);
		_p3.move(vec);
		_p4.move(vec);
	}
	// Checks if this rectangle is equal to another object.

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Rect_2D)) return false;
		Rect_2D rect2D = (Rect_2D) o;
		return Objects.equals(get_p1(), rect2D.get_p1()) && Objects.equals(get_p2(), rect2D.get_p2()) && Objects.equals(get_p3(), rect2D.get_p3()) && Objects.equals(get_p4(), rect2D.get_p4());
	}
	// Generates a hash code for this rectangle.

	@Override
	public int hashCode() {
		return Objects.hash(get_p1(), get_p2(), get_p3(), get_p4());
	}
	// Creates a copy of this rectangle.

	@Override
	public GeoShape copy() {
		Point_2D p1 = new Point_2D(this._p1);
		Point_2D p2 = new Point_2D(this._p2);
		Point_2D p3 = new Point_2D(this._p3);
		Point_2D p4 = new Point_2D(this._p4);
		return new Rect_2D(p1, p2);
	}
	// Scales the rectangle relative to the given center point and ratio.

	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center, ratio);
		_p2.scale(center, ratio);
		_p3.scale(center, ratio);
		_p4.scale(center, ratio);
	}
	// Rotates the rectangle around the given center point by the specified angle.

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center, angleDegrees);
		_p2.rotate(center, angleDegrees);
		_p3.rotate(center, angleDegrees);
		_p4.rotate(center, angleDegrees);
	}

	public Point_2D get_p1() {
		return _p1;
	}
	public Point_2D get_p2() {
		return _p2;
	}
	public Point_2D get_p3() {
		return _p3;
	}
	public Point_2D get_p4() {
		return _p4;
	}


	@Override
	public String toString(){
		return _p1.toString() + "," + _p2.toString() + "," + _p3.toString() + "," + _p4.toString();
	}
}
