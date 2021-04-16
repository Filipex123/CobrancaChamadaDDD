package ferramenta;

import com.google.gson.Gson;
import entidade.ListaDDDs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    public static ListaDDDs getListaDDD() throws IOException {
        String json = String.join(" ", Files.readAllLines(
                Paths.get("./src/main/resources/ddd.json"), StandardCharsets.UTF_8));
        return new Gson().fromJson(json, ListaDDDs.class);
    }
}
