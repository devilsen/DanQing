package me.devilsen.danqing.achieve;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import me.devilsen.danqing.option.ImageOption;
import me.devilsen.danqing.option.ImageRequestBuilder;

/**
 * desc : glide 4.0+ 图片加载实现类
 * date : 2018/7/4
 *
 * @author : dongSen
 */
public class GlideAchieve implements IAchieve {

    @Override
    public void load(@NonNull ImageRequestBuilder requestBuilder) {
        RequestBuilder<Drawable> builder = Glide
                .with(requestBuilder.context)
                .load(requestBuilder.model);

        request(builder, requestBuilder.option);
    }

    @Override
    public void clear(@NonNull Context context, @NonNull View view) {
        Glide.with(context).clear(view);
    }

    @Override
    public void pauseRequests(@NonNull Context context) {
        Glide.with(context).pauseRequests();
    }

    @Override
    public void resumeRequests(@NonNull Context context) {
        Glide.with(context).resumeRequests();
    }

    private void request(@NonNull RequestBuilder requestBuilder, @NonNull ImageOption imageOption) {

        RequestOptions options = new RequestOptions();

        if (imageOption.thumbSizeMultiplier != 0)
            requestBuilder.thumbnail(imageOption.thumbSizeMultiplier);

        if (imageOption.placeholderDrawable != null)
            options.placeholder(imageOption.placeholderDrawable);

        if (imageOption.placeholderId != 0)
            options.placeholder(imageOption.placeholderId);

        if (imageOption.errorPlaceholder != null)
            options.error(imageOption.errorPlaceholder);

        if (imageOption.errorId != 0)
            options.error(imageOption.errorId);

        if (imageOption.overrideHeight != -1 && imageOption.overrideWidth != -1)
            options.override(imageOption.overrideWidth, imageOption.overrideHeight);

        if (imageOption.saveSource)
            options.diskCacheStrategy(DiskCacheStrategy.ALL);

        if (imageOption.centerCrop)
            options.centerCrop();

        if (imageOption.fitCenter)
            options.fitCenter();

        if (imageOption.highPriority)
            options.priority(Priority.HIGH);

        if (imageOption.lowPriority)
            options.priority(Priority.LOW);

        if (imageOption.format565)
            options.format(DecodeFormat.PREFER_RGB_565);

        requestBuilder.apply(options).into(imageOption.target);
    }


}
