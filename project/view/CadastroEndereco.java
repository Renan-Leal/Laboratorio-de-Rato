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

public class CadastroEndereco extends JPanel {

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
	
	public CadastroEndereco() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(206, 5, 10, 10);
		add(panel);
		
		txtCep = new JTextField();
		txtCep.setBounds(48, 41, 128, 20);
		add(txtCep);
		txtCep.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(302, 41, 86, 20);
		add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(14, 44, 46, 14);
		add(lblCep);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(246, 44, 46, 14);
		add(lblNumero);
		
		lblRua = new JLabel("Rua: ");
		lblRua.setBounds(14, 88, 26, 14);
		add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setBounds(48, 85, 341, 20);
		add(txtRua);
		txtRua.setColumns(10);
		
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 132, 78, 14);
		add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(98, 129, 291, 20);
		add(txtComplemento);
		txtComplemento.setColumns(10);
		
		lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(29, 170, 46, 14);
		add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(98, 167, 290, 20);
		add(txtBairro);
		txtBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(29, 205, 46, 14);
		add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(98, 202, 290, 20);
		add(txtCidade);
		txtCidade.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(29, 242, 46, 14);
		add(lblEstado);
		
		cbEstado = new JComboBox();
		cbEstado.setBounds(98, 238, 290, 22);
		add(cbEstado);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endereco.setCep(txtCep.getText());
				endereco.setNumero(txtNumero.getText());
				endereco.setRua(txtRua.getText());
				endereco.setComplemento(txtComplemento.getText());
				endereco.setBairro(txtBairro.getText());
				endereco.setCidade(txtCidade.getText());
				endereco.setEstado(cbEstado.getActionCommand());
				
				EnderecoController controller = new EnderecoController();
				
				try {
					if(endereco.getId() == null) {
						controller.inserir(endereco);
						JOptionPane.showMessageDialog(null, "Endereco cadastrado com sucesso!", 
								"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					} else {
						controller.atualizar(endereco);
						JOptionPane.showMessageDialog(null, "Endereco atualizado com sucesso!", 
								"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (CampoInvalidoException excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		btnSalvar.setBounds(299, 266, 89, 23);
		add(btnSalvar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 267, 89, 23);
		add(btnVoltar);
		
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
