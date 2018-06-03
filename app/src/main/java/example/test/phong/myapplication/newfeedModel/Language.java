
package example.test.phong.myapplication.newfeedModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("languageId")
    @Expose
    public int languageId;
    @SerializedName("languageSymbol")
    @Expose
    public String languageSymbol;

}
