package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class TelaAgendamentoTreino {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgendamentoTreino window = new TelaAgendamentoTreino();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAgendamentoTreino() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(15, 18, 46, 14);
		frame.getContentPane().add(lblCliente);
		
		JComboBox cbCliente = new JComboBox();
		cbCliente.setBounds(71, 14, 335, 22);
		frame.getContentPane().add(cbCliente);
		
		JLabel lblPersonal = new JLabel("Personal:");
		lblPersonal.setBounds(15, 54, 46, 14);
		frame.getContentPane().add(lblPersonal);
		
		JComboBox cbPersonal = new JComboBox();
		cbPersonal.setBounds(71, 50, 335, 22);
		frame.getContentPane().add(cbPersonal);
		
		JLabel lblInicio = new JLabel("Inicio -");
		lblInicio.setBounds(15, 94, 46, 14);
		frame.getContentPane().add(lblInicio);
		
		JLabel lblDataInicio = new JLabel("Data:");
		lblDataInicio.setBounds(82, 94, 46, 14);
		frame.getContentPane().add(lblDataInicio);
		
		JLabel lblHoraInicio = new JLabel("Hora:");
		lblHoraInicio.setBounds(252, 94, 46, 14);
		frame.getContentPane().add(lblHoraInicio);
		
		JComboBox cbHoraInicio = new JComboBox();
		cbHoraInicio.setBounds(297, 90, 109, 22);
		frame.getContentPane().add(cbHoraInicio);
		
		JComboBox cbDataInicio = new JComboBox();
		cbDataInicio.setBounds(127, 90, 109, 22);
		frame.getContentPane().add(cbDataInicio);
		
		JComboBox cbHoraFinal = new JComboBox();
		cbHoraFinal.setBounds(297, 123, 109, 22);
		frame.getContentPane().add(cbHoraFinal);
		
		JLabel lblHoraFinal = new JLabel("Hora:");
		lblHoraFinal.setBounds(252, 127, 46, 14);
		frame.getContentPane().add(lblHoraFinal);
		
		JComboBox cbDataFinal = new JComboBox();
		cbDataFinal.setBounds(127, 123, 109, 22);
		frame.getContentPane().add(cbDataFinal);
		
		JLabel lblDataFinal = new JLabel("Data:");
		lblDataFinal.setBounds(82, 127, 46, 14);
		frame.getContentPane().add(lblDataFinal);
		
		JLabel lblFinal = new JLabel("Final -");
		lblFinal.setBounds(15, 127, 46, 14);
		frame.getContentPane().add(lblFinal);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(173, 166, 89, 23);
		frame.getContentPane().add(btnSalvar);
	}
}
