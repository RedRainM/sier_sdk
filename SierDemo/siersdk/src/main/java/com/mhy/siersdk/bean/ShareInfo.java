package com.mhy.siersdk.bean;

import java.io.Serializable;

/**
 * 描述:
 * Created by F.L on 2017/7/11.
 */

public class ShareInfo implements Serializable{

    /**
     * id : 118
     * title : 游戏资讯0
     * description : 游戏资讯0游戏资讯0游戏资讯0
     * create_time : 1497425674
     * cover :
     * url : http://qipai.cn/app.php?s=/Article/show/id/118
     */

    public String id;
    public String title;
    public String description;
    public String create_time;
    public String cover;
    public String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ShareInfo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", create_time='" + create_time + '\'' +
                ", cover='" + cover + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
