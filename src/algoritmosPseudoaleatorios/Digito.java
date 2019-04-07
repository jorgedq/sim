package algoritmosPseudoaleatorios;

public class Digito {
	private int x;
	private long y;
	private int nroDigitos;
	private int medio;
	private double r;
	//metodo constructor de la clase
	public Digito(int x, long y, int cantidad,int medio,double r) {
		this.x = x;
		this.y = y;
		nroDigitos = cantidad;
		this.medio = medio;
		this.r = r;
		
	}
	//retorna el Xo
	public int getX() {
		
		return x;
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
	public double getR() {
		return r;
	}
	//devuelve informacion del digito
	public String toString() {
		return "Xo = "+x+"; Yo = "+y+"; Digitos = "+nroDigitos+"; medio = "+medio+"; Ri = "+r;
	}
}
