package algoritmosPseudoaleatorios;
public class ProDos {
	private int x;
	private int x2;
	private long y;
	private int nroDigitos;
	private int medio;
	private float r;
	//metodo constructor de la clase
	public ProDos(int x, int x2, long y, int cantidad,int medio,float r) {
		this.x = x;
		this.x2 = x2;
		this.y = y;
		nroDigitos = cantidad;
		this.medio = medio;
		this.r = r;
	}
	//retorna el Xo
	public int getX() {
		return x;
	}
	public int getX2(){
		return x2;
	}
	//retorna el Yo
	public long getY() {
		return y;
	}
	//retorna la cantidad de digitos
	public int getCantidad() {
		return nroDigitos;
	}
	//retorna el numero medio
	public int getMedio() {
		return medio;
	}
	//retorna el Ri generado
	public float getR() {
		return r;
	}
	//devuelve informacion del digito
	public String toString() {
		return "Xo = "+x+" ; Xi = "+x2+"; Yo = "+y+" ; Digitos = "+nroDigitos+" ; medio = "+medio+" ; Ri = "+r;
	}
}
