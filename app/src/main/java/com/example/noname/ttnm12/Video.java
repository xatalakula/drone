package com.example.noname.ttnm12;

public class Video {
    private String video_id;
    private String state;

    public Video(String video_id, String state) {
        this.video_id = video_id;
        this.state = state;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
