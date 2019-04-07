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
		if(valido()&&correcto()){
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
			float r = numeroAleatorio(medio);
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
