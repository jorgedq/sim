package algoritmosPseudoaleatorios;
import javax.swing.JFrame;

public class MarcoInterfaz extends JFrame{
	//metodo constructor
	public MarcoInterfaz () {
		setTitle("Numeros Pseudoaleatorios");
		setBounds(400,150,550,210);
		PanelInterfaz lamina = new PanelInterfaz();
		add(lamina);
	}
	

}
