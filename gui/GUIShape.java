package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 */

import ex2.geo.*;

import java.awt.*;


public class GUIShape implements GUI_Shape {
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	public GUIShape(String s) {
		String[] data = s.split(",");
		_color = Color.decode(data[1]);
		_fill = Boolean.parseBoolean(data[2]);
		_tag = Integer.parseInt(data[3]);
		_isSelected = false;
		_g = null;

		switch (data[4]) {
			case "Circle_2D":
				String centerString = data[5] + "," + data[6];
				Point_2D center = new Point_2D(centerString);
				double radius = Double.parseDouble(data[7]);
				_g = new Circle_2D(center, radius).copy();
				break;
			case "Triangle_2D":
				Point_2D p1 = new Point_2D(data[5] + "," + data[6]);
				Point_2D p2 = new Point_2D(data[7] + "," + data[8]);
				Point_2D p3 = new Point_2D(data[9] + "," + data[10]);
				_g = new Triangle_2D(p1, p2, p3).copy();
				break;
			case "Polygon_2D":
				Polygon_2D polygon = new Polygon_2D();
				for (int i = 5; i < data.length; i += 2) {
					Point_2D point = new Point_2D(data[i] + "," + data[i + 1]);
					polygon.add(point);
				}
				_g = polygon.copy();
				break;
			case "Rect_2D":
				Point_2D topLeft = new Point_2D(data[5] + "," + data[6]);
				Point_2D bottomRight = new Point_2D(data[9] + "," + data[10]);
				_g = new Rect_2D(topLeft, bottomRight).copy();
				break;
			case "Segment_2D":
				Point_2D start = new Point_2D(data[5] + "," + data[6]);
				Point_2D end = new Point_2D(data[7] + "," + data[8]);
				_g = new Segment_2D(start, end).copy();
				break;
			default:
				// Handle unknown shape type
				break;
		}
	}
	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		String ans = ""+this.getClass().getSimpleName()+","+_color+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;

	}
}
