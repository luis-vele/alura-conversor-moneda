import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class ConsultaConversion {
    public Moneda consultaConversion(String monedaOrigen, String monedaDestino, Double monedaCantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/56ed1a958e624b89540353ea/pair/"+monedaOrigen+"/"+monedaDestino+"/"+monedaCantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada.");
        }
    }
}
