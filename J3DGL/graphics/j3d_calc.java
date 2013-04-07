package graphics;

public class j3d_calc {
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
		return (i1*i2)>>j3d_globals.FIXED_POINT_SHITFT;
	}
	
	/**
	 * Fixed point divide of two integers
	 * @param i1 First fixed point integer
	 * @param i2 Second fixed point integer
	 * @return Fixed point integer
	 */
	public static int divide(int i1, int i2){
		return((i1<<j3d_globals.FIXED_POINT_SHITFT)/i2);
	}
}
