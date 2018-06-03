
package example.test.phong.myapplication.newfeedModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import example.test.phong.myapplication.parseManual.Description;

public class Item {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("type")
    @Expose
    public int type;
    @SerializedName("description")
    @Expose
    public List<Description> description = null;
    @SerializedName("location")
    @Expose
    public int location;
    @SerializedName("countries")
    @Expose
    public String countries;
    @SerializedName("publisherId")
    @Expose
    public int publisherId;
    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;
    @SerializedName("publisherName")
    @Expose
    public String publisherName;
    @SerializedName("shortDesc")
    @Expose
    public String shortDesc;
    @SerializedName("modifiedDate")
    @Expose
    public int modifiedDate;
    @SerializedName("createdDate")
    @Expose
    public int createdDate;
    @SerializedName("content")
    @Expose
    public Content content;
    @SerializedName("likes")
    @Expose
    public int likes;

}
