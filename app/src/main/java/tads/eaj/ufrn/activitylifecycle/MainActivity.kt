package tads.eaj.ufrn.activitylifecycle

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var confirmaButton: Button
    lateinit var nomeEditText: EditText

    val MY_REQUEST_CODE = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("AULA", "onCreate() invocado.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        confirmaButton = findViewById(R.id.confirmaButton)
        nomeEditText = findViewById(R.id.nomeEditText)

        /*
        confirmaButton.setOnClickListener {
            val i = Intent(this, ActivityRecebe::class.java)
            val param = Bundle()
            param.putString("TEXTO", nomeEditText.text.toString())
            param.putDouble("VALOR", 20.0)
            param.putString("AULA", "PDM")
            i.putExtras(param)
            startActivity(i)
        }
         */

        confirmaButton.setOnClickListener {
            val i = Intent(this, ActivityRecebe::class.java)
            val param = Bundle()
            param.putString("TEXTO", nomeEditText.text.toString())
            param.putDouble("VALOR", 20.0)
            param.putString("AULA", "PDM")
            i.putExtras(param)
            startActivityForResult(i, MY_REQUEST_CODE)
        }
    }

    override fun onStart() {
        Log.i("AULA", "onStart() invocado.")
        super.onStart()
    }

    override fun onResume() {
        Log.i("AULA", "onResume() invocado.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("AULA", "onPause() invocado.")
        super.onPause()
    }

    override fun onRestart() {
        Log.i("AULA", "onRestart() invocado.")
        super.onRestart()
    }

    override fun onStop() {
        Log.i("AULA", "onStop() invocado.")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("AULA", "onDestroy() invocado.")
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("AULA", "Resquest code = $requestCode, result code = $resultCode")
        when(requestCode){
            MY_REQUEST_CODE->{
                when (resultCode){
                    Activity.RESULT_OK->{
                        val param = data?.extras
                        val textoResultado = param?.getString("DADOS_RESPOSTA")
                        Toast.makeText(this, "A resposta é $textoResultado", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}