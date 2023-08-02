package com.supertalk.app.viewmodel

import androidx.lifecycle.*
import com.supertalk.app.api.DataHandler
import com.supertalk.app.repository.NetworkRepository
import com.supertalk.app.model.ApiResponse
import com.supertalk.app.MyApplication

import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class VoucherViewModel @Inject constructor(
    private val application: MyApplication,
    private val networkRepository: NetworkRepository
) : BaseViewModel(application) {

    private val _vouchers = MutableLiveData<DataHandler<ApiResponse>>()
    val onLineVouchers: LiveData<DataHandler<ApiResponse>> = _vouchers


    fun getVouchers() {
        _vouchers.postValue(DataHandler.LOADING())
        viewModelScope.launch {
            val response = networkRepository.getTopHeadlines("1", "dev")
            _vouchers.postValue(handleResponse(response))

            response.body()?.data?.list?.let { }
        }
    }

    private fun handleResponse(response: Response<ApiResponse>): DataHandler<ApiResponse> {
        if (response.isSuccessful) {
            response.body()?.let { it ->
                return DataHandler.SUCCESS(it)
            }
        }
        return DataHandler.ERROR(message = response.errorBody().toString())
    }


}


