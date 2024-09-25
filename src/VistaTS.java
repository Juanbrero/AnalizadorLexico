import javax.swing.*;
import java.awt.*;

public class VistaTS extends JFrame {
    private JTextArea textArea;
    private String archivo;

    public VistaTS() throws HeadlessException {
        setTitle("Tabla de simbolos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 750);
        getContentPane().setLayout(new BorderLayout());


    }

}
