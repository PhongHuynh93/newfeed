
package example.test.phong.myapplication.newfeedModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("albumInfo")
    @Expose
    public AlbumInfo albumInfo;
    @SerializedName("assetType")
    @Expose
    public int assetType;
    @SerializedName("extraData")
    @Expose
    public String extraData;
    @SerializedName("videoInfo")
    @Expose
    public VideoInfo videoInfo;
    @SerializedName("songInfo")
    @Expose
    public SongInfo songInfo;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("source")
    @Expose
    public String source;
    @SerializedName("linkTitle")
    @Expose
    public String linkTitle;
    @SerializedName("linkDescription")
    @Expose
    public String linkDescription;

}
