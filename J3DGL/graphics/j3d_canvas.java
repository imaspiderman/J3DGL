package graphics;

import java.awt.Window;

public class j3d_canvas extends Window {
	private static final long serialVersionUID = -7671323300003809317L;
	java.awt.Graphics g;
	private java.util.LinkedList<j3d_line> lineBuffer;

	public j3d_canvas(int width, int height){
		super(null);
		this.setSize(width, height);
		this.lineBuffer = new java.util.LinkedList<j3d_line>();
		this.g = this.getGraphics();
		j3d_calc.initCosineAndSineTables();
	}
	
	public void renderMesh(j3d_lineMesh m, j3d_camera c){
		this.lineBuffer.clear();
		j3d_line[] lines = m.getLines();
		lines = j3d_calc.scale(m.getScale(), lines);
		lines = j3d_calc.rotateAllAxis(m.getRotation().getIntX(), m.getRotation().getIntY(), m.getRotation().getIntZ(), lines);
		lines = j3d_calc.translate(m.getWorldPosition(), lines);
		lines = j3d_calc.translate(c.getRenderWorldPosition(), lines);
		lines = j3d_calc.rotateAllAxis(-c.getRotation().getIntX(), -c.getRotation().getIntY(), -c.getRotation().getIntZ(), lines);
		
		int sx1;
		int sx2;
		int sy1;
		int sy2;
		for(int i=0; i<lines.length; i++){
			sx1 = j3d_calc.divide(
					j3d_calc.multiply(lines[i].getPoints()[0].x,c.getEyeDistance()),
					(c.getEyeDistance() + lines[i].getPoints()[0].z)
					) + ((this.getWidth()>>1)<<j3d_globals.FIXED_POINT_SHITFT);
			sy1 = j3d_calc.divide(
					j3d_calc.multiply(lines[i].getPoints()[0].y,c.getEyeDistance()),
					(c.getEyeDistance() + lines[i].getPoints()[0].z)
					) + ((this.getHeight()>>1)<<j3d_globals.FIXED_POINT_SHITFT);
			sx2 = j3d_calc.divide(
					j3d_calc.multiply(lines[i].getPoints()[1].x,c.getEyeDistance()),
					(c.getEyeDistance() + lines[i].getPoints()[1].z)
					) + ((this.getWidth()>>1)<<j3d_globals.FIXED_POINT_SHITFT);
			sy2 = j3d_calc.divide(
					j3d_calc.multiply(lines[i].getPoints()[1].y,c.getEyeDistance()),
					(c.getEyeDistance() + lines[i].getPoints()[1].z)
					) + ((this.getHeight()>>1)<<j3d_globals.FIXED_POINT_SHITFT);
			
			this.g.drawLine(sx1, sy1, sx2, sy2);
		}
		
		this.invalidate();
	}
	
}
