
package example.test.phong.myapplication.newfeedModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("items")
    @Expose
    public List<Item> items = null;
    @SerializedName("lastIndex")
    @Expose
    public int lastIndex;
    @SerializedName("isMore")
    @Expose
    public boolean isMore;
    @SerializedName("total")
    @Expose
    public int total;
    @SerializedName("likedIds")
    @Expose
    public List<Integer> likedIds = null;

}
