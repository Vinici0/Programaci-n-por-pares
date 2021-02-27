package empleado;

public class EmpleadoSinHorasExtras extends Empleado {
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
		return getHorasTrabajadas() * getSueldoPorHora();
	}
}
