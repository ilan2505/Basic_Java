package matala4;

import static org.junit.jupiter.api.Assertions.*;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

import org.junit.jupiter.api.Test;

import ex4.geometry.Triangle2D;

class Triangle2DTest {
	Triangle2D t1 = new Triangle2D (new Point2D(0,0),new Point2D(4,3),new Point2D(6,0));
	Triangle2D t2 = new Triangle2D (new Point2D(0,0),new Point2D(0,2),new Point2D(4,0));
	Triangle2D t3 = new Triangle2D (new Point2D(-4,-3),new Point2D(-2,1),new Point2D(4,-2));
	
	
	@Test
	void testContains() {
		//Exemple only for the triangle r1 :
				//if this point is in the triangle t1 ? -> NO he is out of t1.
		        Point2D out = new Point2D(0,3);
		        assertFalse(t1.contains(out));
		        Point2D out1 = new Point2D(5,-1);
		        assertFalse(t1.contains(out1));
		        Point2D out2 = new Point2D(7,0);
		        assertFalse(t1.contains(out2));

		        //if this point is in the triangle r1 ? -> YES he is in t1.
		        Point2D in = new Point2D(2,1);
		        assertTrue(t1.contains(in));
		        Point2D in1 = new Point2D(1,0.1);
		        assertTrue(t1.contains(in1));
		        Point2D in2 = new Point2D(5,0.5);
		        assertTrue(t1.contains(in2));

		        ////if this point is in the triangle r1 ? -> YES he is on t1.
		        Point2D on = new Point2D(4,0);
		        assertTrue(t1.contains(on));
		        Point2D on1 = new Point2D(2,1.5);
		        assertTrue(t1.contains(on1));
		        Point2D on2 = new Point2D(5,1.5);
		        assertTrue(t1.contains(on2));
    }

	@Test
	void testCenterOfMass() {
	//Check center of mass of r1 if equal to center of c1 :
        assertEquals(new Point2D(3.3333333333333335,1.0),t1.centerOfMass());
    //Check center of mass of r2 if equal to center of c2 :
        assertEquals(new Point2D(1.3333333333333333,0.6666666666666666),t2.centerOfMass());
    //Check center of mass of r3 if equal to center of c3 :
        assertEquals(new Point2D(-0.6666666666666666,-1.3333333333333333),t3.centerOfMass());	
	}

	@Test
	void testArea() {
		double area1 = 9.000000000000002;
        double area2 = 4.0;
        double area3 = 15.000000000000002;
        //Check area
        assertEquals(area1,t1.area());
        assertEquals(area2,t2.area());
        assertEquals(area3,t3.area());
	}

	@Test
	void testPerimeter() {
		double perimeter1 = 14.60555127546399;
        double perimeter2 = 10.47213595499958;
        double perimeter3 = 19.242597635797498;
        //Check perimeters :
        assertEquals(perimeter1,t1.perimeter());
        assertEquals(perimeter2,t2.perimeter());
        assertEquals(perimeter3,t3.perimeter());
	}

	@Test
	void testMove() {
		//Create a new vector to move it :
        Point2D v = new Point2D(1,1);
        // answers :
        Triangle2D t11 = new Triangle2D (new Point2D(1,1),new Point2D(5,4),new Point2D(7,1));
    	Triangle2D t22= new Triangle2D (new Point2D(1,1),new Point2D(1,3),new Point2D(5,1));
    	Triangle2D t33 = new Triangle2D (new Point2D(-3,-2),new Point2D(-1,2),new Point2D(5,-1));
        //move t1, t2, t3 :
        t1.move(v);
        t2.move(v);
        t3.move(v);

        //Check Equality :
        assertEquals(t11.toString(),t1.toString());
        assertEquals(t22.toString(),t2.toString());
        assertEquals(t33.toString(),t3.toString());
	}

	@Test
	void testCopy() {
		//create a copy of t1 :
	    Triangle2D t11 = (Triangle2D) t1.copy();
	    //check if t1 = t11 :
		assertEquals(t1.toString(),t11.toString());
		//create a copy of t2 :
		Triangle2D t22 = (Triangle2D) t2.copy();
		//check if t2 = t22 :
		assertEquals(t2.toString(),t22.toString());
		//create a copy of t3 :
		Triangle2D t33 = (Triangle2D) t3.copy();
		//check if t3 = t33 :
		assertEquals(t3.toString(),t33.toString());
	}

	@Test
	void testGetPoints() {
		//t1
        Point2D p1 =new Point2D(0,0);
        Point2D p2 =new Point2D(4,3);
        Point2D p3 =new Point2D(6,0);
        Point2D [] ans = t1.getPoints();
        //solution arrray :
        assertEquals(p1,ans[0]);
        assertEquals(p2,ans[1]);
        assertEquals(p3,ans[2]);
        
        //t2
        Point2D p11 =new Point2D(0,0);
        Point2D p22 =new Point2D(0,2);
        Point2D p33 =new Point2D(4,0);
        Point2D [] ans2 = t2.getPoints();
        //solution arrray :
        assertEquals(p11,ans2[0]);
        assertEquals(p22,ans2[1]);
        assertEquals(p33,ans2[2]);
        
        //t3
        Point2D p111 =new Point2D(-4,-3);
        Point2D p222 =new Point2D(-2,1);
        Point2D p333 =new Point2D(4,-2);
        Point2D [] ans3 = t3.getPoints();
        //solution array :
        assertEquals(p111,ans3[0]);
        assertEquals(p222,ans3[1]);
        assertEquals(p333,ans3[2]);
	}

}
