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
        val horoscopeUser = userInfo?.horoscope.toString()
        val chineseHoroscopeUser = userInfo?.chineseHoroscope.toString()
        changeImgHoroscopeSrc(horoscopeUser)
        changeImgChineseHoroscopeSrc(chineseHoroscopeUser)

         binding.tvUsername.text = userInfo?.name
         binding.tvnNum.text = userInfo?.account_number.toString()
         binding.tvBirth.text = userInfo?.birth
         binding.tvHoroscopo.text = userInfo?.horoscope.toString()
         binding.tvHoroscopoChino.text = userInfo?.chineseHoroscope
         binding.tvAgeUser.text = userInfo?.age



        //Toast.makeText(this, "Usuario ${userInfo?.name},correo: ${userInfo?.email}", Toast.LENGTH_LONG).show()
    }

    fun changeImgHoroscopeSrc(horoscope: String){
        when(horoscope){
            "Aries"->{
                binding.ivHoroscope.setImageResource(R.drawable.aries);
            }
            "Tauro"->{
                binding.ivHoroscope.setImageResource(R.drawable.taurus);
            }
            "Geminis"->{
                binding.ivHoroscope.setImageResource(R.drawable.gemini);
            }
            "Cancer"->{
                binding.ivHoroscope.setImageResource(R.drawable.cancer);
            }
            "Leo"->{
                binding.ivHoroscope.setImageResource(R.drawable.leo);
            }
            "Virgo"->{
                binding.ivHoroscope.setImageResource(R.drawable.virgo);
            }
            "Libra"->{
                binding.ivHoroscope.setImageResource(R.drawable.libra);
            }
            "Escorpio"->{
                binding.ivHoroscope.setImageResource(R.drawable.scorpio);
            }
            "Sagitario"->{
                binding.ivHoroscope.setImageResource(R.drawable.sagitarius);
            }
            "Capricornio"->{
                binding.ivHoroscope.setImageResource(R.drawable.capricornio);
            }
            "Acuario"->{
                binding.ivHoroscope.setImageResource(R.drawable.aquarius);
            }
            "Pisces"->{
                binding.ivHoroscope.setImageResource(R.drawable.pisces);
            }
        }
    }
    fun changeImgChineseHoroscopeSrc(horoscope: String){
        when(horoscope){
            "Mono"->{
                binding.ivChinese.setImageResource(R.drawable.monkey);
            }
            "Gallo"->{
                binding.ivChinese.setImageResource(R.drawable.rooster);
            }
            "Perro"->{
                binding.ivChinese.setImageResource(R.drawable.dog);
            }
            "Cerdo"->{
                binding.ivChinese.setImageResource(R.drawable.pig);
            }
            "Rata"->{
                binding.ivChinese.setImageResource(R.drawable.rat);
            }
            "Buey"->{
                binding.ivChinese.setImageResource(R.drawable.ox);
            }
            "Tigre"->{
                binding.ivChinese.setImageResource(R.drawable.tiger);
            }
            "Conejo"->{
                binding.ivChinese.setImageResource(R.drawable.rabbit);
            }
            "Dragon"->{
                binding.ivChinese.setImageResource(R.drawable.dragon);
            }
            "Serpiente"->{
                binding.ivChinese.setImageResource(R.drawable.snake);
            }
            "Caballo"->{
                binding.ivChinese.setImageResource(R.drawable.horse);
            }
            "Borrego"->{
                binding.ivChinese.setImageResource(R.drawable.goat);
            }
        }
    }
}