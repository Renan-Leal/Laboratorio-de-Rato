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

public class PainelLogin extends JPanel {
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JButton btnLogar;

	public PainelLogin() {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(92dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(36dlu;default)"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		lblLogin = new JLabel("Login:");
		add(lblLogin, "10, 8, right, default");

		txtLogin = new JTextField();
		add(txtLogin, "12, 8, fill, default");
		txtLogin.setColumns(10);

		lblSenha = new JLabel("Senha:");
		add(lblSenha, "10, 12, right, default");

		txtSenha = new JPasswordField();
		add(txtSenha, "12, 12, fill, default");

		btnLogar = new JButton("Logar");
		add(btnLogar, "12, 16");

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
