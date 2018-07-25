package me.devilsen.danqing.achieve;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import me.devilsen.danqing.option.ImageRequestBuilder;

/**
 * desc :
 * date : 2018/7/4
 *
 * @author : dongSen
 */
public interface IAchieve {

    void load(@NonNull ImageRequestBuilder requestBuilder);

    void clear(@NonNull Context context, @NonNull View view);

    void pauseRequests(@NonNull Context context);

    void resumeRequests(@NonNull Context context);
}
