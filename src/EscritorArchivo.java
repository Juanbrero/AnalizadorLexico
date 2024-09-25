import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EscritorArchivo {

    public void escribirArchivo(List<Lexema> lexemas, String nombreArchivo) {

        Set<Lexema> lexemasUnicos = new HashSet<>(lexemas);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("ID\t\tTOKEN\t\tVALOR\t\tLONGITUD");
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
