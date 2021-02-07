package manual.rai;

import manual.rai.dto.playlist.RaiChannelDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static manual.rai.dto.playlist.RaiChannelDto.INITIAL_PAGE;
import static manual.rai.dto.playlist.RaiChannelDto.VIDEO_HREF_CLASS;

public class RaiChannelList {

    public static List<RaiChannelDto> retrieve() {
        List<RaiChannelDto> channelsList = new ArrayList<>();
        try {
            final Document diretteContent = Jsoup.connect(INITIAL_PAGE).get();
            Elements channelsHref = diretteContent.select(VIDEO_HREF_CLASS);
            channelsList = channelsHref
                    .stream()
                    .map(channel -> new RaiChannelDto(channel)).collect(Collectors.toList());
        } catch (IOException e) {
        }
        return channelsList;
    }

}
