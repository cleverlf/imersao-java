public class Conteudo {
    
    private String titulo;
    private String urlImagem;
    private String rating;
    
    
    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }
    

    public Conteudo(String titulo, String urlImagem, String rating) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.rating = rating;
    }


    public String getTitulo() {
        return titulo;
    }
    public String getUrlImagem() {
        return urlImagem;
    }
    public String getRating() {
        return rating;
    }
    

    
}
