package entidade;

public class DDD {

    private int codigo;
    private float preco;
    private String estado;

    public DDD(int codigo, float preco, String estado) {
        this.codigo = codigo;
        this.preco = preco;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return " " +
                "codigo = " + codigo +
                ", preco = " + preco +
                ", estado = " + estado +
                " ";
    }
}
