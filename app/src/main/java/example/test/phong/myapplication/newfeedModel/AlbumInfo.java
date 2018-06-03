
package example.test.phong.myapplication.newfeedModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumInfo {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("artId")
    @Expose
    public String artId;
    @SerializedName("art")
    @Expose
    public String art;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("thumb")
    @Expose
    public String thumb;
    @SerializedName("contentOwner")
    @Expose
    public String contentOwner;
    @SerializedName("zId")
    @Expose
    public int zId;
    @SerializedName("isOfficial")
    @Expose
    public boolean isOfficial;
    @SerializedName("isHit")
    @Expose
    public boolean isHit;
    @SerializedName("isWorld")
    @Expose
    public boolean isWorld;
    @SerializedName("releaseDate")
    @Expose
    public String releaseDate;
    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("gId")
    @Expose
    public String gId;
    @SerializedName("gName")
    @Expose
    public String gName;
    @SerializedName("isAlbum")
    @Expose
    public boolean isAlbum;
    @SerializedName("userId")
    @Expose
    public int userId;
    @SerializedName("bgImage")
    @Expose
    public String bgImage;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("totalSong")
    @Expose
    public int totalSong;
    @SerializedName("songs")
    @Expose
    public Songs songs;

}
