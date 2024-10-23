package com.prodia_service.Model.http.request;

import com.prodia_service.Model.Effect;

public class RequestGenerate {
    private String imageUrl;
    private Effect effect;
    private int width;
    private int height;
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Effect getEffect() {
        return effect;
    }
    public void setEffect(Effect effect) {
        this.effect = effect;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    
}
