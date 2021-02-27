package empleado;

public class EmpleadoConHorasDobles extends Empleado {

	private int horasExtras;

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras; 
	}

	@Override
	public double CalcularSalario() {
		return (40 + horasExtras * 2) * getSueldoPorHora();
	}

	@Override
	public void marcarPagado() {
		setPagado(true);

	}

	@Override
	public boolean esPagado() {
		return getPagado();
	}
}