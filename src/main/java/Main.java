import entidade.Chamada;
import entidade.Fila;
import entidade.ListaDDDs;
import ferramenta.JsonUtils;

public class Main {
    public static void main(String[] args) {

        try {
            ListaDDDs listaDDDs = JsonUtils.getListaDDD();

            Fila filaChamada = new Fila();

            filaChamada.insere(new Chamada("9900000000", listaDDDs));
            filaChamada.insere(new Chamada("34111111111", listaDDDs));
            filaChamada.insere(new Chamada("3422222-2222", listaDDDs));
            filaChamada.insere(new Chamada("(34)333333333", listaDDDs));
            filaChamada.insere(new Chamada("(55)444444444", listaDDDs));
            System.out.println("bla");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
