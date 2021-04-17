import entidade.Chamada;
import entidade.Fila;
import entidade.ListaDDDs;
import ferramenta.JsonUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private final static BufferedReader TECLADO = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        Fila filaChamada = new Fila();
        ListaDDDs listaDDDs = populaListaDDD(filaChamada);

        while (true) {
            System.out.println("#### Para encerrar do programa digite 'sair' ####");
            System.out.println("Digite seu numero: ");
            try {
                String digitado = TECLADO.readLine();
                if(digitado.equals("sair")) {
                    break;
                }
                filaChamada.insere(new Chamada(digitado, listaDDDs));
                filaChamada.printaFila();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private static ListaDDDs populaListaDDD(Fila filaChamada) {
        try {
            ListaDDDs listaDDDs = JsonUtils.getListaDDD();
            filaChamada.insere(new Chamada("9900000000", listaDDDs));
            filaChamada.insere(new Chamada("34111111111", listaDDDs));
            filaChamada.insere(new Chamada("3422222-2222", listaDDDs));
            filaChamada.insere(new Chamada("(34)333333333", listaDDDs));
            filaChamada.insere(new Chamada("(11)444444444", listaDDDs));
            return listaDDDs;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
