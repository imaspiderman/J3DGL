package graphics;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class j3d_canvas extends Frame {
	private static final long serialVersionUID = -7671323300003809317L;
	java.awt.image.BufferedImage _screen;
	private java.util.LinkedList<j3d_line> lineBuffer;

	public j3d_canvas(int width, int height){
		this._screen = new java.awt.image.BufferedImage(width,height,java.awt.image.BufferedImage.TYPE_4BYTE_ABGR);
		this.setSize(width, height);
		this.lineBuffer = new java.util.LinkedList<j3d_line>();
		j3d_calc.initCosineAndSineTables();
		this.setBackground(Color.black);
		this.addWindowListener(new Closer());
	}
	
	public void clearCanvas(){
		Graphics2D g = (Graphics2D)this._screen.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, this._screen.getWidth(), this._screen.getHeight());
	}
	
	public void renderMesh(j3d_lineMesh m, j3d_camera c){
		this.lineBuffer.clear();
		j3d_line[] lines = m.getLines();
		lines = j3d_calc.translate(j3d_calc.subtract(m.getWorldPosition(), m.getRootPoint()), lines);
		lines = j3d_calc.scale(m.getWorldScale(), lines);
		lines = j3d_calc.rotateAllAxis(m.getWorldRotation().getIntX(), m.getWorldRotation().getIntY(), m.getWorldRotation().getIntZ(), lines);
		lines = j3d_calc.translate(m.getWorldPosition(), lines);
		lines = j3d_calc.translate(c.getRenderWorldPosition(), lines);
		lines = j3d_calc.rotateAllAxis(-c.getWorldRotation().getIntX(), -c.getWorldRotation().getIntY(), -c.getWorldRotation().getIntZ(), lines);
		
		int sx1;
		int sx2;
		int sy1;
		int sy2;
		for(int i=0; i<lines.length; i++){
			if(lines[i].getPoints()[0].z <= 0 && lines[i].getPoints()[1].z <= 0) continue;
			if(lines[i].getPoints()[0].z <= 0) lines[i].getPoints()[0].z = 1;
			if(lines[i].getPoints()[1].z <= 0) lines[i].getPoints()[1].z = 1;
			sx1 = j3d_calc.divide(
					j3d_calc.multiply(lines[i].getPoints()[0].x,c.getEyeDistance()),
					(c.getEyeDistance() + lines[i].getPoints()[0].z)
					) + ((this.getWidth()>>1)<<j3d_globals.FIXED_POINT_SHITFT)>>j3d_globals.FIXED_POINT_SHITFT;
			sy1 = j3d_calc.divide(
					j3d_calc.multiply(lines[i].getPoints()[0].y,c.getEyeDistance()),
					(c.getEyeDistance() + lines[i].getPoints()[0].z)
					) + ((this.getHeight()>>1)<<j3d_globals.FIXED_POINT_SHITFT)>>j3d_globals.FIXED_POINT_SHITFT;
			sx2 = j3d_calc.divide(
					j3d_calc.multiply(lines[i].getPoints()[1].x,c.getEyeDistance()),
					(c.getEyeDistance() + lines[i].getPoints()[1].z)
					) + ((this.getWidth()>>1)<<j3d_globals.FIXED_POINT_SHITFT)>>j3d_globals.FIXED_POINT_SHITFT;
			sy2 = j3d_calc.divide(
					j3d_calc.multiply(lines[i].getPoints()[1].y,c.getEyeDistance()),
					(c.getEyeDistance() + lines[i].getPoints()[1].z)
					) + ((this.getHeight()>>1)<<j3d_globals.FIXED_POINT_SHITFT)>>j3d_globals.FIXED_POINT_SHITFT;
			Graphics2D g = (Graphics2D)this._screen.getGraphics();
			g.setColor(Color.white);
			g.setClip(0, 0, _screen.getWidth(), _screen.getHeight());
			g.drawLine(sx1, sy1, sx2, sy2);
		}
		this.getGraphics().drawImage(_screen, 0, 0, null);
	}
	
	class Closer extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosing(e);
			System.exit(0);
		}
		
	}
	
}
