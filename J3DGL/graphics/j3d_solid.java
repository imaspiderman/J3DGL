package graphics;

public class j3d_solid {
	private j3d_point worldPosition;
	private j3d_vector position;
	private j3d_vector worldRotation;
	private j3d_vector rotation;
	private j3d_vector worldSpeed;
	private j3d_vector speed;
	private j3d_vector worldScale;
	private j3d_vector scale;
	
	public j3d_solid(){
		this.worldPosition = new j3d_point(0,0,0);
		this.position = new j3d_vector(0,0,0);
		this.worldRotation = new j3d_vector(0,0,0);
		this.rotation = new j3d_vector(0,0,0);
		this.worldSpeed = new j3d_vector(0,0,0);
		this.speed = new j3d_vector(0,0,0);
		this.worldScale = new j3d_vector(1,1,1);
		this.scale = new j3d_vector(0,0,0);
	}

	/**
	 * This is the position of an object inside of the world
	 * @return
	 */
	public j3d_point getWorldPosition() {
		return worldPosition;
	}

	/**
	 * This is the position of an object inside of the world
	 * @return
	 */
	public void setWorldPosition(j3d_point worldPosition) {
		this.worldPosition = worldPosition;
	}

	/**
	 * This is a vector to add to the world position every game frame
	 * @return
	 */
	public j3d_vector getPosition() {
		return position;
	}

	/**
	 * This is a vector to add to the world position every game frame
	 * @return
	 */
	public void setPosition(j3d_vector position) {
		this.position = position;
	}

	/**
	 * This is how much the object is rotated around all 3 axis in degrees
	 * values between -359 and 359
	 * @return
	 */
	public j3d_vector getWorldRotation() {
		return worldRotation;
	}

	/**
	 * This is how much the object is rotated around all 3 axis in degrees
	 * values between -359 and 359
	 * @return
	 */
	public void setWorldRotation(j3d_vector worldRotation) {
		this.worldRotation = worldRotation;
	}

	/**
	 * This is a vector to increment each axis rotation every game frame in degrees.
	 * (So how fast an object will be spinning).
	 * @return
	 */
	public j3d_vector getRotation() {
		return rotation;
	}

	/**
	 * This is a vector to increment each axis rotation every game frame in degrees.
	 * (So how fast an object will be spinning).
	 * @return
	 */
	public void setRotation(j3d_vector rotation) {
		this.rotation = rotation;
	}

	/**
	 * This is how fast and in what direction an object is moving through the world
	 * @return
	 */
	public j3d_vector getWorldSpeed() {
		return worldSpeed;
	}

	/**
	 * This is how fast and in what direction an object is moving through the world
	 * @return
	 */
	public void setWorldSpeed(j3d_vector worldSpeed) {
		this.worldSpeed = worldSpeed;
	}

	/**
	 * This is how fast and in what direction an object is accelerating through the world
	 * @return
	 */
	public j3d_vector getSpeed() {
		return speed;
	}

	/**
	 * This is how fast and in what direction an object is accelerating through the world
	 * @return
	 */
	public void setSpeed(j3d_vector speed) {
		this.speed = speed;
	}

	/**
	 * This is how much to scale each point of an object by. It is multiplied to all point values.
	 * @return
	 */
	public j3d_vector getWorldScale() {
		return worldScale;
	}

	/**
	 * This is how much to scale each point of an object by. It is multiplied to all point values.
	 * @return
	 */
	public void setWorldScale(j3d_vector worldScale) {
		this.worldScale = worldScale;
	}

	/**
	 * This is a factor to continually add to the world scale each game frame.
	 * (So how fast an object expands or contracts)
	 * @return
	 */
	public j3d_vector getScale() {
		return scale;
	}

	/**
	 * This is a factor to continually add to the world scale each game frame.
	 * (So how fast an object expands or contracts)
	 * @return
	 */
	public void setScale(j3d_vector scale) {
		this.scale = scale;
	}
	
}
