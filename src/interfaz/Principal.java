package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import empleado.EmpleadoConHorasDobles;
import empleado.EmpleadoConHorasTriples;
import empleado.EmpleadoSinHorasExtras;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements ActionListener {
	private static final String CALCULAR = "Calcular";
	private static final String SALIR = "Salir";
	private static final String PAGAR = "Pagar";
	private double sueldoHora = 0;
	private int horas = 0;
	private String nombre = "";
	static Principal principal;
	private JPanel panel;
	private JTextField txt_horas;
	private JTextField txt_sueldoHora;
	private JTextField txt_nombre;
	private JButton bt_pagar;
	private JLabel lb_Horas;
	private JLabel lbl_sueldoHora;
	private JLabel lb_nombre;
	private JButton bt_calcular;
	private JButton bt_salir;
	private EmpleadoConHorasTriples empleadoConHorasTriples;    //
	private EmpleadoConHorasDobles empleadoConHorasDobles;		//
	private EmpleadoSinHorasExtras empleadoSinHorasExtra;		//
	private boolean cambiar;

	public Principal() {
		setTitle("Salario");                                  //TITULO DE LA INTERFAZ
		setSize(300, 350);                                    //TAMAÑO DE LA INTERFAZ

		panel = new JPanel();							       
		getContentPane().add(panel, BorderLayout.CENTER);      
		panel.setLayout(null);//BORJA VINICIO

		lb_Horas = new JLabel("Horas trabajadas: ");  //NOMBRE DEL BOTON
		lb_Horas.setBounds(24, 63, 112, 13);          //UBICACION DEL BOTON
		panel.add(lb_Horas);						  //AGRGAR AL PANEL

		txt_horas = new JTextField();
		txt_horas.setBounds(146, 60, 96, 19);
		panel.add(txt_horas);//BORJA VINICIO
		txt_horas.setColumns(10);

		lbl_sueldoHora = new JLabel("Salario por hora: ");
		lbl_sueldoHora.setBounds(24, 100, 112, 13);
		panel.add(lbl_sueldoHora);//BORJA VINICIO

		txt_sueldoHora = new JTextField();
		txt_sueldoHora.setBounds(146, 97, 96, 19);
		panel.add(txt_sueldoHora);//BORJA VINICIO
		txt_sueldoHora.setColumns(10);

		bt_calcular = new JButton("Calcular Salario");
		bt_calcular.setActionCommand(CALCULAR);
		bt_calcular.addActionListener(this);
		bt_calcular.setBounds(68, 175, 137, 50);
		panel.add(bt_calcular);//BORJA VINICIO

		bt_salir = new JButton("Salir");//BORJA VINICIO
		bt_salir.setActionCommand(SALIR);
		bt_salir.addActionListener(this);
		bt_salir.setBounds(68, 236, 137, 50);
		panel.add(bt_salir);

		bt_pagar = new JButton("Pagar");
		bt_pagar.setBounds(68, 144, 137, 21);
		bt_pagar.setActionCommand(PAGAR);
		bt_pagar.addActionListener(this);
		bt_pagar.setVisible(false);
		panel.add(bt_pagar);

		lb_nombre = new JLabel("Nombre");
		lb_nombre.setBounds(24, 21, 45, 13);
		panel.add(lb_nombre);

		txt_nombre = new JTextField();
		txt_nombre.setBounds(146, 17, 96, 19);
		panel.add(txt_nombre);
		txt_nombre.setColumns(10);
		setVisible(true);

	}

	public static void main(String[] args) { //Main
		principal = new Principal();
	}

	public void calcular() {
		if (horas != Integer.parseInt(txt_horas.getText()) || sueldoHora != Double.parseDouble(txt_sueldoHora.getText())
				|| !nombre.equals(txt_nombre.getText())) {
			cambiar = true;

		}
		nombre = txt_nombre.getText();
		horas = Integer.parseInt(txt_horas.getText());
		sueldoHora = Double.parseDouble(txt_sueldoHora.getText());
		String mensaje = "";
		if (horas >= 0 && horas <= 40) {
			if (cambiar) {
				empleadoSinHorasExtra = new EmpleadoSinHorasExtras(); //Borja Vinicio
				empleadoSinHorasExtra.setHorasTrabajadas(horas);
				empleadoSinHorasExtra.setSueldoPorHora(sueldoHora);
				empleadoSinHorasExtra.setNombre(txt_nombre.getText());//Borja Vinicio
			}
			mensaje += "Nombre: " + empleadoSinHorasExtra.getNombre() + "\n";
			mensaje += "Horas Trabajadas: " + empleadoSinHorasExtra.getHorasTrabajadas() + "\n";
			mensaje += "Sueldo por hora: $" + empleadoSinHorasExtra.getSueldoPorHora() + "\n";
			mensaje += "Salario: $" + empleadoSinHorasExtra.CalcularSalario() + "\n";
			mensaje += "Pagado: " + empleadoSinHorasExtra.esPagado();//Borja Vinicio
		} else if (horas > 40 && horas <= 45) {
			if (cambiar) {
				empleadoConHorasDobles = new EmpleadoConHorasDobles();
				empleadoConHorasDobles.setHorasTrabajadas(horas);
				empleadoConHorasDobles.setSueldoPorHora(sueldoHora);
				empleadoConHorasDobles.setNombre(txt_nombre.getText());
				empleadoConHorasDobles.setHorasExtras(horas - 40);//Borja Vinicio
			}
			mensaje += "Nombre: " + empleadoConHorasDobles.getNombre() + "\n";
			mensaje += "Horas Trabajadas: " + empleadoConHorasDobles.getHorasTrabajadas() + "\n";
			mensaje += "Sueldo por hora: $" + empleadoConHorasDobles.getSueldoPorHora() + "\n";//Borja Vinicio
			mensaje += "Horas extras: " + empleadoConHorasDobles.getHorasExtras() + "\n";
			mensaje += "Salario: $" + empleadoConHorasDobles.CalcularSalario() + "\n";
			mensaje += "Pagado: " + empleadoConHorasDobles.esPagado();
		} else if (horas > 45) {
			if (cambiar) {
				empleadoConHorasTriples = new EmpleadoConHorasTriples();
				empleadoConHorasTriples.setHorasTrabajadas(horas);
				empleadoConHorasTriples.setSueldoPorHora(sueldoHora);//Borja Vinicio
				empleadoConHorasTriples.setNombre(txt_nombre.getText());
				empleadoConHorasTriples.setHorasExtras(horas - 40);
			}
			mensaje += "Nombre: " + empleadoConHorasTriples.getNombre() + "\n";
			mensaje += "Horas Trabajadas: " + empleadoConHorasTriples.getHorasTrabajadas() + "\n";
			mensaje += "Sueldo por hora: $" + empleadoConHorasTriples.getSueldoPorHora() + "\n";//Borja Vinicio
			mensaje += "Horas extras: " + empleadoConHorasTriples.getHorasExtras() + "\n";
			mensaje += "Salario: $" + empleadoConHorasTriples.CalcularSalario() + "\n";
			mensaje += "Pagado: " + empleadoConHorasTriples.esPagado();
		}
		if (cambiar) {
			bt_pagar.setVisible(true);
		}
		mensaje(mensaje);
		cambiar = false;
	}

	public void mensaje(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}

	public void actionPerformed(ActionEvent e) { //Cuando se haga clic ejecuta la operación
		if (CALCULAR.equals(e.getActionCommand())) {
			calcular();
		} else if (PAGAR.equals(e.getActionCommand())) {
			if (horas >= 0 && horas <= 40) {
				empleadoSinHorasExtra.marcarPagado();
			} else if (horas > 40 && horas <= 45) {
				empleadoConHorasDobles.marcarPagado();
			} else if (horas > 45) {
				empleadoConHorasTriples.marcarPagado();
			}
			bt_pagar.setVisible(false);
		} else if (SALIR.equals(e.getActionCommand())) {
			dispose();
		}
	}
}