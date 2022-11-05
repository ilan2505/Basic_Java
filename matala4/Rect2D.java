package matala4;
/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape {
	
	public Point2D p_1,p_2,p_3,p_4;
	
	public Rect2D(Point2D p_1, Point2D p_3) {    //constructor
		this.p_1 = new Point2D(Math.min(p_1.x(), p_3.x()),Math.min(p_1.y(), p_3.y()));
		this.p_2 = new Point2D(Math.min(p_1.x(), p_3.x()),Math.max(p_1.y(), p_3.y()));
		this.p_3 = new Point2D(Math.max(p_1.x(), p_3.x()),Math.max(p_1.y(), p_3.y()));
		this.p_4 = new Point2D(Math.max(p_1.x(), p_3.x()),Math.min(p_1.y(), p_3.y()));
	}
	
	public Rect2D(Rect2D R) {                   //copy constructor
	    this.p_1 = R.getP1();
		this.p_2 = R.getP2();
		this.p_3 = R.getP3();
		this.p_4 = R.getP4();
	}
//--------------------------------------------------------------
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

		public Point2D getP3() { 
			return p_3; 
		}

		public void setP3(Point2D p_3) { 
			this.p_3 = p_3; 
		}

		public Point2D getP4() { 
			return p_4; 
		}

		public void setP4(Point2D p_4) { 
			this.p_4 = p_4; 
		}
//--------------------------------------------------------------
	
	@Override
	public boolean contains(Point2D ot) {
		//if : x of p3 < x of ot  or x of ot < x of p1 : false
		if (ot.x() > getP3().x() || ot.x() < getP1().x()){   
			return false;	
		}
		//if : y of p3 < y of ot  or y of ot < y of p1 : false
		if (ot.y() > getP3().y() || ot.y() < getP1().y()) {  
			return false;
		}
		return true;          //-> true
	}
	
	@Override
	public Point2D centerOfMass() {
		//(x,y) = ((x1+x4)/2 , (y1+y2)/2)
		return new Point2D((getP1().x()+getP4().x())/2,(getP1().y()+getP2().y())/2);
	}
	
	@Override
	public double area() {
		//x = (x2-x1)^2 + (y2-y1)^2
		double x = Math.pow(getP2().x()-getP1().x(), 2) + Math.pow(getP2().y()-getP1().y(), 2);
		//xx = Chorech x
		double xx = Math.sqrt(x);
		//y = (x3-x2)^2 + (y3-y2)^2
		double y = Math.pow(getP3().x()-getP2().x(), 2) + Math.pow(getP3().y()-getP2().y(), 2);
		//yy = Chorech y
	    double yy = Math.sqrt(y);
		double ans = xx * yy;
		return ans;
	}
	
	@Override
	public double perimeter() {
		//x = (x2-x1)^2 + (y2-y1)^2
		double x = Math.pow(getP2().x()-getP1().x(), 2) + Math.pow(getP2().y()-getP1().y(), 2);
		//xx = Chorech x
		double xx = Math.sqrt(x);
		//x = (x3-x2)^2 + (y3-y2)^2
		double y = Math.pow(getP3().x()-getP2().x(), 2) + Math.pow(getP3().y()-getP2().y(), 2);
		//yy = Chorech y
	    double yy = Math.sqrt(y);
		double ans = xx*2 + yy*2;
		return ans;
	}

	@Override
	public void move(Point2D vec) {
		p_1.move(vec);
		p_3.move(vec);
	}
	
	@Override
	public GeoShape copy() {
		return new Rect2D(this);
	}
	
	@Override
	public String toString() {
		return "Rect2D" +","+p_1.x()+","+p_1.y()+","+p_3.x()+","+p_3.y();
	}

	@Override
	public Point2D[] getPoints() {
        Point2D [] ans  =new Point2D[2];
        ans[0]=this.getP1();
        ans[1]=this.getP3();
        return ans;
	}
	
}
