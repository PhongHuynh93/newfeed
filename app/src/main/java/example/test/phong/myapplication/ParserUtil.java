package example.test.phong.myapplication;

import android.text.TextUtils;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/**
 * Created by PhuongHoang on 7/14/16.
 */
public class ParserUtil {
    public static boolean consumeNextNull(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return true;
        }
        return false;
    }

    public static String parseArtistName(JsonReader in) throws IOException {
        return parseStringWithComma(in);
    }

    public static String parseThumb(JsonReader in, String prefix) throws IOException {
        return parseThumb(in.nextString(), prefix);
    }

    public static String parseThumb(String thumb, String prefix) throws IOException {
        if (TextUtils.isEmpty(thumb))
            return null;
        if (thumb.startsWith("http"))
            return thumb;
        return prefix + thumb;
    }

    public static String parseStringWithComma(JsonReader in) throws IOException {
        String str = in.nextString().replace("&amp;", "&");
        if (str.contains(",")) {
            String[] ns = str.split(",");
            if (ns != null && ns.length > 0) {
                StringBuilder temp = new StringBuilder(ns[0].trim());
                for (int i = 1; i < ns.length; i++) {
                    temp.append(", ").append(ns[i].trim());
                }
                str = temp.toString();
            }
        }
        return str;
    }
}
