package com.Hanafi.github.ui.main.api

import com.Hanafi.github.ui.main.data.model.User
import com.Hanafi.github.ui.main.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 41c89d58d6eb46bbbef1e3722984c7283eb3420e")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 41c89d58d6eb46bbbef1e3722984c7283eb3420e")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<DetailUserResponse>

    class DetailUserResponse {

    }

    @GET("users/{username}/followers")
    @Headers("Authorization: token 41c89d58d6eb46bbbef1e3722984c7283eb3420e")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 41c89d58d6eb46bbbef1e3722984c7283eb3420e")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}