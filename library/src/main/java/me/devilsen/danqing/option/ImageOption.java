package me.devilsen.danqing.option;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * desc : 图片加载选项
 * date : 2018/7/5
 *
 * @author : dongSen
 */
public class ImageOption {

    public ImageView target;

    @Nullable
    public Drawable errorPlaceholder;
    public int errorId;
    @Nullable
    public Drawable placeholderDrawable;
    public int placeholderId;

    public int overrideHeight = -1;
    public int overrideWidth = -1;

    public float thumbSizeMultiplier;
    public boolean saveSource;

    public boolean centerCrop;
    public boolean fitCenter;

    public boolean highPriority;
    public boolean lowPriority;

    public boolean format565;
}
