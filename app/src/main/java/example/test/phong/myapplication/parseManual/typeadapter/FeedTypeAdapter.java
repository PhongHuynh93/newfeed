package example.test.phong.myapplication.parseManual.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import example.test.phong.myapplication.ParserUtil;
import example.test.phong.myapplication.parseManual.Feed;
import example.test.phong.myapplication.parseManual.FeedType;

public class FeedTypeAdapter extends TypeAdapter<Feed> {
    @Override
    public void write(JsonWriter out, Feed value) throws IOException {

    }

    @Override
    public Feed read(JsonReader in) throws IOException {
        // TODO: 6/3/2018 return which data type is Feed depend on the asset type
        Feed feed = new Feed();
        String name;
        FeedLinkTypeAdapter feedLinkTypeAdapter = new FeedLinkTypeAdapter();
        FeedSongTypeAdapter feedSongTypeAdapter = new FeedSongTypeAdapter();
        FeedVideoTypeAdapter feedVideoTypeAdapter = new FeedVideoTypeAdapter();
        FeedAlbumTypeAdapter feedAlbumTypeAdapter = new FeedAlbumTypeAdapter();
        in.beginObject();
        int type = -1;
        while (in.hasNext()) {
            name = in.nextName();
            if (ParserUtil.consumeNextNull(in))
                continue;
            switch (name) {
                case "type":
                    type = in.nextInt();
                    break;
                case "content":
                    in.beginObject();
                    while (in.hasNext()) {
                        name = in.nextName();
                        if (ParserUtil.consumeNextNull(in))
                            continue;
                        switch (name) {
                            case "assetType":
                                // FIXME: 6/3/2018 very wrong here
                                FeedType feedType;
                                int assetType = in.nextInt();
                                if (type == FeedType.TYPE_LINK) {
                                    in.beginObject();
                                    feed.content = feedLinkTypeAdapter.read(in);
                                    in.endObject();
                                } else {
                                    switch (assetType) {
                                        case FeedType.TYPE_SONG:
                                            in.beginObject();
                                            feed.content = feedSongTypeAdapter.read(in);
                                            in.endObject();
                                            break;
                                        case FeedType.TYPE_ALBUM:
                                            in.beginObject();
                                            feed.content = feedAlbumTypeAdapter.read(in);
                                            in.endObject();
                                            break;
                                        case FeedType.TYPE_VIDEO:
                                            in.beginObject();
                                            feed.content = feedVideoTypeAdapter.read(in);
                                            in.endObject();
                                            break;
                                    }
                                }
                                break;
                            default:
                                in.skipValue();
                                break;
                        }
                    }
                    in.endObject();
                    break;
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();
        return feed;
    }
}
