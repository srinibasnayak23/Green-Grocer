package com.example.gronic.data.remote


import com.example.gronic.domain.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("restAPI/v3/admin_timetrack.php")
    suspend fun login(
        @Field("action") action: String = "login",
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<LoginResponse>
}
