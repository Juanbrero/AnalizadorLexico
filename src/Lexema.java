import java.util.Objects;

public class Lexema {
    private String id;
    private String _id = null;
    private String token;
    //private String tipo;
    private String valor = "~";
    private String longitud = "~";
    private boolean esCte = false;
    private int Fila;
    private int Columna;
    private boolean error = false;

    public Lexema(String id, String token) {
        this.id = id;
        this.token = token;
        crearId();
    }

    public Lexema(String id, String token, int fila, int columna) {
        this.id = id;
        this.token = token;
        this.Fila = fila;
        this.Columna = columna;
        crearId();
    }

    public Lexema(String id, String token, String valor, int fila, int columna) {
        this.id = id;
        this.token = token;
        this.valor = valor;
        this.Fila = fila;
        this.Columna = columna;
        crearId();
    }

    public Lexema(String id, String token, boolean esCte) {
        this.esCte = esCte;
        this.id = id;
        this.token = token;
        setValor();
        setLongitud();
        verificarConstantes();
    }

    public Lexema(String id, String token, String valor, boolean esCte, int fila, int columna) {
        this.esCte = esCte;
        this.id = id;
        this.token = token;
        this.Fila = fila;
        this.Columna = columna;
        setValor();
        setLongitud();
        verificarConstantes();
        crearId();
    }

    private void setValor() {
        if (esCte) {
            switch (token) {
                case "CTE_STRING" -> {
                    this.valor = id.substring(1, id.length() - 1);
                }
                case "CTE_BIN" -> {
                    this.valor = id.replace("0b", "");
                }
                case "CTE_INT", "CTE_REAL" -> {
                    this.valor = id;
                }
            }
        }
    }

    private void setLongitud() {
        if (esCte)
            switch (token) {
                case "CTE_STRING", "CTE_BIN" -> {
                    this.longitud = String.valueOf(valor.length());
                }
                case "CTE_INT", "CTE_REAL" -> {
                    this.longitud = String.valueOf(id.length());
                }
            }
    }

    private void verificarConstantes() {
        if (esCte)
            switch (token) {
                case "CTE_STRING" -> {
                    if (valor.length() > 30) error = true;
                }
                case "CTE_INT" -> {
                    try {
                        Integer.parseInt(valor);
                    } catch (NumberFormatException nfe) {
                        error = true;
                    }
                }
                case "CTE_REAL" -> {
                    try {
                        Float.parseFloat(valor);
                    } catch (NumberFormatException nfe) {
                        error = true;
                    }
                }
            }
    }

    private void crearId() {
        if (!token.equals("ID"))
            if (token.equals("CTE_STRING") || token.equals("CTE_BIN") || token.equals("CTE_INT") || token.equals("CTE_REAL"))
                _id = "_" + id;
    }

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public String getValor() {
        return valor;
    }

    public String getLongitud() {
        return longitud;
    }

    public int getFila() {
        return Fila;
    }

    public int getColumna() {
        return Columna;
    }

    public boolean isEsCte() {
        return esCte;
    }

    public boolean isError() {
        return error;
    }

    public String get_id() {
        return _id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token, valor, longitud);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Si es el mismo objeto
        if (o == null || getClass() != o.getClass()) return false;  // Si no es la misma clase
        Lexema lexema = (Lexema) o;  // Comparación de atributos
        return id.equals(lexema.id)
                && token.equals(lexema.token)
                && valor.equals(lexema.valor)
                && longitud.equals(lexema.longitud);
    }

    @Override
    public String toString() {
        return "Lexema{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", valor='" + valor + '\'' +
                ", longitud=" + longitud +
                ", esCte=" + esCte +
                ", Fila=" + Fila +
                ", Columna=" + Columna +
                '}';
    }
}
