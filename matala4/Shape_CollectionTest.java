package matala4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.Shape_Collection;
import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class Shape_CollectionTest {
	Circle2D c1 = new Circle2D(new Point2D(1,1),5);
	Point2D p_1 =new Point2D(-7,-4);
	Rect2D r1 = new Rect2D(new Point2D(2,1),new Point2D(11,7));
	Segment2D s1 = new Segment2D (new Point2D (4,-5) , new Point2D(11,-3));
	Triangle2D t1 = new Triangle2D(new Point2D(-10,1),new Point2D(-6,8),new Point2D(-2,1));
	
	
	@Test
    void get() {
        //Add shapes to GUIShape :
        GUI_Shape g1 = new GUIShape();     //cercle
        g1.setShape(c1);
        GUI_Shape g2 = new GUIShape();     //point
        g2.setShape(p_1);
        GUI_Shape g3 = new GUIShape();     //rectangle
        g3.setShape(r1);
        GUI_Shape g4 = new GUIShape();     //segment
        g4.setShape(s1);
        GUI_Shape g5 = new GUIShape();     //triangle
        g5.setShape(t1);

        //create Shape_Collection
        Shape_Collection s = new Shape_Collection();
        s.add(g1);
        s.add(g2);
        s.add(g3);
        s.add(g4);
        s.add(g5);
        
        //Check get :
        assertEquals(s.get(0),g1);
        assertEquals(s.get(1),g2);
        assertEquals(s.get(2),g3);
        assertEquals(s.get(3),g4);
        assertEquals(s.get(4),g5); 
    }

    @Test
    void size() {
    	//Add shapes to GUIShape :
        GUI_Shape g1 = new GUIShape();     //cercle
        g1.setShape(c1);
        GUI_Shape g2 = new GUIShape();     //point
        g2.setShape(p_1);
        GUI_Shape g3 = new GUIShape();     //rectangle
        g3.setShape(r1);
        GUI_Shape g4 = new GUIShape();     //segment
        g4.setShape(s1);
        GUI_Shape g5 = new GUIShape();     //triangle
        g5.setShape(t1);

        //create Shape_Collection
        Shape_Collection s =new Shape_Collection();
        s.add(g1);
        //Check Size :
        assertEquals(s.size(),1);
        s.add(g2);
        assertEquals(s.size(),2);
        s.add(g3);
        assertEquals(s.size(),3);
        s.add(g4);
        assertEquals(s.size(),4);
        s.add(g5);
        assertEquals(s.size(),5);

        //remove at 2
        s.removeElementAt(2);
        assertEquals(s.size(),4);

        //remove All
        s.removeAll();
        assertEquals(0,s.size());
    }

    @Test
    void removeElementAt() {
    	//Add shapes to GUIShape :
        GUI_Shape g1 = new GUIShape();     //cercle
        g1.setShape(c1);
        GUI_Shape g2 = new GUIShape();     //point
        g2.setShape(p_1);
        GUI_Shape g3 = new GUIShape();     //rectangle
        g3.setShape(r1);
        GUI_Shape g4 = new GUIShape();     //segment
        g4.setShape(s1);
        GUI_Shape g5 = new GUIShape();     //triangle
        g5.setShape(t1);
        
        //create Shape_Collection
        Shape_Collection s =new Shape_Collection();
        s.add(g1);
        //Check Size
        s.add(g2);
        s.add(g3);
        s.add(g4);
        s.add(g5);

        //Check If the element at 1 is deleted
        assertEquals(s.size(),5);
        s.removeElementAt(1);
        assertEquals(s.size(),4);
    }

    @Test
    void addAt() {
    	//Add shapes to GUIShape :
        GUI_Shape g1 = new GUIShape();     //cercle
        g1.setShape(c1);
        GUI_Shape g2 = new GUIShape();     //point
        g2.setShape(p_1);
        GUI_Shape g3 = new GUIShape();     //rectangle
        g3.setShape(r1);
        GUI_Shape g4 = new GUIShape();     //segment
        g4.setShape(s1);
        GUI_Shape g5 = new GUIShape();     //triangle
        g5.setShape(t1);
        
        //create Shape_Collection
        Shape_Collection s =new Shape_Collection();
        // check if it's at the correct place
        s.addAt(g1,0);
        assertEquals(g1,s.get(0));
        s.addAt(g2,1);
        assertEquals(g2,s.get(1));
        s.addAt(g3,2);
        assertEquals(g3,s.get(2));
        s.addAt(g4,3);
        assertEquals(g4,s.get(3));
        s.addAt(g5,4);
        assertEquals(g5,s.get(4));
    }

    @Test
    void add() {
    	//Add shapes to GUIShape :
        GUI_Shape g1 = new GUIShape();     //cercle
        g1.setShape(c1);
        GUI_Shape g2 = new GUIShape();     //point
        g2.setShape(p_1);
        GUI_Shape g3 = new GUIShape();     //rectangle
        g3.setShape(r1);
        GUI_Shape g4 = new GUIShape();     //segment
        g4.setShape(s1);
        GUI_Shape g5 = new GUIShape();     //triangle
        g5.setShape(t1);

        //Creat Shape_Collection
        Shape_Collection s =new Shape_Collection();
        s.add(g1);
        s.add(g2);
        s.add(g3);
        s.add(g4);
        s.add(g5);

        //Check if Each Shape is add to Shape Collection
        assertEquals(s.get(0),g1);
        assertEquals(s.get(1),g2);
        assertEquals(s.get(2),g3);
        assertEquals(s.get(3),g4);
        assertEquals(s.get(4),g5);

    }

//    @Test
//    void copy() {
//    	//Add shapes to GUIShape :
//        GUI_Shape g1 = new GUIShape();     //cercle
//        g1.setShape(c1);
//        GUI_Shape g2 = new GUIShape();     //point
//        g2.setShape(p_1);
//        GUI_Shape g3 = new GUIShape();     //rectangle
//        g3.setShape(r1);
//        GUI_Shape g4 = new GUIShape();     //segment
//        g4.setShape(s1);
//        GUI_Shape g5 = new GUIShape();     //triangle
//        g5.setShape(t1);
//
//        //create Shape_Collection
//        Shape_Collection s =new Shape_Collection();
//        //Add Element At and check if each element are in  the correct place
//        s.addAt(g1,0);
//        s.addAt(g2,1);
//        s.addAt(g3,2);
//        s.addAt(g4,3);
//        s.addAt(g5,4);
//
//        //Creat a new ShapeCollection to copy
//        Shape_Collection s2 =new Shape_Collection();
//        s2.addAt(g1,0);
//        s2.addAt(g2,1);
//        s2.addAt(g3,2);
//        s2.addAt(g4,3);
//        s2.addAt(g5,4);
//
//        //equal
//        assertEquals(s2.toString(),s.toString());
//
//        //not equal.
//        s2.removeAll();
//        assertNotEquals(s2.toString(),s.toString());
//    }

    @Test
    void sort() {
    	//Add shapes to GUIShape :
        GUI_Shape g1 = new GUIShape();     //cercle
        g1.setShape(c1);
        GUI_Shape g2 = new GUIShape();     //point
        g2.setShape(p_1);
        GUI_Shape g3 = new GUIShape();     //rectangle
        g3.setShape(r1);
        GUI_Shape g4 = new GUIShape();     //segment
        g4.setShape(s1);
        GUI_Shape g5 = new GUIShape();     //triangle
        g5.setShape(t1);

        //create Shape_Collection
        Shape_Collection s =new Shape_Collection();
        //AddAt Element At and check the place
        s.addAt(g1,0);
        s.addAt(g2,1);
        s.addAt(g3,2);
        s.addAt(g4,3);
        s.addAt(g5,4);
    }

    @Test
    void removeAll() {
    	//Add shapes to GUIShape :
        GUI_Shape g1 = new GUIShape();     //cercle
        g1.setShape(c1);
        GUI_Shape g2 = new GUIShape();     //point
        g2.setShape(p_1);
        GUI_Shape g3 = new GUIShape();     //rectangle
        g3.setShape(r1);
        GUI_Shape g4 = new GUIShape();     //segment
        g4.setShape(s1);
        GUI_Shape g5 = new GUIShape();     //triangle
        g5.setShape(t1);

        //create Shape_Collection
        Shape_Collection s =new Shape_Collection();
        //Add Element At and check if each element are in  the correct place
        s.addAt(g1,0);
        s.addAt(g2,1);
        s.addAt(g3,2);
        s.addAt(g4,3);
        s.addAt(g5,4);

        assertEquals(5,s.size());
        s.removeAll();
        assertEquals(0,s.size());

    }

}
