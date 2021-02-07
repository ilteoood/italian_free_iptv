package auto.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Playlist {

    @SerializedName("class")
    private String jsonMemberClass;

    @SerializedName("url")
    private String url;

    @SerializedName("target")
    private String target;

}