package example.test.phong.myapplication.parseManual.alreadyAdapter;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by PhuongHoang on 5/26/16.
 */
public class ZingBase implements Parcelable {
    private String mId;
    private String mTitle;
    private String mThumbnail;
    private String mBigThumbnail;
    private String mDescription;
    private String mLink;
    private boolean mVnOnly;

    private String mSource;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getBigThumbnail() {
        if (!TextUtils.isEmpty(mBigThumbnail))
            return mBigThumbnail;
        return mThumbnail;
    }

    public String getActualBigThumbnail() {
        return mBigThumbnail;
    }

    public void setBigThumbnail(String bigThumbnail) {
        mBigThumbnail = bigThumbnail;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public boolean isVnOnly() {
        return mVnOnly;
    }

    public void setVnOnly(boolean vnOnly) {
        mVnOnly = vnOnly;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mId);
        dest.writeString(this.mTitle);
        dest.writeString(this.mThumbnail);
        dest.writeString(this.mBigThumbnail);
        dest.writeString(this.mDescription);
        dest.writeString(this.mLink);
        dest.writeByte(this.mVnOnly ? (byte) 1 : (byte) 0);
        dest.writeString(this.mSource);
    }

    public ZingBase() {
    }

    protected ZingBase(Parcel in) {
        this.mId = in.readString();
        this.mTitle = in.readString();
        this.mThumbnail = in.readString();
        this.mBigThumbnail = in.readString();
        this.mDescription = in.readString();
        this.mLink = in.readString();
        this.mVnOnly = in.readByte() != 0;
        this.mSource = in.readString();
    }

    public static final Creator<ZingBase> CREATOR = new Creator<ZingBase>() {
        @Override
        public ZingBase createFromParcel(Parcel source) {
            return new ZingBase(source);
        }

        @Override
        public ZingBase[] newArray(int size) {
            return new ZingBase[size];
        }
    };

    protected void writeBoolean(Parcel dest, boolean value) {
        dest.writeByte(value ? (byte) 1 : (byte) 0);
    }

    protected boolean readBoolean(Parcel in) {
        return in.readByte() != 0;
    }

    @Override
    public String toString() {
        return String.format("ZingBase[id=%s, title=%s]", mId, mTitle);
    }
}
