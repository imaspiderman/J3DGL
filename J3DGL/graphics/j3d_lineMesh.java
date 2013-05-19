package graphics;

public class j3d_lineMesh extends j3d_solid{
	private java.util.LinkedList<j3d_line> lines;
	
	/**
	 * This mesh is used for objects that will be in wire frame form only
	 * It allows the creation of complete objects that don't necessarily have all
	 * the lines connected throughout the object.
	 */
	public j3d_lineMesh(){
		super();
		lines = new java.util.LinkedList<j3d_line>();
	}
	
	/**
	 * Adds a new j3d_line to the mesh
	 * @param l
	 */
	public void addLine(j3d_line l){
		lines.add(l);
	}
	
	/**
	 * Adds a new line to the mesh using two j3d_points
	 * @param p1
	 * @param p2
	 */
	public void addLine(j3d_point p1, j3d_point p2){
		j3d_line l = new j3d_line(p1,p2);
		lines.add(l);
	}
	
	/**
	 * Adds a new line to the mesh using 2 sets of x,y,z coordinates
	 * @param x1 Non-fixed point value
	 * @param y1 Non-fixed point value
	 * @param z1 Non-fixed point value
	 * @param x2 Non-fixed point value
	 * @param y2 Non-fixed point value
	 * @param z2 Non-fixed point value
	 */
	public void addLine(int x1, int y1, int z1, int x2, int y2, int z2){
		j3d_line l = new j3d_line(new j3d_point(x1,y1,z1), new j3d_point(x2,y2,z2));
		lines.add(l);
	}
	
	/**
	 * Gets all the lines of the mesh in an array
	 * @return
	 */
	public j3d_line[] getLines(){
		return this.lines.toArray(new j3d_line[0]);
	}
}
