package auto;

import auto.dto.ChannelNameClass;
import auto.dto.Playlist;
import com.google.gson.Gson;
import dto.ChannelDto;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JustNetworkParser {

    private static final String SITE_URL = "https://justnetwork.it/tv/";
    private static final String CHANNEL_SELECTOR = ".et_pb_text";
    private static final String CHANNEL_NAME_SELECTOR = ".et_pb_text_inner > p";
    private static final String ATTRIBUTE_CSS_CLASS = "class";
    private static final String CHANNEL_CLASS_PREFIX = "et_pb_text_";
    private static final String SCRIPT_VARIABLE_PREFIX = "et_link_options_data = ";
    private final Document pageContent;
    private final List<Playlist> playlistContent;

    public JustNetworkParser() throws IOException {
        pageContent = Jsoup.connect(SITE_URL).get();
        playlistContent = Arrays.asList(retrievePlaylist());
    }

    public List<ChannelDto> createChannelList() throws IOException {
        final List<ChannelNameClass> channelsNameClass = retrieveAvailableChannels();
        final List<ChannelDto> channelsList = channelsNameClass.stream()
                .map(this::buildChannelDto)
                .collect(Collectors.toList());
        return channelsList.subList(1, channelsList.size() - 2);
    }

    @NotNull
    private Optional<Element> findPlaylistElement() {
        return pageContent.select("body > script").stream()
                .filter(scriptNode -> scriptNode.childNodeSize() > 0)
                .filter(scriptNode -> scriptNode.childNode(0).toString().contains(SCRIPT_VARIABLE_PREFIX))
                .findFirst();
    }

    private Playlist[] retrievePlaylist() {
        final Optional<Element> playlistElement = findPlaylistElement();
        final String scriptContent = playlistElement.isPresent() ? playlistElement.get().toString() : "";
        final String playlistData = scriptContent.substring(
                scriptContent.indexOf(SCRIPT_VARIABLE_PREFIX), scriptContent.lastIndexOf(";")
        ).replace(SCRIPT_VARIABLE_PREFIX, "");
        return new Gson().fromJson(playlistData, Playlist[].class);

    }

    private List<ChannelNameClass> retrieveAvailableChannels() throws IOException {
        return pageContent.select(CHANNEL_SELECTOR).stream()
                .map(element -> new ChannelNameClass(
                        element.select(CHANNEL_NAME_SELECTOR).text(),
                        findChannelClass(element)
                )).collect(Collectors.toList());
    }

    private String findChannelClass(final Element element) {
        return Arrays.stream(element.attr(ATTRIBUTE_CSS_CLASS).split(" "))
                .filter(className -> className.startsWith(CHANNEL_CLASS_PREFIX))
                .findFirst()
                .orElse("");
    }

    private ChannelDto buildChannelDto(final ChannelNameClass channelNameClass) {
        return new ChannelDto(
                channelNameClass.getName(),
                findChannelLink(channelNameClass.getCssClass())
        );
    }

    private String findChannelLink(final String channelClass) {
        return playlistContent.stream().filter(
                playlist -> playlist.getJsonMemberClass().equals(channelClass)
        ).findFirst().get().getUrl();
    }


}
