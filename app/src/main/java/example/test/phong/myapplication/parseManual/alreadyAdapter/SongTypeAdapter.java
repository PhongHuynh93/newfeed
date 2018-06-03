package example.test.phong.myapplication.parseManual.alreadyAdapter;

import android.text.TextUtils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import example.test.phong.myapplication.ParserUtil;

/**
 * Created by PhuongHoang on 6/10/16.
 */
public class SongTypeAdapter<T extends ZingSong> extends TypeAdapter<T> {

    @Override
    public void write(JsonWriter out, T value) throws IOException {

    }

    @Override
    public T read(JsonReader in) throws IOException {
        ZingSong song = new ZingSong();
        in.beginObject();
        while (in.hasNext()) {
            String name;
            name = in.nextName();
            if (ParserUtil.consumeNextNull(in))
                continue;
            parseSong(in, song, name);
        }
        in.endObject();
        return (T) song;
    }

    void parseSong(JsonReader in, ZingSong song, String name) throws IOException {
        switch (name) {
            case "id":
                song.setId(in.nextString());
                song.setZingId(song.getId());
                break;
            case "hasVideo":
                song.setHasVideo(in.nextBoolean());
                break;
            case "title":
                song.setTitle(in.nextString());
                break;
            case "artId":
                song.setArtistId(in.nextString());
                break;
            case "art":
                song.setArtist(ParserUtil.parseArtistName(in));
                break;
            case "lrc":
                song.setLrc(in.nextString());
                break;
            case "thumb":
//                ParserUtil.parseThumbAndSetBigThumb(in, Config.IMAGE_PREFIX_SONG, song);
                break;
            case "artAva":
//                song.setThumbnail(ParserUtil.parseThumb(in, Config.IMAGE_PREFIX_AVATAR));
                break;
            case "gId":
                song.setGenreId(in.nextString());
                break;
            case "gName":
                song.setGenre(ParserUtil.parseStringWithComma(in));
                break;
            case "createdTime":
                song.setReleaseDate(in.nextLong() * 1000);
                break;
            case "contentOwner":
                song.setContentOwner(in.nextString());
                break;
            case "link":
//                song.setLink(ParserUtil.parseLink(in));
                break;
            case "status":
                song.setStatus(in.nextInt());
                break;
            case "dwnStatus":
                song.setDownloadStatus(in.nextInt());
                break;
            case "streamingStatus":
                song.setStreamingStatus(in.nextInt());
                break;
            case "album":
                song.setAlbum(in.nextString());
                break;
            case "albumId":
                song.setAlbumId(in.nextString());
                break;
            case "hasDwnType":
                name = in.nextString();
                if (!TextUtils.isEmpty(name)) {
                    song.setHas64(name.contains("64"));
                    song.setHas320(name.contains("320"));
                    song.setHasLossless(name.contains("lossless"));
                }
                break;
            case "lrcId":
                song.setHasLyrics(!TextUtils.isEmpty(in.nextString()));
                break;
            case "isOfficial":
                song.setOfficial(in.nextBoolean());
                break;
            case "modifiedDate":
                song.setModifiedDate(in.nextLong() * 1000);
                break;
            case "adsDis":
                song.setNoAds(in.nextBoolean());
                break;
            default:
                in.skipValue();
                break;
        }
    }
}