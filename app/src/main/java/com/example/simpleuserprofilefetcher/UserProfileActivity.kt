package com.example.simpleuserprofilefetcher

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpleuserprofilefetcher.ViewModel.UserViewModel

class UserProfileActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val usernameTextView: TextView = findViewById(R.id.usernameTextView)
        val emailTextView: TextView = findViewById(R.id.emailTextView)
        val phoneTextView: TextView = findViewById(R.id.phoneTextView)
        val addressTextView: TextView = findViewById(R.id.addressTextView)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewModel.userProfile.observe(this, Observer { user ->
            nameTextView.text = user.name
            usernameTextView.text = user.username
            emailTextView.text = user.email
            phoneTextView.text = user.phone
            addressTextView.text = "${user.address.street}, ${user.address.city}"
        })

        viewModel.error.observe(this, Observer { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        })

        viewModel.fetchUserProfile()
    }
}