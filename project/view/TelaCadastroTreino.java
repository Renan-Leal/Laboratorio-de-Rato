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

public class TelaCadastroTreino extends JPanel {

	private JLabel lblPrazo;
	private JLabel lblNvl;
	private JLabel lblTreino;
	private JTextField txtPrazo;
	private JComboBox cbNvl;

	private JButton btnCadastrar;
	private JTextArea textArea;

	
	public TelaCadastroTreino() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("8px"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("93px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("81px:grow"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("7px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("34px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("81px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		lblPrazo = new JLabel("Prazo:");
		lblPrazo.setBounds(37, 26, 46, 14);
		add(lblPrazo, "4, 4, left, center");
		
		txtPrazo = new JTextField();
		txtPrazo.setBounds(77, 23, 86, 20);
		add(txtPrazo, "6, 4, left, center");
		txtPrazo.setColumns(10);
		
		lblNvl = new JLabel("Nível:");
		lblNvl.setBounds(188, 26, 46, 14);
		add(lblNvl, "8, 4, center, center");
		
		cbNvl = new JComboBox(new String[] {"BÁSICO","INTERMEDIÁRIO","AVANÇADO"});
		cbNvl.setBounds(224, 22, 82, 22);
		add(cbNvl, "12, 4, 3, 1, fill, fill");
		
		lblTreino = new JLabel("Treino:");
		lblTreino.setBounds(146, 56, 46, 14);
		add(lblTreino, "4, 8, left, center");
		
		textArea = new JTextArea();
		add(textArea, "6, 8, 8, 5, fill, fill");
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(124, 533, 89, 23);
		add(btnCadastrar, "6, 14, 8, 1, fill, fill");
	}
}
