package manual.rai.dto.playlist;

public class Video {
    private String highlights;
    private String contentUrl;

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    @Override
    public String toString() {
        return
                "Video{" +
                        "highlights = '" + highlights + '\'' +
                        ",content_url = '" + contentUrl + '\'' +
                        "}";
    }
}
