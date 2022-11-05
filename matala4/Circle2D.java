package matala4;
/** 
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShape {
	private Point2D _center;
	private double _radius;
	
	public Circle2D(Point2D cen, double rad) {     //constructor
		this._center = new Point2D(cen);
		this._radius = rad;
	}
	
    public Circle2D(Circle2D C) {                 //copy constructor
	    this._center = C.getCenter();
	    this._radius = C.getRadius();
		}
//--------------------------------------------------------------------------	
  //gets and sets :
    
  	public Point2D getCenter() {              
  		return this._center;
  	}
    public double getRadius() {             
		return this._radius;
	}
//--------------------------------------------------------------------------	
    
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}
	
	//it's the center of the circle
	@Override
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}
	
	//area = PI*R^2
	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}
	
	//perimeter = 2*PI*R
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}
	
	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}
	
	@Override
	public GeoShape copy() {
		return new Circle2D(_center, _radius);
	}
	
	@Override
	public String toString(){
		return "Circle2D,"+_center.x()+","+_center.y()+", "+_radius;
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}
	
}
