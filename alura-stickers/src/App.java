import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    
    public static void main(String[] args) throws Exception {

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
