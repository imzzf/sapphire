package com.miracle.sapphire.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author miracle
 * @since 2020-11-07
 */
public class Retweet implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer tweetId;

    private Integer userId;

    private LocalDateTime retweetTime;


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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getRetweetTime() {
        return retweetTime;
    }

    public void setRetweetTime(LocalDateTime retweetTime) {
        this.retweetTime = retweetTime;
    }

    @Override
    public String toString() {
        return "Retweet{" +
        "id=" + id +
        ", tweetId=" + tweetId +
        ", userId=" + userId +
        ", retweetTime=" + retweetTime +
        "}";
    }
}
