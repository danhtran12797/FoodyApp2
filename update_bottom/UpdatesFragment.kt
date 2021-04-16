package com.oneibc.feature.notifications

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.oneibc.R
import com.oneibc.common.BaseFragment
import com.oneibc.databinding.FragmentUpdatesBinding
import com.oneibc.feature.notifications.adapter.UpdatesBottomAdapter
import com.oneibc.feature.setup_now.SetUpNowViewModel

import org.koin.android.viewmodel.ext.android.viewModel

class UpdatesFragment : BaseFragment<SetUpNowViewModel, FragmentUpdatesBinding>(R.layout.fragment_updates) {

    override val viewModel: SetUpNowViewModel by viewModel()
    override val binding: FragmentUpdatesBinding by viewBinding()

    override fun initControl() {
    }

    override fun initUI() {
        binding.bottomRecyclerView.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=UpdatesBottomAdapter()
            addItemDecoration(object:DividerItemDecoration(context, DividerItemDecoration.VERTICAL){

            })
        }
    }

    override fun initEvent() {
    }

    override fun initConfig() {
    }
}