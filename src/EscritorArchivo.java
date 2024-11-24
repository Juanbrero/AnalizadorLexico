import representaciones.Lexema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EscritorArchivo {
    private Set<Lexema> lexemasUnicos;
    private ArrayList<Map> tipos;
    private String nombreArchivo;

    public EscritorArchivo(List<Lexema> lexemas, ArrayList<Map> tipos, String nombreArchivo) {
        lexemasUnicos = new HashSet<>(lexemas);
        this.tipos = tipos;
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
            for (Map lista : tipos) {
                if (lista.containsKey(lexema.getId()))
                    lexema.setType((String) lista.get(lexema.getId()));
            }
        }
    }
}
