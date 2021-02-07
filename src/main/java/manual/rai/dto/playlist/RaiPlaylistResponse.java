package manual.rai.dto.playlist;

public class RaiPlaylistResponse {
    private String editor;
    private String pathId;
    private String channel;
    private String description;
    private String transparentIcon;
    private Video video;
    private String type;
    private String hexColor;
    private Dfp dfp;
    private RightsManagement rightsManagement;
    private String stillFrame;
    private boolean adv;
    private String datePublished;
    private String name;
    private String weblink;
    private boolean isLive;
    private String id;
    private TrackInfo trackInfo;
    private String timePublished;
    private String headerBg;

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransparentIcon() {
        return transparentIcon;
    }

    public void setTransparentIcon(String transparentIcon) {
        this.transparentIcon = transparentIcon;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public Dfp getDfp() {
        return dfp;
    }

    public void setDfp(Dfp dfp) {
        this.dfp = dfp;
    }

    public RightsManagement getRightsManagement() {
        return rightsManagement;
    }

    public void setRightsManagement(RightsManagement rightsManagement) {
        this.rightsManagement = rightsManagement;
    }

    public String getStillFrame() {
        return stillFrame;
    }

    public void setStillFrame(String stillFrame) {
        this.stillFrame = stillFrame;
    }

    public boolean isAdv() {
        return adv;
    }

    public void setAdv(boolean adv) {
        this.adv = adv;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public boolean isIsLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TrackInfo getTrackInfo() {
        return trackInfo;
    }

    public void setTrackInfo(TrackInfo trackInfo) {
        this.trackInfo = trackInfo;
    }

    public String getTimePublished() {
        return timePublished;
    }

    public void setTimePublished(String timePublished) {
        this.timePublished = timePublished;
    }

    public String getHeaderBg() {
        return headerBg;
    }

    public void setHeaderBg(String headerBg) {
        this.headerBg = headerBg;
    }

    @Override
    public String toString() {
        return
                "RaiPlaylistResponse{" +
                        "editor = '" + editor + '\'' +
                        ",path_id = '" + pathId + '\'' +
                        ",channel = '" + channel + '\'' +
                        ",description = '" + description + '\'' +
                        ",transparent_icon = '" + transparentIcon + '\'' +
                        ",video = '" + video + '\'' +
                        ",type = '" + type + '\'' +
                        ",hex_color = '" + hexColor + '\'' +
                        ",dfp = '" + dfp + '\'' +
                        ",rights_management = '" + rightsManagement + '\'' +
                        ",still_frame = '" + stillFrame + '\'' +
                        ",adv = '" + adv + '\'' +
                        ",date_published = '" + datePublished + '\'' +
                        ",name = '" + name + '\'' +
                        ",weblink = '" + weblink + '\'' +
                        ",is_live = '" + isLive + '\'' +
                        ",id = '" + id + '\'' +
                        ",track_info = '" + trackInfo + '\'' +
                        ",time_published = '" + timePublished + '\'' +
                        ",header_bg = '" + headerBg + '\'' +
                        "}";
    }
}
