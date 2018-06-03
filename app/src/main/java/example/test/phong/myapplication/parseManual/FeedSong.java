package example.test.phong.myapplication.parseManual;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import example.test.phong.myapplication.parseManual.alreadyAdapter.ZingSong;

public class FeedSong implements FeedType {
    @SerializedName("assetType")
    @Expose
    public int assetType;
    @SerializedName("extraData")
    @Expose
    public String extraData;
    @SerializedName("songInfo")
    @Expose
    // TODO: 6/3/2018 used SongTypeAdapter in zingmp3 app
    public ZingSong songInfo;

    @Override
    public int getFeedType() {
        return FeedType.TYPE_SONG;
    }
}
