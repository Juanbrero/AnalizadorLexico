import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EscritorArchivo {
    private Set<Lexema> lexemasUnicos;
    private String nombreArchivo;

    public EscritorArchivo(List<Lexema> lexemas, String nombreArchivo) {
        lexemasUnicos = new HashSet<>(lexemas);
        this.nombreArchivo = nombreArchivo + ".txt";
    }
    public void escribirTablaDeSimbolos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("ID\t\tTOKEN\t\tVALOR\t\tLONGITUD");
            writer.newLine();
            System.out.println(lexemasUnicos);
            for ( Lexema lexema : lexemasUnicos ) {
                // Escribe cada objeto como una línea en el archivo
                writer.write(lexema.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
