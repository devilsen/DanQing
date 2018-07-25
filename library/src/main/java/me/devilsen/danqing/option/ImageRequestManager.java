package me.devilsen.danqing.option;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.io.File;
import java.net.URL;

import me.devilsen.danqing.achieve.AchieveProvider;

/**
 * desc : 美事图片加载管理器
 * date : 2018/7/4
 *
 * @author : dongSen
 */
public class ImageRequestManager implements ModelTypes<ImageRequestBuilder> {

    private Context context;

    public ImageRequestManager(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ImageRequestBuilder<Bitmap> load(@Nullable Bitmap bitmap) {
        return new ImageRequestBuilder<Bitmap>(context).load(bitmap);
    }

    @NonNull
    @Override
    public ImageRequestBuilder load(@Nullable Drawable drawable) {
        return new ImageRequestBuilder<Drawable>(context).load(drawable);
    }

    @NonNull
    @Override
    public ImageRequestBuilder load(@Nullable String string) {
        return new ImageRequestBuilder<String>(context).load(string);
    }

    @NonNull
    @Override
    public ImageRequestBuilder load(@Nullable Uri uri) {
        return new ImageRequestBuilder<Uri>(context).load(uri);
    }

    @NonNull
    @Override
    public ImageRequestBuilder load(@Nullable File file) {
        return new ImageRequestBuilder<File>(context).load(file);
    }

    @NonNull
    @Override
    public ImageRequestBuilder load(@Nullable Integer resourceId) {
        return new ImageRequestBuilder<Integer>(context).load(resourceId);
    }

    @Override
    public ImageRequestBuilder load(@Nullable URL url) {
        return new ImageRequestBuilder<URL>(context).load(url);
    }

    @NonNull
    @Override
    public ImageRequestBuilder load(@Nullable byte[] model) {
        return new ImageRequestBuilder<byte[]>(context).load(model);
    }

    @NonNull
    @Override
    public ImageRequestBuilder load(@Nullable Object model) {
        return new ImageRequestBuilder<>(context).load(model);
    }

    public void clear(ImageView view) {
        AchieveProvider.getInstance().getAchiever().clear(context, view);
    }

    public void pauseRequests() {
        AchieveProvider.getInstance().getAchiever().pauseRequests(context);
    }

    public void resumeRequests() {
        AchieveProvider.getInstance().getAchiever().resumeRequests(context);
    }

}
