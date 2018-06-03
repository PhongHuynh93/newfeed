package example.test.phong.myapplication.parseManual.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import example.test.phong.myapplication.parseManual.FeedVideo;


public class FeedVideoTypeAdapter extends TypeAdapter<FeedVideo> {
    @Override
    public void write(JsonWriter out, FeedVideo value) throws IOException {

    }

    @Override
    public FeedVideo read(JsonReader in) throws IOException {
        return null;
    }
}
