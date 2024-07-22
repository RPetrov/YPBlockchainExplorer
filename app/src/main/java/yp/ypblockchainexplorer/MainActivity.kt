package yp.ypblockchainexplorer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.Callback
import retrofit2.Response
import yp.ypblockchainexplorer.dto.WalletModel

class MainActivity : AppCompatActivity() {


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create<BlockchainApi>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputField = findViewById<EditText>(R.id.input_field)
        val balanceText = findViewById<TextView>(R.id.balance)

        inputField.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                retrofit.get(inputField.text.toString())
                    .enqueue(object : Callback<WalletModel> {
                        override fun onResponse(p0: Call<WalletModel>, p1: Response<WalletModel>) {
                            balanceText.text = p1.body()?.finalBalance.toString()
                            Log.d("ErrorTag", "удачный запрос")
                        }

                        override fun onFailure(p0: Call<WalletModel>, p1: Throwable) {
                            Log.e("ErrorTag", "Ошибка запроса", p1)
                        }

                    })
                return@setOnEditorActionListener true
            }
            false
        }
    }

    companion object {
        const val BASE_URL = "https://blockchain.info/"
    }
}