package algoritmosPseudoaleatorios;
import java.util.ArrayList;
public class pruebaMedia {
	private ArrayList<Digito> lista;
	private ArrayList<ProDos> lista2;
	private int tipo;
	private float alpha;
	private float zTabla;
	//constructor 1
	public pruebaMedia(ArrayList<Digito> lista,ArrayList<ProDos> cadena,int tipo,float alpha,float zTabla){
		this.lista = lista;
		this.lista2 = cadena;
		this.tipo = tipo;
		this.alpha = alpha;
		this.zTabla = zTabla;
	}
	public double media() {
		double respuesta;
		if(tipo == 1) {
			respuesta = dameMedia(lista);
		}else {
			respuesta = dameMedia1(lista2);
		}
		return respuesta;
	}
	private double dameMedia1(ArrayList<ProDos> cadena) {
		double respuesta = 0;
		for(int i = 0;i<cadena.size();i++) {
			respuesta = respuesta + cadena.get(i).getR();
		}
		return respuesta;
	}
	private double dameMedia(ArrayList<Digito> cadena) {
		double respuesta = 0;
		for(int i = 0;i<cadena.size();i++) {
			respuesta = respuesta + cadena.get(i).getR();
		}
		return respuesta;
	}
	
}
