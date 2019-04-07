package algoritmosPseudoaleatorios;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelResultados extends JPanel{
	private JTable tabla;
	private CuadradosMedios generados;
	private int Xo;
	private int Xi;
	private int cantidad;
	private String seleccion;
	//constructor 1
	public PanelResultados(int x, int cantidad,String seleccion) {
		Xo = x;
		Xi = 0;
		this.cantidad = cantidad;
		this.seleccion = seleccion;
		setLayout(new BorderLayout());
		add(panelSuperior(),BorderLayout.NORTH);
		add(panelInferior(),BorderLayout.EAST);
		
	}
	//constructtor 2
	public PanelResultados(int x , int y, int cantidad, String seleccion) {
		Xo = x;
		Xi = y;
		this.cantidad = cantidad;
		this.seleccion = seleccion;
		tabla = new JTable();
		
		setLayout(new BorderLayout());
		add(panelSuperior(),BorderLayout.NORTH);
		add(panelInferior(),BorderLayout.CENTER);
		add(new JLabel(),BorderLayout.SOUTH);
	}
	//dibuja el panel superior
	public JPanel panelSuperior() {
		JPanel respuesta = new JPanel();
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		JLabel labelNada = new JLabel(seleccion);
		
		if(seleccion == "Cuadrados Medios") {
			JLabel labelSemilla = new JLabel("Xo = "+Xo);
			panel1.add(new JLabel());
			panel2.add(labelNada);
			panel3.add(labelSemilla);
			respuesta.add(panel1,BorderLayout.NORTH);
			respuesta.add(panel2,BorderLayout.CENTER);
			respuesta.add(panel3,BorderLayout.SOUTH);
		}else if(seleccion == "Producto Medio"){
			JLabel labelSemilla = new JLabel("Xo = "+Xo);
			JLabel labelSemilla2 = new JLabel("Xi = "+Xi);
			panel1.add(labelNada);
			panel2.add(labelSemilla);
			panel3.add(labelSemilla2);
			respuesta.add(panel1,BorderLayout.NORTH);
			respuesta.add(panel2,BorderLayout.CENTER);
			respuesta.add(panel3,BorderLayout.SOUTH);
		}else{
			JLabel labelSemilla = new JLabel("a = "+Xo);
			JLabel labelSemilla2 = new JLabel("Xo = "+Xi);
			panel1.add(labelNada);
			panel2.add(labelSemilla);
			panel3.add(labelSemilla2);
			respuesta.add(panel1,BorderLayout.NORTH);
			respuesta.add(panel2,BorderLayout.CENTER);
			respuesta.add(panel3,BorderLayout.SOUTH);
		}
		
		return respuesta;
	}
	//dibuja el panel inferior
	public JPanel panelInferior() {
		JPanel respuesta = new JPanel();
		respuesta.setLayout(new FlowLayout());
		if(seleccion == "Cuadrados Medios"){
			//llamamos a nuestra clase disegnada para generar los numeros
			CuadradosMedios cuadrado= new CuadradosMedios(Xo,cantidad);
			if(cuadrado.iniciar()) {
				tabla = new JTable();
				tabla.setModel(tablaCuadradosMedios(cuadrado.getNumeros()));
				respuesta.add(new JScrollPane(tabla));
				
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error en generar los numeros");
			}
			
		}else if(seleccion == "Producto Medio"){
			//llamamos a nuestra clase disegnada para generar los numeros
			ProductoMultiplicador producto = new ProductoMultiplicador(Xo,Xi,cantidad,"Producto");
			if(producto.iniciar()) {
				tabla = new JTable();
				tabla.setModel(tablaProductoMedio(producto.getNumeros()));
				respuesta.add(new JScrollPane(tabla));
				
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error en generar los numeros");
			}
		}else {
			//llamamos a nuestra clase disegnada para generar los numeros
			ProductoMultiplicador multiplica = new ProductoMultiplicador(Xo,Xi,cantidad,"Multiplicador");
			if(multiplica.iniciar()) {
				tabla = new JTable();
				tabla.setModel(tablaMultiplicador(multiplica.getNumeros()));
				respuesta.add(new JScrollPane(tabla));
				
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error en generar los numeros");
			}
		}
		return respuesta;
	}
	//retorna la tabla de multiplicador constante
	public DefaultTableModel tablaMultiplicador(ArrayList<ProDos> arrayList) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nro");
		modelo.addColumn("a");
		modelo.addColumn("Xo");
		modelo.addColumn("Yo");
		modelo.addColumn("Digitos");
		modelo.addColumn("Medio");
		modelo.addColumn("Ri");
		String [] datos = new String[7];
		//llenamos los datos
		for(int i = 0;i<arrayList.size();i++) {
			datos[0] = String.valueOf(i+1);
			datos[1] = String.valueOf(arrayList.get(i).getX());
			datos[2] = String.valueOf(arrayList.get(i).getX2());
			datos[3] = String.valueOf(arrayList.get(i).getY());
			datos[4] = String.valueOf(arrayList.get(i).getCantidad());
			datos[5] = String.valueOf(arrayList.get(i).getMedio());
			datos[6] = String.valueOf(arrayList.get(i).getR());
			modelo.addRow(datos);
		}
		//modelo.addRow(datos); por cada linea
		return modelo;
	}
	//retorna la tabla de cuadrados
	public DefaultTableModel tablaCuadradosMedios(ArrayList<Digito> cadena) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nro");
		modelo.addColumn("Xo");
		modelo.addColumn("Yo");
		modelo.addColumn("Digitos");
		modelo.addColumn("Medio");
		modelo.addColumn("Ri");
		String [] datos = new String[6];
		//llenamos los datos
		for(int i = 0;i<cadena.size();i++) {
			datos[0] = String.valueOf(i+1);
			datos[1] = String.valueOf(cadena.get(i).getX());
			datos[2] = String.valueOf(cadena.get(i).getY());
			datos[3] = String.valueOf(cadena.get(i).getCantidad());
			datos[4] = String.valueOf(cadena.get(i).getMedio());
			datos[5] = String.valueOf(cadena.get(i).getR());
			modelo.addRow(datos);
		}
		//modelo.addRow(datos); por cada linea
		return modelo;
	}
	//retorna la tabla de producto
	public DefaultTableModel tablaProductoMedio(ArrayList<ProDos> cadena) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nro");
		modelo.addColumn("Xo");
		modelo.addColumn("Xi");
		modelo.addColumn("Yo");
		modelo.addColumn("Digitos");
		modelo.addColumn("Medio");
		modelo.addColumn("Ri");
		String [] datos = new String[7];
		//llenamos los datos
		for(int i = 0;i<cadena.size();i++) {
			datos[0] = String.valueOf(i+1);
			datos[1] = String.valueOf(cadena.get(i).getX());
			datos[2] = String.valueOf(cadena.get(i).getX2());
			datos[3] = String.valueOf(cadena.get(i).getY());
			datos[4] = String.valueOf(cadena.get(i).getCantidad());
			datos[5] = String.valueOf(cadena.get(i).getMedio());
			datos[6] = String.valueOf(cadena.get(i).getR());
			modelo.addRow(datos);
		}
		//modelo.addRow(datos); por cada linea
		return modelo;
	}
}
