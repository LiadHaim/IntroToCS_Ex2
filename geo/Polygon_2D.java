package ex2.geo;

import java.util.ArrayList;
import java.util.Objects;

public class Polygon_2D implements GeoShape {
	// This class represents a 2D polygon.

	private ArrayList<Point_2D> arrayOfPoints;
	// Constructs an empty polygon.

	public Polygon_2D() {
		this.arrayOfPoints = new ArrayList<Point_2D>();
	}

	public Polygon_2D(Polygon_2D po) {
		this.arrayOfPoints = new ArrayList<>(po.arrayOfPoints);
	}
	// Returns an array containing all points of the polygon.

	public Point_2D[] getAllPoints() {
		Point_2D[] p1 = new Point_2D[this.arrayOfPoints.size()];
		for (int i=0; i< arrayOfPoints.size(); i++){
			p1[i] = arrayOfPoints.get(i);
		}
		return p1;
	}
	// Adds a point to the polygon.

	public void add(Point_2D p) {
		this.arrayOfPoints.add(p);
	}

	@Override
	public String toString() {
		String string = "All points: ";
		for (int i = 0; i < arrayOfPoints.size() - 1; i++) {
			Point_2D point = arrayOfPoints.get(i);
			string += "(" + point.x() + "," + point.y() + "), ";
		}
		string += "(" + arrayOfPoints.get(arrayOfPoints.size() - 1).x() + "," + arrayOfPoints.get(arrayOfPoints.size() - 1).y() + ")";

		return string;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Polygon_2D polygon2D)) return false;
		return Objects.equals(arrayOfPoints, polygon2D.arrayOfPoints);
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrayOfPoints);
	}
	// Checks if the polygon contains the given point.

	@Override
	public boolean contains(Point_2D ot) {
		int n = arrayOfPoints.size();
		Point_2D outside = new Point_2D(Double.MAX_VALUE, ot.y());
		int count = 0;

		for (int i = 0, j = n - 1; i < n; j = i++) {
			if ((arrayOfPoints.get(i).y() > ot.y()) != (arrayOfPoints.get(j).y() > ot.y()) &&
					ot.x() < (arrayOfPoints.get(j).x() - arrayOfPoints.get(i).x()) * (ot.y() - arrayOfPoints.get(i).y()) / (arrayOfPoints.get(j).y() - arrayOfPoints.get(i).y()) + arrayOfPoints.get(i).x()) {
				count++;
			}
		}

		return count % 2 == 1;
	}

	// Calculates the area of the polygon.

	@Override
	public double area() {
		double S_X = 0;
		double S_Y = 0;
		for (int i = 0; i < this.arrayOfPoints.size(); i++) {
			S_X += this.arrayOfPoints.get(i).x() * this.arrayOfPoints.get((i + 1) % this.arrayOfPoints.size()).y();
			S_Y += this.arrayOfPoints.get(i).y() * this.arrayOfPoints.get((i + 1) % this.arrayOfPoints.size()).x();
		}
		return (0.5 * Math.abs(S_X-S_Y));

	}
	// Calculates the perimeter of the polygon.

	@Override
	public double perimeter() {
		Point_2D[] points = getAllPoints();
		if (points.length < 2){
			return 0;
		}
		double perimeter = 0.0;
		for (int i = 0; i < points.length - 1; i++) {
			perimeter += points[i].distance(points[i + 1]);
		}
		perimeter += points[points.length - 1].distance(points[0]);

		return perimeter;
	}
	// Translates the polygon by the given vector.

	@Override
	public void translate(Point_2D vec) {
		for (int i = 0; i < arrayOfPoints.size() - 1; i++) {
			arrayOfPoints.get(i).move(vec);
		}

	}
	// Creates a copy of this polygon.

	@Override
	public GeoShape copy() {
//		Polygon_2D polygon = new Polygon_2D();
//		for (int i = 0; i < arrayOfPoints.size() - 1; i++) {
//			Point_2D p = new Point_2D(arrayOfPoints.get(i).x(), arrayOfPoints.get(i).y());
//			polygon.add(p);
//		}
//		return polygon;
		return new Polygon_2D(this);
	}
	// Scales the polygon relative to the given center point and ratio.

	@Override
	public void scale(Point_2D center, double ratio) {
		for (int i = 0; i < arrayOfPoints.size() - 1; i++) {
			arrayOfPoints.get(i).scale(center, ratio);
		}
	}
	// Rotates the polygon around the given center point by the specified angle.

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i < arrayOfPoints.size() - 1; i++) {
			arrayOfPoints.get(i).rotate(center, angleDegrees);
		}

	}
}
