package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import model.vo.NivelTreino;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextArea;

public class PainelCadastroTreino extends JPanel {
	private JLabel lblNvl;
	private JLabel lblTreino;
	private JComboBox cbNvl;
	private JButton btnCadastrar;
	private JTextArea textArea;
	private JLabel lblCliente;
	private JLabel lblProfissional;
	private JComboBox comboBox;

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
		
		JComboBox cbCliente = new JComboBox();
		add(cbCliente, "4, 2, fill, top");
		
		lblNvl = new JLabel("Nível:");
		add(lblNvl, "6, 2, left, center");
		
		cbNvl = new JComboBox(new String[] {"BÁSICO","INTERMEDIÁRIO","AVANÇADO"});
		add(cbNvl, "8, 2, fill, fill");
		
		lblProfissional = new JLabel("Profissional:");
		add(lblProfissional, "2, 4, left, center");
		
		comboBox = new JComboBox();
		add(comboBox, "4, 4, fill, top");
		
		lblTreino = new JLabel("Treino:");
		add(lblTreino, "2, 6, right, top");
		
		textArea = new JTextArea();
		add(textArea, "2, 8, 7, 1, fill, fill");
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "4, 10, 5, 1, fill, top");
	}
}
