import dto.ChannelDto;
import io.lindstrom.m3u8.model.MediaPlaylist;
import io.lindstrom.m3u8.model.MediaSegment;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import java.util.List;

public class M3u8Builder {

    static MediaPlaylist buildPlaylist(final List<ChannelDto> channelsList) {
        return MediaPlaylist.builder()
                .addMediaSegments(
                        channelsList.stream().map(M3u8Builder::generateMediaSegment).toArray(MediaSegment[]::new))
                .targetDuration(1)
                .build();

    }

    static MediaSegment generateMediaSegment(final ChannelDto channelDto) {
        return MediaSegment.builder()
                .uri(channelDto.getLink())
                .duration(0.0)
                .title(WordUtils.capitalize(StringUtils.lowerCase(channelDto.getName())))
                .build();
    }

}
