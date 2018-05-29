package com.beginner.wechat.constant;

/**
 * @author heqing
 * @date 2018/5/23.
 */
public enum MediaType {

    /**
     * image : 2M，支持PNG\JPEG\JPG\GIF格式
     */
    IMAGE("image"),

    /**
     * voice : 2M，播放长度不超过60s，支持AMR\MP3格式
     */
    VOICE("voice"),

    /**
     * video : 10MB，支持MP4格式
     */
    VIDEO("video"),

    /**
     * thumb :  64KB，支持JPG格式
     */
    THUMB("thumb"),

    /**
     * news :  图文
     */
    NEWS("news");

    MediaType(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getMedia(MediaType mediaType) {
        String media = null;
        if(mediaType != null) {
            switch (mediaType) {
                case IMAGE:
                    media = IMAGE.getName();
                    break;
                case VOICE:
                    media = VOICE.getName();
                    break;
                case VIDEO:
                    media = VIDEO.getName();
                    break;
                case THUMB:
                    media = THUMB.getName();
                    break;
                case NEWS:
                    media = NEWS.getName();
                    break;
              default:
                    media = "";
            }
        }
        return media;
    }
}
