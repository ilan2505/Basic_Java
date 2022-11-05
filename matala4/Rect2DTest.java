package matala4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class Rect2DTest {
	Rect2D r1 = new Rect2D (new Point2D(0,0),new Point2D(7,4));
	Rect2D r2 = new Rect2D (new Point2D(-3,-3),new Point2D(3,2));
	Rect2D r3 = new Rect2D (new Point2D(-9,-4),new Point2D(-7,3));
	
	@Test
	void testContains() {
		//Exemple only for the rectangle r1 :
		//if this point is in  the rectangle r1 ? -> NO he is out of r1.
        Point2D out = new Point2D(8,5);
        assertFalse(r1.contains(out));
        Point2D out1 = new Point2D(0,5);
        assertFalse(r1.contains(out1));
        Point2D out2 = new Point2D(-1,-1);
        assertFalse(r1.contains(out2));

        //if this point is in  the rectangle r1 ? -> YES he is in r1.
        Point2D in = new Point2D(3,2);
        assertTrue(r1.contains(in));
        Point2D in1 = new Point2D(0.1,0.1);
        assertTrue(r1.contains(in1));
        Point2D in2 = new Point2D(6.99,3.99);
        assertTrue(r1.contains(in2));

        ////if this point is in the rectangle r1 ? -> YES he is on r1.
        Point2D on = new Point2D(7,4);
        assertTrue(r1.contains(on));
        Point2D on1 = new Point2D(0,2);
        assertTrue(r1.contains(on1));
        Point2D on2 = new Point2D(4,0);
        assertTrue(r1.contains(on2));
	}
	
	@Test
    void testCenterOfMass() {
    //Check center of mass of r1 if equal to center of c1 :
        assertEquals(new Point2D(3.5,2),r1.centerOfMass());
    //Check center of mass of r2 if equal to center of c2 :
        assertEquals(new Point2D(0,-0.5),r2.centerOfMass());
    //Check center of mass of r3 if equal to center of c3 :
        assertEquals(new Point2D(-8,-0.5),r3.centerOfMass());
    }
	
	@Test
    void testArea() {
        double area1 = 28;
        double area2 = 30;
        double area3 = 14;
        //Check area
        assertEquals(area1,r1.area());
        assertEquals(area2,r2.area());
        assertEquals(area3,r3.area());
    }
	
	@Test
    void testPerimeter() {
        double perimeter1 = 22;
        double perimeter2 = 22;
        double perimeter3 = 18;
        //Check perimeters :
        assertEquals(perimeter1,r1.perimeter());
        assertEquals(perimeter2,r2.perimeter());
        assertEquals(perimeter3,r3.perimeter());
    }
	
	void testMove() {
        //Create a new vector to move it :
        Point2D v = new Point2D(1,1);
        // answers :
        Rect2D r11 = new Rect2D (new Point2D(1,1),new Point2D(8,5));
    	Rect2D r22 = new Rect2D (new Point2D(-2,-2),new Point2D(4,3));
    	Rect2D r33= new Rect2D (new Point2D(-8,-3),new Point2D(-6,4));
        //move r1, r2, r3 :
        r1.move(v);
        r2.move(v);
        r3.move(v);

        //Check Equality :
        assertEquals(r11.toString(),r1.toString());
        assertEquals(r22.toString(),r2.toString());
        assertEquals(r33.toString(),r3.toString());
	}
	
	@Test
    void testCopy() { 
        //create a copy of r1 :
		Rect2D r11 = (Rect2D) r1.copy();
	    //check if r1 = r11 :
        assertEquals(r1.toString(),r11.toString());
        //create a copy of r2 :
        Rect2D r22 = (Rect2D) r2.copy();
      	//check if r2 = r22 :
        assertEquals(r2.toString(),r22.toString());
        //create a copy of r3 :
        Rect2D r33 = (Rect2D) r3.copy();
      	//check if r3 = r33 :
        assertEquals(r3.toString(),r33.toString());
    }
	
	@Test
    void TestGetPoints() {
	  //r1
        Point2D p1 =new Point2D(0,0);
        Point2D p3 =new Point2D(7,4);
        Point2D [] ans = r1.getPoints();
        //solution arrray :
        assertEquals(p1,ans[0]);
        assertEquals(p3,ans[1]);
        
      //r2
        Point2D p11 =new Point2D(-3,-3);
        Point2D p33 =new Point2D(3,2);
        Point2D [] ans2 = r2.getPoints();
        //solution arrray :
        assertEquals(p11,ans2[0]);
        assertEquals(p33,ans2[1]);
        
      //r3
        Point2D p111 =new Point2D(-9,-4);
        Point2D p333 =new Point2D(-7,3);
        Point2D [] ans3 = r3.getPoints();
        //solution array :
        assertEquals(p111,ans3[0]);
        assertEquals(p333,ans3[1]);
        
//        

    }

}
