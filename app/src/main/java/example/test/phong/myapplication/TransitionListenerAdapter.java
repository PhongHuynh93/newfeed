package example.test.phong.myapplication;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.transition.Transition;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class TransitionListenerAdapter implements Transition.TransitionListener {
    @Override
    public void onTransitionStart(@NonNull Transition transition) {

    }

    @Override
    public void onTransitionEnd(@NonNull Transition transition) {

    }

    @Override
    public void onTransitionCancel(@NonNull Transition transition) {

    }

    @Override
    public void onTransitionPause(@NonNull Transition transition) {

    }

    @Override
    public void onTransitionResume(@NonNull Transition transition) {

    }
}
