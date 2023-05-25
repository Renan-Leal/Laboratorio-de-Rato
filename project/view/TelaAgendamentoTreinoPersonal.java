package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAgendamentoTreinoPersonal {

	private JFrame frame;
	private JTable tblListagemTreinos;
	private String[] nomesColunas = { "Nome Clinete", "Horario Inicio", "Horario Final", "Dia", "E-mail Cliente" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgendamentoTreinoPersonal window = new TelaAgendamentoTreinoPersonal();
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
	public TelaAgendamentoTreinoPersonal() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tblListagemTreinos = new JTable();
		tblListagemTreinos.setBounds(10, 67, 414, 164);
		frame.getContentPane().add(tblListagemTreinos);
		
		JLabel lblPersonal = new JLabel("Personal:");
		lblPersonal.setBounds(23, 13, 46, 14);
		frame.getContentPane().add(lblPersonal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(79, 9, 345, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(336, 37, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRecusar.setBounds(33, 242, 89, 23);
		frame.getContentPane().add(btnRecusar);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.setBounds(314, 242, 89, 23);
		frame.getContentPane().add(btnAceitar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(178, 242, 89, 23);
		frame.getContentPane().add(btnExcluir);
	}
}
