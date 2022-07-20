import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaMarvel implements ExtratorDeConteudo {

    @Override
    public List<Conteudo> extraiConteudos(String json) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo= atributos.get("name");
            if (titulo.contains(":")) {
                titulo = titulo.replace(":", " -");
                
            }else if (titulo.contains("/")) {
                titulo = titulo.replace("/", " ");
            }
            else{
                titulo = atributos.get("name");
            }
            String urlImagem;
            if (atributos.get("path") != null) {
                urlImagem = atributos.get("path") + ".jpg" ;
            } else {
                continue;
            }

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
    
}
