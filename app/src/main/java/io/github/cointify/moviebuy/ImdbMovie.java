package io.github.cointify.moviebuy;

public class ImdbMovie {

    private String id;
    private String originalTitle;
    private String title;
    private String posterPath;
    private String releaseDate;
    private String overview;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * As per assignment's requirement fetch w185 size. Other sizes available: w92, w154, w185, w342, w500, w780
     */
    public String getPosterPath() {
        return "/w185" + posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
