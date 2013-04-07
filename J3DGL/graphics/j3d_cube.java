package graphics;

public class j3d_cube {
	public j3d_point center;
	public int width_half;
	public int height_half;
	public int depth_half;
	
	public j3d_cube(){
		this.center = new j3d_point(0,0,0);
		this.width_half = (1<<j3d_globals.FIXED_POINT_SHITFT)>>1;
		this.height_half = (1<<j3d_globals.FIXED_POINT_SHITFT)>>1;
		this.depth_half = (1<<j3d_globals.FIXED_POINT_SHITFT)>>1;
	}
	
	public j3d_cube(j3d_point center, int width, int height, int depth){
		this.center = center;
		this.width_half = (width<<j3d_globals.FIXED_POINT_SHITFT)>>1;
		this.height_half = (height<<j3d_globals.FIXED_POINT_SHITFT)>>1;
		this.depth_half = (depth<<j3d_globals.FIXED_POINT_SHITFT)>>1;
	}
	
	public boolean contains(j3d_point p){
		if(p.x < (this.center.x-this.width_half) || p.x > (this.center.x+this.width_half)) return false;
		if(p.y < (this.center.y-this.height_half) || p.y > (this.center.y+this.height_half)) return false;
		if(p.z < (this.center.z-this.depth_half) || p.z > (this.center.z+this.depth_half)) return false;
		
		return true;
	}
	
	public void translate(j3d_point center){
		this.center = center;
	}
}
