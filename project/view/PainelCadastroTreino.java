package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import model.controller.TreinoController;
import model.controller.UsuarioController;
import model.exception.CampoInvalidoException;
import model.vo.Endereco;
import model.vo.NivelTreino;
import model.vo.TipoUsuario;
import model.vo.Treino;
import model.vo.Usuario;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextArea;

public class PainelCadastroTreino extends JPanel {
	private JLabel lblNvl;
	private JLabel lblTreino;
	private JComboBox cbNivel;
	private JButton btnCadastrar;
	private JTextArea txtTreino;
	private JLabel lblCliente;
	private JLabel lblProfissional;
	private JComboBox cbProfissional;
	private Treino treino;
	private JComboBox cbCliente;

	public PainelCadastroTreino() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("60px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("141px"),
				ColumnSpec.decode("23px"),
				ColumnSpec.decode("27px"),
				ColumnSpec.decode("45px"),
				ColumnSpec.decode("119px"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("134px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		lblCliente = new JLabel("Cliente:");
		add(lblCliente, "2, 2, right, center");
		
		cbCliente = new JComboBox();
		add(cbCliente, "4, 2, fill, top");
		
		lblNvl = new JLabel("Nível:");
		add(lblNvl, "6, 2, left, center");
		
		cbNivel = new JComboBox(new String[] {"BÁSICO","INTERMEDIÁRIO","AVANÇADO"});
		add(cbNivel, "8, 2, fill, fill");
		
		lblProfissional = new JLabel("Profissional:");
		add(lblProfissional, "2, 4, left, center");
		
		cbProfissional = new JComboBox();
		add(cbProfissional, "4, 4, fill, top");
		
		lblTreino = new JLabel("Treino:");
		add(lblTreino, "2, 6, right, top");
		
		txtTreino = new JTextArea();
		add(txtTreino, "2, 8, 7, 1, fill, fill");
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			treino.setCliente((Usuario) cbCliente.getSelectedItem());
			treino.setProfissional((Usuario) cbProfissional.getSelectedItem());
			treino.setNivelTreino((NivelTreino) cbNivel.getSelectedItem());
			treino.setTreino(txtTreino.getText());

			TreinoController controller = new TreinoController();
			
			try {
				if(treino.getId() == null) {
					controller.inserir(treino);
					JOptionPane.showMessageDialog(null, "Treino cadastrado com sucesso!", 
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (CampoInvalidoException excecao) {
				JOptionPane.showMessageDialog(null, excecao.getMessage(), 
						"Erro", JOptionPane.ERROR_MESSAGE); 
			}
		}
		});
		add(btnCadastrar, "4, 10, 5, 1, fill, top");
	}
}
