package com.thays.mvp_project.data

import com.thays.mvp_project.domain.LoginContract
import io.reactivex.rxjava3.core.Single

class LoginRepository : LoginContract.Repository {

    override fun getUser(username: String, password: String): Single<Boolean> {
        var result = false

        if (username == "Thays" && password == "123456") {
            result = true
        }

        return Single.just(result)
    }
}