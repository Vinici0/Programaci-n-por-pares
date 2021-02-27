package empleado;

public abstract class Empleado implements IPagadoEmple{
	private String nombre;
	private int horasTrabajadas;
	private double sueldoPorHora;
	private boolean pagado;

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public double getSueldoPorHora() {//BORJA VINICIO
		return sueldoPorHora;
	}

	public void setSueldoPorHora(double sueldoPorHora) {//BORJA VINICIO
		this.sueldoPorHora = sueldoPorHora;
	}
	
	public boolean getPagado() {//BORJA VINICIO
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public String getNombre() {//BORJA VINICIO
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;//BORJA VINICIO
	}
	
	

}