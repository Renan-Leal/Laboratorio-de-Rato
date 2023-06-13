package view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelListagemEndereco extends JPanel {

	private JButton btnEditar;
	
	public PainelListagemEndereco() {
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(250, 375, 200, 45);
		btnEditar.setEnabled(false);
		this.add(btnEditar);

	}
	
	public JButton getBtnEditar() {
		return this.btnEditar;
	}

}
