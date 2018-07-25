package me.devilsen.danqing;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import me.devilsen.danqing.option.ImageRequestManager;

/**
 * desc : 统一图片加载器
 * date : 2018/7/4
 *
 * @author : dongSen
 */
public class Danqing {

    @NonNull
    public static ImageRequestManager with(@NonNull Context context) {
        return getImageOption(context);
    }

    @NonNull
    public static ImageRequestManager with(@NonNull Activity activity) {
        return getImageOption(activity);
    }

    @NonNull
    public static ImageRequestManager with(@NonNull FragmentActivity activity) {
        return getImageOption(activity);
    }

    @NonNull
    public static ImageRequestManager with(@NonNull Fragment fragment) {
        return getImageOption(fragment.getActivity());
    }

    private static ImageRequestManager getImageOption(@Nullable Context context) {
        if (context == null) {
            throw new NullPointerException("You cannot start a load on a not yet attached View or a Fragment where getActivity() "
                    + "returns null (which usually occurs when getActivity() is called before the Fragment "
                    + "is attached or after the Fragment is destroyed).");
        }
        return new ImageRequestManager(context);
    }


}
