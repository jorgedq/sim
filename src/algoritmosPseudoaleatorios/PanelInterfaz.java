package algoritmosPseudoaleatorios;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInterfaz extends JPanel {
	 private JComboBox combo;
	 private JTextField semilla1;
	 private JTextField semilla2;
	 private JTextField cantidad;
	 private JLabel labelMedio2;
	 private JButton generar;
	 private JLabel label1;
	
	 //metodo constructor
	public PanelInterfaz() {
		setLayout(new BorderLayout());
		
		add(PanelMedio(),BorderLayout.CENTER);
		add(PanelSuperior(),BorderLayout.NORTH);
		add(PanelInferior(),BorderLayout.SOUTH);
		ocultar();
	}
	//funcionalidad para cambiar los atributos a multiplicador
	public void cambiar() {
		semilla2.setVisible(true);
		labelMedio2.setVisible(true);
		label1.setText("Ingrese constante (a)");
		labelMedio2.setText("Ingrese semilla 1(Xo)");
	}
	//funcionalidad para el combo
	public void ocultar() {
		semilla2.setVisible(false);
		labelMedio2.setVisible(false);
		JPanel panel = new JPanel();
		//panel = PanelInferior();
		//panel.repaint();
	
	}
	//funcionalidad para el combo
	public void mostrar() {
		semilla2.setVisible(true);
		labelMedio2.setVisible(true);
		label1.setText("Ingrese semilla 1(Xo)");
		labelMedio2.setText("Ingrese semilla 2(Xi)");
	}
	//dibuaja los componentes del panel inferior
	public JPanel PanelInferior() {
		JPanel respuesta = new JPanel();
		respuesta.setLayout(new BorderLayout());
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		
		generar = new JButton("GENERAR NÚMEROS");
		Accion pulsar = new Accion();
		generar.addActionListener(pulsar);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(generar);
		
		respuesta.add(label1,BorderLayout.NORTH);
		respuesta.add(panel1,BorderLayout.CENTER);
		respuesta.add(label2,BorderLayout.SOUTH);
		return respuesta;
	}
	//dibuja los componentes del panel superior
	public JPanel PanelSuperior() {
		JPanel respuesta = new JPanel();
		respuesta.setLayout(new BorderLayout());
		JLabel uno = new JLabel();
		combo = new JComboBox();
		//funcionalidad del combo
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(combo.getSelectedIndex() == 0) {
					//para los cuadrados
					ocultar();
				}else if(combo.getSelectedIndex()==1){
					//para el producto
					mostrar();
				}else{
					//para el multiplicador
					cambiar();
				}
			}
		});
		JLabel dos = new JLabel();
		JLabel tipo = new JLabel("Escoje el algoritmo a usar");
		combo.addItem("Cuadrados Medios");
		combo.addItem("Producto Medio");
		combo.addItem("Multiplicador Constante");
		
		JPanel panelMedio = new JPanel();
		panelMedio.setLayout(new FlowLayout());
		panelMedio.add(tipo);
		panelMedio.add(combo);
		
		respuesta.add(uno,BorderLayout.NORTH);
		respuesta.add(panelMedio,BorderLayout.CENTER);
		respuesta.add(dos,BorderLayout.SOUTH);
		return respuesta;
		
	}
	//dibuja los componentes del panel medio
	public JPanel PanelMedio() {
		JPanel respuesta = new JPanel();
		respuesta.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		
		semilla1 = new JTextField(15);
		label1 = new JLabel("Ingrese semilla 1(Xo)");
		panel1.add(semilla1);
		panel1.add(label1);
		
		semilla2 = new JTextField(15);
		labelMedio2 = new JLabel("Ingrese semilla 2(Xi)");
		panel2.add(semilla2);
		panel2.add(labelMedio2);
		
		cantidad = new JTextField(8);
		JLabel label3 = new JLabel("Ingrese cantidad de números a generar");
		panel3.add(cantidad);
		panel3.add(label3);
		
		
		respuesta.add(panel1,BorderLayout.NORTH);
		respuesta.add(panel2,BorderLayout.CENTER);
		respuesta.add(panel3,BorderLayout.SOUTH);
		
		return respuesta;
	}
	//clase para darle funcionalidad a el boton
	private class Accion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(valido()) {
				if(coinciden()) {
					
				
				try{
					if(combo.getSelectedIndex()==0) {
						int uno = Integer.parseInt(semilla1.getText());
						int c = Integer.parseInt(cantidad.getText());
						String seleccion = combo.getSelectedItem().toString();
						InterfazResultado inter = new InterfazResultado(uno,c,seleccion);
						inter.start();
					}else if(combo.getSelectedIndex()==1){
						int uno = Integer.parseInt(semilla1.getText());
						int dos = Integer.parseInt(semilla2.getText());
						int c = Integer.parseInt(cantidad.getText());
						String seleccion = combo.getSelectedItem().toString();
						InterfazResultado inter = new InterfazResultado(uno,dos,c,seleccion);
						
						inter.start();
					}else{
						int uno = Integer.parseInt(semilla1.getText());
						int dos = Integer.parseInt(semilla2.getText());
						int c = Integer.parseInt(cantidad.getText());
						String seleccion = combo.getSelectedItem().toString();
						InterfazResultado inter = new InterfazResultado(uno,dos,c,seleccion);
						
						inter.start();
					}
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Los campos de texto tienen que contener digitos");
				}
				}else {
					JOptionPane.showMessageDialog(null, "Para el producto medio y el multiplicador constante las semillas tienen que ser de igual cantidad de digitos");
				}
				
			}else {
				JOptionPane.showMessageDialog(null,"Todos los campos deben estar llenados");
			}	
		}
		public boolean coinciden() {
			boolean respuesta = false;
			if(combo.getSelectedIndex()!=0) {
				if((cantidad((long)Integer.parseInt(semilla1.getText())))== (cantidad((long)Integer.parseInt(semilla2.getText())))) {
					respuesta = true;
				}
			}else {
				respuesta = true;
			}
			return respuesta;
		}
		//cuenta la cantidad de digitos de un valor long
		private int cantidad(long x) {
			int respuesta = 0;
			if(x==0) {
				respuesta = 0;
			}else{
				respuesta = 1 + cantidad(x/10);
			}
			return respuesta;
		}
		public boolean valido() {
			boolean respuesta = false;
			if(combo.getSelectedIndex()==0) {
				if(semilla1.getText() != "" && cantidad.getText() != "") {
					respuesta = true;
				}
			}else{
				if(semilla1.getText() != "" && semilla2.getText() != "" && cantidad.getText() != "") {
					respuesta = true;
				}
			}
			return respuesta;
		}

	}
}
