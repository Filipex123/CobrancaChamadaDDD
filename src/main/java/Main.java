import com.google.gson.Gson;
import entidade.Fila;
import entidade.ListaDDDs;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        try {
            String json = String.join(" ", Files.readAllLines(
                    Paths.get("./src/main/resources/ddd.json"), StandardCharsets.UTF_8));

            ListaDDDs listaDDDs = new Gson().fromJson(json, ListaDDDs.class);

            Fila filaChamada = new Fila();

            filaChamada.insere("(18)44366-7880");
            filaChamada.insere("(19)44366-7880");
            filaChamada.insere("(45)44366-7880");
            filaChamada.insere("(78)44366-7880");
            filaChamada.insere("(99)44366-7880");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
