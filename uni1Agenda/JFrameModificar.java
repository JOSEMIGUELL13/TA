import javax.swing.*;
public class JFrameModificar extends JFrame {
    PanelModificar md = new PanelModificar();

    public JFrameModificar() {
        initComponents();
    }
    private void initComponents() {
        this.setBounds(580,180,300,300);
        setSize(300, 300);
        setTitle("MODIFICAR CONTACTO");
        setResizable(false);
        setContentPane(md);
        setVisible(true);
    }
}
