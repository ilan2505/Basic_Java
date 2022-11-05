package matala4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;

import ex4.geometry.*;
public class GUIShape implements GUI_Shape {
	private GeoShape shape ;
	private boolean filled;
	private  Color color;
	private  int tag;
		
	public GUIShape(GeoShape shape, Color color, boolean filled, int tag){    //constructor
        this.shape = shape ;
        this.color = color;
	    this.filled = filled;
	    this.tag = tag;
	}
	
	public GUIShape(GUIShape g) {         //copy constructor
		this.setShape(g.getShape());
		this.setColor(g.getColor());
		this.setFilled(g.isFilled());
	    this.setTag(g.getTag());
	}
	public GUIShape() {                  //constructor for the test
		this.shape = null;
		this.color = Color.red;
		this.filled = true;
	    this.tag = 0;
	}
//--------------------------------------------------------------------------------------
	////gets and sets :

	@Override
	public GeoShape getShape() {
		return shape;
	}

	@Override
	public void setShape(GeoShape g) {
		this.shape = g;
	}

	@Override
	public boolean isFilled() {
		return filled;
	}

	@Override
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color cl) {
		this.color  = cl;
	}

	@Override
	public int getTag() {
		return tag;
	}

	@Override
	public void setTag(int tag) {
		this.tag =tag;
	}

	@Override
	public GUI_Shape copy() {
		return new GUIShape(this);
	}
	@Override
	public String toString() {
		return  "GUIShape = " +
				" Geoshape : " + getShape() +
				",Color : " + getColor() +
				", IsFilled : " + isFilled() +
				", Tag : " + getTag()+".";
	}
}
