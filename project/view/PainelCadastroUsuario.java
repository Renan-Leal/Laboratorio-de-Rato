package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class PainelCadastroUsuario extends JPanel {

	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtLogin;
	private JTextField txtValorHora;
	private Usuario usuario;
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraTel;
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
	private JButton btnVoltar;
	private UsuarioController usuarioController = new UsuarioController();
	private PessoaController pessoaController = new PessoaController();
	private DatePicker dataNascimento;
	private DatePickerSettings dateSettings;

	public PainelCadastroUsuario(Usuario usuario) {
		setBackground(new Color(108, 255, 108));
		setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("max(119dlu;pref):grow"),
				FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("42px"), ColumnSpec.decode("49px"),
				FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("228px"), FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("68px"), ColumnSpec.decode("4px"), ColumnSpec.decode("191px"),
				ColumnSpec.decode("16px"), FormSpecs.UNRELATED_GAP_COLSPEC, ColumnSpec.decode("24px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, FormSpecs.GROWING_BUTTON_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC, FormSpecs.DEFAULT_COLSPEC, ColumnSpec.decode("94px"), },
				new RowSpec[] { FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("pref:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("20px"),
						FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("21px"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("22px"), FormSpecs.UNRELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("pref:grow"), }));
		setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("max(113dlu;pref):grow"), FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("26px"), ColumnSpec.decode("80px"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("228px"), FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("85px"),
						ColumnSpec.decode("191px"), ColumnSpec.decode("16px"), FormSpecs.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("24px"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						FormSpecs.GROWING_BUTTON_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, ColumnSpec.decode("94px"), },
				new RowSpec[] { FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("pref:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("20px"),
						FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("21px"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("22px"), FormSpecs.UNRELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("pref:grow"), }));

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNome.setForeground(Color.BLACK);
		add(lblNome, "7, 6, center, fill");

		txtNome = new JTextField();
		add(txtNome, "9, 6, 4, 1, fill, fill");
		txtNome.setColumns(10);

		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblCPF.setForeground(Color.BLACK);
		add(lblCPF, "7, 8, center, fill");

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			// silent
		}

		txtCPF = new JFormattedTextField(mascaraCpf);
		add(txtCPF, "9, 8, fill, fill");
		txtCPF.setColumns(10);

		lblDtNascimento = new JLabel("Dt. Nasc:");
		lblDtNascimento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblDtNascimento.setForeground(Color.BLACK);
		add(lblDtNascimento, "11, 8, center, center");

		dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);
		dataNascimento = new DatePicker(dateSettings);
		add(dataNascimento, "13, 8");

		txtCPF = new JFormattedTextField(mascaraCpf);
		add(txtCPF, "9, 8, fill, fill");
		txtCPF.setColumns(10);

		lblDtNascimento = new JLabel("Dt. Nasc:");
		lblDtNascimento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblDtNascimento.setForeground(Color.BLACK);
		add(lblDtNascimento, "11, 8, center, center");


		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblEmail.setForeground(Color.BLACK);
		add(lblEmail, "7, 10, center, fill");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		add(txtEmail, "9, 10, fill, fill");

		lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblValorHora.setForeground(Color.BLACK);
		add(lblValorHora, "11, 10, center, center");

		txtValorHora = new JTextField();
		txtValorHora.setColumns(10);
		add(txtValorHora, "13, 10, fill, fill");
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		add(txtEmail, "9, 10, fill, fill");

		lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblValorHora.setForeground(Color.BLACK);
		add(lblValorHora, "11, 10, center, center");

		txtValorHora = new JTextField();
		txtValorHora.setColumns(10);
		add(txtValorHora, "12, 10, fill, fill");

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTelefone.setForeground(Color.BLACK);
		add(lblTelefone, "7, 12, center, fill");

		try {
			mascaraTel = new MaskFormatter("(##)#####-####");
			mascaraTel.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			// silent
		}

		txtTelefone = new JFormattedTextField(mascaraTel);
		add(txtTelefone, "9, 12, fill, fill");
		txtTelefone.setColumns(10);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblSenha.setForeground(Color.BLACK);
		add(lblSenha, "11, 12, center, center");

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		add(txtSenha, "13, 12, fill, fill");

		txtTelefone = new JFormattedTextField(mascaraTel);
		add(txtTelefone, "9, 12, fill, fill");
		txtTelefone.setColumns(10);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblSenha.setForeground(Color.BLACK);
		add(lblSenha, "11, 12, center, center");

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		add(txtSenha, "12, 12, fill, fill");

		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblLogin.setForeground(Color.BLACK);
		add(lblLogin, "7, 14, center, fill");

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		add(txtLogin, "9, 14, fill, fill");

		lblTipoUsuario = new JLabel("Tipo:");
		lblTipoUsuario.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTipoUsuario.setForeground(Color.BLACK);
		add(lblTipoUsuario, "11, 14, center, center");

		cbTipoUsuario = new JComboBox(new String[] { "Administrador", "Personal Trainer", "Cliente" });
		cbTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbTipoUsuario.setBackground(Color.LIGHT_GRAY);
		cbTipoUsuario.setForeground(Color.BLACK);
		add(cbTipoUsuario, "13, 14, fill, top");

		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblEndereco.setForeground(Color.BLACK);
		add(lblEndereco, "7, 16, center, fill");

		cbEndereco = new JComboBox(new EnderecoController().consultarTodos().toArray());
		cbEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbEndereco.setForeground(Color.BLACK);
		cbEndereco.setBackground(Color.LIGHT_GRAY);
		add(cbEndereco, "9, 16, 5, 1, fill, fill");

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(btnVoltar, "7, 18, fill, bottom");

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		add(txtLogin, "9, 14, fill, fill");

		lblTipoUsuario = new JLabel("Tipo:");
		lblTipoUsuario.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTipoUsuario.setForeground(Color.BLACK);
		add(lblTipoUsuario, "11, 14, center, center");

		cbTipoUsuario = new JComboBox(new String[] { "Administrador", "Personal Trainer", "Cliente" });
		cbTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbTipoUsuario.setBackground(Color.LIGHT_GRAY);
		cbTipoUsuario.setForeground(Color.BLACK);
		add(cbTipoUsuario, "12, 14, fill, top");

		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblEndereco.setForeground(Color.BLACK);
		add(lblEndereco, "7, 16, center, fill");

		cbEndereco = new JComboBox(new EnderecoController().consultarTodos().toArray());
		cbEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbEndereco.setForeground(Color.BLACK);
		cbEndereco.setBackground(Color.LIGHT_GRAY);
		add(cbEndereco, "9, 16, 4, 1, fill, fill");
		this.usuario = usuario;

		btnSalvar = new JButton("Cadastrar");
		btnSalvar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setForeground(Color.WHITE);
		add(btnSalvar, "13, 18, right, fill");

		btnSalvar = new JButton("Cadastrar");
		btnSalvar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setForeground(Color.WHITE);
		add(btnSalvar, "12, 18, right, fill");

		if (this.usuario != null) {
			preencherCamposTela();
		} else {
			this.usuario = new Usuario();
		}

	}

	private void preencherCamposTela() {
		this.txtNome.setText(this.usuario.getPessoa().getNome());
		this.txtCPF.setText(this.usuario.getPessoa().getCpf());
		this.dataNascimento.setText(this.usuario.getPessoa().getDtNascimento().toString()
				.replaceAll("(\\d{4})-(\\d{2})-(\\d{2})", "$3/$2/$1"));
		this.txtEmail.setText(this.usuario.getEmail());
		this.txtTelefone.setText(this.usuario.getPessoa().getTelefone());
		this.txtValorHora.setText(this.usuario.getValorHora().toString());
		this.txtLogin.setText(this.usuario.getLogin());
		this.txtSenha.setText(this.usuario.getSenha());
		this.cbEndereco.setSelectedItem(this.usuario.getPessoa().getEndereco());
		this.cbTipoUsuario.setSelectedIndex(this.usuario.getTipoUsuario().getValor() - 1);

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

		this.usuario.getPessoa().setDtNascimento(dataNascimento.getDate());
		try {
			String telefoneSemMascara = (String) mascaraTel.stringToValue(txtTelefone.getText());
			this.usuario.getPessoa().setTelefone(telefoneSemMascara);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao converter o telefone", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		if (this.usuario.getId() == null) {
			this.usuario.setMatricula(new Random().nextInt(900000) + 100000);
		}

		this.usuario.setValorHora(Double.parseDouble(txtValorHora.getText()));
		this.usuario.setEmail(txtEmail.getText());
		this.usuario.setLogin(txtLogin.getText());
		if (txtSenha.getText().length() != 4) {
			throw new SenhaInvalidaException("Sua senha deve conter 4 dígitos");
		} else {
			this.usuario.setSenha(txtSenha.getText());
		}

		this.usuario.setTipoUsuario(TipoUsuario.getTipoUsuarioPorValor(cbTipoUsuario.getSelectedIndex() + 1));
		this.usuario.getPessoa().setEndereco((Endereco) cbEndereco.getSelectedItem());

		this.usuario.setDataCadastro(LocalDateTime.now());

		try {
			if (this.usuario.getId() == null) {
				Pessoa pessoaConsultada = this.pessoaController.consultarPorCpf(this.usuario.getPessoa());
				if (pessoaConsultada == null) {
					Pessoa pessoaCadastrada = this.pessoaController.inserir(this.usuario.getPessoa());
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

			} else {
				Pessoa pessoaConsultada = pessoaController.consultarPorCpf(this.usuario.getPessoa());
				this.usuario.getPessoa().setId(pessoaConsultada.getId());

				if (pessoaController.atualizar(this.usuario.getPessoa())) {
					usuarioController.atualizar(this.usuario);
					JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
				}
				;

			}
		} catch (CampoInvalidoException excecao) {
			JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		return usuario;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

}
