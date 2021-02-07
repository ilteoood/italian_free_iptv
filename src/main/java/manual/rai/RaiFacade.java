package manual.rai;

import com.google.gson.Gson;
import io.lindstrom.m3u8.model.MediaSegment;
import manual.rai.dto.playlist.RaiChannelDto;
import manual.rai.dto.playlist.RaiPlaylistResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class RaiFacade {

    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final Gson GSON = new Gson();

    public static List<MediaSegment> constructRaiSegments() {
        return RaiChannelList.retrieve().stream().map(
                raiChannelDto -> MediaSegment.builder()
                        .uri(retrievePlayList(raiChannelDto))
                        .title(raiChannelDto.getChannelName())
                        .build()
        ).collect(Collectors.toList());
    }

    private static String retrievePlayList(final RaiChannelDto raiChannelDto) {
        String playlistLink = "";
        final Request request = new Request.Builder().url(raiChannelDto.getChannelLink()).build();
        try {
            final Response response = CLIENT.newCall(request).execute();
            final RaiPlaylistResponse raiPlaylistResponse = GSON.fromJson(response.body().string().trim(), RaiPlaylistResponse.class);
            System.out.println(raiPlaylistResponse);
            playlistLink = raiPlaylistResponse.getVideo().getContentUrl();
        } catch (IOException e) {
        }
        return playlistLink;
    }

}
