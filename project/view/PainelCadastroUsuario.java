package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

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
				setLayout(new FormLayout(new ColumnSpec[] {
						FormSpecs.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("51px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("34px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("53px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("15px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("62px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("24px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("31px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("44px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("3px"),
						ColumnSpec.decode("52px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("26px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("11px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("5px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("32px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("41px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("43px"),},
					new RowSpec[] {
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("22px"),
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("22px"),
						RowSpec.decode("32px"),
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("23px"),}));
		
				JLabel lblNome = new JLabel("Nome:");
				lblNome.setBounds(20, 14, 46, 14);
				add(lblNome, "2, 2, left, center");
		txtNome = new JTextField();
		txtNome.setBounds(63, 11, 330, 20);
		add(txtNome, "4, 2, 11, 1, default, top");
		txtNome.setColumns(10);
		
				JLabel lblCPF = new JLabel("CPF:");
				lblCPF.setBounds(20, 48, 46, 14);
				add(lblCPF, "2, 4, left, center");
				
						txtCPF = new JTextField();
						txtCPF.setBounds(63, 45, 132, 20);
						add(txtCPF, "4, 4, 5, 1, left, top");
						txtCPF.setColumns(10);
		
				JLabel lblNewLabel = new JLabel("Dt. Nasc:");
				lblNewLabel.setBounds(207, 83, 46, 14);
				add(lblNewLabel, "10, 4, left, center");
				
						txtDtNascimento = new JTextField();
						txtDtNascimento.setBounds(261, 81, 132, 20);
						add(txtDtNascimento, "12, 4, 3, 1, left, top");
						txtDtNascimento.setColumns(10);
		
				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setBounds(20, 117, 46, 14);
				add(lblEmail, "2, 6, left, center");
		
				txtEmail = new JTextField();
				txtEmail.setColumns(10);
				txtEmail.setBounds(63, 114, 330, 20);
				add(txtEmail, "4, 6, 3, 1, left, top");
								
										JLabel lblMatricula = new JLabel("Matricula:");
										lblMatricula.setBounds(205, 48, 61, 14);
										add(lblMatricula, "10, 6, left, center");
						
								txtMatricula = new JTextField();
								txtMatricula.setColumns(10);
								txtMatricula.setBounds(261, 45, 132, 20);
								add(txtMatricula, "12, 6, 5, 1, left, top");
				
						JLabel lblTelefone = new JLabel("Telefone:");
						lblTelefone.setBounds(13, 82, 46, 14);
						add(lblTelefone, "2, 8, left, center");
		
				txtTelefone = new JTextField();
				txtTelefone.setBounds(64, 81, 132, 20);
				add(txtTelefone, "4, 8, 4, 1, right, top");
				txtTelefone.setColumns(10);
								
										JButton btnSalvar = new JButton("Salvar");
										btnSalvar.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
											}
										});
														
																JLabel lblValorHora = new JLabel("Valor Hora:");
																lblValorHora.setBounds(206, 223, 66, 14);
																add(lblValorHora, "10, 8, right, center");
														
																txtValorHora = new JTextField();
																txtValorHora.setColumns(10);
																txtValorHora.setBounds(263, 219, 130, 20);
																add(txtValorHora, "12, 8, 5, 1, left, center");
																
																		JLabel lblLogin = new JLabel("Login:");
																		lblLogin.setBounds(21, 152, 46, 14);
																		add(lblLogin, "2, 9, left, center");
																
																		txtLogin = new JTextField();
																		txtLogin.setColumns(10);
																		txtLogin.setBounds(64, 147, 131, 20);
																		add(txtLogin, "4, 9, 4, 1, left, center");
														
																JLabel lblSenha = new JLabel("Senha:");
																lblSenha.setBounds(216, 151, 46, 14);
																add(lblSenha, "10, 9, left, center");
														
																txtSenha = new JTextField();
																txtSenha.setColumns(10);
																txtSenha.setBounds(263, 147, 129, 20);
																add(txtSenha, "12, 9, 5, 1, left, center");
												
														JLabel lblEndereco = new JLabel("Endere\u00E7o:");
														lblEndereco.setBounds(11, 185, 53, 14);
														add(lblEndereco, "2, 10, left, center");
												
														JComboBox cbEndereco = new JComboBox();
														cbEndereco.setBounds(65, 181, 330, 22);
														add(cbEndereco, "4, 10, 4, 1, left, top");
												
														JLabel lblTipoUsuario = new JLabel("Tipo:");
														lblTipoUsuario.setBounds(20, 225, 46, 14);
														add(lblTipoUsuario, "10, 10, right, center");
										
												JComboBox cbTipoUsuario = new JComboBox();
												cbTipoUsuario.setBounds(65, 221, 130, 22);
												add(cbTipoUsuario, "12, 10, 5, 1, right, top");
										btnSalvar.setBounds(153, 254, 89, 23);
										add(btnSalvar, "27, 12, 3, 1, left, top");
	}

}
