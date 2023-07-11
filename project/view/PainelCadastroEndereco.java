package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.EnderecoController;
import model.exception.EnderecoInvalidoException;
import model.exception.CampoInvalidoException;
import model.vo.Endereco;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import java.awt.Font;

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
	private MaskFormatter mascaraTxtCep;
	
	public PainelCadastroEndereco(Endereco endereco) {
		setBackground(new Color(108, 255, 108));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(91dlu;pref):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(14dlu;pref):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(86dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(10dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(55dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(130dlu;default)"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(23dlu;pref):grow"),}));
		
		lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.BLACK);
		lblCep.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblCep, "16, 5, fill, center");
		
		try {
			mascaraTxtCep = new MaskFormatter("#####-###");
			mascaraTxtCep.setValueContainsLiteralCharacters(false);		
		} catch (ParseException e) {
			// silent
		}
		
		txtCep = new JFormattedTextField(mascaraTxtCep);
		add(txtCep, "18, 5, fill, top");
		txtCep.setColumns(10);
		
		lblNumero = new JLabel("Número:");
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblNumero, "22, 5, right, fill");
		
		txtNumero = new JTextField();
		add(txtNumero, "24, 5, fill, fill");
		txtNumero.setColumns(10);
		
		lblRua = new JLabel("Rua: ");
		lblRua.setForeground(Color.BLACK);
		lblRua.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblRua, "16, 7, fill, center");
		
		txtRua = new JTextField();
		add(txtRua, "18, 7, 7, 1, fill, fill");
		txtRua.setColumns(10);
		
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setForeground(Color.BLACK);
		lblComplemento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblComplemento, "16, 9, fill, center");
		
		txtComplemento = new JTextField();
		add(txtComplemento, "18, 9, 7, 1, fill, top");
		txtComplemento.setColumns(10);
		
		lblBairro = new JLabel("Bairro: ");
		lblBairro.setForeground(Color.BLACK);
		lblBairro.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblBairro, "16, 11, fill, center");
		
		txtBairro = new JTextField();
		add(txtBairro, "18, 11, 7, 1, fill, top");
		txtBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.BLACK);
		lblCidade.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblCidade, "16, 13, fill, center");
		
		txtCidade = new JTextField();
		add(txtCidade, "18, 13, 7, 1, fill, fill");
		txtCidade.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblEstado, "16, 15, fill, center");
		
		cbEstado = new JComboBox(estados);
		cbEstado.setForeground(Color.WHITE);
		cbEstado.setBackground(Color.DARK_GRAY);
		cbEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.add(cbEstado, "18, 15, 7, 1, fill, fill");
		
		
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(btnVoltar, "16, 19, fill, bottom");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(btnSalvar, "24, 19, fill, fill");
		
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
	
	public void cadastrarEndereco() throws ParseException {
		String cepSemMascara = (String) mascaraTxtCep.stringToValue(txtCep.getText());
		this.endereco.setCep(cepSemMascara);
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
