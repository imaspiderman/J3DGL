package graphics;

public class j3d_vector extends j3d_point {
	private static final long serialVersionUID = 1L;
	public double length;
	
	public j3d_vector(){
		super();
	}
	
	public j3d_vector(int x, int y, int z){
		super(x,y,z);
		calculateLength();
	}
	
	private void calculateLength(){
		this.length = java.lang.Math.sqrt((this.x*this.x)+(this.y*this.y)+(this.z*this.z));
	}
}
