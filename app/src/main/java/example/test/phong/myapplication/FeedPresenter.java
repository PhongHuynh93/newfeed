package example.test.phong.myapplication;

class FeedPresenter implements FeedContract.Presenter{
    private final FeedContract.View mView;

    public FeedPresenter(FeedContract.View view) {
        mView = view;
    }
}
