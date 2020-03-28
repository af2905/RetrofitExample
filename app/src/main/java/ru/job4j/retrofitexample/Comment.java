package ru.job4j.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;

    @SerializedName("body")
    private String text;

    public int getPostId() {
        return postId;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    String getText() {
        return text;
    }
}
