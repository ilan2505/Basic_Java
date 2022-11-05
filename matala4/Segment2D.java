package matala4;
/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape {
	public Point2D p_1,p_2;
	
	public Segment2D(Point2D p_1, Point2D p_2) {   //constructor
		this.p_1 = p_1;
		this.p_2 = p_2;
	}
	public Segment2D(Segment2D S) {                //copy constructor
	    this.p_1 = S.getP1();
		this.p_2 = S.getP2();
	}
//--------------------------------------------------------------------
	//gets and sets :
	public Point2D getP1() {
		return p_1;
	}
	public void setP1(Point2D p_1) {
		this.p_1 = p_1;
	}
    public Point2D getP2() {
		return p_2;
	}
	public void setP2(Point2D p_2) {
		this.p_2 = p_2;
	}
//--------------------------------------------------------------------
	@Override
	public boolean contains(Point2D ot) {
		//if ot is on the line (P1P2) : (x2-x1)/(y2-y1) =(x-x1)/(y-y1) :
		if ((getP2().x()-getP1().x())/(getP2().y()-getP1().y()) == (ot.x()-getP1().x())/(ot.y()-getP1().y())) {
			  //if ot is on the segment [P1P2] :
			  if( ot.x()<=getP2().x() && ot.x()>=getP1().x()) {
			     return true;
			  } 
			  else {      //ot isn't on the segment [P1P2]
				  return false; 
			  }
		} 
		else {           //ot isn't on the line (P1P2)
		    return false;
		}
    }

	@Override
	public Point2D centerOfMass() {
		Point2D mid = new Point2D((getP1().x() + getP2().x())/2, (getP1().y() + getP2().y())/2);
		return mid;
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	//the perimeter of a segment [P1P2] is the distance between P1 and P2
	public double perimeter() {
		 //x = (x2-x1)^2 + (y2-y1)^2
		 double x = Math.pow(getP2().x()-getP1().x(), 2) + Math.pow(getP2().y()-getP1().y(), 2);
		 //xx = Chorech x
		 double ans = Math.sqrt(x);
	     return ans;
	}

	@Override
	public void move(Point2D vec) {
		p_1.move(vec);
		p_2.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Segment2D(this);
	}
	
	@Override
	public Point2D[] getPoints() {
		Point2D[] points = new Point2D[2];
        points[0] = this.p_1;
		points[1] = this.p_2;
		return points;
	}
	
	@Override
	public String toString() {
		return "Segment2D,"+p_1.x()+","+p_1.y()+","+p_2.x()+","+p_2.y();
	}
}
