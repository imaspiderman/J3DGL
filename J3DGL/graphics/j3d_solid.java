package graphics;

public class j3d_solid {
	private j3d_vector worldPosition;
	private j3d_vector position;
	private j3d_vector worldRotation;
	private j3d_vector rotation;
	private j3d_vector worldRotationSpeed;
	private j3d_vector rotationSpeed;
	private j3d_vector worldSpeed;
	private j3d_vector speed;
	private j3d_vector worldScale;
	private j3d_vector scale;
	
	public j3d_solid(){
		this.worldPosition = new j3d_vector(0,0,0);
		this.position = new j3d_vector(0,0,0);
		this.worldRotation = new j3d_vector(0,0,0);
		this.rotation = new j3d_vector(0,0,0);
		this.worldRotationSpeed = new j3d_vector(0,0,0);
		this.rotationSpeed = new j3d_vector(0,0,0);
		this.worldSpeed = new j3d_vector(0,0,0);
		this.speed = new j3d_vector(0,0,0);
		this.worldScale = new j3d_vector(0,0,0);
		this.scale = new j3d_vector(0,0,0);
	}

	public j3d_vector getWorldPosition() {
		return worldPosition;
	}

	public void setWorldPosition(j3d_vector worldPosition) {
		this.worldPosition = worldPosition;
	}

	public j3d_vector getPosition() {
		return position;
	}

	public void setPosition(j3d_vector position) {
		this.position = position;
	}

	public j3d_vector getWorldRotation() {
		return worldRotation;
	}

	public void setWorldRotation(j3d_vector worldRotation) {
		this.worldRotation = worldRotation;
	}

	public j3d_vector getRotation() {
		return rotation;
	}

	public void setRotation(j3d_vector rotation) {
		this.rotation = rotation;
	}

	public j3d_vector getWorldRotationSpeed() {
		return worldRotationSpeed;
	}

	public void setWorldRotationSpeed(j3d_vector worldRotationSpeed) {
		this.worldRotationSpeed = worldRotationSpeed;
	}

	public j3d_vector getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(j3d_vector rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}

	public j3d_vector getWorldSpeed() {
		return worldSpeed;
	}

	public void setWorldSpeed(j3d_vector worldSpeed) {
		this.worldSpeed = worldSpeed;
	}

	public j3d_vector getSpeed() {
		return speed;
	}

	public void setSpeed(j3d_vector speed) {
		this.speed = speed;
	}

	public j3d_vector getWorldScale() {
		return worldScale;
	}

	public void setWorldScale(j3d_vector worldScale) {
		this.worldScale = worldScale;
	}

	public j3d_vector getScale() {
		return scale;
	}

	public void setScale(j3d_vector scale) {
		this.scale = scale;
	}
	
}
