package graphics;

import java.awt.Window;

public class j3d_canvas extends Window {
	private static final long serialVersionUID = -7671323300003809317L;
	java.awt.Graphics g;

	public j3d_canvas(int width, int height){
		super(null);
		this.setSize(width, height);
		g = this.getGraphics();
	}
	
}
