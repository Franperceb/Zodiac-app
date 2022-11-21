package com.example.zodiac_app

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.zodiac_app.databinding.ActivityFormBinding
import com.example.zodiac_app.model.User
import java.util.*


class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun goToResult(view: View) {

        var userName = "";
        var userEmail ="";
        var account = 0;
        var invalidInfo = false;

        if(binding.tvNombreUser.text.isNotEmpty()){
            userName = binding.tvNombreUser.text.toString()
        }
        else
        {
            binding.tvNombreUser.error = getString(R.string.name_val)
            invalidInfo = true;
        }

        if(binding.tvCorreoUser.text.isNotEmpty()){
             userEmail = binding.tvCorreoUser.text.toString();
            val isValidEmail =  userEmail.isValidEmail()

            if(!isValidEmail){
                binding.tvCorreoUser.error = getString(R.string.email_inval)
                invalidInfo = true;
            }
        }
        else
        {
            binding.tvCorreoUser.error = getString(R.string.email_val)
            invalidInfo = true;
        }


        if(binding.tvNumCuentaUser.text.isNotEmpty()){
            account = binding.tvNumCuentaUser.text.toString().toInt()
        }
        else
        {
            binding.tvNumCuentaUser.error = getString(R.string.account_inval)
            invalidInfo = true;
        }

        if(invalidInfo)
            return;

        val dayUser = binding.dpFechaUser.dayOfMonth.toString().toInt();
        val monthUser = binding.dpFechaUser.month.toString().toInt() +1;
        val yearUser = binding.dpFechaUser.year.toString().toInt();
        val birth = "$dayUser/$monthUser/$yearUser";
        val horoscopeUser = getHoroscope(dayUser, monthUser)
        val chineseHoroscopeUser = getChineseHoroscope(yearUser)
        val ageUser = getAge( yearUser,monthUser,dayUser).toString()

        var userInfo = User(userName, account, birth,ageUser, userEmail, horoscopeUser,chineseHoroscopeUser)




        val intent = Intent(this, HoroscopeActivity::class.java)
        val params = Bundle()
        params.putParcelable("userInfo", userInfo)//cambiar clase de userInfo mandar dato de horoscopos tambien
        intent.putExtras(params)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    private fun getAge(year: Int, month: Int, day: Int): Int {
        val dateOfBirth = Calendar.getInstance()
        val today = Calendar.getInstance()
        dateOfBirth[year, month] = day
        var age = today[Calendar.YEAR] - dateOfBirth[Calendar.YEAR]
        if (today[Calendar.DAY_OF_YEAR] < dateOfBirth[Calendar.DAY_OF_YEAR]) {
            age--
        }
        return age
    }

    fun getHoroscope(day: Int,month: Int ): String{
        var horoscope = "";
        when(month){
            12->{
                if (day < 22){
                    horoscope = getString(R.string.sagitario);
                }
                else{
                    horoscope = getString(R.string.capricornio);
                }
            }
            1->{
                if (day < 20){
                    horoscope = getString(R.string.capricornio);
                }
                else{
                    horoscope = getString(R.string.acuario);
                }            }
            2->{
                if (day < 19){
                    horoscope = getString(R.string.acuario);
                }
                else{
                    horoscope = getString(R.string.piscis);
                }
            }
            3->{
                if (day < 21){
                    horoscope = getString(R.string.piscis);
                }
                else{
                    horoscope = getString(R.string.aries);
                }
            }
            4->{
                if (day < 20){
                    horoscope = getString(R.string.aries);
                }
                else{
                    horoscope = getString(R.string.tauro);
                }
            }
            5->{
                if (day < 21){
                    horoscope = getString(R.string.tauro);
                }
                else{
                    horoscope = getString(R.string.geminis);
                }
            }
            6->{
                if (day < 21){
                    horoscope = getString(R.string.geminis);
                }
                else{
                    horoscope = getString(R.string.cancer);
                }
            }
            7->{
                if (day < 23){
                    horoscope = getString(R.string.cancer);
                }
                else{
                    horoscope = getString(R.string.leo);
                }
            }
            8->{
                if (day < 23){
                    horoscope = getString(R.string.leo);
                }
                else{
                    horoscope = getString(R.string.virgo);
                }
            }
            9->{
                if (day < 23){
                    horoscope = getString(R.string.virgo);
                }
                else{
                    horoscope =  getString(R.string.libra);
                }
            }
            10->{
                if (day < 23){
                    horoscope =  getString(R.string.libra);
                }
                else{
                    horoscope =  getString(R.string.escorpio);
                }
            }
            11->{
                if (day < 22){
                    horoscope = getString(R.string.escorpio);
                }
                else{
                    horoscope =  getString(R.string.sagitario);
                }
            }
            else -> {
                horoscope = "No horoscope"
            }
        }
        return horoscope
    }

    fun   getChineseHoroscope(year: Int): String {
        var yearOption=   year % 12
        var chineseAnimal = "";
        when(yearOption){
            0->{
               chineseAnimal = getString(R.string.mono);
            }
            1->{
                chineseAnimal = getString(R.string.gallo);
            }
            2->{
                chineseAnimal = getString(R.string.perro);
            }
            3->{
                chineseAnimal = getString(R.string.cerdo);
            }
            4->{
                chineseAnimal = getString(R.string.rata);
            }
            5->{
                chineseAnimal = getString(R.string.buey);
            }
            6->{
                chineseAnimal = getString(R.string.tigre);
            }
            7->{
                chineseAnimal = getString(R.string.conejo);
            }
            8->{
                chineseAnimal = getString(R.string.dragon);
            }
            9->{
                chineseAnimal = getString(R.string.serpiente);
            }
            10->{
                chineseAnimal = getString(R.string.caballo);
            }
            11->{
                chineseAnimal = getString(R.string.borrego);
            }
            else ->{
                chineseAnimal ="no Animal"
            }
        }
        return chineseAnimal
    }
}