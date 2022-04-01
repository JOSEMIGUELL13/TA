import javax.swing.*;

public class JFrameAltas extends JFrame
{
   JPanelAltas mostrar = new JPanelAltas();
   
    public JFrameAltas()
   {  
      initComponents();
   }
   private void initComponents()
   {
      this.setBounds(580,180,300,200);
      setSize(380, 200);
      setTitle("AGENDA2022");
      setResizable(false);
      setContentPane(mostrar);
      setVisible(true);
       
   }   
}
