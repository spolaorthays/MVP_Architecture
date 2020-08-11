package com.thays.mvp_project.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thays.mvp_project.R
import com.thays.mvp_project.utils.USERNAME
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        text_user_login.text = intent.getStringExtra(USERNAME)
    }

}