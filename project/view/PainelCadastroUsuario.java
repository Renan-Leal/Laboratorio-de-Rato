package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCadastroUsuario extends JPanel {

	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtMatricula;
	private JTextField txtTelefone;
	private JTextField txtDtNascimento;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtLogin;
	private JTextField txtValorHora;

	public PainelCadastroUsuario() {
		txtNome = new JTextField();
		txtNome.setBounds(63, 11, 330, 20);
		add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 14, 46, 14);
		add(lblNome);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(20, 48, 46, 14);
		add(lblCPF);

		txtCPF = new JTextField();
		txtCPF.setBounds(63, 45, 132, 20);
		add(txtCPF);
		txtCPF.setColumns(10);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(205, 48, 61, 14);
		add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(261, 45, 132, 20);
		add(txtMatricula);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(64, 81, 132, 20);
		add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(13, 82, 46, 14);
		add(lblTelefone);

		JLabel lblNewLabel = new JLabel("Dt. Nasc:");
		lblNewLabel.setBounds(207, 83, 46, 14);
		add(lblNewLabel);

		txtDtNascimento = new JTextField();
		txtDtNascimento.setBounds(261, 81, 132, 20);
		add(txtDtNascimento);
		txtDtNascimento.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(63, 114, 330, 20);
		add(txtEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 117, 46, 14);
		add(lblEmail);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(263, 147, 129, 20);
		add(txtSenha);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(216, 151, 46, 14);
		add(lblSenha);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(153, 254, 89, 23);
		add(btnSalvar);

		JComboBox cbEstado = new JComboBox();
		cbEstado.setBounds(65, 181, 330, 22);
		add(cbEstado);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(11, 185, 53, 14);
		add(lblEndereco);

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(64, 147, 131, 20);
		add(txtLogin);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(21, 152, 46, 14);
		add(lblLogin);

		txtValorHora = new JTextField();
		txtValorHora.setColumns(10);
		txtValorHora.setBounds(263, 219, 130, 20);
		add(txtValorHora);

		JLabel lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setBounds(206, 223, 66, 14);
		add(lblValorHora);

		JLabel lblTipoUsuario = new JLabel("Tipo:");
		lblTipoUsuario.setBounds(20, 225, 46, 14);
		add(lblTipoUsuario);

		JComboBox cbTipoUsuario = new JComboBox();
		cbTipoUsuario.setBounds(65, 221, 130, 22);
		add(cbTipoUsuario);
	}

}
