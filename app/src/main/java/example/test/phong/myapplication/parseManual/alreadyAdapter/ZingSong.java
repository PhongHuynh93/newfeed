package example.test.phong.myapplication.parseManual.alreadyAdapter;

import android.content.ContentUris;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by PhuongHoang on 5/26/16.
 */
public class ZingSong extends ZingBase {
    private static final Uri LOCAL_ALBUM_ART_URI = Uri.parse("content://media/external/audio/albumart");
    private String mLocalPath;
    private int mLocalBitRate;
    private String mZingId; //for offline song mId is local id, this field is for online id
    private String mArtist;
    private String mArtistId;
    private String mArtistThumbnail;
    private String mAlbum;
    private String mAlbumId;
    private String mAlbumThumbnail;

    private String mGenre;
    private String mGenreId;
    private String mContentOwner;
    private long mReleaseDate;

    private String mLrc;
    private boolean mHasLyrics;

    private boolean mFav;
    private boolean mHasVideo;
    private boolean mHas64;
    private boolean mHas320;
    private boolean mHasLossless;

    private int mStatus;
    private int mDownloadStatus;
    private int mStreamingStatus = StreamingStatus.ENABLE;
    private long mUpdateTime;

    private boolean mIsOfficial;

    private boolean mIsDownloadedSong;

    private long mModifiedDate;
    private boolean mNoAds;

    // for tracking only
    private String mPId;

    @Override
    public String getId() {
        if (!TextUtils.isEmpty(super.getId()))
            return super.getId();
        return getZingId();
    }

    public String getZingId(String defValue) {
        return getZingId() == null ? defValue : getZingId();
    }

    public String getZingId() {
        return mZingId;
    }

    public void setZingId(String zingId) {
        mZingId = zingId;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public String getArtistId() {
        return mArtistId;
    }

    public void setArtistId(String artistId) {
        mArtistId = artistId;
    }

    public String getFirstArtistId() {
        if (mArtistId != null && mArtistId.contains(","))
            return mArtistId.split(",")[0];
        return mArtistId;
    }

    public String getArtistThumbnail() {
        return mArtistThumbnail;
    }

    public void setArtistThumbnail(String artistThumbnail) {
        mArtistThumbnail = artistThumbnail;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public void setAlbum(String album) {
        mAlbum = album;
    }

    public String getAlbumId() {
        return mAlbumId;
    }

    public String getFirstAlbumId() {
        if (mAlbumId != null && mAlbumId.contains(","))
            return mAlbumId.split(",")[0];
        return mAlbumId;
    }

    public void setAlbumId(String albumId) {
        mAlbumId = albumId;
    }

    public String getAlbumThumbnail() {
        return mAlbumThumbnail;
    }

    public void setAlbumThumbnail(String albumThumbnail) {
        mAlbumThumbnail = albumThumbnail;
    }

    public String getGenreId() {
        return mGenreId;
    }

    public void setGenreId(String genreId) {
        mGenreId = genreId;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public String getContentOwner() {
        return mContentOwner;
    }

    public void setContentOwner(String contentOwner) {
        mContentOwner = contentOwner;
    }

    public long getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getLocalPath() {
        return mLocalPath;
    }

    public void setLocalPath(String localPath) {
        mLocalPath = localPath;
    }

    public int getLocalBitRate() {
        return mLocalBitRate;
    }

    public void setLocalBitRate(int bitRate) {
        mLocalBitRate = bitRate;
    }

    public boolean isLocalHq() {
        return mLocalBitRate >= 250000;
    }

    /**
     * @return true if this song is local or downloaded song
     */
    public boolean isLocalSong() {
        return !TextUtils.isEmpty(mLocalPath);
    }

    public String getLrc() {
        return mLrc;
    }

    public void setLrc(String lrcPath) {
        mLrc = lrcPath;
    }

    public boolean hasLyrics() {
        return mHasLyrics;
    }

    public void setHasLyrics(boolean hasLyrics) {
        mHasLyrics = hasLyrics;
    }

    public boolean isFav() {
        return mFav;
    }

    public void setFav(boolean fav) {
        mFav = fav;
    }

    public boolean hasVideo() {
        return mHasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        mHasVideo = hasVideo;
    }

    public boolean has64() {
        return mHas64;
    }

    public void setHas64(boolean has64) {
        mHas64 = has64;
    }

    public boolean has320() {
        return mHas320;
    }

    public void setHas320(boolean has320) {
        mHas320 = has320;
    }

    public boolean hasLossless() {
        return mHasLossless;
    }

    public void setHasLossless(boolean hasLossless) {
        mHasLossless = hasLossless;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public int getDownloadStatus() {
        return mDownloadStatus;
    }

    public void setDownloadStatus(int status) {
        mDownloadStatus = status;
    }

    public int getStreamingStatus() {
        return mStreamingStatus;
    }

    public void setStreamingStatus(int status) {
        mStreamingStatus = status;
    }

    public long getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        mUpdateTime = updateTime;
    }

    public boolean isDownloadedSong() {
        return mIsDownloadedSong;
    }

    public void setDownloadedSong(boolean downloadedSong) {
        mIsDownloadedSong = downloadedSong;
    }

    public boolean isZingSong() {
        return !isLocalSong() || isDownloadedSong();
    }

    public boolean isStreamingEnable(boolean isVip, boolean inVn) {
        switch (mStreamingStatus) {
            case StreamingStatus.DISABLE:
                return false;
            case StreamingStatus.ENABLE:
                return true;
            case StreamingStatus.VIP:
                if (isVip)
                    return true;
                break;
            case StreamingStatus.VN:
                if (inVn)
                    return true;
                break;
            case StreamingStatus.VN_VIP:
                if (isVip && inVn)
                    return true;
                break;
            default:
                return true;
        }
        return false;
    }

    public boolean isOfficial() {
        return mIsOfficial;
    }

    public void setOfficial(boolean official) {
        mIsOfficial = official;
    }

    public long getModifiedDate() {
        return mModifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        mModifiedDate = modifiedDate;
    }

    public boolean isNoAds() {
        return mNoAds;
    }

    public void setNoAds(boolean noAds) {
        mNoAds = noAds;
    }

    public Uri getLocalAlbumArtUri() {
        if (TextUtils.isEmpty(mAlbumId) || !TextUtils.isDigitsOnly(mAlbumId))
            return null;
        return ContentUris.withAppendedId(LOCAL_ALBUM_ART_URI, Integer.parseInt(mAlbumId));
    }

    public String getPId() {
        return mPId;
    }

    public void setPId(String pId) {
        mPId = pId;
    }

    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("id", getId());
            jo.put("title", getTitle());
            jo.put("artist", getArtist());
            jo.put("albumId", getAlbumId());
            jo.put("artistId", getArtistId());
            jo.put("thumbnail", getThumbnail());
            jo.put("bigThumbnail", getBigThumbnail());
            jo.put("isDownloaded", isDownloadedSong());
            jo.put("link", getLink());
            jo.put("lrcPath", getLrc());
            jo.put("hasVideo", hasVideo());
            jo.put("official", isOfficial());
            jo.put("localPath", getLocalPath());
            jo.put("localBitRate", getLocalBitRate());
            jo.put("noAds", isNoAds());
        } catch (JSONException e) {
        }
        return jo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getClass().getName());
        super.writeToParcel(dest, flags);
        dest.writeString(this.mZingId);
        dest.writeString(this.mArtist);
        dest.writeString(this.mArtistId);
        dest.writeString(this.mArtistThumbnail);
        dest.writeString(this.mAlbum);
        dest.writeString(this.mAlbumId);
        dest.writeString(this.mAlbumThumbnail);
        dest.writeString(this.mGenre);
        dest.writeString(this.mGenreId);
        dest.writeString(this.mContentOwner);
        dest.writeLong(this.mReleaseDate);
        dest.writeString(this.mLocalPath);
        dest.writeInt(this.mLocalBitRate);
        dest.writeString(this.mLrc);
        writeBoolean(dest, mHasLyrics);
        writeBoolean(dest, mFav);
        writeBoolean(dest, mHasVideo);
        writeBoolean(dest, mHas64);
        writeBoolean(dest, mHas320);
        writeBoolean(dest, mHasLossless);
        dest.writeInt(this.mStatus);
        dest.writeInt(this.mDownloadStatus);
        dest.writeInt(this.mStreamingStatus);
        dest.writeLong(this.mUpdateTime);
        writeBoolean(dest, this.mIsOfficial);
        writeBoolean(dest, this.mIsDownloadedSong);
        dest.writeLong(this.mModifiedDate);
        writeBoolean(dest, this.mNoAds);
        dest.writeString(this.mPId);
    }

    public ZingSong() {
    }

    public ZingSong(String id) {
        setId(id);
    }

    public ZingSong(JSONObject jo) {
        try {
            if (jo.has("id"))
                setId(jo.getString("id"));
            if (jo.has("title"))
                setTitle(jo.getString("title"));
            if (jo.has("artist"))
                setArtist(jo.getString("artist"));
            if (jo.has("albumId"))
                setAlbumId(jo.getString("albumId"));
            if (jo.has("artistId"))
                setArtistId(jo.getString("artistId"));
            if (jo.has("thumbnail"))
                setThumbnail(jo.getString("thumbnail"));
            if (jo.has("bigThumbnail"))
                setBigThumbnail(jo.getString("bigThumbnail"));
            if (jo.has("isDownloaded"))
                setDownloadedSong(jo.getBoolean("isDownloaded"));
            if (jo.has("link"))
                setLink(jo.getString("link"));
            if (jo.has("lrcPath"))
                setLrc(jo.getString("lrcPath"));
            if (jo.has("hasVideo"))
                setHasVideo(jo.getBoolean("hasVideo"));
            if (jo.has("official"))
                setOfficial(jo.getBoolean("official"));
            if (jo.has("localPath"))
                setLocalPath(jo.getString("localPath"));
            if (jo.has("localBitRate"))
                setLocalBitRate(jo.getInt("localBitRate"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected ZingSong(Parcel in) {
        super(in);
        this.mZingId = in.readString();
        this.mArtist = in.readString();
        this.mArtistId = in.readString();
        this.mArtistThumbnail = in.readString();
        this.mAlbum = in.readString();
        this.mAlbumId = in.readString();
        this.mAlbumThumbnail = in.readString();
        this.mGenre = in.readString();
        this.mGenreId = in.readString();
        this.mContentOwner = in.readString();
        this.mReleaseDate = in.readLong();
        this.mLocalPath = in.readString();
        this.mLocalBitRate = in.readInt();
        this.mLrc = in.readString();
        this.mHasLyrics = readBoolean(in);
        this.mFav = readBoolean(in);
        this.mHasVideo = readBoolean(in);
        this.mHas64 = readBoolean(in);
        this.mHas320 = readBoolean(in);
        this.mHasLossless = readBoolean(in);
        this.mStatus = in.readInt();
        this.mDownloadStatus = in.readInt();
        this.mStreamingStatus = in.readInt();
        this.mUpdateTime = in.readLong();
        this.mIsOfficial = readBoolean(in);
        this.mIsDownloadedSong = readBoolean(in);
        this.mModifiedDate = in.readLong();
        this.mNoAds = readBoolean(in);
        this.mPId = in.readString();
    }


    @Override
    public String toString() {
        return String.format("%s[id=%s, title=%s, artist=%s, hash=%s], ", getClass().getSimpleName(), getId(), getTitle(), getArtist(),
                Integer.toHexString(hashCode()));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof ZingSong))
            return false;
        ZingSong toCpr = (ZingSong) o;
        if (isLocalSong()) {
            if (!TextUtils.isEmpty(this.getLocalPath()) && !TextUtils.isEmpty(toCpr.getLocalPath()) && this.getLocalPath().equals(toCpr
                    .getLocalPath()))
                return true;
        }
        if (this.getId().equals(toCpr.getId()) && TextUtils.equals(this.getSource(), toCpr.getSource()))
            return true;
        return false;
    }

    public static class DownloadStatus {
        public static final int DISABLE = 0;
        public static final int ENABLE = 1;
        public static final int VIP = 2;
        public static final int VN = 3;
        public static final int VN_VIP = 4;
    }

    public static class Status {
        public static final int ACTIVE = 1;
    }

    public static class StreamingStatus {
        public static final int DISABLE = 0;
        public static final int ENABLE = 1;
        public static final int VIP = 2;
        public static final int VN = 3;
        public static final int VN_VIP = 4;
    }
}
