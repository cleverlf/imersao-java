import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{
    
    public List<Conteudo> extraiConteudos(String json){

        // extrair so os dados que interessam (titulo, poster, classificacao)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo= atributos.get("title");
            if (titulo.contains(":")) {
                titulo = titulo.replace(":", " -");
                
            }else if (titulo.contains("/")) {
                titulo = titulo.replace("/", " ");
            }
            else{
                titulo = atributos.get("title");
            }
            String urlImagem;
            if (atributos.get("hdurl") != null) {
                urlImagem = atributos.get("hdurl");
            } else {
                continue;
            }

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
