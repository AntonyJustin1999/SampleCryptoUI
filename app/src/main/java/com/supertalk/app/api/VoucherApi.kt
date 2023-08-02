package com.supertalk.app.api


import com.supertalk.app.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VoucherApi {
    @GET("v1/prepaid-voucher")
    suspend fun getVouchers(
        @Query("page") page: String,
        @Query("env") env: String,
    ): Response<ApiResponse>
}