import javax.swing.*;
public class JFrameConsultas extends JFrame {
	JPanelConsultas md = new JPanelConsultas();

	public JFrameConsultas() {
		initComponents();
	}
	private void initComponents() {
		this.setBounds(500,100,475,300);
		setTitle("Contactos Registrados");
		setResizable(false);
		setContentPane(md);
		setVisible(true);
	}
}