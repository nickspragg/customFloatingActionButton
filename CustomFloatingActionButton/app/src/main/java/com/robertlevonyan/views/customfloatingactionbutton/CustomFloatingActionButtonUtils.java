package com.robertlevonyan.views.customfloatingactionbutton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/**
 * Created by robert on 3/1/2017.
 */

class CustomFloatingActionButtonUtils {

    public static final int FAB_ID = 0x0000180591;
    public static final int FAB_ICON_ID = 0x0000911805;

    static Drawable setDrawableColor(Drawable icon, int color) {
        if (icon == null) {
            return null;
        }
        icon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        return icon;
    }

    static Drawable resize(Context context, Drawable image) {
        if( image instanceof BitmapDrawable) {
            Bitmap b = ((BitmapDrawable) image).getBitmap();
            Bitmap bitmapResized = Bitmap.createScaledBitmap(b, (int) context.getResources().getDimension(R.dimen.fab_icon_size), (int) context.getResources().getDimension(R.dimen.fab_icon_size), false);
            return new BitmapDrawable(context.getResources(), bitmapResized);
        }
        if( image instanceof VectorDrawable) {
            (image).setBounds(0,0,(int) context.getResources().getDimension(R.dimen.fab_icon_size),(int) context.getResources().getDimension(R.dimen.fab_icon_size));
            return image;
        }
        return image;
    }

}
