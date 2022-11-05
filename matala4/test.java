package matala4;



public class test {
	public static void main(String[] args) {
	Point2D p1 = new Point2D(3,3);
	Point2D p2 = new Point2D(0,3);
	Point2D p3 = new Point2D(2,1);
    Triangle2D t = new Triangle2D (p1,p2,p3);
    Triangle2D t11 = (Triangle2D) t.copy();
    System.out.println(t11.perimeter());
	}
    
}
