package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCadastroEndereco {

	private JFrame frmCadastroDeEndereco;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JLabel lblRua;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblCidade;
	private JLabel lblComplemento;
	private JLabel lblEstado;
	private JButton btnSalvar;
	private JComboBox cbEstado;
	
	//Objeto usado para armazenar o endere�o que ser� criado ou editado
//	private Endereco endereco;
	
	//TODO chamar API ou backend futuramente
	private String[] estados = {"PR", "RS", "SC"};
	private JTextField txtComplemento;
	private JLabel lblNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco window = new TelaCadastroEndereco();
					window.frmCadastroDeEndereco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeEndereco = new JFrame();
		frmCadastroDeEndereco.setTitle("Cadastro de endereco");
		frmCadastroDeEndereco.setBounds(100, 100, 415, 268);
		frmCadastroDeEndereco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeEndereco.getContentPane().setLayout(null);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(15, 20, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(42, 17, 143, 20);
		frmCadastroDeEndereco.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(15, 51, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblRua);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(15, 107, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblBairro);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(15, 138, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblCidade);
		
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(15, 79, 69, 14);
		frmCadastroDeEndereco.getContentPane().add(lblComplemento);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(15, 166, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblEstado);
		
		txtRua = new JTextField();
		txtRua.setBounds(42, 48, 347, 20);
		frmCadastroDeEndereco.getContentPane().add(txtRua);
		txtRua.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(89, 104, 300, 20);
		frmCadastroDeEndereco.getContentPane().add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(89, 135, 300, 20);
		frmCadastroDeEndereco.getContentPane().add(txtCidade);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(243, 17, 146, 20);
		frmCadastroDeEndereco.getContentPane().add(txtNumero);
		
		cbEstado = new JComboBox(estados);
		cbEstado.setToolTipText("Selecione");
		cbEstado.setSelectedIndex(-1);
		cbEstado.setBounds(89, 162, 300, 22);
		frmCadastroDeEndereco.getContentPane().add(cbEstado);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(144, 195, 100, 23);
		frmCadastroDeEndereco.getContentPane().add(btnSalvar);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(89, 76, 300, 20);
		frmCadastroDeEndereco.getContentPane().add(txtComplemento);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(195, 20, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblNumero);

	}
}
