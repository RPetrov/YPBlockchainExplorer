package yp.ypblockchainexplorer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import yp.ypblockchainexplorer.dto.Wallet

class MainActivity : AppCompatActivity() {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://blockchain.info/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.search_text)
        val blockchainService = retrofit.create(BlockchainService::class.java)
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

            override fun afterTextChanged(s: Editable?) {
                s ?: return
                blockchainService.getWalletInfo(s.toString()).enqueue(object : Callback<Wallet?> {
                    override fun onResponse(p0: Call<Wallet?>, response: Response<Wallet?>) {
                        if(response.isSuccessful){
                            Log.e("MA", response.body()?.toString() ?: "NO_RES")
                        } else {
                            Log.e("MA", "not ok ${response.code()}")
                        }
                    }

                    override fun onFailure(p0: Call<Wallet?>, throwable: Throwable) {
                        Log.e("MA", throwable.message, throwable)
                    }
                })
            }
        })



//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}