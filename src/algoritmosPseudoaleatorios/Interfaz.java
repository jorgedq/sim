package algoritmosPseudoaleatorios;
import javax.swing.JFrame;

public class Interfaz extends Thread{
	//hilo de ejecucion
	public void run() {
		MarcoInterfaz mimarco = new MarcoInterfaz();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setResizable(false);
		mimarco.setVisible(true);
	}
}
