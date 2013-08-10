package graphics;

public class j3d_calc {
	
	public static int[] cosine = null;
	public static int[] sine = null;
	
	public j3d_calc(){};
	
	/**
	 * Adds two points together
	 * @param p1 First point
	 * @param p2 Second point
	 * @return Sum of two points
	 */
	public static j3d_point add(j3d_point p1, j3d_point p2){
		j3d_point r = new j3d_point();
		
		r.x = p1.x + p2.x;
		r.y = p1.y + p2.y;
		r.z = p1.z + p2.z;
		
		return r;
	}
	
	/**
	 * Add two vectors together
	 * @param v1 First vector
	 * @param v2 Second vector
	 * @return Sum of two vectors
	 */
	public static j3d_vector add(j3d_vector v1, j3d_vector v2){
		j3d_vector r = new j3d_vector(
					((v1.x+v2.x)>>j3d_globals.FIXED_POINT_SHITFT),
					((v1.y+v2.y)>>j3d_globals.FIXED_POINT_SHITFT),
					((v1.z+v2.z)>>j3d_globals.FIXED_POINT_SHITFT)
				);
		return r;
	}
	
	/**
	 * Subtracts the second point from the first point
	 * @param p1 First point
	 * @param p2 Second point
	 * @return The difference of the two points
	 */
	public static j3d_point subtract(j3d_point p1, j3d_point p2){
		j3d_point r = new j3d_point();
		
		r.x = p1.x - p2.x;
		r.y = p1.y - p2.y;
		r.z = p1.z - p2.z;
		
		return r;
	}
	
	/**
	 * Subtracts the second vector from the first vector
	 * @param v1 First vector
	 * @param v2 Second vector
	 * @return The difference of the two vectors
	 */
	public static j3d_vector subtract(j3d_vector v1, j3d_vector v2){
		j3d_vector r = new j3d_vector(
				((v1.x-v2.x)>>j3d_globals.FIXED_POINT_SHITFT),
				((v1.y-v2.y)>>j3d_globals.FIXED_POINT_SHITFT),
				((v1.z-v2.z)>>j3d_globals.FIXED_POINT_SHITFT)
			);
		return r;
	}
	
	/**
	 * Fixed point multiply of two integers
	 * @param i1 First fixed point integer
	 * @param i2 Second fixed point integer
	 * @return Fixed point integer
	 */
	public static int multiply(int i1, int i2){		
		long l1 = i1;
		long l2 = i2;
		return (int)((l1*l2)>>j3d_globals.FIXED_POINT_SHITFT);
	}
	
	/**
	 * Multiplies two j3d_point objects together
	 * @param p1 First point
	 * @param p2 Second point
	 * @return New point
	 */
	public static j3d_point multiply(j3d_point p1, j3d_point p2){
		j3d_point r = new j3d_point();
		
		r.x = multiply(p1.x,p2.x);
		r.y = multiply(p1.y,p2.y);
		r.z = multiply(p1.z,p2.z);
		
		return r;
	}
	
	/**
	 * Multiplies two j3d_vectors objects together
	 * @param v1 First vector
	 * @param v2 Second vector
	 * @return New vector
	 */
	public static j3d_vector multiply(j3d_vector v1, j3d_vector v2){
		j3d_vector r = new j3d_vector(
					multiply(v1.x,v2.x),
					multiply(v1.y,v2.y),
					multiply(v1.z,v2.z)
				);
		return r;
	}
	
	/**
	 * Fixed point divide of two integers
	 * @param i1 First fixed point integer
	 * @param i2 Second fixed point integer
	 * @return Fixed point integer
	 */
	public static int divide(int i1, int i2){
		long l1 = i1;
		long l2 = i2;
		return (int)((l1<<j3d_globals.FIXED_POINT_SHITFT)/l2);
	}
	
	/**
	 * Scales an array of lines by a factor
	 * @param factor Scale factor as a j3d_vector
	 * @param lines Array of j3d_points
	 * @return New array of scaled lines
	 */
	public static j3d_line[] scale(j3d_vector factor, j3d_line[] lines){
		j3d_line[] newArray = new j3d_line[lines.length];
		for(int i=0; i<lines.length; i++){
			j3d_point p1,p2;
			p1 = j3d_calc.multiply((j3d_point)factor, lines[i].getPoints()[0]);
			p2 = j3d_calc.multiply((j3d_point)factor, lines[i].getPoints()[1]);
			newArray[i] = new j3d_line(p1,p2);
		}
		return newArray;
	}
	
	/**
	 * Translates an array of lines by a given j3d_vector translation
	 * @param translate The j3d_vector to translate by
	 * @param lines The array of lines to translate
	 * @return New array of translated lines
	 */
	public static j3d_line[] translate(j3d_point translate, j3d_line[] lines){
		j3d_line[] newArray = new j3d_line[lines.length];
		for(int i=0; i<lines.length; i++){
			j3d_point p1,p2;
			p1 = j3d_calc.add(translate,lines[i].getPoints()[0]);
			p2 = j3d_calc.add(translate, lines[i].getPoints()[1]);
			newArray[i] = new j3d_line(p1,p2);
		}
		return newArray;
	}
	
	/**
	 * Call this once during setup to initialize the cosine and sine tables
	 * used for calculations. The tables will contain the fixed point values
	 * of sine and cosine needed for arithmetic.
	 */
	public static void initCosineAndSineTables(){
		double radians = 0.00;
		if(cosine != null && sine != null) return;
		
		cosine = new int[360];
		sine = new int[360];
		
		for(double angle=0; angle<360; angle++){
			radians = (java.lang.Math.PI * angle)/180;
			cosine[(int)angle] = (int)(java.lang.Math.cos(radians) * java.lang.Math.pow(2.0, (double)j3d_globals.FIXED_POINT_SHITFT));
			sine[(int)angle] = (int)(java.lang.Math.sin(radians) * java.lang.Math.pow(2.0, (double)j3d_globals.FIXED_POINT_SHITFT));
		}
	}
	
	/**
	 * Forces the value to be between -359 and 359
	 * @param degrees
	 * @return
	 */
	public static int normalizeDegrees(int degrees){
		int r = degrees;
		if(java.lang.Math.abs(degrees)>359){
			int temp = 0;
			temp = java.lang.Math.abs(degrees);
			temp = temp % 360;
			if(degrees < 0) temp = ~temp + 1;
			r = temp;
		}
		
		if(r < 0) r = 360 + r;
		
		return r;
	}
	
	/**
	 * Rotates the points of a line around the X axis by the given degrees
	 * @param degrees Value between -359 and 359
	 * @param lines Array of lines to rotate
	 * @return New array of rotated lines
	 */
	public static j3d_line[] rotateXAxis(int degrees, j3d_line[] lines){
		if(degrees == 0) return lines;
		
		j3d_line[] newArray = new j3d_line[lines.length];
		j3d_point p1,p2;
		
		degrees = j3d_calc.normalizeDegrees(degrees);
		
		for(int i=0; i<lines.length; i++){
			p1 = new j3d_point();
			p2 = new j3d_point();
			
			p1.x = lines[i].getPoints()[0].x;
			p1.y = j3d_calc.multiply(lines[i].getPoints()[0].z,-sine[degrees]) + 
				   j3d_calc.multiply(lines[i].getPoints()[0].y, cosine[degrees]);
			p1.z = j3d_calc.multiply(lines[i].getPoints()[0].z, cosine[degrees]) +
				   j3d_calc.multiply(lines[i].getPoints()[0].y, sine[degrees]);
			
			p2.x = lines[i].getPoints()[1].x;
			p2.y = j3d_calc.multiply(lines[i].getPoints()[1].z,-sine[degrees]) + 
				   j3d_calc.multiply(lines[i].getPoints()[1].y, cosine[degrees]);
			p2.z = j3d_calc.multiply(lines[i].getPoints()[1].z, cosine[degrees]) +
				   j3d_calc.multiply(lines[i].getPoints()[1].y, sine[degrees]);
			
			newArray[i] = new j3d_line(p1,p2);
		}
		return newArray;
	}
	
	/**
	 * Rotates the points of a line around the Y axis by the given degrees
	 * @param degrees Value between -359 and 359
	 * @param lines Array of lines to rotate
	 * @return New array of rotated lines
	 */
	public static j3d_line[] rotateYAxis(int degrees, j3d_line[] lines){
		if(degrees == 0) return lines;
		
		j3d_line[] newArray = new j3d_line[lines.length];
		j3d_point p1,p2;
		
		degrees = j3d_calc.normalizeDegrees(degrees);
		
		for(int i=0; i<lines.length; i++){
			p1 = new j3d_point();
			p2 = new j3d_point();
			
			p1.y = lines[i].getPoints()[0].y;
			p1.x = j3d_calc.multiply(lines[i].getPoints()[0].x, cosine[degrees]) + 
				   j3d_calc.multiply(lines[i].getPoints()[0].z, sine[degrees]);
			p1.z = j3d_calc.multiply(lines[i].getPoints()[0].x, -sine[degrees]) +
				   j3d_calc.multiply(lines[i].getPoints()[0].z, cosine[degrees]);
			
			p2.y = lines[i].getPoints()[1].y;
			p2.x = j3d_calc.multiply(lines[i].getPoints()[1].x, cosine[degrees]) + 
				   j3d_calc.multiply(lines[i].getPoints()[1].z, sine[degrees]);
			p2.z = j3d_calc.multiply(lines[i].getPoints()[1].x, -sine[degrees]) +
				   j3d_calc.multiply(lines[i].getPoints()[1].z, cosine[degrees]);
			
			newArray[i] = new j3d_line(p1,p2);
		}
		return newArray;
	}
	
	/**
	 * Rotates the points of a line around the Z axis by the given degrees
	 * @param degrees Value between -359 and 359
	 * @param lines Array of lines to rotate
	 * @return New array of rotated lines
	 */
	public static j3d_line[] rotateZAxis(int degrees, j3d_line[] lines){
		if(degrees == 0) return lines;
		
		j3d_line[] newArray = new j3d_line[lines.length];
		j3d_point p1,p2;
		
		degrees = j3d_calc.normalizeDegrees(degrees);
		
		for(int i=0; i<lines.length; i++){
			p1 = new j3d_point();
			p2 = new j3d_point();
			
			p1.z = lines[i].getPoints()[0].z;
			p1.x = j3d_calc.multiply(lines[i].getPoints()[0].x, cosine[degrees]) + 
				   j3d_calc.multiply(lines[i].getPoints()[0].y, sine[degrees]);
			p1.y = j3d_calc.multiply(lines[i].getPoints()[0].x, -sine[degrees]) +
				   j3d_calc.multiply(lines[i].getPoints()[0].y, cosine[degrees]);
			
			p2.z = lines[i].getPoints()[1].z;
			p2.x = j3d_calc.multiply(lines[i].getPoints()[1].x, cosine[degrees]) + 
				   j3d_calc.multiply(lines[i].getPoints()[1].y, sine[degrees]);
			p2.y = j3d_calc.multiply(lines[i].getPoints()[1].x, -sine[degrees]) +
				   j3d_calc.multiply(lines[i].getPoints()[1].y, cosine[degrees]);
			
			newArray[i] = new j3d_line(p1,p2);
		}
		return newArray;
	}
	
	/**
	 * Rotates an array of lines around all 3 axis
	 * @param xDegrees Degrees to rotate around X axis
	 * @param yDegrees Degrees to rotate around Y axis
	 * @param zDegrees Degrees to rotate around Z axis
	 * @param lines Array of lines to perform rotation transformation
	 * @return New array of rotated lines.
	 */
	public static j3d_line[] rotateAllAxis(int xDegrees, int yDegrees, int zDegrees, j3d_line[] lines){
		j3d_line[] newArray;
		
		newArray = j3d_calc.rotateXAxis(xDegrees, lines);
		newArray = j3d_calc.rotateYAxis(yDegrees, newArray);
		newArray = j3d_calc.rotateZAxis(zDegrees, newArray);
		
		return newArray;
	}
}
