package matala4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;

class Segment2DTest {
	Segment2D s1 = new Segment2D (new Point2D (-2,-2) , new Point2D(3,3));
	Segment2D s2 = new Segment2D (new Point2D (-1,4) , new Point2D(4,4));
	Segment2D s3 = new Segment2D (new Point2D (-4,-2) , new Point2D(-4,2));

	@Test
	void testContains() {
		//Exemple only for the rectangle s1 :
				//if this point is in  the segment s1 ? -> NO he is out of s1.
		        Point2D out = new Point2D(3,1);
		        assertFalse(s1.contains(out));
		        Point2D out1 = new Point2D(-3,0);
		        assertFalse(s1.contains(out1));
		        Point2D out2 = new Point2D(5,-4);
		        assertFalse(s1.contains(out2));

		        ////if this point is on the segment s1 ? -> YES he is on s1.
		        Point2D on = new Point2D(2.5,2.5);
		        assertTrue(s1.contains(on));
		        Point2D on1 = new Point2D(-0.4,-0.4);
		        assertTrue(s1.contains(on1));
		        Point2D on2 = new Point2D(0,0);
		        assertTrue(s1.contains(on2));
		}

	@Test
	void testCenterOfMass() {
	//Check center of mass of s1 if equal to center of c1 :
        assertEquals(new Point2D(0.5,0.5),s1.centerOfMass());
    //Check center of mass of c2 if equal to center of c2 :
        assertEquals(new Point2D(1.5,4),s2.centerOfMass());
    //Check center of mass of c3 if equal to center of c3 :
        assertEquals(new Point2D(-4,0),s3.centerOfMass());
	}

	@Test
	void testPerimeter() {
		double perimeter1 = Math.sqrt(50);
        double perimeter2 = 5;
        double perimeter3 = 4;
        //Check perimeters :
        assertEquals(perimeter1,s1.perimeter());
        assertEquals(perimeter2,s2.perimeter());
        assertEquals(perimeter3,s3.perimeter());
		
	}

	@Test
	void testMove() {
		//Create a new vector to move it :
        Point2D v = new Point2D(1,1);
        // answers :
        Segment2D s11 = new Segment2D (new Point2D (-1,-1) , new Point2D(4,4));
    	Segment2D s22 = new Segment2D (new Point2D (0,5) , new Point2D(5,5));
    	Segment2D s33 = new Segment2D (new Point2D (-3,-1) , new Point2D(-3,3));
        
        //move c1, c2, c3 :
        s1.move(v);
        s2.move(v);
        s3.move(v);

        //Check Equality :
        assertEquals(s11.toString(),s1.toString());
        assertEquals(s22.toString(),s2.toString());
        assertEquals(s33.toString(),s3.toString());
	}

	@Test
	void testCopy() {
		//create a copy of s1 :
	    Segment2D s11 = (Segment2D) s1.copy();
	    //check if s1 = s11 :
		assertEquals(s1.toString(),s11.toString());
		//create a copy of s2 :
		Segment2D s22 = (Segment2D) s2.copy();
		//check if s2 = s22 :
	    assertEquals(s2.toString(),s22.toString());
		//create a copy of s3 :
	    Segment2D s33 = (Segment2D) s3.copy();
		//check if s3 = s33 :
		assertEquals(s3.toString(),s33.toString());
	}

	@Test
	void testGetPoints() {
	//s1
        Point2D p1 =new Point2D(-2,-2);
        Point2D p2 =new Point2D(3,3);
        Point2D [] ans = s1.getPoints();
        //solution arrray :
        assertEquals(p1,ans[0]);
        assertEquals(p2,ans[1]);
        
      //s2
        Point2D p11 =new Point2D(-1,4);
        Point2D p33 =new Point2D(4,4);
        Point2D [] ans2 = s2.getPoints();
        //solution arrray :
        assertEquals(p11,ans2[0]);
        assertEquals(p33,ans2[1]);
        
      //s2
        Point2D p111 =new Point2D(-4,-2);
        Point2D p333 =new Point2D(-4,2);
        Point2D [] ans3 = s3.getPoints();
        //solution array :
        assertEquals(p111,ans3[0]);
        assertEquals(p333,ans3[1]); 
		
	}

}
