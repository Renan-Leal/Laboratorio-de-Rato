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
	
	public PainelCadastroEndereco() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("30px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("40px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("78px"),
				ColumnSpec.decode("30px"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("30px"),
				ColumnSpec.decode("46px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("90px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("10px"),
				RowSpec.decode("26px"),
				RowSpec.decode("20px"),
				RowSpec.decode("24px"),
				RowSpec.decode("20px"),
				RowSpec.decode("24px"),
				RowSpec.decode("20px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("24px"),}));
		
		JPanel panel = new JPanel();
		add(panel, "8, 2, left, top");
		
		txtCep = new JTextField();
		add(txtCep, "4, 4, 3, 1, fill, top");
		txtCep.setColumns(10);
		
		txtNumero = new JTextField();
		add(txtNumero, "12, 4, center, top");
		txtNumero.setColumns(10);
		
		lblCep = new JLabel("CEP:");
		add(lblCep, "2, 4, 3, 1, center, center");
		
		lblNumero = new JLabel("N\u00FAmero:");
		add(lblNumero, "10, 4, fill, center");
		
		lblRua = new JLabel("Rua: ");
		add(lblRua, "2, 6, right, center");
		
		txtRua = new JTextField();
		add(txtRua, "4, 6, 9, 1, fill, top");
		txtRua.setColumns(10);
		
		lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "2, 8, 3, 1, fill, center");
		
		txtComplemento = new JTextField();
		add(txtComplemento, "6, 8, 7, 1, fill, top");
		txtComplemento.setColumns(10);
		
		lblBairro = new JLabel("Bairro: ");
		add(lblBairro, "2, 10, 3, 1, center, center");
		
		txtBairro = new JTextField();
		add(txtBairro, "6, 10, 7, 1, fill, top");
		txtBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "2, 12, 3, 1, center, center");
		
		txtCidade = new JTextField();
		add(txtCidade, "6, 12, 7, 1, fill, top");
		txtCidade.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		add(lblEstado, "2, 14, 3, 1, center, center");
		
		cbEstado = new JComboBox(estados);
		this.add(cbEstado, "6, 14, 7, 1, fill, fill");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endereco.setCep(txtCep.getText());
				endereco.setNumero(txtNumero.getText());
				endereco.setRua(txtRua.getText());
				endereco.setComplemento(txtComplemento.getText());
				endereco.setBairro(txtBairro.getText());
				endereco.setCidade(txtCidade.getText());
				endereco.setEstado((String) cbEstado.getSelectedItem());
				
				EnderecoController controller = new EnderecoController();
				
				try {
					if(endereco.getId() == null) {
						controller.inserir(endereco);
						JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!", 
								"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (CampoInvalidoException excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		add(btnSalvar, "12, 16, fill, top");
		
		btnVoltar = new JButton("Voltar");
		add(btnVoltar, "2, 16, 5, 1, left, bottom");
		
		if(this.endereco.getId() != null) {
			preencherCamposTela();
		}

	}
	
	private void preencherCamposTela() {
		this.txtRua.setText(this.endereco.getRua());
		this.txtCep.setText(this.endereco.getCep());
		this.cbEstado.setSelectedItem(this.endereco.getEstado());
	}
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
