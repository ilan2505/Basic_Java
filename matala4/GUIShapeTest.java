package matala4;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class GUIShapeTest {
	//create shapes :
	GUIShape g =new GUIShape();
	Circle2D c1 = new Circle2D(new Point2D(1,1),5);
	Point2D p_1 =new Point2D(-7,-4);
	Rect2D r1 = new Rect2D(new Point2D(2,1),new Point2D(11,7));
	Segment2D s1 = new Segment2D (new Point2D (4,-5) , new Point2D(11,-3));
	Triangle2D t1 = new Triangle2D(new Point2D(-10,1),new Point2D(-6,8),new Point2D(-2,1));
	
	 @Test
	    void getShape() {
		    //for the circle
	        //create a New GUIShape :
	        GUIShape g =new GUIShape(c1,Color.red,true,5);
	        assertEquals(c1,g.getShape());
	        
		    //for the rectangle
	        //create a New GUIShape :
	        GUIShape g1 =new GUIShape(r1,Color.red,false,-2);
	        assertEquals(r1,g1.getShape());
	    }

	    @Test
	    void setShape() {
	        //Creat a copy of this.GUIShape :
	        GUIShape g1 = (GUIShape) g.copy();
	        assertEquals(g.toString(),g1.toString());
            //g is a triangle t1 :
	        g.setShape(t1);
            //g and g1 are not equals now because we set g.
	        assertNotEquals(g.toString(),g1.toString());

	    }

	    @Test
	    void isFilled() {
	        //IsFilled on the constructor is true.
	        assertEquals(true,g.isFilled());
            //Creat new GeoShape (filled false)
	        GUIShape g1 =new GUIShape(s1,Color.red,false,5);
	        //Check Equality
	        assertEquals(false,g1.isFilled());
	    }

	    @Test
	    void setFilled() {	
	    	//create new GUIShape
	    	GUIShape g1 =new GUIShape(s1,Color.red,false,5);
	        //Set to True
	        g.setFilled(true);
	        assertEquals(true,g.isFilled());
	    }

	    @Test
	    void getColor() {
	        //Creat a new GeoShape with Color Blue for the segment s1 :
	        GUIShape g1 =new GUIShape(s1,Color.blue,true,5);
	        //Check Equality
	        assertEquals(Color.blue,g1.getColor());
	        
	        //Creat a new GeoShape with Color red for the circle c1 s1 :
	        GUIShape g2 =new GUIShape(c1,Color.red,true,2);
	        //Check Equality
	        assertEquals(Color.red,g2.getColor());
	    }
//
	    @Test
	    void setColor() {
	    	GUIShape g1 =new GUIShape(s1,Color.blue,true,5);
	        //Set s1 from blue to Red
	        g1.setColor(Color.red);
	        //Check if color is red :
	        assertEquals(Color.red,g1.getColor());
	        //Set s1 from blue to black
	        g1.setColor(Color.black);
	        //Check if color is black :
	        assertEquals(Color.black,g1.getColor());
	    }

        @Test
	    void getTag() {
	        //Creat new GUIShape rectangle : tag = 7
	        GUIShape g =new GUIShape(r1,Color.green,true,7);
	        //Check Tag :
	        assertEquals(7,g.getTag());
	        
	        //Creat new GUIShape rectangle with : tag = 15
	        GUIShape g1 =new GUIShape(r1,Color.green,true,15);
	        //Check Tag :
	        assertEquals(15,g1.getTag());
	    }

	    @Test
	    void setTag() {
	    	GUIShape g =new GUIShape(r1,Color.green,true,7);
	        //Set g tag from 7 to 2 :
	        g.setTag(2);
	        //Check Tag :
	        assertEquals(2,g.getTag());
	        //Set g tag from 2 to 10 :
	        g.setTag(10);
	        //Check Tag :
	        assertEquals(10,g.getTag());
	    }

	    @Test
	    void copy() {
	    	//for  r1 :
	    	GUIShape g =new GUIShape(r1,Color.green,true,7);
	        //create a copy
	        GUIShape g1 = (GUIShape) g.copy();
	        //g and g1 are now equals.
	        assertEquals(g.toString(),g1.toString());

	        //for c1 :
	        GUIShape g2 =new GUIShape(c1,Color.red,true,2);
	        //create a copy
	        GUIShape g3 = (GUIShape) g2.copy();
	        //g2 and g3 are now equals.
	        assertEquals(g2.toString(),g3.toString());
	    }
}
