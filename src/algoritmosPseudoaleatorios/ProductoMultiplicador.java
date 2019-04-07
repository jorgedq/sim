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
		if(valido()){
			
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
			double r = numeroAleatorio(medio);
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
			double r = numeroAleatorio(medio);
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
		private double numeroAleatorio(int medio) {
			return (double)medio / divisor(medio);
		}
		//calcular el divisor par los Ri
		private double divisor(int numero) {
			double respuesta = 1;
			if (numero == 0) {
				respuesta = 1;
			}else {
				respuesta = respuesta * 10 * divisor(numero/10);
			}
			return respuesta;
		}
	//verifica si la cantidad a extraer es mayor a 0
	public boolean valido(){
		return cantidad != 0;
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
		return extraer(cantidad(numero),cantidad(semilla),numero);
	}

	//metodo para extraer el modulo de los digitos
	
	private int extraer(int cantTotal,int cantSemilla,long numero) {
		int respuesta = 0;
		int h = (cantTotal - cantSemilla)/2;
		if (h == 0) {
			respuesta = (int) (numero % (calcularModulo(cantSemilla)));
		}else {
			long x = dividir(numero,h);		
			respuesta =  (int) (x % (calcularModulo(cantSemilla)));
		}
		return respuesta;
	}
	//metodo para dividir el numero
	private long dividir(long numero ,int h) {
		long respuesta = numero;
		for(int i = 0;i<h;i++) {
			respuesta = respuesta/10;
		}
		return respuesta;
	}
	//metodo para poder extraer el modulo
	private int calcularModulo(int cantidad) {
		int respuesta = 1;
		
		for(int i = 0; i< cantidad ;i++) {
			respuesta = respuesta * 10;
		}
		
		return respuesta;
	}
}
