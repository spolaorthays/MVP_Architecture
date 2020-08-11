package com.thays.mvp_project.domain

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginPresenter(
    private val view: LoginContract.View,
    private val interactor: LoginContract.Interactor
) : LoginContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun executeLogin(username: String, password: String) {
        compositeDisposable.add(
            interactor.requestUser(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.showProgress() }
                .doOnTerminate { view.hideProgress() }
                .subscribe({ loginSuccess ->
                    if (loginSuccess) {
                        view.loginSuccess()
                        view.goToNextPage()
                    } else {
                        view.loginFailure()
                    }
                }, {
                    view.loginFailure()
                }
                )
        )
    }
}