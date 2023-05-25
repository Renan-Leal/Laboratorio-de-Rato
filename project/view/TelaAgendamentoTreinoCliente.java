package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class TelaAgendamentoTreinoCliente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgendamentoTreinoCliente window = new TelaAgendamentoTreinoCliente();
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
	public TelaAgendamentoTreinoCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 433, 240);
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
		
		JLabel lblDataInicio = new JLabel("Data Hora:");
		lblDataInicio.setBounds(71, 94, 76, 14);
		frame.getContentPane().add(lblDataInicio);
		
		JComboBox cbHoraInicio = new JComboBox();
		cbHoraInicio.setBounds(133, 90, 273, 22);
		frame.getContentPane().add(cbHoraInicio);
		
		JComboBox cbHoraFinal = new JComboBox();
		cbHoraFinal.setBounds(133, 123, 273, 22);
		frame.getContentPane().add(cbHoraFinal);
		
		JLabel lblDataFinal = new JLabel("Data Hora:");
		lblDataFinal.setBounds(71, 127, 61, 14);
		frame.getContentPane().add(lblDataFinal);
		
		JLabel lblFinal = new JLabel("Final -");
		lblFinal.setBounds(15, 127, 46, 14);
		frame.getContentPane().add(lblFinal);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(173, 166, 89, 23);
		frame.getContentPane().add(btnSalvar);
	}
}
