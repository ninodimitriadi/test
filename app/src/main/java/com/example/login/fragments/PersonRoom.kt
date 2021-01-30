package com.example.login.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.login.MainActivity
import com.example.login.PasswordChangeActivity
import com.example.login.R
import com.google.firebase.auth.FirebaseAuth

class PersonRoom : Fragment(R.layout.fragment_person_room) {

    private  lateinit var navController: NavController
    private lateinit var logOutButton: Button
    private lateinit var passwordChangeButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        navController = Navigation.findNavController(view)

        mAuth = FirebaseAuth.getInstance()
        passwordChangeButton = view.findViewById(R.id.goToPasswordChangeButton)
        logOutButton = view.findViewById(R.id.logOutButton)

//PersonActivity და PersonRoom ერთი და იგივეა იდეაში.მაგრამ რადგან პირველი აქთივითია და მეორე ფრაგმენტი intent-ზე და finish-ზე გვიწითლებს
        passwordChangeButton.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity::class.java))
        }

        logOutButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }





    }

}