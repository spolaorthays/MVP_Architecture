package com.thays.mvp_project.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.thays.mvp_project.R
import com.thays.mvp_project.data.LoginRepository
import com.thays.mvp_project.domain.LoginContract
import com.thays.mvp_project.domain.LoginInteractor
import com.thays.mvp_project.domain.LoginPresenter
import com.thays.mvp_project.utils.USERNAME
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private var username = String()
    private var password = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val presenter = LoginPresenter(this, LoginInteractor(LoginRepository()))

        clickInLogin(presenter)
    }

    private fun clickInLogin(presenter: LoginPresenter){
        btNext.setOnClickListener {
            username = usernameId.text.toString()
            password = passwordId.text.toString()

            presenter.executeLogin(username = username,
                password = password)
        }
    }

    override fun loginSuccess() {
        Toast.makeText(this, "Login realizado com sucesso! ;D", Toast.LENGTH_LONG).show()
    }

    override fun loginFailure() {
        Toast.makeText(this, "Login falhou =(", Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun goToNextPage() {
        val intent = Intent(this, UserDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putString(USERNAME, username)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}