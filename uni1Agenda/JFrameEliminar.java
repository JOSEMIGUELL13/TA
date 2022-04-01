import javax.swing.*;
public class JFrameEliminar extends JFrame {
    JPanelEliminar eliminar = new JPanelEliminar();

    public JFrameEliminar() {
        initComponents();
    }
    private void initComponents() {
        this.setBounds(580,180,300,300);
        setSize(300, 300);
        setTitle("EMILINAR CONTACTO");
        setResizable(false);
        setContentPane(eliminar);
        setVisible(true);
    }
}
