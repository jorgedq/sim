package algoritmosPseudoaleatorios;
import javax.swing.JFrame;

public class MarcoInterfaz extends JFrame{
	//metodo constructor
	public MarcoInterfaz () {
		setTitle("N�meros Pseudoaleatorios");
		setBounds(400,150,550,210);
		PanelInterfaz lamina = new PanelInterfaz();
		add(lamina);
	}
	

}
