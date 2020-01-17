package com.example.RecycleViewAndJsonParsing;

public class ExampleIten {
    private String mImageURL;
    private String mCreator;
    private int mLikes;

    public ExampleIten(String imageURL, String creator, int likes) {
        setmImageURL(imageURL);
        setmCreator(creator);
        setmLikes(likes);
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public void setmImageURL(String mImageURL) {
        this.mImageURL = mImageURL;
    }

    public String getmCreator() {
        return mCreator;
    }

    public void setmCreator(String mCreator) {
        this.mCreator = mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }

    public void setmLikes(int mLikes) {
        this.mLikes = mLikes;
    }
}
