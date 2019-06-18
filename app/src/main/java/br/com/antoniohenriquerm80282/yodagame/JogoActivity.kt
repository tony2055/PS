package br.com.antoniohenriquerm80282.yodagame

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_jogo.*
import java.util.*

class JogoActivity : AppCompatActivity() {

    private var numeroAleatorio: Random? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        numeroAleatorio = Random()

        val login = intent.getParcelableExtra<Login>("login")

        val name = login.nome
        val time = login.timeEscolhido

        tvNome.text = name
        tvTime.text = time
    }

    fun chuteGame(view: View){
        val chuteUsuario = etChuteUsuario.text.toString().toInt()

        val jogadaPC = numeroAleatorio!!.nextInt(100)

        tvChutePC.text = jogadaPC.toString()

        if(jogadaPC == chuteUsuario){
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Parabéns")
            alert.setMessage("Você acertou o número!")
            alert.setNegativeButton("SAIR", null)
            alert.show()
        }
        if(jogadaPC > chuteUsuario){
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Não foi dessa vez")
            alert.setMessage("O número foi maior")
            alert.setNegativeButton("SAIR", null)
            alert.show()
        }
        if(jogadaPC < chuteUsuario){
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Não foi dessa vez")
            alert.setMessage("O número foi menor")
            alert.setNegativeButton("SAIR", null)
            alert.show()
        }
    }
}
