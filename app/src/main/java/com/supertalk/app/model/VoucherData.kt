package com.supertalk.app.model

data class VoucherData(
    val list: List<VoucherDetails>,
    val total_page: Int,
    val current_page: String
)