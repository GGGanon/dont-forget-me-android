package com.csming.dontforgetme.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csming.dontforgetme.common.model.*
import com.csming.dontforgetme.repository.BookRepository
import com.csming.dontforgetme.repository.UserRepository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Created by csming on 2018/10/3.
 */

class MainViewModel @Inject constructor(
        private val bookRepository: BookRepository,
        private val userRepository: UserRepository
) : ViewModel() {

    private var token: String = ""

    val isLoading = MutableLiveData<Boolean>()

    private val _bookLiveData = MutableLiveData<NetModel<List<BookModel>?>>()
    val bookLiveData: LiveData<NetModel<List<BookModel>?>>
        get() = _bookLiveData

    private val _dailyLiveData = MutableLiveData<NetModel<List<RecordingModel>?>>()
    val dailyLiveData: LiveData<NetModel<List<RecordingModel>?>>
        get() = _dailyLiveData

    private val _userLiveData = MutableLiveData<NetModel<UserModel?>>()
    val userLiveData: LiveData<NetModel<UserModel?>>
        get() = _userLiveData

    fun getBooks() {

        bookRepository.getBooks(token, object : Observer<List<BookModel>?> {

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onComplete() {
                isLoading.postValue(false)
            }

            override fun onError(e: Throwable) {
                isLoading.postValue(false)
                Timber.e(e)
                _bookLiveData.value = NetModel(
                        status = NET_ERROR
                )
            }

            override fun onNext(bookModels: List<BookModel>?) {
                _bookLiveData.value = NetModel(
                        status = SUCCESS,
                        data = bookModels
                )
            }
        })
    }

    /**
     * 获取日常列表
     */
    fun getDailies() {
        bookRepository.getDailies(token, object : Observer<List<RecordingModel>?> {

            override fun onSubscribe(d: Disposable?) {
                isLoading.postValue(false)
            }

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                isLoading.postValue(false)
                Timber.e(e)
                _dailyLiveData.value = NetModel(
                        status = NET_ERROR
                )
            }

            override fun onNext(recordingmodels: List<RecordingModel>?) {
                _dailyLiveData.value = NetModel(
                        status = SUCCESS,
                        data = recordingmodels
                )
            }
        })
    }

    fun getMe() {
        userRepository.getMe(token, object : Observer<UserModel?> {

            override fun onSubscribe(d: Disposable?) {
                isLoading.postValue(false)
            }

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                isLoading.postValue(false)
                Timber.e(e)
                _userLiveData.value = NetModel(
                        status = NET_ERROR
                )
            }

            override fun onNext(userModel: UserModel?) {
                _userLiveData.value = NetModel(
                        status = SUCCESS,
                        data = userModel
                )
            }
        })
    }

    fun setToken(token: String) {
        this.token = token
    }

    fun getToken(): String{
        return token
    }
}