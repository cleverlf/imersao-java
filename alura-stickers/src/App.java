import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {  
    // chcp 65001 ATIVAR EMOJI NO TERMINAL  
    // tirar a cor
    public static final String RESET = "\u001B[0m";
    // cor do texto
    public static final String BRIGHT_GREEN = "\u001b[92m";
    public static final String BRIGHT_AZUL = "\u001b[96m";
    public static final String BRIGHT_YELLOW = "\u001b[93m";
    // emoji estrela
    public static final String STAR = "\u2b50";
    
    public static void main(String[] args) throws Exception {

        // fazer uma conexao HTTP e buscar dados q contenham titulo e imagem
        API minhaAPI = API.NASA;
        
        var http = new ClienteHttp();
        String json = http.buscaDados(minhaAPI.url());
        List<Conteudo> conteudos = minhaAPI.extrator().extraiConteudos(json);

        // exibir e manipular os dados         
        var geradora = new GeradoraDeFigurinhas();
        for (Conteudo conteudo : conteudos) {  

            //mostra          
            System.out.println("Titulo: " + BRIGHT_GREEN + conteudo.getTitulo() + RESET);
            System.out.println("Imagem - Url: " + BRIGHT_AZUL +conteudo.getUrlImagem() + RESET);
            if (conteudo.getRating()!= null) {
            System.out.println("Nota: " + BRIGHT_YELLOW+ conteudo.getRating() + ratingStars(conteudo.getRating()) + RESET); 
            }           
            System.out.println();

            //cria figurinhas
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);
            
        }        
            
    }

    public static String ratingStars(String rating) {

        String stars = "";
        for (int i = 0; i < Math.floor(Double.parseDouble(rating)); i++) {

            stars = stars + " "+ STAR;

        }

        return stars;

    }
       
}
