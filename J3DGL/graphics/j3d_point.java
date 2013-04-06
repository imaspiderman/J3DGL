package graphics;

import java.awt.geom.Point2D;

public class j3d_point extends java.awt.Point {
	private static final long serialVersionUID = 1L;
	public int z;
	
	public j3d_point(){
		super();
	}
	/**
	 * Constructor expects 3 non fixed point integers and will convert their values to fixed point
	 * @param x Non-fixed point integer
	 * @param y Non-fixed point integer
	 * @param z Non-fixed point integer
	 */
	public j3d_point(int x, int y, int z){
		super((x<<j3d_globals.FIXED_POINT_SHITFT),(y<<j3d_globals.FIXED_POINT_SHITFT));
		this.z = (z<<j3d_globals.FIXED_POINT_SHITFT);
	}
	
	public int getZ(){
		return z;
	}
	
	/**
	 * Changes this j3d_point to the new j3d_point values
	 * @param p The j3d_point to set this points values to
	 */
	public void setLocation(j3d_point p){
		this.setLocation(p.x, p.y);
		this.z = p.z;
	}
	
	/**
	 * Expects 3 fixed point integers
	 * @param x Fixed point integer
	 * @param y Fixed point integer
	 * @param z Fixed point integer
	 */
	public void setLocation(int x, int y, int z){
		this.setLocation(x, y);
		this.z = z;
	}
	
	/**
	 * Calculates the distance between two j3d_points
	 * @param p j3d_point to calculate the distance from this point
	 * @return The distance in double format
	 */
	public double distance(j3d_point p){
		double r;
		r = java.lang.Math.sqrt(((p.x - this.x)*(p.x - this.x))+((p.y-this.y)*(p.y-this.y))+((p.z-this.z)*(p.z-this.z)));
		return r;
	}

	/**
	 * Not implemented
	 */
	@Override
	public double distance(double px, double py) {
		try{
			throw new java.lang.UnsupportedOperationException();
		}catch(Exception ex){}
		
		double r=0;
		return r;
	}
	/**
	 * Not implemented
	 */
	@Override
	public double distance(Point2D pt) {
		try{
			throw new java.lang.UnsupportedOperationException();
		}catch(Exception ex){}
		
		double r=0;
		return r;
	}
	/**
	 * Not implemented
	 */
	@Override
	public double distanceSq(double px, double py) {
		try{
			throw new java.lang.UnsupportedOperationException();
		}catch(Exception ex){}
		
		double r=0;
		return r;
	}
	/**
	 * Not implemented
	 */
	@Override
	public double distanceSq(Point2D pt) {
		try{
			throw new java.lang.UnsupportedOperationException();
		}catch(Exception ex){}
		
		double r=0;
		return r;
	}
	/**
	 * Not implemented
	 */
	@Override
	public void setLocation(double x, double y) {
		try{
			throw new java.lang.UnsupportedOperationException();
		}catch(Exception ex){}
	}
	
	
}
