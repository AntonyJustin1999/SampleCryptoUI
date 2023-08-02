package com.supertalk.app.repository


import com.supertalk.app.api.VoucherApi
import com.supertalk.app.model.ApiResponse
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    val voucherApi: VoucherApi
) {

    suspend fun getTopHeadlines(page: String, env: String): Response<ApiResponse> {
        return voucherApi.getVouchers(page, env)
    }

}