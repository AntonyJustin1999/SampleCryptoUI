package com.supertalk.app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.supertalk.R
import com.supertalk.app.api.DataHandler
import com.supertalk.app.model.VoucherDetails
import com.supertalk.databinding.FragmentHomeBinding
import com.supertalk.app.utils.Utils.LogData
import com.supertalk.app.view.adapters.UniversalRecyclerViewAdapter
import com.supertalk.app.viewmodel.VoucherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: VoucherViewModel by viewModels()
    var voucherAdapter =
        UniversalRecyclerViewAdapter<VoucherDetails>(null, R.layout.rv_voucher_item)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.fr = this
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var toolbar = binding?.toolbarLayout.toolbar as androidx.appcompat.widget.Toolbar
        toolbar.title = getString(R.string.app_name)
        initRecyclerView()
        observeLiveData()

    }

    override fun onClick(vararg data: Any) {

    }


    private fun observeLiveData() {
        viewModel.onLineVouchers.observe(viewLifecycleOwner) { dataHandler ->
            when (dataHandler) {
                is DataHandler.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    var data = dataHandler.data?.data?.list
                    dataHandler.data?.data?.list?.let {
                        voucherAdapter.setData(dataHandler.data?.data?.list)
                    }

                    LogData("Online Data: success****************** " + dataHandler.message)
                }
                is DataHandler.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    LogData("Online Data: ERROR************* " + dataHandler.message)
                }
                is DataHandler.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    LogData("Online Data***********: LOADING..")

                }
            }


        }
        viewModel.getVouchers()
    }

    private fun initRecyclerView() {
        voucherAdapter.fr = this
        binding.rvVouchers.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvVouchers.adapter = voucherAdapter

    }
}