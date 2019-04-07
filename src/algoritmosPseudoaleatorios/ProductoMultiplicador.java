package algoritmosPseudoaleatorios;

import java.util.ArrayList;
public class ProductoMultiplicador {
	private int semilla;
	private int semillaDos;
	private int cantidad;
	private ArrayList<ProDos> numerosGenerados;
	private String tipo;
	//Metodo constructor
	public ProductoMultiplicador(int semilla,int semillaDos ,int n,String tipo){
		this.semilla = semilla;
		this.semillaDos = semillaDos;
		cantidad = n;
		numerosGenerados = null;
		this.tipo = tipo;
	}
	//imprime en consola los numeros geenrados por la serie
	public void imprimir() {
		System.out.println(toString());
		for(int i = 0;i< numerosGenerados.size();i++) {
			System.out.println((i+1)+".-  "+numerosGenerados.get(i).toString());
		}
	}
	//informacion de la semilla
	public String toString() {
		return "Xo v a = "+semilla+" ; Xi = "+semillaDos+" ; Cantidad Pedida = "+cantidad;
	}
	
	//retorna el valor de la semilla
	public int getSemilla() {
		return semilla;
	}
	//cambia el valor de la semilla
	public void setSemilla(int otra) {
		semilla = otra;
	}
	//retorna el valor de la semilla Dos
	public int getSemillaDos() {
		return semillaDos;
	}
	//cambia el valor de la semillaDos
	public int setSemillaDos(int dato) {
		return semillaDos = dato;
	}
	//retorna el valor de la cantidad
	public int getCantidad() {
		return cantidad;
	}
	//cambia el valor de la cantidad
	public void setCantidad(int otra) {
		cantidad = otra;
	}
	//retorna el arrayList con los digitos generados
	public ArrayList<ProDos> getNumeros(){
		return numerosGenerados;
	}
	//verifica e inicia la generacion de numeros
	public boolean iniciar(){
		boolean respuesta = false;
		if(valido()&&correcto()){
			if(segundoCorrecto()) {
				if(cantidad(semilla) == cantidad(semillaDos)) {
					if(tipo == "Producto") {
						numerosGenerados = generarNumeros(semilla,semillaDos,cantidad);
						respuesta = true;
					}else {
						numerosGenerados = generarMultiplicador(semillaDos,cantidad);
						respuesta = true;
					}
					
				}	
			}
		}
		return respuesta;
	}
	//metodo para generar los numeros aleatorios del profucto
	public ArrayList<ProDos> generarNumeros(int x,int x1, int d){
		ArrayList<ProDos> respuesta;
		if(d>0){
			ArrayList<ProDos>junte = new ArrayList<ProDos>();
			long y = (long)x*(long)x1;
			int cantidad = cantidad(y);
			int medio = medio(y);
			float r = numeroAleatorio(medio);
			junte.add(new ProDos(x,x1,y,cantidad,medio,r));
			respuesta = juntar(junte,generarNumeros(x1,medio,d-1));
			
		}else {
			respuesta = null;
		}
		return respuesta;
	}
	//metodo para generar los numeros aleatorios del multiplicador
	public ArrayList<ProDos> generarMultiplicador(int x1, int d){
		ArrayList<ProDos> respuesta;
		if(d>0){
			ArrayList<ProDos>junte = new ArrayList<ProDos>();
			long y = (long)semilla*(long)x1;
			int cantidad = cantidad(y);
			int medio = medio(y);
			float r = numeroAleatorio(medio);
			junte.add(new ProDos(semilla,x1,y,cantidad,medio,r));
			respuesta = juntar(junte,generarMultiplicador(medio,d-1));
			
		}else {
			respuesta = null;
		}
		return respuesta;
	}
	//metodo para juntar cadenas
	private ArrayList<ProDos> juntar(ArrayList<ProDos> cadena1, ArrayList<ProDos> cadena2){
		ArrayList<ProDos> respuesta;
		if(cadena2 == null) {
			respuesta = cadena1;
		}else {
			respuesta = cadena1;
			for(int i = 0;i<cadena2.size();i++) {
				respuesta.add(cadena2.get(i));
			}
		}
		return respuesta;
	}
	//define el Ri
	private float numeroAleatorio(int medio) {
		float respuesta;
		int count = cantidad(medio);
		if(count <= 4 ) {
			respuesta = (float)medio/10000;
		}else {
			respuesta = (float)medio/100000;
		}
		return respuesta;
	}
	//verifica si la cantidad a extraer es mayor a 0
	public boolean valido(){
		return cantidad != 0;
	}
	//verifica si la cantidad de la semilla es mayor o igual a 4 y menor e igual a 5
	public boolean correcto() {
		int cant = cantidad(this.semilla);
		
		return cant>3 && cant<6;
	}
	//verifica la segunda semilla
	public boolean segundoCorrecto() {
		int cant = cantidad(this.semillaDos);
		
		return cant>3 && cant<6;
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
	//cuenta la cantidad de digitos
	private int cantidad(int x){
		int respuesta = 0;
		if(x==0) {
			respuesta = 0;
		}else {
			respuesta = 1 + cantidad(x/10);
		}
		return respuesta;
	}
	//extrae el digito medio
	private int medio(long numero) {
		int respuesta = 0;
		int cont = cantidad(this.semilla);
		if(cont==4) {
			respuesta= cuatro(numero);
		}else if(cont==5){
			respuesta = cinco(numero);
		}
		return respuesta;
	}
	//extraer para semilla de 4 digitos
	private int cuatro(long numero){
		long respuesta = 0;
		int cont = cantidad(numero);
		if(cont==8){
			numero = numero/100;
			respuesta = numero%10000;
		}else if(cont ==7){
			numero = numero/10;
			respuesta = numero%10000;
		}else if(cont == 6 ){
			numero = numero/10;
			respuesta = numero%10000;
		}else if(cont == 5) {
			respuesta = numero%10000;
		}else {
			respuesta = numero;
		}
		return (int) respuesta;
	}
	//extraer para semilla de 5 digitos
	private int cinco(long numero){
		long respuesta = 0;
		int cont = cantidad(numero);
		if(cont == 10) {
			numero = numero/100;
			respuesta = numero%100000;
		}else if(cont == 9){
			numero = numero/100;
			respuesta = numero%100000;
		}else if(cont == 8) {
			numero = numero/10;
			respuesta = numero%100000;
		}else if(cont == 7) {
			numero = numero/10;
			respuesta = numero%100000;
		}else if(cont == 6) {
			respuesta = numero%100000;
		}else {
			respuesta = numero;
		}
		return (int)respuesta;
	}
}