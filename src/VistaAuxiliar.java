/*
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class Vista extends JFrame {
    private Lexico Lexer;
    private JTextArea textAreaLex;
    private JTextArea textAreaCod;
    private String archivo;

    public Vista() {
        setTitle("Analizador Lexico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 750);
        getContentPane().setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel(new FlowLayout());
        panelNorte.setBackground(Color.LIGHT_GRAY);
        this.add(panelNorte, BorderLayout.NORTH);
        panelNorte.setPreferredSize(new Dimension(1500, 40));
        JButton compilarArchivo = new JButton("Compilar Archivo");
        panelNorte.add(compilarArchivo);
        compilarArchivo.setPreferredSize(new Dimension(150, 30));

        JPanel panelCentro = new JPanel(new GridLayout(1, 2));
        this.add(panelCentro, BorderLayout.CENTER);

        // Panel analizador lexico
        JScrollPane scrollPaneIzq = new JScrollPane();
        panelCentro.add(scrollPaneIzq);
        scrollPaneIzq.setPreferredSize(new Dimension(750, 550));
        scrollPaneIzq.setWheelScrollingEnabled(true);
        scrollPaneIzq.setViewportBorder(new LineBorder(Color.BLACK, 2));
        textAreaLex = new JTextArea();
        textAreaLex.setEditable(false);
        textAreaLex.setFont(new Font("Monospaced", Font.PLAIN, 15));
        scrollPaneIzq.add(textAreaLex);
        scrollPaneIzq.setViewportView(textAreaLex);

        // Panel edicion codigo
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setPreferredSize(new Dimension(750, 550));

        textAreaCod = new JTextArea();
        textAreaCod.setEditable(true);
        textAreaCod.setFont(new Font("Monospaced", Font.PLAIN, 15));
        JScrollPane scrollPaneDcho = new JScrollPane(textAreaCod);
        scrollPaneDcho.setWheelScrollingEnabled(true);
        scrollPaneDcho.setViewportBorder(new LineBorder(Color.BLACK, 2));
        scrollPaneDcho.setBounds(0, 0, 750, 550);
        layeredPane.add(scrollPaneDcho);

        // Boton de guardado
        JButton guardarArchivo = new JButton("Guardar");
        guardarArchivo.setBounds(560, 560, 150, 30);
        layeredPane.add(guardarArchivo);
        layeredPane.setLayer(scrollPaneDcho, JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(guardarArchivo, JLayeredPane.PALETTE_LAYER);
        layeredPane.moveToFront(guardarArchivo);

        panelCentro.add(layeredPane);

        JPanel panelSur = new JPanel(new FlowLayout());
        this.add(panelSur, BorderLayout.SOUTH);
        panelSur.setBackground(Color.LIGHT_GRAY);
        panelSur.setPreferredSize(new Dimension(1500, 40));
        JButton abrirArchivo = new JButton("Abrir archivo");
        panelSur.add(abrirArchivo);
        abrirArchivo.setPreferredSize(new Dimension(150, 30));

        // -------- Eventos -------- //

        abrirArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    abrirArchivo();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Abrir ventana buscador de archivos
        guardarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarArchivo();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        compilarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (compilarArchivo()) {
                        crearTablaDeSimbolos();
                    }
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, "Error durante la compilación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        layeredPane.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Dimension size = layeredPane.getSize();
                scrollPaneDcho.setBounds(0, 0, size.width, size.height);  // Ajustar JScrollPane al tamaño completo
                guardarArchivo.setLocation(size.width - guardarArchivo.getWidth() - 20, size.height - guardarArchivo.getHeight() - 20);  // Ajustar botón
                layeredPane.moveToFront(guardarArchivo);
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        textAreaCod.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Forzar que el botón esté siempre en la capa superior después de escribir
                layeredPane.moveToFront(guardarArchivo);
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        this.setVisible(true);
    }

    private boolean compilarArchivo() {
        boolean exito = false;
        textAreaLex.setText("");
        JFrame frame = new JFrame();
        JFileChooser jc = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt");
        jc.setFileFilter(filtro);
        jc.showOpenDialog(frame);

        FileReader f = null;
        try {
            f = new FileReader(jc.getSelectedFile().getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        }

        if (f != null) {
            Lexer = new Lexico(f);
            try {
                Lexer.next_token();
                exito = true;
                for (String t : Lexer.getTokens()) {
                    textAreaLex.append(t + "\n");
                }
            } catch (IOException | RuntimeException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return exito;
    }

    private void crearTablaDeSimbolos() {
        try {
            EscritorArchivo escritorArchivo = new EscritorArchivo(Lexer.getLexemas(), "ts");
            escritorArchivo.escribirTablaDeSimbolos();
            JOptionPane.showMessageDialog(this, "Tabla de simbolos creada exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir la tabla de símbolos: " + e.getMessage(),
                    "Error de escritura", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirArchivo() throws IOException {
        JFrame frame = new JFrame();
        JFileChooser jc = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt");
        jc.setFileFilter(filtro);
        jc.showOpenDialog(frame);
        try {
            this.archivo = jc.getSelectedFile().getAbsolutePath();
            FileReader f = new FileReader(archivo);
            BufferedReader br = new BufferedReader(f);

            String linea;
            while ((linea = br.readLine()) != null) {
                textAreaCod.append(linea + "\n");
            }
            br.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");
        }
    }

    private void guardarArchivo() throws IOException {
        try {
            if (this.archivo == null) {
                this.archivo = "prueba.txt";
            }
            FileWriter fW = new FileWriter(this.archivo);
            fW.write(textAreaCod.getText());
            fW.close();
            textAreaCod.setText("");
            JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente.");
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");
        }
    }
}
*/
