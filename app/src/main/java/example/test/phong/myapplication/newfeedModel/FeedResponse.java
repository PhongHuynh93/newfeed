
package example.test.phong.myapplication.newfeedModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedResponse {

    @SerializedName("err")
    @Expose
    public int err;
    @SerializedName("msg")
    @Expose
    public String msg;
    @SerializedName("data")
    @Expose
    public Data data;
    @SerializedName("timestamp")
    @Expose
    // TODO: 6/2/2018 when using int and when using long???
    public long timestamp;

    @Override
    public String toString() {
        return "FeedResponse{" +
                "err=" + err +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
}
