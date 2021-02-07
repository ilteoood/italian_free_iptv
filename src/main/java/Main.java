import auto.JustNetworkParser;
import dto.ChannelDto;
import io.lindstrom.m3u8.model.MediaPlaylist;
import io.lindstrom.m3u8.parser.MediaPlaylistParser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws IOException {
        final List<ChannelDto> channelList = new JustNetworkParser().createChannelList();
        final MediaPlaylist mediaPlaylist = M3u8Builder.buildPlaylist(channelList);
        savePlaylist(mediaPlaylist);
    }

    private static void savePlaylist(final MediaPlaylist mediaPlaylist) throws IOException {
        final OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("./playlist.m3u8"));
        streamWriter.write(new MediaPlaylistParser().writePlaylistAsString(mediaPlaylist));
        streamWriter.close();
    }

}
