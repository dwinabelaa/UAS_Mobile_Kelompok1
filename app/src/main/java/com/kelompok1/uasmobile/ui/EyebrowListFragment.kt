package com.kelompok1.uasmobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kelompok1.uasmobile.R
import com.kelompok1.uasmobile.databinding.FragmentEyebrowListBinding

class EyebrowListFragment: Fragment() {
    private val MakeUpViewModel: MakeUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEyebrowListBinding.inflate(inflater)
        MakeUpViewModel.getDataEyebrow()
        binding.lifecycleOwner = this
        binding.data = MakeUpViewModel
        binding.recyclerView.adapter = EyebrowListAdapter(EyebrowListener { eyebrow ->
            MakeUpViewModel.onEyebrowClicked(eyebrow)
            findNavController()
                .navigate(R.id.action_eyebrowListFragment_to_eyebrowDetailFragment2)
        })
        return binding.root
    }
}