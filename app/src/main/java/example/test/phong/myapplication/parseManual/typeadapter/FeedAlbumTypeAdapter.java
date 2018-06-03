package example.test.phong.myapplication.parseManual.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import example.test.phong.myapplication.parseManual.FeedAlbum;


public class FeedAlbumTypeAdapter extends TypeAdapter<FeedAlbum> {
    @Override
    public void write(JsonWriter out, FeedAlbum value) throws IOException {

    }

    @Override
    public FeedAlbum read(JsonReader in) throws IOException {
        // TODO: 6/3/2018 manual parse "content" field from json
        return null;
    }
}
