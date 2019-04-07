package algoritmosPseudoaleatorios;
import javax.swing.JFrame;

public class MarcoResultados extends JFrame{
	private int x;
	private int y;
	private int cantidad;
	private String seleccion;
	//constructor
	public MarcoResultados(int x,int cantidad,String seleccion) {
		this.x = x;
		y = 0;
		this.cantidad = cantidad;
		this.seleccion= seleccion;
		setTitle(seleccion);
		setBounds(450,200,500,500);
		PanelResultados lamina = new PanelResultados(this.x,this.cantidad,this.seleccion);
		add(lamina);
	}
	//constructor2
	public MarcoResultados(int x,int y,int cantidad,String seleccion) {
		this.x = x;
		this.y = y;
		this.cantidad = cantidad;
		this.seleccion= seleccion;
		
		setTitle(this.seleccion);
		setBounds(500,200,550,600);
		
		PanelResultados lamina = new PanelResultados(this.x,this.y,this.cantidad,this.seleccion);
		add(lamina);
	}
	
}
