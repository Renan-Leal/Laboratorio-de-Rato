package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.controller.UsuarioController;
import model.exception.CampoInvalidoException;
import model.vo.Usuario;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class PainelLogin extends JPanel {
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JButton btnLogar;

	public PainelLogin() {
		setBackground(new Color(108, 255, 108));
		setForeground(SystemColor.desktop);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(40dlu;pref):grow"),
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
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("fill:pref:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
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
				RowSpec.decode("fill:pref:grow"),}));
																
																		lblLogin = new JLabel("Login:");
																		lblLogin.setForeground(Color.BLACK);
																		lblLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
																		add(lblLogin, "16, 6, fill, fill");
														
																txtLogin = new JTextField();
																txtLogin.setForeground(Color.BLACK);
																add(txtLogin, "19, 6, fill, fill");
																txtLogin.setColumns(10);
												
														lblSenha = new JLabel("Senha:");
														lblSenha.setForeground(Color.BLACK);
														lblSenha.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
														add(lblSenha, "16, 10, fill, fill");
										
												txtSenha = new JPasswordField();
												txtSenha.setForeground(Color.BLACK);
												add(txtSenha, "19, 10, fill, fill");
										
												btnLogar = new JButton("Logar");
												btnLogar.setForeground(Color.WHITE);
												btnLogar.setBackground(Color.BLACK);
												btnLogar.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
												btnLogar.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
													}
												});
												add(btnLogar, "19, 14, fill, fill");

	}

	public JButton getBtnLogar() {
		return btnLogar;
	}
	
	@SuppressWarnings("deprecation")
	public Usuario autenticar() throws CampoInvalidoException {
		Usuario usuarioAutenticado = null;
		usuarioAutenticado = new UsuarioController().consultarPorLoginSenha(this.txtLogin.getText(), this.txtSenha.getText());
		return usuarioAutenticado;
	}
	
	

}
