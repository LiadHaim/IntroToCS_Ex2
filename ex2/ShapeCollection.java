package ex2.ex2;

import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements GUI_Shape_Collection {// This class represents a collection of GUI_Shape objects.

	public ArrayList<GUI_Shape> _shapes;

	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();}




	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		_shapes.remove(i);
		return null;
	}
	// Adds a shape at the specified index in the collection.

	@Override
	public void addAt(GUI_Shape s, int i) {
		_shapes.add(i, s);
	}
	@Override
	// Adds a shape to the collection.
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}
	// Creates a copy of the collection.
	@Override
	public GUI_Shape_Collection copy() {
		ShapeCollection ShPc = new ShapeCollection();
		ShPc._shapes.addAll(this._shapes);
		return ShPc;
	}
	// Sorts the shapes in the collection using the specified comparator.

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
	}
	// Removes all shapes from the collection.

	@Override
	public void removeAll() {
		_shapes.clear();
	}
	// Saves the collection to a file.

	@Override
	public void save(String file) {
		try {
			String b = "";
			FileWriter myWriter = new FileWriter(file);
			for(int i = 0; i < this._shapes.size(); i++) {
				b += this._shapes.get(i).toString() + "\n";

			}
			myWriter.write(b);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	@Override
	public void load(String file) { // Loads shapes from a file into the collection.
		_shapes.clear();
		try {
			// Open
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			// Read
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				_shapes.add(new GUIShape(line));
			}
			// Close
			bufferedReader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {    // Returns a string representation of the collection.
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}
}
