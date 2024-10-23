package com.prodia_service.Model.http.request;

public class RequestProdia {
    private String imageUrl;           // 0
    private String model;              // 1
    private String prompt;             // 2
    private Double denoising_strength;  // 3
    private String style_preset;         // 4
    private int steps;                 // 5
    private int cfg_scale;              // 6
    private int seed;                  // 7
    private boolean upscale;            // 8
    private String sampler;            // 9
    private int width;                 // 10
    private int height;      

    public RequestProdia(String imageUrl, String model, String prompt, Double denoising_strength, String style_preset,
            int steps, int cfg_scale, int seed, boolean upscale, String sampler, int width, int height) {
        this.imageUrl = imageUrl;
        this.model = model;
        this.prompt = prompt;
        this.denoising_strength = denoising_strength;
        this.style_preset = style_preset;
        this.steps = steps;
        this.cfg_scale = cfg_scale;
        this.seed = seed;
        this.upscale = upscale;
        this.sampler = sampler;
        this.width = width;
        this.height = height;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getPrompt() {
        return prompt;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    public Double getDenoising_strength() {
        return denoising_strength;
    }
    public void setDenoising_strength(Double denoising_strength) {
        this.denoising_strength = denoising_strength;
    }
    public String getStyle_preset() {
        return style_preset;
    }
    public void setStyle_preset(String style_preset) {
        this.style_preset = style_preset;
    }
    public int getSteps() {
        return steps;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }
    public int getCfg_scale() {
        return cfg_scale;
    }
    public void setCfg_scale(int cfg_scale) {
        this.cfg_scale = cfg_scale;
    }
    public int getSeed() {
        return seed;
    }
    public void setSeed(int seed) {
        this.seed = seed;
    }
    public boolean isUpscale() {
        return upscale;
    }
    public void setUpscale(boolean upscale) {
        this.upscale = upscale;
    }
    public String getSampler() {
        return sampler;
    }
    public void setSampler(String sampler) {
        this.sampler = sampler;
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
