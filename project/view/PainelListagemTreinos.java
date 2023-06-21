package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.vo.Treino;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class PainelListagemTreinos extends JPanel {

	private ArrayList<Treino> treinos;
	private String[] nomesColunas = { "Cliente", "Personal", "Nivel", "Treino" };
	private JTable tblTreinos;
	private JLabel lblCliente;
	private JLabel lblProfissional;
	private JComboBox cbCliente;
	private JComboBox cbProfissional;
	private JLabel lblNivel;
	private JComboBox cbNivel ;
	private JButton btnBuscarComFiltro;
	private JButton btnBuscarTodos;
	private JButton btnExcluir;
	private JButton btnEditar;
	private JButton btnGerarPlanilha;
	private JButton btnAvancarPagina;
	private JButton btnVoltarPagina;
	
	private void limparTabelaTreinos() {
		tblTreinos.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	public PainelListagemTreinos() {
		setLayout(null);
		
		lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(33, 37, 46, 14);
		add(lblCliente);
		
		lblProfissional = new JLabel("Personal:");
		lblProfissional.setBounds(33, 72, 46, 14);
		add(lblProfissional);
		
		cbCliente = new JComboBox();
		cbCliente.setBounds(89, 33, 231, 22);
		add(cbCliente);
		
		cbProfissional = new JComboBox();
		cbProfissional.setBounds(89, 68, 231, 22);
		add(cbProfissional);
		
		lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(33, 110, 46, 14);
		add(lblNivel);
		
		cbNivel = new JComboBox();
		cbNivel.setBounds(89, 106, 231, 22);
		add(cbNivel);
		
		btnBuscarComFiltro = new JButton("Buscar com Filtro");
		btnBuscarComFiltro.setBounds(360, 33, 125, 23);
		add(btnBuscarComFiltro);
		
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.setBounds(360, 72, 125, 23);
		add(btnBuscarTodos);
		
		tblTreinos = new JTable();
		this.limparTabelaTreinos();
		tblTreinos.setBounds(22, 141, 520, 133);
		this.add(tblTreinos);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(22, 329, 89, 23);
		add(btnExcluir);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(121, 329, 89, 23);
		add(btnEditar);
		
		btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha.setBounds(22, 285, 125, 23);
		add(btnGerarPlanilha);
		
		btnAvancarPagina = new JButton("Avançar >>");
		btnAvancarPagina.setBounds(347, 285, 102, 23);
		add(btnAvancarPagina);
		
		btnVoltarPagina = new JButton("<< Voltar");
		btnVoltarPagina.setBounds(453, 285, 89, 23);
		add(btnVoltarPagina);




	}
}
