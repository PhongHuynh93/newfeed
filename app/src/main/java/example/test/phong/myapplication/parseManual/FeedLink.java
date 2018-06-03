package example.test.phong.myapplication.parseManual;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedLink implements FeedType {
    @SerializedName("assetType")
    @Expose
    public int assetType;
    @SerializedName("extraData")
    @Expose
    public String extraData;
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

    @Override
    public int getFeedType() {
        return FeedType.TYPE_LINK;
    }
}
