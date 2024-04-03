package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DetailPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        val userId = intent.getStringExtra("userId")

        // mainActivity로 이동하는 버튼
        val btnHome = findViewById<ImageView>(R.id.btn_home)
        btnHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 유저정보 출력
        val name = findViewById<TextView>(R.id.content_name)
        val mbti = findViewById<TextView>(R.id.content_mbti)
        val thoughts = findViewById<TextView>(R.id.content_thoughts)

        name.text = userMap[userId]?.userName
        mbti.text = userMap[userId]?.userMbti
        thoughts.text = userMap[userId]?.userThoughts

        //
        val profileImage = findViewById<ImageView>(R.id.img_profile)
        val userProfileImage = userMap[userId]?.profile
        if (userProfileImage == null) {
            profileImage.setImageResource(R.drawable.defaultprofile)
        }

        // 첫번째 게시글의 이름, 이미지, 글
        val userName1 = findViewById<TextView>(R.id.userName1)
        val postImage1 = findViewById<ImageView>(R.id.post_image1)
        val postWriting1 = findViewById<TextView>(R.id.post_writing1)

        userName1.text = userId
        userMap[userId]?.postImage?.let { postImage1.setImageResource(it.get(0)) }
        postWriting1.text = userMap[userId]?.postWriting?.get(0)

        // 두번째 게시글의 이름, 이미지, 글
        val userName2 = findViewById<TextView>(R.id.userName2)
        val postImage2 = findViewById<ImageView>(R.id.post_image2)
        val postWriting2 = findViewById<TextView>(R.id.post_writing2)

        userName2.text = userId
        userMap[userId]?.postImage?.let { postImage2.setImageResource(it.get(1)) }
        postWriting2.text = userMap[userId]?.postWriting?.get(1)
    }
}