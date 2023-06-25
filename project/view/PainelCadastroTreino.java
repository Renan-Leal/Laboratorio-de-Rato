package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import model.exception.CampoInvalidoException;
import model.vo.NivelTreino;
import model.vo.Treino;
import model.vo.Usuario;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextArea;

public class PainelCadastroTreino extends JPanel {
	private JLabel lblNivel;
	private JLabel lblTreino;
	private JComboBox cbNivel;
	private JButton btnCadastrar;
	private JTextArea txtTreino;
	private JLabel lblCliente;
	private JLabel lblProfissional;
	private JComboBox cbProfissional;
	private Treino treino;
	private JComboBox cbCliente;
	private JButton btnVoltar;

	public PainelCadastroTreino() {
		setBackground(new Color(108, 255, 108));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(57dlu;pref):grow"),
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
				ColumnSpec.decode("max(40dlu;pref):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(253dlu;default)"),
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(15dlu;pref)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(95dlu;default):grow"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("fill:pref:grow"),}));
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblCliente.setForeground(Color.BLACK);
		add(lblCliente, "16, 5, right, center");
		
		cbCliente = new JComboBox();
		cbCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbCliente.setForeground(Color.BLACK);
		add(cbCliente, "18, 5, fill, top");
		
		lblProfissional = new JLabel("Profissional:");
		lblProfissional.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblProfissional.setForeground(Color.BLACK);
		add(lblProfissional, "16, 7, right, center");
		
		cbProfissional = new JComboBox();
		cbProfissional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbProfissional.setForeground(Color.BLACK);
		add(cbProfissional, "18, 7, fill, fill");
		
		lblNivel = new JLabel("Nível:");
		lblNivel.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNivel.setForeground(Color.BLACK);
		add(lblNivel, "16, 9, right, center");
		
		cbNivel = new JComboBox(new String[] {"BÁSICO","INTERMEDIÁRIO","AVANÇADO"});
		cbNivel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbNivel.setForeground(Color.BLACK);
		add(cbNivel, "18, 9, fill, fill");
		
		lblTreino = new JLabel("Treino:");
		lblTreino.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTreino.setForeground(Color.BLACK);
		add(lblTreino, "16, 11, right, top");
		
		txtTreino = new JTextArea();
		txtTreino.setForeground(Color.BLACK);
		add(txtTreino, "18, 11, fill, fill");
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.BLACK);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
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
		add(btnCadastrar, "18, 13, right, top");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnVoltar, "18, 15, right, fill");
	}
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
