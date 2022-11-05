package matala2;

//342615648, Souffir Ilan Meyer

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

class Ex2_Test {
	static double[] po1={2,0,3, -1,0}, 
			po2 = {0.1,0,1, 0.1,3};
	static final double EPS = 0.001;

	@Test
	void testF() {
		double[] po={1,2,3,4};
		double f0 = Ex2.f(po, 0);
		double f1 = Ex2.f(po, 1);
		double f2 = Ex2.f(po, 2);
		double fx0 = Ex2.f(po1, 0);
		double fx1 = Ex2.f(po1, 1);
		double fx2 = Ex2.f(po1, 2);
		assertEquals(f0,1);
		assertEquals(f1,10);
		assertEquals(f2,49);
		assertEquals(fx0,2);
		assertEquals(fx1,4);
		assertEquals(fx2,6);
	}
	
	
	@Test
	void testpoly() {
		double[] poly={1,2,3,4};
		double[] poly1={1,0,3,4};
        String str = Ex2.poly(poly);
        String str1 = "4.0x^3 +3.0x^2 +2.0x^1 +1.0";
        String string = Ex2.poly(poly1);
        String string1 = "4.0x^3 +3.0x^2 +1.0";
        assertEquals(str,str1);
        assertEquals(string,string1);
		
	}
	

	@Test
	void testRoot() {
		double x12 = Ex2.root(po1, 0, 10, EPS);
		assertEquals(x12, 3.1958, 0.001);
	}
	@Test
	void testRoot2() {
		double[] poly={-5,3,0,1};
		double x = Ex2.root(poly, 1, 2, EPS);
		assertEquals(1.1542, x, 0.001);
	}
	@Test
	void testRoot3() {
		double[] poly={-10,3,0,0,0,5};
		double x = Ex2.root(poly, 0, 2, EPS);
		assertEquals(1.0637, x, 0.001);
	}
	
	
	@Test
    void testadd() {
		double[] p1 ={-5,3,0,1};
		double[] p2 ={5,-3,0,-1};
		double[] p3 ={0,0,0,0};
		double [] x = Ex2.add(p1,p2);
		assertEquals(x[0], p3[0]);
		assertEquals(x[2], p3[2]);
		assertEquals(x.length, p3.length);
		}
	@Test
    void testadd1() {
		double[] p1 ={1,2,3};
		double[] p2 ={0,0,0,3,5};
		double[] p3 ={1,2,3,3,5};
		double [] x = Ex2.add(p1,p2);
		assertEquals(x[0], p3[0]);
		assertEquals(x[2], p3[2]);
		assertEquals(x[3], p3[3]);
		assertEquals(x.length, p3.length);
		}
	
	
    @Test
    void testmul() {
    	double[] p1 ={1,2,3};
		double[] p2 ={1,2,3};
		double[] p3 ={1,4,10,12,9};
		double [] x = Ex2.mul(p1,p2);
		assertEquals(x[0], p3[0]);
		assertEquals(x[1], p3[1]);
		assertEquals(x[2], p3[2]);
		assertEquals(x[3], p3[3]);
		assertEquals(x[4], p3[4]);
		assertEquals(x.length, p3.length);
		}
    @Test
    void testmul2() {
    	double[] p1 ={2,1,3,1};
		double[] p2 ={0,1};
		double[] p3 ={0,2,1,3,1};
		double [] x = Ex2.mul(p1,p2);
		assertEquals(x[0], p3[0]);
		assertEquals(x[1], p3[1]);
		assertEquals(x[2], p3[2]);
		assertEquals(x[3], p3[3]);
		assertEquals(x[4], p3[4]);
		assertEquals(x.length, p3.length);
		}
	
    

    
	@Test
	void testDerivativeArrayDoubleArray() {
		double[] p = {1,2,3}; // 3X^2+2x+1
		double[] dp1 = {2,6}; // 6x+2
		double[] dp2 = Ex2.derivative(p);
		assertEquals(dp1[0], dp2[0],EPS);
		assertEquals(dp1[1], dp2[1],EPS);
		assertEquals(dp1.length, dp2.length);
	}
	@Test
	void testDerivativeArrayDoubleArray2() {
		double[] p = {1,2,3,4}; // 4x^3+3X^2+2x+1
		double[] dp1 = {2,6,12}; // 6x+2
		double[] dp2 = Ex2.derivative(p);
		assertEquals(dp1[0], dp2[0],EPS);
		assertEquals(dp1[1], dp2[1],EPS);
		assertEquals(dp1[2], dp2[2],EPS);
		assertEquals(dp1.length, dp2.length);
	}
}
