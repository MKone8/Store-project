package Rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RestApi {

    public static Root getBooks() {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(
                            "https://api.nytimes.com/svc/books/v3/lists/full-overview.json?api-key=60pSocrRBRsDiLZ7XTfqiUEY2md7xFsh"))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(getResponse.body(), Root.class);
            return root;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
