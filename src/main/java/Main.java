import entidade.Chamada;
import entidade.Fila;
import entidade.ListaDDDs;
import ferramenta.JsonUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private final static BufferedReader TECLADO = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            ListaDDDs listaDDDs = JsonUtils.getListaDDD();

            Fila filaChamada = new Fila();

            filaChamada.insere(new Chamada("9900000000", listaDDDs));
            filaChamada.insere(new Chamada("34111111111", listaDDDs));
            filaChamada.insere(new Chamada("3422222-2222", listaDDDs));
            filaChamada.insere(new Chamada("(34)333333333", listaDDDs));
            filaChamada.insere(new Chamada("(11)444444444", listaDDDs));

            System.out.println("Digite seu numero: ");
            String digitado = TECLADO.readLine();
            filaChamada.insere(new Chamada(digitado, listaDDDs));
            filaChamada.printaFila();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
