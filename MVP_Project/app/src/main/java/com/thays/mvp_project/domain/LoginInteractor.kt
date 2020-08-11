package com.thays.mvp_project.domain

import io.reactivex.rxjava3.core.Single

class LoginInteractor (
    private val repository: LoginContract.Repository
) : LoginContract.Interactor {

    override fun requestUser(username: String, password: String): Single<Boolean> {
        return repository.getUser(username, password)
    }
}