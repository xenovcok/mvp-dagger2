package com.bmt.zicreative.maidas.booking;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created By Herwin DJ on 10/26/2018
 **/

@GlideModule
public class MaidasGlideModule extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        int bitmapPoolSizeBytes = 1024 * 1024 * 30; // 30mb
        builder.setBitmapPool(new LruBitmapPool(bitmapPoolSizeBytes));
    }
}
