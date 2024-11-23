import representaciones.Lexema;
import representaciones.Regla;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EscritorArchivo {
    private Set<Lexema> lexemasUnicos;
    private List<Regla> reglas;
    private String nombreArchivo;

    public EscritorArchivo(List<Lexema> lexemas, List<Regla> reglas, String nombreArchivo) {
        lexemasUnicos = new HashSet<>(lexemas);
        this.reglas = reglas;
        this.nombreArchivo = nombreArchivo + ".txt";
        matchingTypeID();
    }

    public void escribirTablaDeSimbolos() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(String.format("%-30s %-30s %-10s %-30s %-10s", "ID", "TOKEN", "TIPO", "VALOR", "LONGITUD"));
            writer.newLine();

            for (Lexema lexema : lexemasUnicos) {
                if (lexema.esSimbolo()) {
                    writer.write(String.format("%-30s %-30s %-10s %-30s %-10s",
                            lexema.getId(),
                            lexema.getToken(),
                            lexema.getType(),
                            lexema.getValor(),
                            lexema.getLongitud()));
                    writer.newLine();
                }
            }
        }
    }

    private void matchingTypeID() {
        for (Lexema lexema : lexemasUnicos) {
            for (Regla regla : reglas) {
                if (lexema.getId().equals(regla.getID()))
                    lexema.setType(regla.getType());
            }
        }
    }
}
