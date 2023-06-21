package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class PainelAgendamentoTreino extends JPanel {
	
	public PainelAgendamentoTreino() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("53px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("125px"),
				ColumnSpec.decode("21px"),
				ColumnSpec.decode("53px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("125px"),},
			new RowSpec[] {
				RowSpec.decode("32px"),
				RowSpec.decode("22px"),
				RowSpec.decode("28px"),
				RowSpec.decode("22px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				RowSpec.decode("35px"),
				RowSpec.decode("23px"),}));
		JLabel lblCliente = new JLabel("Cliente:");
		add(lblCliente, "2, 2, left, center");
		
		JComboBox cbCliente = new JComboBox();
		add(cbCliente, "4, 2, 5, 1, fill, top");
		
		JLabel lblPersonal = new JLabel("Personal:");
		add(lblPersonal, "2, 4, left, center");
		
		JComboBox cbPersonal = new JComboBox();
		add(cbPersonal, "4, 4, 5, 1, fill, top");
		
		JLabel lblInicio = new JLabel("Inicio -");
		add(lblInicio, "2, 6, left, top");
		
		JLabel lblDataInicio = new JLabel("Data Hora:");
		add(lblDataInicio, "2, 8, left, center");
		
		JComboBox cbHoraInicio = new JComboBox();
		add(cbHoraInicio, "4, 8, fill, top");
		
		JComboBox cbHoraFinal = new JComboBox();
		add(cbHoraFinal, "8, 8, fill, top");
		
		JLabel lblDataFinal = new JLabel("Data Hora:");
		add(lblDataFinal, "6, 8, left, center");
		
		JLabel lblFinal = new JLabel("Final -");
		add(lblFinal, "6, 6, left, top");
		
		JButton btnSalvar = new JButton("Salvar");
		add(btnSalvar, "8, 10, right, top");
	}



}
