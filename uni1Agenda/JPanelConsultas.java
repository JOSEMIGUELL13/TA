import javax.swing.*;
import java.awt.*;
import java.util.*;
public class JPanelConsultas extends JPanel{
	JTable tabla;
	JScrollPane scroll = new JScrollPane();
	ZPersona mp = new ZPersona();
	ArrayList<Persona> datosPer = new ArrayList<Persona>();
	public JPanelConsultas() {
		datosPer = mp.Datos();
		String titulos[] = { "Nombre", "Apellidos", "Celular", "Correo Electronico", "Fecha De Cumpleaños" };
		String info[][] = obtenerDatos();
		setLayout(new GridLayout(2, 1));
		tabla = new JTable(info, titulos);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scroll.setViewportView(tabla);
		add(scroll);
	}
	private String[][] obtenerDatos() {
		int x = 0;
		String informacion[][] = new String[datosPer.size()][5];
		Iterator<Persona> itrPersona = datosPer.iterator();
		while (itrPersona.hasNext()) {
			Persona persona = itrPersona.next();
			informacion[x][0] = persona.getNombre();
			informacion[x][1] = persona.getApellidos();
			informacion[x][2] = persona.getTelefono();
			informacion[x][3] = persona.getCorreoe();
			informacion[x][4] = persona.getFechaN();
			x++;
		}
		return informacion;
	}
}
