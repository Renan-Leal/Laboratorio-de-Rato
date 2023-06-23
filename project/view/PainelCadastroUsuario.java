package view;

import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
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
import model.controller.PessoaController;
import model.controller.UsuarioController;
import model.exception.CampoInvalidoException;
import model.exception.SenhaInvalidaException;
import model.vo.TipoUsuario;
import model.vo.Usuario;
import model.vo.Endereco;
import model.vo.Pessoa;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class PainelCadastroUsuario extends JPanel {

	private JTextField txtNome;
	private JTextField txtCPF;
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
	private JLabel lblTelefone;
	private JLabel lblTipoUsuario;
	private JComboBox cbEndereco;
	private JButton btnSalvar;
	private JLabel lblValorHora;
	private JLabel lblLogin;
	private JLabel lblEndereco;

	public PainelCadastroUsuario(Usuario usuario) {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(14dlu;default)"),
						ColumnSpec.decode("79px"), FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("134px"),
						ColumnSpec.decode("-4px"), ColumnSpec.decode("55px"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("24px"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("94px"),
						ColumnSpec.decode("18px"), ColumnSpec.decode("30px"), ColumnSpec.decode("117px"),
						ColumnSpec.decode("63px"), },
				new RowSpec[] { FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"), FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("21px"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("26px"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("23px"), }));

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 14, 46, 14);
		add(lblNome, "3, 2, center, center");

		txtNome = new JTextField();
		txtNome.setBounds(63, 11, 330, 20);
		add(txtNome, "5, 2, 7, 1, fill, top");
		txtNome.setColumns(10);

		lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(20, 48, 46, 14);
		add(lblCPF, "3, 4, center, center");

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			// silent
		}

		txtCPF = new JFormattedTextField(mascaraCpf);
		txtCPF.setBounds(63, 45, 132, 20);
		add(txtCPF, "5, 4, left, top");
		txtCPF.setColumns(10);

		lblDtNascimento = new JLabel("Dt. Nasc:");
		lblDtNascimento.setBounds(207, 83, 46, 14);
		add(lblDtNascimento, "7, 4, 3, 1, left, center");

		txtDtNascimento = new JTextField();
		txtDtNascimento.setBounds(261, 81, 132, 20);
		add(txtDtNascimento, "11, 4, 3, 1, left, top");
		txtDtNascimento.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 117, 46, 14);
		add(lblEmail, "3, 6, center, center");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(63, 114, 330, 20);
		add(txtEmail, "5, 6, left, top");

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(13, 82, 46, 14);
		add(lblTelefone, "3, 8, center, center");

		txtTelefone = new JTextField();
		txtTelefone.setBounds(64, 81, 132, 20);
		add(txtTelefone, "5, 8, fill, fill");
		txtTelefone.setColumns(10);

		lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setBounds(206, 223, 66, 14);
		add(lblValorHora, "7, 8, 3, 1, right, center");

		txtValorHora = new JTextField();
		txtValorHora.setColumns(10);
		txtValorHora.setBounds(263, 219, 130, 20);
		add(txtValorHora, "11, 8, 3, 1, left, center");

		lblLogin = new JLabel("Login:");
		lblLogin.setBounds(21, 152, 46, 14);
		add(lblLogin, "3, 10, center, center");

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(64, 147, 131, 20);
		add(txtLogin, "5, 10, left, center");

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(216, 151, 46, 14);
		add(lblSenha, "7, 10, left, center");

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(263, 147, 129, 20);
		add(txtSenha, "11, 10, 3, 1, left, center");

		lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(11, 185, 53, 14);
		add(lblEndereco, "3, 12, center, center");

		cbEndereco = new JComboBox(new EnderecoController().consultarTodos().toArray());
		cbEndereco.setBounds(65, 181, 330, 22);
		add(cbEndereco, "5, 12, left, top");

		lblTipoUsuario = new JLabel("Tipo:");
		lblTipoUsuario.setBounds(20, 225, 46, 14);
		add(lblTipoUsuario, "9, 12, right, center");

		cbTipoUsuario = new JComboBox(new String[] { "Administrador", "Personal Trainer", "Cliente" });
		cbTipoUsuario.setBounds(65, 221, 130, 22);
		add(cbTipoUsuario, "11, 12, fill, top");

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(153, 254, 89, 23);
		add(btnSalvar, "11, 14, fill, fill");

		this.usuario = usuario;

		if (this.usuario != null) {
			preencherCamposTela();
		} else {
			this.usuario = new Usuario();
		}

	}

	private void preencherCamposTela() {
		this.txtNome.setText(this.usuario.getPessoa().getNome());
		this.txtCPF.setText(this.usuario.getPessoa().getCpf());
		this.txtDtNascimento.setText(this.usuario.getPessoa().getDtNascimento().toString());
		this.txtEmail.setText(this.usuario.getEmail());
		this.txtTelefone.setText(this.usuario.getPessoa().getTelefone());
		this.txtValorHora.setText(this.usuario.getValorHora().toString());
		this.txtLogin.setText(this.usuario.getLogin());
		this.txtSenha.setText(this.usuario.getSenha());
		this.cbEndereco.setSelectedItem(this.usuario.getPessoa().getEndereco());
		this.cbTipoUsuario.setSelectedIndex(this.usuario.getTipoUsuario().getValor());

	}

	public Usuario cadastrarUsuario() throws SenhaInvalidaException {
		this.usuario.setPessoa(new Pessoa());

		this.usuario.getPessoa().setNome(txtNome.getText());
		try {
			String cpfSemMascara = (String) mascaraCpf.stringToValue(txtCPF.getText());
			this.usuario.getPessoa().setCpf(cpfSemMascara);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao converter o CPF", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		this.usuario.getPessoa()
				.setDtNascimento(LocalDate.parse(txtDtNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		this.usuario.getPessoa().setTelefone(txtTelefone.getText());

		this.usuario.setMatricula(new Random().nextInt(900000) + 100000);
		this.usuario.setValorHora(Double.parseDouble(txtValorHora.getText()));
		this.usuario.setEmail(txtEmail.getText());
		this.usuario.setLogin(txtLogin.getText());
		if(txtSenha.getText().length() != 4) {
			throw new SenhaInvalidaException("Sua senha deve conter 4 dígitos");
		} else {
			this.usuario.setSenha(txtSenha.getText());
		}
		
		this.usuario.setTipoUsuario(TipoUsuario.getTipoUsuarioPorValor(cbTipoUsuario.getSelectedIndex() + 1));
		this.usuario.getPessoa().setEndereco((Endereco) cbEndereco.getSelectedItem());

		// TODO Finalizar o método de Cadastro de Pessoa e Usuário
		UsuarioController usuarioController = new UsuarioController();
		PessoaController pessoaController = new PessoaController();

		try {
			if (this.usuario.getId() == null) {
				Pessoa pessoaConsultada = pessoaController.consultarPorCpf(this.usuario.getPessoa());
				if (pessoaConsultada == null) {
					Pessoa pessoaCadastrada = pessoaController.inserir(this.usuario.getPessoa());
					this.usuario.getPessoa().setId(pessoaCadastrada.getId());
					usuarioController.inserir(this.usuario);

					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					this.usuario.getPessoa().setId(pessoaConsultada.getId());
					usuarioController.inserir(this.usuario);

					JOptionPane.showMessageDialog(null,
							"Pessoa já cadastrada! No entanto, o usuário foi cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		} catch (CampoInvalidoException excecao) {
			JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		return usuario;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

}
