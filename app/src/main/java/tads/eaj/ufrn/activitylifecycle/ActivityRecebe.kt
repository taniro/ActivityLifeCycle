package tads.eaj.ufrn.activitylifecycle

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityRecebe : AppCompatActivity() {
    lateinit var voltarButton:Button
    lateinit var resultadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)

        voltarButton = findViewById(R.id.voltarButton)
        resultadoTextView = findViewById(R.id.resultadoTextView)

        val params = intent.extras
        val texto = params?.getString("TEXTO")

        resultadoTextView.text = texto

        voltarButton.setOnClickListener {
            val i = Intent()
            i.putExtra("DADOS_RESPOSTA", "Deu certo!")
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }
}