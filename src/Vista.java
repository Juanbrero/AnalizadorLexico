import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vista extends JFrame {

    private String contenido;
    private JTextArea textArea;


    public Vista(){
        setTitle("AnalizadorLexico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 750);
        getContentPane().setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel(new FlowLayout());
        this.add(panelNorte, BorderLayout.NORTH);
        panelNorte.setPreferredSize(new Dimension(1500, 40));
        JButton cargarArchivo = new JButton("Cargar Archivo");
        panelNorte.add(cargarArchivo);
        cargarArchivo.setPreferredSize(new Dimension(150, 30));
        cargarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cargarArchivo();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(1500, 550));
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setViewportBorder(new LineBorder(Color.BLACK, 1));
        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        scrollPane.add(textArea);
        scrollPane.setViewportView(textArea);
        scrollPane.setAlignmentX(10);


        JPanel panelSur = new JPanel(new FlowLayout());
        this.add(panelSur, BorderLayout.SOUTH);
        panelSur.setPreferredSize(new Dimension(1500, 40));
        JButton compilarArchivo = new JButton("Compilar");
        panelSur.add(compilarArchivo);
        compilarArchivo.setPreferredSize(new Dimension(150, 30));

        this.setVisible(true);
    }

    private void cargarArchivo() throws IOException {
        JFrame frame = new JFrame();
        JFileChooser jc= new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt");
        jc.setFileFilter(filtro);
        jc.showOpenDialog(frame);
        try {
            FileReader f = new FileReader(jc.getSelectedFile().getAbsolutePath());
            Lexico Lexer = new Lexico(f);
            Lexer.next_token();
            for (String t : Lexer.getTokens()) {
                textArea.append(t + "\n");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");
        }
    }

}
