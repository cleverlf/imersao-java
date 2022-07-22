import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoTMDB implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json){
        // extrair so os dados que interessam (titulo, poster, classificacao)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parseTMDB(json);
        
        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo;
            if (atributos.containsKey("title")) {
                titulo = atributos.get("title");
            }else{
                titulo = atributos.get("name");
            }
            if (titulo!=null) {
                titulo = titulo.replace(":", " -");
            }
            

            String urlImagem;
            if (atributos.containsKey(",\"poster_path")) {
                urlImagem = "https://image.tmdb.org/t/p/w500" +  atributos.get(",\"poster_path");
            }else if (atributos.containsKey(".\",\"poster_path")) {
                urlImagem = "https://image.tmdb.org/t/p/w500" +  atributos.get(".\",\"poster_path");
            }else{
                urlImagem = "https://image.tmdb.org/t/p/w500" +  atributos.get("poster_path");
            }
            String rating = atributos.get("vote_average");            
            
            var conteudo = new Conteudo(titulo, urlImagem, rating);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
