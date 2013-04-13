package graphics;

public class j3d_line {
	private j3d_point[] points = new j3d_point[2];
	
	/**
	 * Represents a line as two j3d_point objects
	 * @param p1 First end point of the line
	 * @param p2 Second end point of the line
	 */
	public j3d_line(j3d_point p1, j3d_point p2){
		points[0] = p1;
		points[1] = p2;
	}
	
	/**
	 * Gets the points of the line
	 * @return
	 */
	public j3d_point[] getPoints(){
		return this.points;
	}
}
