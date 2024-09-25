public class Lexema {
    private String nombre;
    private String token;
    private String valor = null;
    private Integer longitud = null;
    private boolean esCte = false;
    private int Fila;
    private int Columna;

    public Lexema(String nombre, String token) {
        this.nombre = nombre;
        this.token = token;
    }

    public Lexema(String nombre, String token, int fila, int columna) {
        this.nombre = nombre;
        this.token = token;
        this.Fila = fila;
        this.Columna = columna;
    }

    public Lexema(String nombre, String token, String valor, int fila, int columna) {
        this.nombre = nombre;
        this.token = token;
        this.valor = valor;
        this.Fila = fila;
        this.Columna = columna;
    }

    public Lexema(String nombre, String token, boolean esCte) {
        this.esCte = esCte;
        this.nombre = nombre;
        this.token = token;
        setValor();
        setLongitud();

    }

    public Lexema(String nombre, String token, String valor, boolean esCte, int fila, int columna) {
        this.esCte = esCte;
        this.nombre = nombre;
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
                    this.valor = nombre.substring(1, nombre.length() - 1);
                }
                case "CTE_BIN" -> {
                    this.valor = token.replace("0b", "");
                }
                case "CTE_INT", "CTE_REAL" -> {
                    this.valor = nombre;
                }
            }
        }
    }

    private Integer setLongitud() {
        if (esCte)
            switch (token) {
                case "CTE_CHAR" -> {
                    this.longitud = 1;
                }
                case "CTE_STRING", "CTE_BIN" -> {
                    this.longitud = nombre.length() - 2;
                }
                case "CTE_INT", "CTE_REAL" -> {
                    this.longitud = 4;
                }
            }
        return null;
    }

    public String getNombre() {
        return nombre;
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
    public String toString() {
        return "Lexema{" +
                "nombre='" + nombre + '\'' +
                ", token='" + token + '\'' +
                ", valor='" + valor + '\'' +
                ", longitud='" + longitud + '\'' +
                ", esCte=" + esCte +
                '}';
    }
}
