package graphics;

import java.awt.Polygon;

public class j3d_polygon extends Polygon {
	private static final long serialVersionUID = 1L;
	public java.util.LinkedList<j3d_point> points;
	
	public j3d_polygon(){
		super();
		points = new java.util.LinkedList<j3d_point>();
	}
	
	/**
	 * Adds a point with non fixed point parameters to the polygon
	 * @param x Non-fixed point x
	 * @param y Non-fixed point y
	 * @param z Non-fixed point z
	 */
	public void addPoint(int x, int y, int z){
		points.add(new j3d_point(x,y,z));
	}
	
	public j3d_cube getBounds3D(){
		j3d_cube c;
		java.util.Iterator<j3d_point> i = points.iterator();
		int maxX,maxY,maxZ,minX,minY,minZ;
		
		maxX=maxY=maxZ=minX=minY=minZ=0;
		
		boolean bFirst = true;
		while(i.hasNext()){
			j3d_point p = i.next();
			if(bFirst){
				maxX=minX=p.x;
				maxY=minY=p.y;
				maxZ=minZ=p.z;
			}else{
				if(p.x < minX) minX = p.x;
				if(p.x > maxX) maxX = p.x;
				if(p.y < minY) minY = p.y;
				if(p.y > maxY) maxY = p.y;
				if(p.z < minZ) minZ = p.z;
				if(p.z > maxZ) maxZ = p.z;
			}
			bFirst = false;
		}
		
		c = new j3d_cube(
				new j3d_point(
					((minX+maxX)>>1)>>j3d_globals.FIXED_POINT_SHITFT,
					((minY+maxY)>>1)>>j3d_globals.FIXED_POINT_SHITFT,
					(minZ+maxZ>>1)>>j3d_globals.FIXED_POINT_SHITFT
				),
				(maxX-minX),
				(maxY-minY),
				(maxZ-minZ)
			);
		
		return c;
	}
	
	/**
	 * Adds a j3d_point to the polygon
	 * @param p j3d_point
	 */
	public void addPoint(j3d_point p){
		points.add(p);
	}
}
