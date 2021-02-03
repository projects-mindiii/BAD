package com.bad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bad.data.MyRepository
import com.bad.data.Resource
import com.bad.model.User
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

class MainViewModel(private val repository: MyRepository): ViewModel() {
    private val liveUserResource: MutableLiveData<Resource<Any>> = MutableLiveData()

    /**
     * find user by its id, first call would be api if get any error will go to check local database
     * If found data into data base success resource will be assigned otherwise will error, initially it would be loading assigned
     *
     * @param id of user
     * */
    fun findUserById(id: Int) {
        repository.findUserById(id)
                .toObservable()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<User> {
                    override fun onSubscribe(d: Disposable) {
                        liveUserResource.postValue(Resource.loading())
                    }

                    override fun onNext(t: User) {
                        liveUserResource.postValue(Resource.success(t))
                    }

                    override fun onError(e: Throwable) {
                        liveUserResource.postValue(Resource.error(e))
                    }

                    override fun onComplete() {
                        //TODO("Not yet implemented")
                    }
                })
    }

    /**
     * Exposing live user resource
     *
     * @return liveUserResource
     * */
    fun user(): LiveData<Resource<Any>> = liveUserResource
}