package example.test.phong.myapplication.parseManual.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import example.test.phong.myapplication.ParserUtil;
import example.test.phong.myapplication.parseManual.FeedLink;


public class FeedLinkTypeAdapter extends TypeAdapter<FeedLink> {
    @Override
    public void write(JsonWriter out, FeedLink value) throws IOException {

    }

    @Override
    public FeedLink read(JsonReader in) throws IOException {
        FeedLink feed = new FeedLink();
        String name;
        in.beginObject();
        while (in.hasNext()) {
            name = in.nextName();
            if (ParserUtil.consumeNextNull(in))
                continue;
            switch (name) {
                case "assetType":
                    feed.assetType = in.nextInt();
                case "extraData":
                    feed.extraData = in.nextString();
                case "link":
                    feed.link = in.nextString();
                case "source":
                    feed.source = in.nextString();
                case "linkTitle":
                    feed.linkTitle = in.nextString();
                case "linkDescription":
                    feed.linkDescription = in.nextString();
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();
        return feed;
    }
}
