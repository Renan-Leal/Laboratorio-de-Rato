package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroFuncionario {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtMatricula;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario window = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 426, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(63, 11, 330, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 14, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(20, 48, 46, 14);
		frame.getContentPane().add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(63, 45, 132, 20);
		frame.getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(205, 48, 61, 14);
		frame.getContentPane().add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(261, 45, 132, 20);
		frame.getContentPane().add(txtMatricula);
		
		textField = new JTextField();
		textField.setBounds(63, 79, 132, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(13, 82, 46, 14);
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblNewLabel = new JLabel("Dt. Nasc:");
		lblNewLabel.setBounds(207, 83, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(261, 81, 132, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(63, 114, 330, 20);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 117, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(63, 149, 330, 20);
		frame.getContentPane().add(txtSenha);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(20, 152, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(150, 295, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JComboBox cbEndereco = new JComboBox();
		cbEndereco.setBounds(63, 187, 330, 22);
		frame.getContentPane().add(cbEndereco);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(9, 191, 53, 14);
		frame.getContentPane().add(lblEndereco);
		
		JComboBox cbCargo = new JComboBox();
		cbCargo.setBounds(63, 223, 330, 22);
		frame.getContentPane().add(cbCargo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(15, 228, 53, 14);
		frame.getContentPane().add(lblCargo);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(67, 261, 326, 20);
		frame.getContentPane().add(txtValor);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(17, 265, 46, 14);
		frame.getContentPane().add(lblValor);
	}

}
