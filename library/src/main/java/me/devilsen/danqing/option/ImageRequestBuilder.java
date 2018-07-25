package me.devilsen.danqing.option;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import me.devilsen.danqing.achieve.AchieveProvider;

/**
 * desc :
 * date : 2018/7/4
 *
 * @author : dongSen
 */
public class ImageRequestBuilder<ModelType> {

    public final Context context;
    public ImageOption option;
    public ModelType model;

    ImageRequestBuilder(Context context) {
        this.context = context;
        option = new ImageOption();
    }

    @NonNull
    ImageRequestBuilder<ModelType> load(@Nullable ModelType model) {
        this.model = model;
        return this;
    }

    public ImageRequestBuilder<ModelType> placeholder(@Nullable Drawable drawable) {
        option.placeholderDrawable = drawable;
        return this;
    }

    public ImageRequestBuilder<ModelType> placeholder(@DrawableRes int resourceId) {
        option.placeholderId = resourceId;
        return this;
    }

    public ImageRequestBuilder<ModelType> error(@Nullable Drawable drawable) {
        option.errorPlaceholder = drawable;
        return this;
    }

    public ImageRequestBuilder<ModelType> error(@DrawableRes int resourceId) {
        option.errorId = resourceId;
        return this;
    }

    public ImageRequestBuilder<ModelType> thumbnail(float sizeMultiplier) {
        option.thumbSizeMultiplier = sizeMultiplier;
        return this;
    }

    public ImageRequestBuilder<ModelType> override(int width, int height) {
        option.overrideWidth = width;
        option.overrideHeight = height;
        return this;
    }

    /**
     * 是否保存原图,Glide默认只保存ImageView尺寸的图片
     */
    public ImageRequestBuilder<ModelType> saveSource() {
        option.saveSource = true;
        return this;
    }

    public ImageRequestBuilder<ModelType> setHighPriority() {
        option.highPriority = true;
        return this;
    }

    public ImageRequestBuilder<ModelType> setLowPriority() {
        option.lowPriority = true;
        return this;
    }

    public ImageRequestBuilder<ModelType> centerCrop() {
        option.centerCrop = true;
        return this;
    }

    public ImageRequestBuilder<ModelType> fitCenter() {
        option.fitCenter = true;
        return this;
    }

    public ImageRequestBuilder<ModelType> format565() {
        option.format565 = true;
        return this;
    }

    /**
     * apply如果用在最后，会覆盖之前的属性
     */
    public ImageRequestBuilder apply(ImageOption option) {
        this.option = option;
        return this;
    }

    public void into(@Nullable ImageView imageView) {
        if (imageView == null) {
            throw new NullPointerException("Argument must not be null");
        }

        option.target = imageView;

        AchieveProvider.getInstance().getAchiever().load(this);
    }

}
