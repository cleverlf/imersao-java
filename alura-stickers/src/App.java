import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) throws Exception {

        // fazer uma conexao HTTP e buscar os top 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair so os dados que interessam (titulo, poster, classificacao)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("Titulo: " + filme.get("title"));
            System.out.println("Capa: " + filme.get("image"));
            System.out
                    .println(GREEN + "Nota: " + filme.get("imDbRating") + ratingStars(filme.get("imDbRating")) + RESET);
            System.out.println();
        }

    }

    public static String ratingStars(String rating) {

        String stars = "";

        for (int i = 0; i < Math.floor(Double.parseDouble(rating)); i++) {

            stars = stars + " ⭐";
        }

        return stars;
    }
    
    // tirar a cor
    public static final String RESET = "\u001B[0m";

    // cor do texto
    public static final String GREEN = "\u001B[32m" + " \u001B[42m";

}
