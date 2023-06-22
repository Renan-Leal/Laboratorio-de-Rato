package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.controller.EnderecoController;
import model.exception.EnderecoInvalidoException;
import model.exception.CampoInvalidoException;
import model.vo.Endereco;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class PainelCadastroEndereco extends JPanel {

	private JButton btnVoltar;
	private Endereco endereco;
	private JTextField txtCep;
	private JTextField txtNumero;
	private JLabel lblNumero;
	private JLabel lblRua;
	private JTextField txtRua;
	private JLabel lblComplemento;
	private JTextField txtComplemento;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JLabel lblEstado;
	private JComboBox cbEstado;
	private String[] estados = {"PR", "RS", "SC"};
	private JLabel lblCep;
	private JButton btnSalvar;
	
	public PainelCadastroEndereco(Endereco endereco) {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(14dlu;pref):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(24dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("fill:max(23dlu;pref):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(11dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:pref:grow"),}));
		
		JPanel panel = new JPanel();
		add(panel, "14, 2, left, top");
		
		lblCep = new JLabel("CEP:");
		add(lblCep, "10, 5, fill, center");
		
		txtCep = new JTextField();
		add(txtCep, "12, 5, fill, top");
		txtCep.setColumns(10);
		
		lblNumero = new JLabel("N\u00FAmero:");
		add(lblNumero, "16, 5, fill, fill");
		
		txtNumero = new JTextField();
		add(txtNumero, "18, 5, fill, fill");
		txtNumero.setColumns(10);
		
		lblRua = new JLabel("Rua: ");
		add(lblRua, "10, 7, fill, center");
		
		txtRua = new JTextField();
		add(txtRua, "12, 7, 7, 1, fill, fill");
		txtRua.setColumns(10);
		
		lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "10, 9, fill, center");
		
		txtComplemento = new JTextField();
		add(txtComplemento, "12, 9, 7, 1, fill, top");
		txtComplemento.setColumns(10);
		
		lblBairro = new JLabel("Bairro: ");
		add(lblBairro, "10, 11, fill, center");
		
		txtBairro = new JTextField();
		add(txtBairro, "12, 11, 7, 1, fill, top");
		txtBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "10, 13, fill, center");
		
		txtCidade = new JTextField();
		add(txtCidade, "12, 13, 7, 1, fill, fill");
		txtCidade.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		add(lblEstado, "10, 15, fill, center");
		
		cbEstado = new JComboBox(estados);
		this.add(cbEstado, "12, 15, 7, 1, fill, fill");
		
		
		
		btnVoltar = new JButton("Voltar");
		add(btnVoltar, "10, 19, fill, bottom");
		
		btnSalvar = new JButton("Salvar");
		add(btnSalvar, "18, 19, fill, fill");
		
		this.endereco = endereco;
		if(this.endereco != null) {
			preencherCamposTela();
		} else {
			this.endereco = new Endereco();
		}
	}
	
	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	
	public void cadastrarEndereco() {
		this.endereco.setCep(txtCep.getText());
		this.endereco.setNumero(txtNumero.getText());
		this.endereco.setRua(txtRua.getText());
		this.endereco.setComplemento(txtComplemento.getText());
		this.endereco.setBairro(txtBairro.getText());
		this.endereco.setCidade(txtCidade.getText());
		this.endereco.setEstado((String) cbEstado.getSelectedItem());
		
		EnderecoController enderecoController = new EnderecoController();
		
		try {
			if(endereco.getId() == null) {
				enderecoController.inserir(this.endereco);
				JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!", 
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				enderecoController.atualizar(this.endereco);
				JOptionPane.showMessageDialog(null, "Endereço atualizado com sucesso!", 
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (CampoInvalidoException excecao) {
			JOptionPane.showMessageDialog(null, excecao.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE); 
		}
	}

	private void preencherCamposTela() {
		this.txtRua.setText(this.endereco.getRua());
		this.txtCep.setText(this.endereco.getCep());
		this.cbEstado.setSelectedItem(this.endereco.getEstado());
		this.txtCidade.setText(this.endereco.getCidade());
		this.txtBairro.setText(this.endereco.getBairro());
		this.txtComplemento.setText(this.endereco.getComplemento());
		this.txtNumero.setText(this.endereco.getNumero());
	}
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
