import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Vista extends JFrame {

    public Vista(){
        setTitle("AnalizadorLexico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 750);
        getContentPane().setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel(new FlowLayout());
        this.add(panelNorte, BorderLayout.NORTH);
        panelNorte.setPreferredSize(new Dimension(1500, 100));
        JButton cargarArchivo = new JButton("Cargar Archivo");
        panelNorte.add(cargarArchivo);
        cargarArchivo.setPreferredSize(new Dimension(150, 30));

//        JPanel panelCentro = new JPanel(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane();
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(1500, 550));
//        panelCentro.add(scrollPane);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setViewportBorder(new LineBorder(Color.BLACK, 1));

        JPanel panelSur = new JPanel(new FlowLayout());
        this.add(panelSur, BorderLayout.SOUTH);
        panelSur.setPreferredSize(new Dimension(1500, 100));
        JButton compilarArchivo = new JButton("Compilar");
        panelSur.add(compilarArchivo);
        compilarArchivo.setPreferredSize(new Dimension(150, 30));

        this.setVisible(true);
    }
}
