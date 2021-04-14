package com.oneibc.feature.dashboard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.oneibc.MainActivity
import com.oneibc.R
import com.oneibc.common.BaseFragment
import com.oneibc.databinding.FragmentDashboardBinding
import com.oneibc.databinding.SingleChipLayoutBinding
import com.oneibc.feature.setup_now.SetUpNowViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class DashboardFragment : BaseFragment<SetUpNowViewModel, FragmentDashboardBinding>(R.layout.fragment_dashboard) {

    override fun initControl() {
        (activity as MainActivity).apply {
            initToolbar(backButton = true)
            enableSupportButton("searchButton")
            enableBottomNavigation(false)
        }
    }

    override fun initUI() {
//        binding.dialogButton.setOnClickListener {
//            navigate(DashboardFragmentDirections.actionDashboardFragmentToDialogFragment())
//        }
//        initComponent(10)

        binding.flowLayout.post(Runnable {
            if (binding.flowLayout.rowsCount >= 2) {
                val count=binding.flowLayout.rowsCount
                val view=SingleChipLayoutBinding.inflate(LayoutInflater.from(context), null, false).root
                Log.d("TAG", "row count: $count")
                binding.flowLayout.addView(view, 0)
                binding.flowLayout.maxRows=1
            }
        })
    }

//    fun initComponent(position: Int){
//        var pos=0
//        val listChips=Chips.create(position, createListName())
//        for (i in listChips.indices){
////            val chip=Chip(ContextThemeWrapper(context, R.style.chipStyle))
//            val chip= Chip(context)
//            context?.let {
//                val chipDrawable = ChipDrawable.createFromAttributes(
//                    it,
//                    null,
//                    0,
//                    R.style.chipStyle
//                )
//                chip.setChipDrawable(chipDrawable)
//            }
//            chip.text=listChips[i].name
//            binding.chipGroup.addView(chip)
////            getHeightView(binding.chipGroup) {
////                if(it>150){
////                    pos=i
////                    Log.d("OOO", "position: $pos, height: $it")
////                }
////            }
////            Log.d("OOO", "Count child: ${binding.chipGroup.childCount}")
//        }
//
//        getHeightView(binding.chipGroup){
//            if(it>150){
//                Log.d("OOO", "height Group: $it")
//                binding.chipGroup.isSingleLine = true
//            }
//        }
//    }

    fun createListName()= listOf(
        getString(R.string.jurisdictions_free),
        getString(R.string.open_account),
        getString(R.string.managing_members),
        getString(R.string.back),
        getString(R.string.service_fee),
        getString(R.string.set_up_service),
        getString(R.string.billing_information),
        getString(R.string.company_formation_unfinished),
        getString(R.string.cash),
        getString(R.string.confirmation),
        getString(R.string.jurisdiction_incorporation),
        getString(R.string.dashboard)
    )

    override fun initEvent() {
    }

    override fun initConfig() {
    }

    fun getHeightView(view: View, callback: (Int) -> Unit){
        view.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val height = view.height
                callback.invoke(height)
            }
        })
    }

    override val viewModel: SetUpNowViewModel by viewModel()
    override val binding: FragmentDashboardBinding by viewBinding()
}