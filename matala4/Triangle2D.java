package matala4;
/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape {
	public Point2D p_1,p_2,p_3;
	
	
		public Triangle2D(Point2D p_1, Point2D p_2, Point2D p_3) {   //constructor
			this.p_1 = p_1;
			this.p_2 = p_2;
			this.p_3 = p_3;
	    }
		
		public Triangle2D(Triangle2D t) {   //copy constructor

			this.p_1 = t.getP1();
			this.p_2 = t.getP2();
			this.p_3 = t.getP3();
		}
		
//------------------------------------------------------------------------------------
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
	
//------------------------------------------------------------------------------------
	@Override
	public boolean contains(Point2D ot) {

		//the determinent :
		double determinant = (getP2().y() - getP3().y()) * (getP1().x() - getP3().x()) 
					- (getP3().x() - getP2().x()) * (getP3().y() - getP1().y());
		
		double min = Math.min(determinant, 0);      //min between determinant or 0
		double max = Math.max(determinant, 0);      //max between determinant or 0

		double a = (getP2().y() - getP3().y()) * (ot.x() - getP3().x())
				+ (getP3().x() - getP2().x()) * (ot.y() - getP3().y());
		
          if (a < min || a > max) {
				return false;
		  }
          
       double b = (getP3().y() - getP1().y()) * (ot.x() - getP3().x()) 
    		   + (getP1().x() - getP3().x()) * (ot.y() - getP3().y());
	     if (b < min || b > max) {
				return false;
	     }
	     
       double c = determinant - a - b;
	     if (c < min || c > max) {
				return false;
	     }

		return true;
   }

	@Override
	public Point2D centerOfMass() {
		double x = (getP1().x() + getP2().x() + getP3().x()) /3;
		double y = (getP1().y() + getP2().y() + getP3().y()) /3;
        Point2D centerOfMass= new Point2D(x,y);
        return centerOfMass;
	}

	@Override
	public double area() {
	//a,b,c are the edges length :
    double p1_p2 = Math.pow(getP2().x()-getP1().x(), 2) + Math.pow(getP2().y()-getP1().y(), 2);
	double a = Math.sqrt(p1_p2); 
	double p2_p3 = Math.pow(getP2().x()-getP3().x(), 2) + Math.pow(getP2().y()-getP3().y(), 2);
	double b = Math.sqrt(p2_p3);
	double p3_p1 = Math.pow(getP3().x()-getP1().x(), 2) + Math.pow(getP3().y()-getP1().y(), 2);
	double c = Math.sqrt(p3_p1);
	
	//area = Math.sqrt(d(d-a)(d-b)(d-c))           
	double  d =perimeter()/2;
    double area = Math.sqrt(d*(d-a)*(d-b)*(d-c));
    return area;
	}

	@Override
	public double perimeter() {
		//distances [P1P2],[P2P3],[P3P1] : 
		double p1_p2 = Math.pow(getP2().x()-getP1().x(), 2) + Math.pow(getP2().y()-getP1().y(), 2);
		double x =Math.sqrt(p1_p2);
		double p2_p3 = Math.pow(getP2().x()-getP3().x(), 2) + Math.pow(getP2().y()-getP3().y(), 2);
		double y =Math.sqrt(p2_p3);
		double p3_p1 = Math.pow(getP3().x()-getP1().x(), 2) + Math.pow(getP3().y()-getP1().y(), 2);
		double z =Math.sqrt(p3_p1);
        double perimeter = x + y + z;
        return perimeter;
	}

	@Override
	public void move(Point2D vec) {
		p_1.move(vec);
		p_2.move(vec);
		p_3.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Triangle2D(this);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D [] ans  = new Point2D[3];
        ans[0]=this.getP1();
		ans[1]=this.getP2();
		ans[2]=this.getP3();
        return ans;
	}
	
	@Override
	public String toString() {
		return "Triangle2D" +"," + p_1.x()+","+ p_1.y()+","+ p_2.x()+","+ p_2.y() +
				","+ p_3.x()+","+ p_3.y();
	}
}
