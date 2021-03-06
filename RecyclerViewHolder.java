package com.maximej.tools.ui.viewholder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @author Maxime Jallu
 * @since 30/06/2016
 *
 * Create for CubeInStore - Android 
 *
 * Use this Class for : <br/>
 * make it easier ViewHolder adapter recyclerView, define T type of item
 * Must to use in ArrayRecyclerAdapter
 * @link ArrayRecyclerAdapter
 *
 * Tools this class:<br/>
 *
 * getContext()
 * getColor(@ColorRes res)
 * getDrawable(@DrawableRes res)
 */
public abstract class RecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    /**
     * This super() auto BindViews with ButterKnife<br/>
     *  <code>
     *      ButterKnife.bind(this, itemView);
     *  </code>
     * @param itemView the Views holder
     */
    @SuppressLint("NewApi")
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(final T item);

    public Context getContext() {
        return itemView.getContext();
    }

    public final String getString(@StringRes int stringRes){
        return getContext().getString(stringRes);
    }

    public final String getQuantityString(@PluralsRes int pluralRes, int quantity){
        return getContext().getResources().getQuantityString(pluralRes, quantity);
    }

    public final String getQuantityStringFormat(@PluralsRes int pluralRes, int quantity){
        return getContext().getResources().getQuantityString(pluralRes, quantity, quantity);
    }

    public final int getColor(@ColorRes int colorResId){
        return ContextCompat.getColor(getContext(), colorResId);
    }

    public final Drawable getDrawable(@DrawableRes int drawableResId){
        return ContextCompat.getDrawable(getContext(), drawableResId);
    }
}
