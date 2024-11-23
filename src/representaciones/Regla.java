package representaciones;

public class Regla {
    private String numero;
    private String descripcion;

    public Regla(int numero, String descripcion){
        this.numero = "[Regla " + numero + "]";
        this.descripcion = descripcion;
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
}
