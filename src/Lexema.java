import exceptions.ErrorCompilacion;

import java.util.Objects;

public class Lexema {
    private String id;
    private String token;
    private String valor = "~";
    private String longitud = "~";
    private final boolean esSimbolo;

    /**
     * Constructor basico para NO CONSTANTES.
     *
     * @param id
     * @param token
     */
    public Lexema(String id, String token) {
        this.id = id;
        this.token = token;
        this.esSimbolo = false;
    }

    /**
     * Constructor para las CONSTANTES y VARIABLES.
     *
     * @param id
     * @param token
     * @param esSimbolo
     * @throws ErrorCompilacion
     */
    public Lexema(String id, String token, boolean esSimbolo) throws ErrorCompilacion {
        this.id = id;
        this.token = token;
        crearId(id);
        this.esSimbolo = esSimbolo;
        if (this.esSimbolo) {
            setValor();
            setLongitud();
            verificarConstantes();
        }
    }

    /**
     * Se le agrega el '_' al ID.
     *
     * @param id
     */
    private void crearId(String id) {
        if (!token.equals("ID")) {
            if (token.equals("CTE_STRING")) {
                String aux = id.substring(1, id.length() - 1);
                this.id = "_" + aux;
            } else if (token.equals("CTE_BIN") || token.equals("CTE_INT") || token.equals("CTE_REAL")) {
                this.id = "_" + id;
            }
        }
    }

    /**
     * Se verifican las longitudes y contenido de las constantes.
     * En caso de que alguna contenga ERROR, arrojamos una Exception.
     */
    private void verificarConstantes() throws ErrorCompilacion {
        if (esSimbolo) {
            switch (token) {
                case "CTE_STRING" -> {
                    if (valor.length() > 30) {
                        throw new ErrorCompilacion("Error: La constante STRING {'" + valor + "'} excede la longitud máxima de 30 caracteres.");
                    }
                }
                case "CTE_INT" -> {
                    try {
                        Integer.parseInt(valor);
                    } catch (NumberFormatException nfe) {
                        throw new ErrorCompilacion("Error: La constante INT {" + valor + "} tiene un formato no válido.");
                    }
                }
                case "CTE_REAL" -> {
                    try {
                        Float.parseFloat(valor);
                    } catch (NumberFormatException nfe) {
                        throw new ErrorCompilacion("Error: La constante REAL {" + valor + "} tiene un formato no válido.");
                    }
                }
            }
        }
    }

    private void setValor() {
        if (esSimbolo) {
            switch (token) {
                case "CTE_STRING", "CTE_INT", "CTE_REAL" -> {
                    this.valor = id.replace("_", "");
                }
                case "CTE_BIN" -> {
                    this.valor = id.replace("_", "").replace("0b", "");
                }
            }
        }
    }

    private void setLongitud() {
        if (esSimbolo)
            switch (token) {
                case "CTE_STRING", "CTE_BIN", "CTE_INT", "CTE_REAL" -> this.longitud = String.valueOf(valor.length());
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
        return longitud;
    }

    public boolean esSimbolo() {
        return esSimbolo;
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
                ", esSimbolo=" + esSimbolo +
                '}';
    }
}
