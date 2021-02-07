package manual.rai.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jsoup.nodes.Element;

@AllArgsConstructor
@Getter
@ToString
public class RaiChannelDto {

    public static final String VIDEO_HREF_CLASS = ".card-item__link";
    public static final String INITIAL_PAGE = "https://www.raiplay.it/dirette/";
    private static final String HREF_PREFIX = "/dirette/";
    private static final String TITLE_CLASS = ".card-item__spec--channel";
    private static final String CONFIG_EXTENSION = ".json";

    private final String channelName;
    private final String channelLink;

    public RaiChannelDto(final Element element) {
        channelLink = INITIAL_PAGE + findChannelLink(element) + CONFIG_EXTENSION;
        channelName = findChannelName(element);
    }

    private String findChannelLink(final Element element) {
        return element.attr("href").replace(HREF_PREFIX, "");
    }

    private String findChannelName(final Element element) {
        return element.getElementsByClass("card-item__spec--channel")
                .stream()
                .findFirst()
                .map(titleElement -> titleElement.text())
                .orElse("");
    }

}
