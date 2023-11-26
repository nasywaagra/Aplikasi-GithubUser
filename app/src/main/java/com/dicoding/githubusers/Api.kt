package com.dicoding.githubusers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: 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")
    fun getSearchUsers(
        @Query("q") query: String
    ) : Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}