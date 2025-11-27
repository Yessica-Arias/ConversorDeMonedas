import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CrearHttp {
    private final String apiKey = "27204570bdc0f115f1a3e034";

    public JsonObject obtenerTasas() {
        String url = "https://v6.exchangerate-api.com/v6/27204570bdc0f115f1a3e034/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println("RESPUESTA API" + response.body());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            return json.getAsJsonObject("conversion_rates");
        }catch (Exception e){
            throw new RuntimeException("Error al obtener las tasas de la Api: " + e.getMessage(), e);
        }

    }
}
