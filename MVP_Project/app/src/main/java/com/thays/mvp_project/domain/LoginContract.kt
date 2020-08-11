package com.thays.mvp_project.domain

import io.reactivex.rxjava3.core.Single

interface LoginContract {

    interface View {
        fun loginSuccess()
        fun loginFailure()
        fun showProgress()
        fun hideProgress()
        fun goToNextPage()
    }

    interface Presenter {
        fun executeLogin(username: String, password: String)
    }

    interface Interactor {
        fun requestUser(username: String, password: String): Single<Boolean>
    }

    interface Repository {
        fun getUser(username: String, password: String): Single<Boolean>
    }
}