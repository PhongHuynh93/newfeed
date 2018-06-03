package example.test.phong.myapplication.parseManual;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhuongHoang on 7/1/16.
 */
// TODO: 6/3/2018 why zibalist implement Parcelable????
public class ZibaListFeed<T> {
    @SerializedName("total")
    private int mTotal;
    @SerializedName("items")
    private List<T> mList;
    @SerializedName("lastIndex")
    private int mLastIndex;
    @SerializedName("isMore")
    private boolean mIsMore;
    @SerializedName("likedIds")
    public List<Integer> likedIds = null;

    public int getTotal() {
        return mTotal;
    }

    public List<T> getList() {
        return mList;
    }

    public void setList(ArrayList<T> list) {
        mList = list;
    }

    public void add(T t) {
        if (mList == null)
            mList = new ArrayList<>();
        mList.add(t);
        if (mTotal < mList.size())
            mTotal = mList.size();
    }

    public int size() {
        return mList == null ? 0 : mList.size();
    }

    public int getLastIndex() {
        return mLastIndex;
    }

    public boolean isMore() {
        return mIsMore;
    }

    public void setMore(boolean more) {
        mIsMore = more;
    }

    public void setLastIndex(int lastIndex) {
        mLastIndex = lastIndex;
    }

    public void setTotal(int total) {

    }

    public ZibaListFeed() {
    }
}
