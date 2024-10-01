import java.util.Objects;

public class Lexema {
    private String id;
    private String token;
    //private String tipo;
    private String valor = "~";
    private String longitud = "~";
    private boolean esCte = false;
    private int Fila;
    private int Columna;

    public Lexema(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public Lexema(String id, String token, int fila, int columna) {
        this.id = id;
        this.token = token;
        this.Fila = fila;
        this.Columna = columna;
    }

    public Lexema(String id, String token, String valor, int fila, int columna) {
        this.id = id;
        this.token = token;
        this.valor = valor;
        this.Fila = fila;
        this.Columna = columna;
    }

    public Lexema(String id, String token, boolean esCte) {
        this.esCte = esCte;
        this.id = id;
        this.token = token;
        setValor();
        setLongitud();
    }

    public Lexema(String id, String token, String valor, boolean esCte, int fila, int columna) {
        this.esCte = esCte;
        this.id = id;
        this.token = token;
        this.Fila = fila;
        this.Columna = columna;
        setValor();
        setLongitud();
    }

    private void setValor() {
        if (esCte) {
            switch (token) {
                case "CTE_CHAR", "CTE_STRING" -> {
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
                case "CTE_CHAR" -> {
                    this.longitud =  "1";
                }
                case "CTE_STRING", "CTE_BIN" -> {
                    this.longitud = String.valueOf(id.length() - 2);
                }
                case "CTE_INT", "CTE_REAL" -> {
                    this.longitud = String.valueOf(id.length());
                }
            }
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
        return longitud.toString();
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
