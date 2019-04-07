package algoritmosPseudoaleatorios;
import javax.swing.JFrame;

public class InterfazResultado extends Thread{
	private int Xo ;
	private int Xi;
	private int cantidad;
	private String seleccion;
	//constructor1
	public InterfazResultado(int x,int cantidad,String seleccion) {
		Xo = x;
		Xi = 0;
		this.cantidad = cantidad;
		this.seleccion = seleccion;
	}
	//constructor 2
	public InterfazResultado(int x,int y,int cantidad,String seleccion) {
		Xo = x;
		Xi = y;
		this.cantidad = cantidad;
		this.seleccion = seleccion;
	}
	//inicia el hilo de ejecucion
	public void run() {
		if(seleccion == "Cuadrados Medios") {
			MarcoResultados mimarco = new MarcoResultados(Xo,cantidad,seleccion);
			mimarco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mimarco.setResizable(false);
			mimarco.setVisible(true);
		}else if(seleccion =="Producto Medio"){
			
			MarcoResultados mimarco = new MarcoResultados(Xo,Xi,cantidad,seleccion);
			mimarco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mimarco.setResizable(false);
			mimarco.setVisible(true);
		}else {
			MarcoResultados mimarco = new MarcoResultados(Xo,Xi,cantidad,seleccion);
			mimarco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mimarco.setResizable(false);
			mimarco.setVisible(true);
		}
		
	}
}
