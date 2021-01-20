package com.Hanafi.github.ui.main.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Hanafi.github.ui.main.api.RetrovitClient.apiInstance
import com.Hanafi.github.ui.main.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingViewModel : ViewModel(){
    val listFollowing = MutableLiveData<ArrayList<User>>()

    fun setListFollowing(username: String) {
        RetrofitUser.apiInstance
                .getFollowing((username))
                .enqueue(object : Callback<ArrayList<User>> {
                    override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                        t.message?.let { Log.d("Failure", it) }
                    }

                    override fun onResponse(
                            call: Call<ArrayList<User>>,
                            response: Response<ArrayList<User>>
                    ) {
                        if (response.isSuccessful) {
                            listFollowing.postValue(response.body())
                        }
                    }

                })
    }

    class RetrofitUser {

    }

    fun getListFollowing(): LiveData<ArrayList<User>> {
        return listFollowing
    }
}