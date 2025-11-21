import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CrearHttp {
    //String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/27204570bdc0f115f1a3e034/latest/USD"))
            .GET()
            .build();

    {
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            JsonObject monedasjson = json.getAsJsonObject("conversion_rates");
            for( String key : monedasjson.keySet()){
                System.out.println(key + ": " + monedasjson.get(key) );
            }
            String valor = monedasjson.get("USD").getAsString();
            System.out.println("Aca es nombre: " + valor);

        } catch (Exception e) {
            throw new RuntimeException("No puedo converetir ese valor.");
        }
    }
}
