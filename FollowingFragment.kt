package com.Hanafi.github.ui.main.detail

import android.os.Bundle
import android.system.Os.bind
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.Hanafi.github.R
import com.Hanafi.github.ui.main.MainAdapter

internal class FollowingFragment : Fragment(R.layout.fragment_follow) {

    var _binding: FollowersFragment.FragmentFollowBinding? = null
    val binding get() = _binding!!
    lateinit var viewModel: FollowingViewModel
    lateinit var adapter: MainAdapter
    lateinit var username: String

    fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        username = args?.getString(DetailUserActivity.USERNAME).toString()

        _binding = FollowersFragment.FragmentFollowBinding.bind(view)

        adapter = MainAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rcMain.setHasFixedSize(true)
            rcMain.layoutManager = LinearLayoutManager(activity)
            rcMain.adapter = adapter
        }

        showLoading(true)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(FollowingViewModel::class.java)

        viewModel.setListFollowing(username)
        viewModel.getListFollowing().observe(viewLifecycleOwner) {
            if (it != null)
                adapter.setList(it)
            showLoading(false)
        }

    }

    fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}
