public enum API {
    
    TMDB ("https://api.themoviedb.org/3/trending/all/day?api_key=18b28a0f741c6bb5155f7fd2438ab796",
        new ExtratorDeConteudoDoTMDB()),
    NASA ("https://api.nasa.gov/planetary/apod?api_key=aMxMXff4fK23QXv5wGhF9lKJaIaZGy4fdggZVtSv&start_date=2022-06-01&end_date=2022-06-30",
        new ExtratorDeConteudoDaNasa());

    private String url;
    private ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator){
        this.url = url;
        this.extrator = extrator;
    }

    public String url() {
        return url;
    }
    public ExtratorDeConteudo extrator() {
        return extrator;
    }

}
