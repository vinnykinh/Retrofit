package com.example.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post {
    @Expose
    @SerializedName("id")
    private var id: Int = 0
    @Expose
    @SerializedName("userId")
    private var userId: Int = 0
    @Expose
    @SerializedName("name")
    private var title: String = ""
    @Expose
    @SerializedName("body")
    private var body: String = ""

    constructor()
    constructor(id: Int, userId: Int, title: String, body: String) {
        this.id = id
        this.userId = userId
        this.title = title
        this.body = body
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getUserId(): Int {
        return userId
    }

    fun setUserId(userId: Int) {
        this.userId = userId
    }

    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getBody(): String {
        return body

    }

    fun setBody(body: String) {
        this.body = body
    }
}