package com.example.zodiac_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.zodiac_app.databinding.ActivityFormBinding
import com.example.zodiac_app.databinding.ActivityHoroscopeBinding
import com.example.zodiac_app.model.User

class HoroscopeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val userInfo = bundle?.getParcelable<User>("userInfo")

         binding.tvUsername.text = userInfo?.name
         binding.tvnNum.text = userInfo?.account_number.toString()
         binding.tvBirth.text = userInfo?.birth
         binding.tvHoroscopo.text = userInfo?.horoscope
         binding.tvHoroscopoChino.text = userInfo?.chineseHoroscope


        Toast.makeText(this, "Usuario ${userInfo?.name},correo: ${userInfo?.email}", Toast.LENGTH_LONG).show()
    }

}