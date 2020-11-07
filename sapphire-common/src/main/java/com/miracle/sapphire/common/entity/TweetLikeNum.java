package com.miracle.sapphire.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author miracle
 * @since 2020-11-07
 */
public class TweetLikeNum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer tweetId;

    private Integer tweetLikes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public void setTweetId(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public Integer getTweetLikes() {
        return tweetLikes;
    }

    public void setTweetLikes(Integer tweetLikes) {
        this.tweetLikes = tweetLikes;
    }

    @Override
    public String toString() {
        return "TweetLikeNum{" +
        "id=" + id +
        ", tweetId=" + tweetId +
        ", tweetLikes=" + tweetLikes +
        "}";
    }
}
