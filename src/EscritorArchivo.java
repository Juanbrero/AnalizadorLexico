import representaciones.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EscritorArchivo {
    private Set<Lexema> lexemas;
    private List<Regla> reglas;
    private String nombreArchivo;

    public EscritorArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo + ".txt";
    }

    public void escribirTablaDeSimbolos() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(String.format("%-30s %-30s %-30s %-10s", "ID", "TOKEN", "VALOR", "LONGITUD"));
            writer.newLine();

            for (Lexema lexema : lexemas) {
                if (lexema.esSimbolo()) {
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



    public Set<Lexema> getLexemas() {
        return lexemas;
    }

    public void setLexemas(Set<Lexema> lexemas) {
        this.lexemas = new HashSet<>(lexemas);
    }

    public List<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
}
