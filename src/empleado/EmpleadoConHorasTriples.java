package empleado;

public class EmpleadoConHorasTriples extends Empleado {
	private int horasExtras;

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}

	@Override
	public void marcarPagado() {
		setPagado(true);
	}

	@Override
	public boolean esPagado() {
		return getPagado();
	}

	@Override
	public double CalcularSalario() {
		return (40 + horasExtras * 3) * getSueldoPorHora();
	}
}
