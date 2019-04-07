package algoritmosPseudoaleatorios;
import java.util.ArrayList;
public class CuadradosMedios {
	private int semilla;
	private int cantidad;
	private ArrayList<Digito> numerosGenerados;
	//Metodo constructor
	public CuadradosMedios(int semilla,int n){
		this.semilla = semilla;
		cantidad = n;
		numerosGenerados = null;
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
		return "Semilla = "+semilla+"; Cantidad Pedida = "+cantidad;
	}
	//retorna el valor de la semilla
	public int getSemilla() {
		return semilla;
	}
	//cambia el valor de la semilla
	public void setSemilla(int otra) {
		semilla = otra;
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
	public ArrayList<Digito> getNumeros(){
		return numerosGenerados;
	}
	//verifica e inicia la generacion de numeros
	public boolean iniciar(){
		boolean respuesta = false;
		if(valido()){
			numerosGenerados = generarNumeros(semilla,cantidad);
			respuesta = true;
		}
		return respuesta;
	}
	//metodo para generar los numeros aleatorios
	public ArrayList<Digito> generarNumeros(int x, int d){
		ArrayList<Digito> respuesta;
		if(d>0){
			ArrayList<Digito>junte = new ArrayList<Digito>();
			long y = (long)x*(long)x;
			int cantidad = cantidad(y);
			int medio = medio(y);
			double r = numeroAleatorio(medio);
			junte.add(new Digito(x,y,cantidad,medio,r));
			respuesta = juntar(junte,generarNumeros(medio,d-1));
			
		}else {
			respuesta = null;
		}
		return respuesta;
	}
	//metodo para juntar cadenas
	private ArrayList<Digito> juntar(ArrayList<Digito> cadena1, ArrayList<Digito> cadena2){
		ArrayList<Digito> respuesta;
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
	