package com.example.interviewpreparation.presentation.PullRequest

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.interviewpreparation.R
import com.example.interviewpreparation.databinding.FragmentClosedMrBinding
import com.example.interviewpreparation.domain.model.ClosedMr
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClosedMrFragment : Fragment() {

    private val viewModel: ClosedMrViewModel by viewModel()
    private lateinit var adapter: ClosedMrAdapter
    private lateinit var binding: FragmentClosedMrBinding
    private var data: MutableList<ClosedMr> = mutableListOf()

    companion object{
        private val TAG=ClosedMrFragment::class.java.simpleName
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"OnViewCreated")
        fetchData()
        initObserver()
        initListener()
    }

    private fun initListener(){
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.lifeCycleTestingFragment)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG,"OnCreateView")
        binding = FragmentClosedMrBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun fetchData() {
        viewModel.getData()
    }

    private fun initObserver() {
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.pullRequestData.observe(viewLifecycleOwner, Observer {
                when {
                    it.isLoading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    it.isError?.isNotEmpty() == true -> {
                        Log.d("AMAN", "Error occured")
                        binding.progressBar.visibility = View.GONE
                        showAlertBox()
                    }
                    else -> {
                        binding.progressBar.visibility = View.GONE
                        data = it.data as MutableList<ClosedMr>
                        initAdapter()
                    }

                }
            })
        }
    }

    private fun showAlertBox() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage(R.string.str_error_message)
            .setNegativeButton(R.string.str_retry,
                DialogInterface.OnClickListener { dialog, id ->
                    fetchData()
                })
            .setPositiveButton(R.string.str_exit,
                DialogInterface.OnClickListener { dialog, id ->
                    exitApp()
                })

        builder.setCancelable(false)
        builder.create().show()
    }

    private fun exitApp() {
        requireActivity().finish()
    }

    private fun initAdapter() {
        adapter = ClosedMrAdapter(data)
        binding.rvPullRequest.adapter = adapter
    }

}