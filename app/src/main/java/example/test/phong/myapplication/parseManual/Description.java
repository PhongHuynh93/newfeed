
package example.test.phong.myapplication.parseManual;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import example.test.phong.myapplication.newfeedModel.Language;

public class Description {

    @SerializedName("language")
    @Expose
    public Language language;
    @SerializedName("content")
    @Expose
    public String content;

}
