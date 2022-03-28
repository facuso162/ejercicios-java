package entidades;

public class Vendedor extends Empleado {

	private double porcenComision;
	private int totalVentas;
	
	public Vendedor(int dni, String nombre, String apellido, String email, double sueldoBase, double porcenComision, int totalVentas) {
		super(dni, nombre, apellido, email, sueldoBase);
		this.porcenComision = porcenComision;
		this.totalVentas = totalVentas;
	}
	
	public double getSueldo() {
		return getSueldoBase() + (porcenComision * totalVentas / 100);
	}
	
	public double getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(double porcenComision) {
		this.porcenComision = porcenComision;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}

	@Override
	public String toString() {
		return "Vendedor [porcenComision=" + porcenComision + ", totalVentas=" + totalVentas + super.toString() + "]";
	}


}
