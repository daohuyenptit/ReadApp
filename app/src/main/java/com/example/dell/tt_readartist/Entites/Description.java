package com.example.dell.tt_readartist.Entites;

/**
 * Created by Dell on 4/23/2018.
 */

public class Description {
    private String href;
    private String srcImage;
    private String des;

    public Description() {
    }

    public Description(String href, String srcImage, String des) {
        this.href = href;
        this.srcImage = srcImage;
        this.des = des;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
