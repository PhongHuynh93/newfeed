package example.test.phong.myapplication.parseManual;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import example.test.phong.myapplication.newfeedModel.AlbumInfo;

public class FeedAlbum implements FeedType {
    @SerializedName("assetType")
    @Expose
    public int assetType;
    @SerializedName("extraData")
    @Expose
    public String extraData;
    @SerializedName("albumInfo")
    @Expose
    public AlbumInfo songInfo;

    @Override
    public int getFeedType() {
        return FeedType.TYPE_ALBUM;
    }
}
