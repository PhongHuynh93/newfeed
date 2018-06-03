package example.test.phong.myapplication.parseManual;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PhuongHoang on 6/2/16.
 */
public class RestResponse<T> {
    @SerializedName("err")
    private int mCode;
    @SerializedName("result")
    private boolean mResult = true;    // use for search suggestion api.
    @SerializedName("msg")
    private String mMessage;
    @SerializedName("data")
    private T mData;

    public int getCode() {
        return !mResult ? 500 : mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }
}
