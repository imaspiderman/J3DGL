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
		this.length = java.lang.Math.sqrt(
				j3d_calc.multiply(this.x,this.x)+
				j3d_calc.multiply(this.y,this.y)+
				j3d_calc.multiply(this.z,this.z)
			);
	}
}
