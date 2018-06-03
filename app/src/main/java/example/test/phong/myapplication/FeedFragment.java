package example.test.phong.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;

import example.test.phong.myapplication.parseManual.Feed;
import example.test.phong.myapplication.parseManual.RestResponse;
import example.test.phong.myapplication.parseManual.ZibaListFeed;
import example.test.phong.myapplication.parseManual.typeadapter.FeedTypeAdapter;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment implements FeedContract.View {
    private FeedContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private FeedAdapter mFeedAdapter;

    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void setPresenter(FeedContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View header = view.findViewById(R.id.header_anim);
//        if (header instanceof ImageView) {
//            AnimatedVectorDrawable avd = (AnimatedVectorDrawable) ContextCompat.getDrawable(
//                    getContext(), R.drawable.avd_header_feed);
//            ((ImageView) header).setImageDrawable(avd);
//            avd.start();
//        }

        RestResponse<ZibaListFeed<Feed>> feedResponse = parseJson(loadJSONFromAsset(getContext()));
        Log.e("Test", "json getting trong assets " + feedResponse);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.feed_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mFeedAdapter = new FeedAdapter();
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
        mRecyclerView.setAdapter(mFeedAdapter);

        // triple the datas
//        List<Item> itemList = new ArrayList<>(feedResponse.data.items);
//        itemList.addAll(feedResponse.data.items);
//        itemList.addAll(feedResponse.data.items);
//        itemList.addAll(feedResponse.data.items);
        mFeedAdapter.submitList(feedResponse.getData().getList());
    }

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("temp.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private RestResponse<ZibaListFeed<Feed>> parseJson(String json) {
        final GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(Feed.class, new FeedTypeAdapter());
        Gson gson = gb.create();
        return gson.fromJson(json, new TypeToken<RestResponse<ZibaListFeed<Feed>>>(){}.getType());
    }
}
