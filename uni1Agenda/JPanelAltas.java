import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JPanelAltas extends JPanel implements ActionListener {
	private JButton btnGuardar, btnMostrar;
	private JTextField txtNombre, txtApellidos, txtTelefono, txtCorreoe, txtFechaN;
	ZPersona mpa = new ZPersona();
	public JPanelAltas() {
		setLayout(new GridLayout(7, 2));
		JLabel lblNombre = new JLabel("Nombre: ", JLabel.RIGHT);
		txtNombre = new JTextField(30);
		add(lblNombre);
		add(txtNombre);
		JLabel lblApellidos = new JLabel("Apellidos: ", JLabel.RIGHT);
		txtApellidos = new JTextField(30);
		add(lblApellidos);
		add(txtApellidos);
		JLabel lblTelefono = new JLabel("Celular: ", JLabel.RIGHT);
		txtTelefono = new JTextField(15);
		add(lblTelefono);
		add(txtTelefono);
		JLabel lblCorreoe = new JLabel("Correo: ", JLabel.RIGHT);
		txtCorreoe = new JTextField(30);
		add(lblCorreoe);
		add(txtCorreoe);
		JLabel lblFechaN = new JLabel("Cumpleaños: (DD/MM/AAAA)", JLabel.RIGHT);
		txtFechaN = new JTextField(30);
		add(lblFechaN);
		add(txtFechaN);
		btnGuardar = new JButton("ALMACENAR");
		btnGuardar.addActionListener(this);
		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(this);
		add(btnGuardar);
		add(btnMostrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			if (txtNombre.getText() == null || txtNombre.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Falta colocar el nombre",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtNombre.requestFocus();
			} else if (txtTelefono.getText() == null || txtTelefono.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Falta capturar su telefono",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtTelefono.requestFocus();
			} else if(txtTelefono.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "Telefono Incompleto, COLOCAR 10 DIGITOS",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtTelefono.requestFocus();
         }else{
				mpa.agregar(txtNombre.getText(), txtApellidos.getText(), txtTelefono.getText(),
						txtCorreoe.getText(), txtFechaN.getText());
				JOptionPane.showMessageDialog(null, "GUARDADO",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtNombre.setText(null);
				txtApellidos.setText(null);
				txtTelefono.setText(null);
				txtCorreoe.setText(null);
				txtFechaN.setText(null);
				txtNombre.requestFocus();
			}
		}
		if (e.getSource() == btnMostrar) {
         if(ZPersona.Arrpersona.size()>0){
             new JFrameConsultas();
         }else{
             JOptionPane.showMessageDialog(null, "NO SE TIENEN REGISTROS",
				   "Aviso", JOptionPane.INFORMATION_MESSAGE);
         }
		}
	}
}
