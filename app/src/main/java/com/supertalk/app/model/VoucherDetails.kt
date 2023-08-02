package com.supertalk.app.model

data class VoucherDetails(
    val branch_name: String,
    val branch_image_path: String,
    val landmark: String,
    val voucher_title: String,
    val purchased_on: String,
    val valid_on: String,
    val order_number: String,
    val price: String,
    val voucher_status: Int,
    val voucher_status_label: String,
    val prepaid_voucher_code: String,
    val redeemed_on: String,
    val voucher_value: String,
    val payment_option: String,
    val is_valid_type: Int
)