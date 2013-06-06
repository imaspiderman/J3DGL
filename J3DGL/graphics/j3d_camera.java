package graphics;

public class j3d_camera extends j3d_solid {

	private j3d_vector lookAt;
	private int eyeDistance;

	public int getEyeDistance() {
		return eyeDistance;
	}

	public void setEyeDistance(int eyeDistance) {
		this.eyeDistance = eyeDistance;
	}

	public j3d_vector getLookAt() {
		return lookAt;
	}

	public j3d_camera() {
		lookAt = new j3d_vector();
		eyeDistance = (128 << j3d_globals.FIXED_POINT_SHITFT);
	}
	
	public void setLookAt(j3d_vector v){
		lookAt = v;
	}
	
	public j3d_point getRenderWorldPosition(){
		j3d_point p = new j3d_point(-this.getWorldPosition().z,
				-this.getWorldPosition().y,
				-this.getWorldPosition().z);
		return p;
	}

}
