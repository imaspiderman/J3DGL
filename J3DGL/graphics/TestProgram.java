package graphics;

public class TestProgram {

	public TestProgram() {
		j3d_canvas c = new j3d_canvas(600,480);
		j3d_camera cam = new j3d_camera();
		j3d_lineMesh m = new j3d_lineMesh();
		m.addLine(0, 0, 0, 50, 0, 0);
		m.addLine(50,0,0,50,0,50);
		m.addLine(50,0,50,0,0,50);
		m.addLine(0,0,50,0,0,0);

		m.addLine(0, 50, 0, 50, 50, 0);
		m.addLine(50,50,0,50,50,50);
		m.addLine(50,50,50,0,50,50);
		m.addLine(0,50,50,0,50,0);
		
		m.addLine(0,0,0,0,50,0);
		m.addLine(0,0,50,0,50,50);
		m.addLine(50,0,0,50,50,0);
		m.addLine(50,0,50,50,50,50);
		
		m.setWorldPosition(new j3d_point(-25,-25,0));
		cam.setWorldPosition(new j3d_vector(0,0,0));
		
		c.setVisible(true);
		j3d_vector up = new j3d_vector(0,0,1);
		j3d_vector down = new j3d_vector(0,0,-1);
		m.setPosition(up);
		m.setWorldScale(new j3d_vector(5,5,2));
		while(true){
			c.clearCanvas();
			c.renderMesh(m, cam);
			moveMesh(m);
			if(m.getWorldPosition().getIntZ() > 100) m.setPosition(down);
			if(m.getWorldPosition().getIntZ() < -100) m.setPosition(up);
		}
	}
	
	private void moveMesh(j3d_lineMesh m){
		m.setWorldRotation(j3d_calc.add(m.getWorldRotation(), m.getRotation()));
		m.setWorldPosition(j3d_calc.add(m.getWorldPosition(), m.getPosition()));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestProgram t = new TestProgram();
	}

}
