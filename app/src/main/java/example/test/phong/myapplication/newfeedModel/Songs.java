
package example.test.phong.myapplication.newfeedModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Songs {

    @SerializedName("items")
    @Expose
    public List<Item_> items = null;
    @SerializedName("lastIndex")
    @Expose
    public int lastIndex;
    @SerializedName("isMore")
    @Expose
    public boolean isMore;
    @SerializedName("total")
    @Expose
    public int total;

}
