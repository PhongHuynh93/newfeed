package example.test.phong.myapplication;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.test.phong.myapplication.parseManual.Feed;
import example.test.phong.myapplication.parseManual.FeedType;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {


    private static final DiffUtil.ItemCallback<Feed> DIFF_CALLBACK = new DiffUtil.ItemCallback<Feed>() {
        @Override
        public boolean areItemsTheSame(Feed oldItem, Feed newItem) {
            return oldItem.id == newItem.id;
        }

        // items if have the same Id always have the same content -> always return true here
        @Override
        public boolean areContentsTheSame(Feed oldItem, Feed newItem) {
            return true;
        }
    };
    private final AsyncListDiffer<Feed> mDiffer = new AsyncListDiffer<>(this, DIFF_CALLBACK);

    public FeedAdapter() {
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case FeedType.TYPE_LINK:
                return LinkFeedVH.newInstance(parent);
            case FeedType.TYPE_SONG:
                return SongFeedVH.newInstance(parent);
            case FeedType.TYPE_VIDEO:
                return SongFeedVH.newInstance(parent);
            case FeedType.TYPE_ALBUM:
                return SongFeedVH.newInstance(parent);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDiffer.getCurrentList().size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDiffer.getCurrentList().get(position).content.getFeedType();
    }

    @Override
    public long getItemId(int position) {
        return mDiffer.getCurrentList().get(position).id;
    }

    public void submitList(List<Feed> list) {
        mDiffer.submitList(list);
    }

    public static abstract class FeedViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImgvHeader;
        private final TextView mTvHeader;
        private final TextView mTvSubHeader;

        public FeedViewHolder(View itemView) {
            super(itemView);
            mImgvHeader = (ImageView) itemView.findViewById(R.id.imgvHeader);
            mTvHeader = (TextView) itemView.findViewById(R.id.tvHeader);
            mTvSubHeader = (TextView) itemView.findViewById(R.id.tvSubHeader);
        }

        public void bindHeader() {

        }

        public abstract void bindContent();
    }

    private static class LinkFeedVH extends FeedViewHolder {
        private final ImageView mImgvContent;
        private final TextView mTvContent;

        public LinkFeedVH(View itemView) {
            super(itemView);
            mImgvContent = (ImageView) itemView.findViewById(R.id.imgvContent);
            mTvContent = (TextView) itemView.findViewById(R.id.tvContent);
        }

        @Override
        public void bindContent() {

        }

        public static FeedViewHolder newInstance(ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.feed_link_item, parent, false);
            return new LinkFeedVH(itemView);
        }
    }

    private static class SongFeedVH extends FeedViewHolder {
        private final ImageView mImgvContent;
        private final TextView mTvContent;
        private final ConstraintLayout mainLayout;
        private final ConstraintSet collapsedConstraints = new ConstraintSet();
        private final ConstraintSet expandedConstraints = new ConstraintSet();
        private boolean expanded = false;
        private int mCollapsedHeight;

        private View.OnTouchListener touchIgnorer = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        };

        // TODO: 6/3/2018 this have the constraintlayout to expand when click viewmore
        public SongFeedVH(final View itemView) {
            super(itemView);
            mainLayout = (ConstraintLayout) itemView;
            mImgvContent = (ImageView) itemView.findViewById(R.id.imgvContent);
            mTvContent = (TextView) itemView.findViewById(R.id.tvContent);

            mTvContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mTvContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    mCollapsedHeight = mTvContent.getHeight(); //height is ready
                }
            });
            collapsedConstraints.clone(mainLayout);
            expandedConstraints.clone(mainLayout.getContext(), R.layout.feed_song_item_expanded);
            // TODO: 6/3/2018 only set clickable when the text is over 3 lines
            mTvContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // because the transition of the textview change the height of the rcv -> need to run transition on the rcv
                    // while the transition is running, disable touch to prevent bugs in bound.
                    final RecyclerView parent = (RecyclerView) itemView.getParent();
                    final Transition transition = TransitionInflater.from(itemView.getContext())
                            .inflateTransition(expanded ? R.transition.feed_song_collapse : R.transition.feed_song_expand);
                    parent.setOnTouchListener(touchIgnorer);
                    mTvContent.setOnTouchListener(touchIgnorer);
                    transition.addListener(new TransitionListenerAdapter() {
                        @Override
                        public void onTransitionEnd(@NonNull Transition transition) {
                            mTvContent.setOnTouchListener(null);
                            parent.setOnTouchListener(null);
                        }
                    });
                    TransitionManager.beginDelayedTransition(parent, transition);
                    flipExpand();
                    // after changing the transition -> bind the view again
                    bindContent();
                }
            });
        }

        private void flipExpand() {
            expanded = !expanded;
        }

        @Override
        public void bindContent() {
            // TODO: 6/3/2018 check the content if already in expand state -> not do anything
            // should put another expanded in Item class

            // seem like constraintset doesn't care the attributes besides size like maxlines, ellipsed, so we have to manually set here
            if (expanded) {
                // reset the maxlines
                mTvContent.setMaxLines(50);
                expandedConstraints.applyTo(mainLayout);
            } else {
                // reset the height that only contains maxLines when collapsed
                // seem like we can't set maxLine(3) here but setHeight() works
                mTvContent.setHeight(mCollapsedHeight);
                collapsedConstraints.applyTo(mainLayout);
            }
            mTvContent.setText("Em từng là duy nhất  Là cả khoảng trời trong anh  Nhưng đến bây giờ anh vẫn như vậy  Chỉ là cần một khoảng trống  Yêu chậm lại một chút  Để biết ta cần nhau hơn  Anh cũng rất sợ ta phải xa nhau  Nhưng tình yêu không như lúc trước  Đừng để thời gian bên nhau là thói quen  Là ở cạnh bên nhưng rất xa xôi  Từng ngày cảm giác trong tim cứ thế phai đi  Lạc nhau ta đâu có hay ");
        }

        public static FeedViewHolder newInstance(ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.feed_song_item_collapsed, parent, false);
            return new SongFeedVH(itemView);
        }
    }
}
