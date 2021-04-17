package entidade;

public class DDD {

    private int codigo;
    private float preco;

    public DDD(int codigo, float preco) {
        this.codigo = codigo;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "{ " +
                "codigo = " + codigo +
                ", preco = " + preco +
                " }";
    }
}
