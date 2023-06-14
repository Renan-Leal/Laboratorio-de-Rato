package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class PainelAgendamentoTreino extends JPanel {
	
	public PainelAgendamentoTreino() {
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(15, 18, 46, 14);
		add(lblCliente);
		
		JComboBox cbCliente = new JComboBox();
		cbCliente.setBounds(71, 14, 335, 22);
		add(cbCliente);
		
		JLabel lblPersonal = new JLabel("Personal:");
		lblPersonal.setBounds(15, 54, 46, 14);
		add(lblPersonal);
		
		JComboBox cbPersonal = new JComboBox();
		cbPersonal.setBounds(71, 50, 335, 22);
		add(cbPersonal);
		
		JLabel lblInicio = new JLabel("Inicio -");
		lblInicio.setBounds(15, 94, 46, 14);
		add(lblInicio);
		
		JLabel lblDataInicio = new JLabel("Data Hora:");
		lblDataInicio.setBounds(71, 94, 76, 14);
		add(lblDataInicio);
		
		JComboBox cbHoraInicio = new JComboBox();
		cbHoraInicio.setBounds(133, 90, 273, 22);
		add(cbHoraInicio);
		
		JComboBox cbHoraFinal = new JComboBox();
		cbHoraFinal.setBounds(133, 123, 273, 22);
		add(cbHoraFinal);
		
		JLabel lblDataFinal = new JLabel("Data Hora:");
		lblDataFinal.setBounds(71, 127, 61, 14);
		add(lblDataFinal);
		
		JLabel lblFinal = new JLabel("Final -");
		lblFinal.setBounds(15, 127, 46, 14);
		add(lblFinal);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(173, 166, 89, 23);
		add(btnSalvar);
	}



}
