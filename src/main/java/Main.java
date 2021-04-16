import entidade.Chamada;
import entidade.Fila;
import entidade.ListaDDDs;
import ferramenta.JsonUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
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

            System.out.println("Digite seu numero: ");
            String digitado = teclado.readLine();

            System.out.println(new Chamada(digitado, listaDDDs));



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
