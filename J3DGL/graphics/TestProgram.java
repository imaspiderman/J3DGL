package graphics;

public class TestProgram {

	public TestProgram() {
		j3d_canvas c = new j3d_canvas(600,480);
		j3d_camera cam = new j3d_camera();
		j3d_lineMesh m = new j3d_lineMesh();
		m.addLine(0, 0, 0, 5000, 0, 0);

		c.setVisible(true);		
		
		c.renderMesh(m, cam);		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestProgram t = new TestProgram();
	}

}
