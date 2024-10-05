import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EscritorArchivo {
    private final Set<Lexema> lexemasUnicos;
    private final String nombreArchivo;

    public EscritorArchivo(List<Lexema> lexemas, String nombreArchivo) {
        lexemasUnicos = new HashSet<>(lexemas);
        this.nombreArchivo = nombreArchivo + ".txt";
    }

    public void escribirTablaDeSimbolos() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(String.format("%-30s %-30s %-30s %-10s", "ID", "TOKEN", "VALOR", "LONGITUD"));
            writer.newLine();

            for (Lexema lexema : lexemasUnicos) {
                writer.write(String.format("%-30s %-30s %-30s %-10s",
                        lexema.getId(),
                        lexema.getToken(),
                        lexema.getValor(),
                        lexema.getLongitud()));
                writer.newLine();
            }
        }
    }
}
