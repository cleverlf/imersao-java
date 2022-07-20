import java.io.InputStream;
<<<<<<< HEAD
import java.net.URL;
import java.util.List;
=======
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
>>>>>>> c44b444c3cf92357e0259649ce23ddb4db032ce7


public class App {
    
    public static void main(String[] args) throws Exception {

<<<<<<< HEAD
        // fazer uma conexao HTTP e buscar dados q contenham titulo e imagem
        // String url = "https://api.themoviedb.org/3/trending/all/day?api_key=18b28a0f741c6bb5155f7fd2438ab796";  
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoTMDB();

        String url = "https://api.nasa.gov/planetary/apod?api_key=aMxMXff4fK23QXv5wGhF9lKJaIaZGy4fdggZVtSv&start_date=2022-06-01&end_date=2022-06-30";  
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();       
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);        

        // exibir e manipular os dados
        
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();
        for (Conteudo conteudo : conteudos) {            
            System.out.println("Titulo: " + conteudo.getTitulo());
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);
            
            
            //System.out.println("Capa: " + "https://image.tmdb.org/t/p/w500" + poster);
            //System.out.println(GREEN + "Nota: " + atributos.get("vote_average") + ratingStars(atributos.get("vote_average")) + RESET);
            System.out.println();
        }
       
        
            System.out.println(conteudos.size());
=======
        // fazer uma conexao HTTP e buscar os top 250 filmes
        String url = "https://api.themoviedb.org/3/trending/all/day?api_key=18b28a0f741c6bb5155f7fd2438ab796";        
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair so os dados que interessam (titulo, poster, classificacao)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();
        for (Map<String, String> filme : listaDeFilmes) {
            
            String titulo;
            if (filme.containsKey("title")) {
                titulo = filme.get("title");
            }else{
                titulo = filme.get("name");
            }
            if (titulo.contains(":")) {
                titulo = titulo.replace(":", "-");
            }

            String poster;
            if (filme.containsKey(",\"poster_path")) {
                poster = filme.get(",\"poster_path");
            }else if (filme.containsKey(".\",\"poster_path")) {
                poster = filme.get(".\",\"poster_path");
            }else{
                poster = filme.get("poster_path");
            }
            
            String urlImagem = "https://image.tmdb.org/t/p/w500" + poster;
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".jpg";

            geradora.cria(inputStream, nomeArquivo);
            System.out.println("Titulo: " + titulo);
            
            System.out.println("Capa: " + "https://image.tmdb.org/t/p/w500" + poster);
            System.out.println(GREEN + "Nota: " + filme.get("vote_average") + ratingStars(filme.get("vote_average")) + RESET);
            System.out.println();
        }
        

>>>>>>> c44b444c3cf92357e0259649ce23ddb4db032ce7
    }

    public static String ratingStars(String rating) {

        String stars = "";

        for (int i = 0; i < Math.floor(Double.parseDouble(rating)); i++) {

            stars = stars + " "+ STAR;
        }

        return stars;
    }
    
    // tirar a cor
    public static final String RESET = "\u001B[0m";

    // cor do texto
    public static final String GREEN = "\u001B[32m" + " \u001B[42m";

    // emoji estrela
    public static final String STAR = "\u2b50";
}
