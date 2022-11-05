package matala4;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
import java.util.Comparator;

import ex4.geometry.Rect2D;

public class Shape_Collection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> arrayList;

    public Shape_Collection(ArrayList<GUI_Shape> arrayList) {     //Constructor
         this.arrayList = arrayList;
	}

	public Shape_Collection() {                 //copy constructor
        this.arrayList=new ArrayList<>();
		 
			
	}
public Shape_Collection(Shape_Collection shape_Collection) {
		// TODO Auto-generated constructor stub
	}

	//------------------------------------------------------------------------------------------
	//gets and sets :
	public ArrayList<GUI_Shape> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<GUI_Shape>arrayList) {
		this.arrayList = arrayList;
	}

//------------------------------------------------------------------------------------------
	@Override
	public GUI_Shape get(int i) {
		return arrayList.get(i);
	}

	@Override
	public int size() {
		return arrayList.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		return this.arrayList.remove(i);
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		arrayList.add(i, s);
	}
	
	@Override
	public void add(GUI_Shape s) {
		this.arrayList.add(s);
	}
	
	@Override
	public GUI_Shape_Collection copy() {
		return new Shape_Collection(this);
	}

	@Override
	public void sort(Comparator comp) {
		Collections.sort(arrayList,comp);
	}

	@Override
	public void removeAll() {
		this.arrayList.clear();
	}

	@Override
	public void save(String file) {	 
	}

	@Override
	public void load(String file) {
		;
	}
	@Override
	public Rect2D getBoundingBox() {
		return null;
	}
	@Override
	public String toString() {
		return null;
		
	}
	

}
