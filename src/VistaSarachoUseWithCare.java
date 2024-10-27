import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class VistaSarachoUseWithCare extends JFrame {
    JTextPane textAreaIzq;
    JTextArea textAreaDer;

    StyledDocument docTextIzq;
    Style defaultStyle;
    Style normalStyle;
    Style errorStyle;

    public VistaSarachoUseWithCare() {
        // Personalizamos la ventana principal
        setTitle("Analizador léxico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 750);
        getContentPane().setLayout(new BorderLayout());

        // Panel de arriba
        JPanel panelNorte = new JPanel(new BorderLayout());
        add(panelNorte, BorderLayout.NORTH);
        panelNorte.setPreferredSize(new Dimension(1500, 40));
        JButton btnCargarArchivo = new JButton("Cargar archivo");
        panelNorte.add(btnCargarArchivo, BorderLayout.WEST);
        btnCargarArchivo.setPreferredSize(new Dimension(150, 30));

        // Panel del centro
        JPanel panel = new JPanel(new GridLayout(1, 2));
        // JTextArea (izquierda)
        textAreaIzq = new JTextPane();
        textAreaIzq.setEditable(false);
        textAreaIzq.setFont(new Font("Monospaced", Font.PLAIN, 15));
        // Crear el StyledDocument para manejar el estilo del texto
        docTextIzq = textAreaIzq.getStyledDocument();
        // Crear estilos para personalizar el texto
        defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        normalStyle = docTextIzq.addStyle("Normal", defaultStyle);
        StyleConstants.setForeground(normalStyle, Color.BLACK); // Formato normal
        errorStyle = docTextIzq.addStyle("Colored", normalStyle);
        StyleConstants.setForeground(errorStyle, Color.RED); // Formato color rojo
        JScrollPane scrollPaneTextIzq = new JScrollPane(textAreaIzq);

        // JTextArea (derecha)
        textAreaDer = new JTextArea();
        textAreaDer.setFont(new Font("Monospaced", Font.PLAIN, 15));
        JScrollPane scrollPaneTextDer = new JScrollPane(textAreaDer);

        panel.add(scrollPaneTextIzq);
        panel.add(scrollPaneTextDer);
        panel.setPreferredSize(new Dimension(1500, 550));
        add(panel);

        // Panel de abajo
        JPanel panelSur = new JPanel(new FlowLayout());
        this.add(panelSur, BorderLayout.SOUTH);
        panelSur.setPreferredSize(new Dimension(1500, 40));
        JButton btnCompilar = new JButton("Compilar");
        panelSur.add(btnCompilar);
        btnCompilar.setPreferredSize(new Dimension(150, 30));


        // Eventos
        btnCargarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cargarArchivo();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnCompilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textAreaDer.getText().isBlank()) { // Si está vacío no hacemos nada.
                        JOptionPane.showMessageDialog(null, "El panel de la derecha NO puede estar limpio", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        compilar();
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        this.setVisible(true);
    }

    /**
     * Se compila lo que se encuentre en la pantalla de la derecha.
     *
     * @throws IOException
     */
    private void compilar() throws IOException {
        try {
            // Crear un archivo temporal
            File tempFile = File.createTempFile("tempFileLexico", ".txt");
            tempFile.deleteOnExit(); // Asegurarse de que el archivo se elimine al salir

            // Escribir el contenido en el archivo temporal
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                writer.write(textAreaDer.getText());
            }

            FileReader fileReader = new FileReader(tempFile.getAbsolutePath());
            Lexico lexer = new Lexico(fileReader);
            lexer.next_token();
            textAreaIzq.setText(""); // Limpia el contenido.
            for (String texto : lexer.getTokens()) {
                texto += "\n";
                if (texto.contains("Illegal character")) {
                    // Aplicar color rojo
                    docTextIzq.insertString(docTextIzq.getLength(), texto, errorStyle);
                } else {
                    // Aplicar formato normal
                    docTextIzq.insertString(docTextIzq.getLength(), texto, normalStyle);
                }
            }
        } catch (IOException | BadLocationException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar el texto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Se le solicita al usuario que seleccione un archivo de texto para mostrar su contenido en pantalla.
     *
     * @throws IOException
     */
    private void cargarArchivo() throws IOException {
        JFrame frame = new JFrame();
        JFileChooser jc = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt");
        jc.setFileFilter(filtro);
        int returnValue = jc.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jc.getSelectedFile();
            leerArchivoEnTextArea(selectedFile, textAreaDer); // Leer el archivo y volcar en JTextArea
        }
    }

    private void leerArchivoEnTextArea(File selectedFile, JTextArea textAreaDer) {
        try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n"); // Agregar línea y un salto de línea
            }
            // Volcar el contenido en el JTextArea
            textAreaDer.setText(contenido.toString());
        } catch (IOException e) {
            // Manejo de errores de entrada/salida
            JOptionPane.showMessageDialog(textAreaDer, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}