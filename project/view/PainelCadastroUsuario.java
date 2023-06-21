package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.controller.EnderecoController;
import model.controller.UsuarioController;
import model.exception.CampoInvalidoException;
import model.vo.TipoUsuario;
import model.vo.Usuario;
import model.vo.Endereco;
import java.text.ParseException;

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
	private Usuario usuario;
	private MaskFormatter mascaraCpf;
	private JLabel lblNome;
	private JComboBox cbTipoUsuario;
	private JLabel lblSenha;
	private JLabel lblCPF;
	private JLabel lblDtNascimento;
	private JLabel lblEmail;
	private JLabel lblMatricula;
	private JLabel lblTelefone;
	private JLabel lblTipoUsuario;
	private JComboBox cbEndereco;
	private JButton btnSalvar;
	private JLabel lblValorHora;
	private JLabel lblLogin;
	private JLabel lblEndereco;

	public PainelCadastroUsuario() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("49px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("95px"),
				ColumnSpec.decode("19px"),
				ColumnSpec.decode("34px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("24px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("59px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("30px"),
				ColumnSpec.decode("117px"),
				ColumnSpec.decode("63px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("21px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 14, 46, 14);
		add(lblNome, "2, 2, left, center");
		
		txtNome = new JTextField();
		txtNome.setBounds(63, 11, 330, 20);
		add(txtNome, "4, 2, 7, 1, fill, top");
		txtNome.setColumns(10);

		lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(20, 48, 46, 14);
		add(lblCPF, "2, 4, left, center");
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			//silent
		}

		txtCPF = new JFormattedTextField(mascaraCpf);
		txtCPF.setBounds(63, 45, 132, 20);
		add(txtCPF, "4, 4, left, top");
		txtCPF.setColumns(10);

		lblDtNascimento = new JLabel("Dt. Nasc:");
		lblDtNascimento.setBounds(207, 83, 46, 14);
		add(lblDtNascimento, "6, 4, 3, 1, left, center");

		txtDtNascimento = new JTextField();
		txtDtNascimento.setBounds(261, 81, 132, 20);
		add(txtDtNascimento, "10, 4, 3, 1, left, top");
		txtDtNascimento.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 117, 46, 14);
		add(lblEmail, "2, 6, left, center");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(63, 114, 330, 20);
		add(txtEmail, "4, 6, left, top");

		lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(205, 48, 61, 14);
		add(lblMatricula, "6, 6, 3, 1, left, center");

		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(261, 45, 132, 20);
		add(txtMatricula, "10, 6, 3, 1, left, top");

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(13, 82, 46, 14);
		add(lblTelefone, "2, 8, left, center");

		txtTelefone = new JTextField();
		txtTelefone.setBounds(64, 81, 132, 20);
		add(txtTelefone, "4, 8, right, top");
		txtTelefone.setColumns(10);

		lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setBounds(206, 223, 66, 14);
		add(lblValorHora, "6, 8, 3, 1, right, center");

		txtValorHora = new JTextField();
		txtValorHora.setColumns(10);
		txtValorHora.setBounds(263, 219, 130, 20);
		add(txtValorHora, "10, 8, 3, 1, left, center");

		lblLogin = new JLabel("Login:");
		lblLogin.setBounds(21, 152, 46, 14);
		add(lblLogin, "2, 10, left, center");

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(64, 147, 131, 20);
		add(txtLogin, "4, 10, left, center");

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(216, 151, 46, 14);
		add(lblSenha, "6, 10, left, center");

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(263, 147, 129, 20);
		add(txtSenha, "10, 10, 3, 1, left, center");

		lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(11, 185, 53, 14);
		add(lblEndereco, "2, 12, left, center");

		cbEndereco = new JComboBox();
		cbEndereco.setBounds(65, 181, 330, 22);
		add(cbEndereco, "4, 12, left, top");

		lblTipoUsuario = new JLabel("Tipo:");
		lblTipoUsuario.setBounds(20, 225, 46, 14);
		add(lblTipoUsuario, "8, 12, right, center");

		cbTipoUsuario = new JComboBox();
		cbTipoUsuario.setBounds(65, 221, 130, 22);
		add(cbTipoUsuario, "10, 12, 3, 1, right, top");
				
						btnSalvar = new JButton("Salvar");
						btnSalvar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								usuario.setNome(txtNome.getText());	
								try {
									String cpfSemMascara = (String) mascaraCpf.stringToValue(
											txtCPF.getText());
									usuario.setCpf(cpfSemMascara);
								} catch (ParseException e1) {
									JOptionPane.showMessageDialog(null, "Erro ao converter o CPF", 
											"Erro", JOptionPane.ERROR_MESSAGE); 
								}
								usuario.setMatricula(txtMatricula.getColumns());
								usuario.setTelefone(txtTelefone.getText());
								usuario.setDtNascimento(txtDtNascimento.getText());
								usuario.setEmail(txtEmail.getText());
								usuario.setLogin(txtLogin.getText());
								usuario.setSenha(txtSenha.getText());
								usuario.setTipoUsuario((TipoUsuario) cbTipoUsuario.getSelectedItem());
								usuario.setEndereco((Endereco) cbEndereco.getSelectedItem());

								UsuarioController controller = new UsuarioController();
								
								try {
									if(usuario.getId() == null) {
										controller.inserir(usuario);
										JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", 
												"Sucesso", JOptionPane.INFORMATION_MESSAGE);
									}
								} catch (CampoInvalidoException excecao) {
									JOptionPane.showMessageDialog(null, excecao.getMessage(), 
											"Erro", JOptionPane.ERROR_MESSAGE); 
								}
							}
						});
						btnSalvar.setBounds(153, 254, 89, 23);
						add(btnSalvar, "10, 14, left, top");
	}

}
