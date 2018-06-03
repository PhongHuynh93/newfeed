package example.test.phong.myapplication.parseManual.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import example.test.phong.myapplication.ParserUtil;
import example.test.phong.myapplication.parseManual.FeedSong;
import example.test.phong.myapplication.parseManual.alreadyAdapter.SongTypeAdapter;


public class FeedSongTypeAdapter extends TypeAdapter<FeedSong> {
    @Override
    public void write(JsonWriter out, FeedSong value) throws IOException {

    }

    @Override
    public FeedSong read(JsonReader in) throws IOException {
        FeedSong feed = new FeedSong();
        SongTypeAdapter songTypeAdapter = new SongTypeAdapter();
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
                case "songInfo":
                    feed.songInfo = songTypeAdapter.read(in);
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();
        return feed;
    }
}
