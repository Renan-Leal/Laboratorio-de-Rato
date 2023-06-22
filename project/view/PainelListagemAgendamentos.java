package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.vo.Agendamento;


import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.util.ArrayList;

import javax.swing.JButton;

public class PainelListagemAgendamentos extends JPanel {

	private ArrayList<Agendamento> agendamentos;
	private String[] nomesColunas = { "Cliente", "Hora Inicio", "Hora Final" };
	private JTable tblAgendamentos;
	private JLabel lblProfissional;
	private JComboBox cbProfissional;
	private JButton btnBuscar;
	private JButton btnRecusar;
	private JButton btnExcluir;
	private JButton btnAceitar;
	
	private void limparTabelaAgendamentos() {
		tblAgendamentos.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	public PainelListagemAgendamentos() {
		setLayout(null);
		
		lblProfissional = new JLabel("Personal:");
		lblProfissional.setBounds(37, 41, 46, 14);
		add(lblProfissional);
		
		cbProfissional = new JComboBox();
		cbProfissional.setBounds(93, 37, 322, 22);
		add(cbProfissional);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(440, 37, 89, 23);
		add(btnBuscar);
		
		btnRecusar = new JButton("Recusar");
		btnRecusar.setBounds(28, 266, 89, 23);
		add(btnRecusar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(243, 266, 89, 23);
		add(btnExcluir);
		
		btnAceitar = new JButton("Aceitar");
		btnAceitar.setBounds(440, 266, 89, 23);
		add(btnAceitar);
		
		tblAgendamentos = new JTable();
		this.limparTabelaAgendamentos();
		tblAgendamentos.setBounds(22, 82, 520, 156);
		this.add(tblAgendamentos);

	}
}
