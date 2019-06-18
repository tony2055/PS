package br.com.antoniohenriquerm80282.yodagame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun logar(view: View) {

        val informacoes = etNome.text.toString()
        val time = spTimes.selectedItem.toString()
        val login = Login(
                etNome.text.toString(),
                spTimes.selectedItem.toString()
        )


        if (informacoes != "" && time != "") {

            val intent = Intent(this, JogoActivity::class.java)

            intent.putExtra("login", login)

            startActivity(intent)
            finish()
        } else {

            Toast.makeText(this, "Digite seu nome e escolha um time",
                    Toast.LENGTH_SHORT).show()
        }
    }
}
