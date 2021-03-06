package com.dexafree.materialList.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public abstract class Card {

    private String title;
    private String description;
    private Bitmap bitmap;
    private boolean canDismiss = true;

    public Card(){}

    public Card(String title, String description, Bitmap bitmap) {
        this.title = title;
        this.description = description;
        this.bitmap = bitmap;
    }

    public Card(String title, String description, int resourceId) {
        this.title = title;
        this.description = description;
        this.bitmap = resourceToBitmap(resourceId);
    }

    public Card(String title, String description, Drawable drawable) {
        this.title = title;
        this.description = description;
        this.bitmap = drawableToBitmap(drawable);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setBitmap(int resourceId){
        bitmap = resourceToBitmap(resourceId);
    }

    public void setBitmap(Drawable drawable){
        bitmap = drawableToBitmap(drawable);
    }

    private Bitmap resourceToBitmap (int resourceId){
        return BitmapFactory.decodeResource(Resources.getSystem(), resourceId);
    }

    private Bitmap drawableToBitmap (Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public boolean canDismiss() {
        return canDismiss;
    }

    public void setCanDismiss(boolean canDismiss) {
        this.canDismiss = canDismiss;
    }

    public abstract int getLayout();


}
