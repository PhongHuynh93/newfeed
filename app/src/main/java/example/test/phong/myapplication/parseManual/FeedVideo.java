package example.test.phong.myapplication.parseManual;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import example.test.phong.myapplication.newfeedModel.VideoInfo;

public class FeedVideo implements FeedType {
    @SerializedName("assetType")
    @Expose
    public int assetType;
    @SerializedName("extraData")
    @Expose
    public String extraData;
    @SerializedName("videoInfo")
    @Expose
    public VideoInfo songInfo;

    @Override
    public int getFeedType() {
        return FeedType.TYPE_VIDEO;
    }
}
