import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {

    // regex101.com
<<<<<<< HEAD
    // regex do tmdb - 
    // private static final Pattern REGEX_ITEMS = Pattern.compile("\\[(.+)\\]");    
    // private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"?(.*?)\"?,");
    // regex outros
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) throws IllegalArgumentException {
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
=======
    // parser do tmdb - 
    private static final Pattern REGEX_ITEMS = Pattern.compile("\\[(.+)\\]");
    // parser do tmdb - 
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"?(.*?)\"?,");
    //private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    //private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) throws IllegalAccessException {
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalAccessException("Não encontrou items.");
>>>>>>> c44b444c3cf92357e0259649ce23ddb4db032ce7

        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items) {

            Map<String, String> atributosItem = new HashMap<>();

            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }
            dados.add(atributosItem);
        }
        return dados;
    }
}
