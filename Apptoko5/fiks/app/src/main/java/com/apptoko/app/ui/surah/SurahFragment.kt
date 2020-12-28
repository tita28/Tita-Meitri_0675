package com.apptoko.app.ui.surah

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import com.apptoko.app.R
import com.apptoko.app.databinding.FragmentSurahBinding
import com.apptoko.app.ui.home.MainActivity
import kotlin.math.log

class SurahFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentSurahBinding
    private val viewModel: SurahViewModel by lazy { SurahViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSurahBinding.inflate(inflater, container, false).apply {
            viewmodel = this@SurahFragment.viewModel
            lifecycleOwner = this@SurahFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       init()
        observe()
    }
    private fun init() {
        binding.recyclerView.adapter = SurahAdapter(parent)
        viewModel.listSurah()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listSurah()
        }
    }

    private fun observe() {
       viewModel.loading.observe(viewLifecycleOwner) {
           binding.swipeRefresh.isRefreshing = it
       }

        viewModel.actionState.observe(viewLifecycleOwner) {
            if (it.isConsumed) {
                Log.i("ActionState", "isConsumed")
            } else if (!it.isSuccess) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}