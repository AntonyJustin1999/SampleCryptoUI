package com.supertalk.app.model

data class ApiResponse(
    val status: Int,
    val data: VoucherData,
    val time: Long,
    val message: String,
    val system: Map<String, String>
)