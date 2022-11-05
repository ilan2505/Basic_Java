package matala4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;

class Point2DTest {
	//create new points :
	Point2D p_1 =new Point2D(1,1);
	Point2D p_2 =new Point2D(1,1);
	Point2D p_3 =new Point2D(1,2);
	Point2D p_4 =new Point2D(-3,3);
	Point2D p_5 =new Point2D(4,-2);
	
	@Test
    void testDistance() {
		//check distance between my points :
        double  d  =1;
        assertEquals(d,p_1.distance(p_3));
        assertEquals(d,p_2.distance(p_3));
        double  d1  =0;
        assertEquals(d1,p_1.distance(p_2));
        double d2=8.602325267042627;
        assertEquals(d2,p_4.distance(p_5));
        double d3=4.123105625617661;
        assertEquals(d3,p_3.distance(p_4));
    }
	
	@Test
    void testEquals() {
       //check if p_1 equal to p_2 : YES
       assertEquals(p_1,p_2);
       //check if p_1 equal to p_2 : NO
       assertNotEquals(p_1,p_3);
    }
	
	@Test
	void testClose2equals() {
		Point2D p_11 = new Point2D(0.99,0.99);
        assertTrue(p_11.close2equals(p_1, 0.1));
        assertFalse(p_11.close2equals(p_1, 0.001));
        Point2D p_33 = new Point2D(0.999,1.999);
        assertTrue(p_33.close2equals(p_3, 0.01));
        assertFalse(p_33.close2equals(p_3, 0.001));
        Point2D p_55 = new Point2D(4.01,-1.99);
        assertTrue(p_55.close2equals(p_5, 0.1));
        assertFalse(p_55.close2equals(p_5, 0.001));
	}
	
	@Test
    void testCenterOfMass() {
    //Check center of mass of p_1 if equal to center of c1 :
        assertEquals(new Point2D(1,1),p_1.centerOfMass());
    //Check center of mass of p_3 if equal to center of c2 :
        assertEquals(new Point2D(1,2),p_3.centerOfMass());
    //Check center of mass of p_4 if equal to center of c3 :
        assertEquals(new Point2D(-3,3),p_4.centerOfMass());
    //Check center of mass of p_5 if equal to center of c3 :
        assertEquals(new Point2D(4,-2),p_5.centerOfMass());
    }
	
	@Test
    void testMove() {
        //Creat a new vector to move it :
        Point2D v = new Point2D(1,1);
        // answers :
        Point2D p_11 =new Point2D(2,2);
    	Point2D p_33 =new Point2D(2,3);
    	Point2D p_44 =new Point2D(-2,4);
    	Point2D p_55 =new Point2D(5,-1);
        
        //move c1, c2, c3 :
        p_1.move(v);
        p_3.move(v);
        p_4.move(v);
        p_5.move(v);

        //Check Equality :
        assertEquals(p_11.toString(),p_1.toString());
        assertEquals(p_33.toString(),p_3.toString());
        assertEquals(p_44.toString(),p_4.toString());
        assertEquals(p_55.toString(),p_5.toString());
    }
	
	@Test
    void testCopy() { 
        //create a copy of p_1 :
		Point2D p_11 = (Point2D) p_1.copy();
	    //check if p_1 = p_11 :
        assertEquals(p_1.toString(),p_11.toString());
        //create a copy of p_3 :
        Point2D p_33 = (Point2D) p_3.copy();
      	//check if p_3 = p_33 :
        assertEquals(p_3.toString(),p_33.toString());
        //create a copy of p_4 :
      	Point2D p_44 = (Point2D) p_4.copy();
      	//check if p_4 = p_44 :
        assertEquals(p_4.toString(),p_44.toString());
        //create a copy of p_5 :
        Point2D p_55 = (Point2D) p_5.copy();
        //check if p_5 = p_55 :
        assertEquals(p_5.toString(),p_55.toString());

        
        p_1.move(new Point2D(1,1));
        p_3.move(new Point2D(1,1));
        p_4.move(new Point2D(1,1));
        p_5.move(new Point2D(1,1));
        //I moved c1 but not c11 so : c1 isn't equal to c11 now
        assertNotEquals(p_1.toString(),p_11.toString());
        assertNotEquals(p_3.toString(),p_33.toString());
        assertNotEquals(p_4.toString(),p_44.toString());
        assertNotEquals(p_5.toString(),p_55.toString());
    }
	
	@Test
    void testGetPoints() {
	  //p_1
        Point2D [] ans = p_1.getPoints();
        assertEquals(p_1,ans[0]);
      //p_3
        Point2D [] ans3 = p_1.getPoints();
        assertEquals(p_1,ans3[0]);
      //p_4
        Point2D [] ans4 = p_1.getPoints();
        assertEquals(p_1,ans4[0]);
      //p_5
        Point2D [] ans5 = p_1.getPoints();
        assertEquals(p_1,ans5[0]);
    }
	
	

}
