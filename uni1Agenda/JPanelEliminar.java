import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class JPanelEliminar extends JPanel implements ActionListener {
	private JButton btnLocalizar, btnEliminar;
	private JTextField txtNombre, txtApellidos, txtTelefono, txtCorreoe, txtFechaN;
   ZPersona mp = new ZPersona();
	ArrayList<Persona> datosPer = new ArrayList<Persona>();
   private int pos = 0;
	public JPanelEliminar() {
      datosPer = mp.Datos();    
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
		JLabel lblCorreoe = new JLabel("Nombre: ", JLabel.RIGHT);
		txtCorreoe = new JTextField(30);
		add(lblCorreoe);
		add(txtCorreoe);
		JLabel lblFechaN = new JLabel("Cumpleaños: (DD/MM/AAAA)", JLabel.RIGHT);
		txtFechaN = new JTextField(30);
		add(lblFechaN);
		add(txtFechaN);
		btnLocalizar = new JButton("LOCALIZAR");
		btnLocalizar.addActionListener(this);
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		add(btnLocalizar);
		add(btnEliminar);
      txtNombre.setEditable(true);
      txtApellidos.setEditable(false);
      txtTelefono.setEditable(true);
      txtCorreoe.setEditable(false);
		txtFechaN.setEditable(false);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLocalizar) {
			if (txtNombre.getText() == null) {
				txtNombre.setEditable(true);
			} else {
            String info[][] = obtenerDatosBusqueda(txtNombre.getText());
            txtNombre.setText(null);
            txtApellidos.setText(null);
            txtTelefono.setText(null);
            txtCorreoe.setText(null);
				txtFechaN.setText(null);
				txtNombre.setEditable(true);
            txtApellidos.setEditable(true);
            txtTelefono.setEditable(true);
            txtCorreoe.setEditable(true);
				txtFechaN.setEditable(true);
            txtNombre.setText(info[pos][0]);
            txtApellidos.setText(info[pos][1]);
            txtTelefono.setText(info[pos][2]);
            txtCorreoe.setText(info[pos][3]);
				txtFechaN.setText(info[pos][4]);
            txtNombre.requestFocus();
            txtApellidos.setEditable(false);
            txtTelefono.setEditable(false);
            txtCorreoe.setEditable(false);
				txtFechaN.setEditable(false);   
            }   
		}
		if (e.getSource() == btnEliminar) {
            Mod(txtNombre.getText());
			JOptionPane.showMessageDialog(null, "Eliminación EXITOSA",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
			txtNombre.setText(null);
            txtApellidos.setText(null);
            txtTelefono.setText(null);
            txtCorreoe.setText(null);
			txtFechaN.setText(null);
			txtNombre.requestFocus();
		}
	}
    private String[][] obtenerDatosBusqueda(String name){
		int x = 0;
		String informacion[][] = new String[datosPer.size()][5];
		Iterator<Persona> itrPersona = datosPer.iterator();
		while(itrPersona.hasNext()){
			Persona persona = itrPersona.next();
			if(persona.getNombre().equals(name)){
				informacion[x][0] = persona.getNombre();
				informacion[x][1] = persona.getApellidos();
				informacion[x][2] = persona.getTelefono();
				informacion[x][3] = persona.getCorreoe();
				informacion[x][4] = persona.getFechaN();
                pos=x;
			}else{
				x++;
			}
		}
		return informacion;
	}
    private void Mod(String name){
		boolean udf = false;
		Iterator<Persona> itrPersona = datosPer.iterator();
		while(itrPersona.hasNext() && udf == false){
			Persona persona = itrPersona.next();
			if(persona.getNombre().equals(name)){
				datosPer.remove(persona);
				udf=true;
			}
		}
        
    }
}
