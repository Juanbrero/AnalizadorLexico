package representaciones;

public class Regla {
    private String numero;
    private String descripcion;
    private String ID = null;
    private String type = null;

    public Regla(int numero, String descripcion){
        this.numero = "[Regla " + numero + "]";
        this.descripcion = descripcion;
    }

    public Regla(int numero, String descripcion, String ID, String type) {
        this.ID = ID;
        this.type = type;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getReglaSinFormato(){
        return this.numero + " " + this.descripcion;
    }

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }
}
