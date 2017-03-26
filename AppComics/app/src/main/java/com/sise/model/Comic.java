package com.sise.model;

/**
 * Created by Abel on 25/03/2017.
 */

public class Comic {
    private String nomComic;
    private Double precComic;
    private int imgComic;

    public Comic(String nomComic, Double precComic, int imgComic) {
        this.nomComic = nomComic;
        this.precComic = precComic;
        this.imgComic = imgComic;
    }

    public Comic() {
    }

    public String getNomComic() {
        return nomComic;
    }

    public void setNomComic(String nomComic) {
        this.nomComic = nomComic;
    }

    public Double getPrecComic() {
        return precComic;
    }

    public void setPrecComic(Double precComic) {
        this.precComic = precComic;
    }

    public int getImgComic() {
        return imgComic;
    }

    public void setImgComic(int imgComic) {
        this.imgComic = imgComic;
    }

}
