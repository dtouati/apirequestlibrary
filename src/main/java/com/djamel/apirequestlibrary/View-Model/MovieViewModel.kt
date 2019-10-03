package com.djamel.apirequestlibrary.`View-Model`

import androidx.lifecycle.ViewModel
import com.djamel.apirequestlibrary.Interface.MovieCallback
import com.djamel.apirequestlibrary.Interface.MovieDetailsCallback
import com.djamel.apirequestlibrary.Model.RateMovie
import com.djamel.apirequestlibrary.Model.WapperDetailsMovie
import com.djamel.apirequestlibrary.MovieDataModel
import com.djamel.apirequestlibrary.Network.ApiRequest
import com.djamel.apirequestlibrary.WapperMovie
import retrofit2.Call

 class MovieViewModel : ViewModel (){

    var listCallback = ArrayList<MovieCallback>()
    var listCallbackDetails = ArrayList<MovieDetailsCallback>()

    fun getListMovie(movieCallback: MovieCallback, movieRequest : Call<WapperMovie>){
        cheackList(movieCallback)

        ApiRequest().getPopularMovie(this,movieRequest )



    }

    fun getDetailsMovie(movieCallback: MovieDetailsCallback, movieRequest : Call<WapperDetailsMovie>){
        cheackListDetails(movieCallback)
        ApiRequest().getDetailsMovie(this,movieRequest)

    }

    fun rateMovie(movieCallback: MovieCallback, movieRate : Call<RateMovie>){
        cheackList(movieCallback)
        ApiRequest().rateMovie(movieRate)
    }

    private fun cheackList(movieCallback : MovieCallback){
        if(!listCallback.contains(movieCallback)){
            listCallback.add(movieCallback)
        }

    }

    private fun cheackListDetails(movieCallback : MovieDetailsCallback){
        if(!listCallbackDetails.contains(movieCallback)){
            listCallbackDetails.add(movieCallback)
        }

    }

    fun notifyObservateurSuccess(value: ArrayList<MovieDataModel>){
        for (callback in listCallback){
            callback.onSuccess(value)
        }
    }
    fun notifyObservateurError(){
        for (callback in listCallback){
            callback.onError()
        }
    }

    fun notifyObservateurSuccessDetails(value: WapperDetailsMovie){
        for (callback in listCallbackDetails){
            callback.onSuccess(value)
        }
    }
}