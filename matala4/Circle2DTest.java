package matala4;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;

class Circle2DTest {
	
	//new Circle :
	Circle2D c1 = new Circle2D(new Point2D(1,1),5);
	Circle2D c2 = new Circle2D(new Point2D(-4,2),9);
	Circle2D c3 = new Circle2D(new Point2D(-2,-2),2);
	
	@Test
	void testContains() {
		//if this point is in  the circle ? -> NO he is out of the circle.
        Point2D out = new Point2D(2,7);
        assertFalse(c1.contains(out));
        Point2D out1 = new Point2D(-7,-4);
        assertFalse(c1.contains(out1));
        Point2D out2 = new Point2D(-6,8);
        assertFalse(c1.contains(out2));

        //if this point is in  the circle ? -> YES he is in the circle.
        Point2D in = new Point2D(2,1);
        assertTrue(c1.contains(in));
        Point2D in1 = new Point2D(-2,-2);
        assertTrue(c1.contains(in1));
        Point2D in2 = new Point2D(-1,4);
        assertTrue(c1.contains(in2));

        ////if this point is in the circle ? -> YES he is on the circle.
        Point2D on = new Point2D(1,-4);
        assertTrue(c1.contains(on));
        Point2D on1 = new Point2D(1,6);
        assertTrue(c1.contains(on1));
        Point2D on2 = new Point2D(6,1);
        assertTrue(c1.contains(on2));
	}
	
	@Test
    void testCenterOfMass() {
    //Check center of mass of c1 if equal to center of c1 :
        assertEquals(new Point2D(1,1),c1.centerOfMass());
    //Check center of mass of c2 if equal to center of c2 :
        assertEquals(new Point2D(-4,2),c2.centerOfMass());
    //Check center of mass of c3 if equal to center of c3 :
        assertEquals(new Point2D(-2,-2),c3.centerOfMass());
    }
	
	@Test
    void testArea() {
        double area1 = 78.53981633974483;
        double area2 = 254.46900494077323;
        double area3 = 12.566370614359172;
        //Check area
        assertEquals(area1,c1.area());
        assertEquals(area2,c2.area());
        assertEquals(area3,c3.area());
    }
	
	@Test
    void testPerimeter() {
        double perimeter1 =31.41592653589793;
        double perimeter2 =56.548667764616276;
        double perimeter3 =12.566370614359172;
        //Check perimeters :
        assertEquals(perimeter1,c1.perimeter());
        assertEquals(perimeter2,c2.perimeter());
        assertEquals(perimeter3,c3.perimeter());
    }
	
	@Test
    void testMove() {
        //Create a new vector to move it :
        Point2D v = new Point2D(1,1);
        // answers :
        Circle2D c11 = new Circle2D(new Point2D(2,2),5);
        Circle2D c22 = new Circle2D(new Point2D(-3,3),9);
        Circle2D c33 = new Circle2D(new Point2D(-1,-1),2);
        //move c1, c2, c3 :
        c1.move(v);
        c2.move(v);
        c3.move(v);

        //Check Equality :
        assertEquals(c11.toString(),c1.toString());
        assertEquals(c22.toString(),c2.toString());
        assertEquals(c33.toString(),c3.toString());
    }
	
	@Test
    void testCopy() { 
        //create a copy of c1 :
		Circle2D c11 = (Circle2D) c1.copy();
	    //check if c1 = c11 :
        assertEquals(c1.toString(),c11.toString());
        //create a copy of c2 :
        Circle2D c22 = (Circle2D) c2.copy();
      	//check if c1 = c11 :
        assertEquals(c2.toString(),c22.toString());
    }
	
	@Test
    void testGetPoints() {
		//C1
        Point2D center =new Point2D(1,1);
        Point2D [] ans = c1.getPoints();
        //solution : 
        assertEquals(center,ans[0]);
        Point2D p =new Point2D(center.x(),center.y()+5);
        assertEquals(p,ans[1]);
        
        //c2
        Point2D center2 =new Point2D(-4,2);
        Point2D [] ans2 = c2.getPoints();
        //solution :
        assertEquals(center2,ans2[0]);
        Point2D p2 =new Point2D(center2.x(),center2.y()+9);
        assertEquals(p2,ans2[1]);
        
        //c3
        Point2D center3 =new Point2D(-2,-2);
        Point2D [] ans3 = c3.getPoints();
        //solution :
        assertEquals(center3,ans3[0]);
        Point2D p3 =new Point2D(center3.x(),center3.y()+2);
        assertEquals(p3,ans3[1]);

    }

}
