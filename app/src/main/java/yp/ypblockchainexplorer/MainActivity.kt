package yp.ypblockchainexplorer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Base64
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import yp.ypblockchainexplorer.blockchainapi.BlockchainApi
import yp.ypblockchainexplorer.blockchainapi.WalletDTO
import java.math.BigDecimal
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


class MainActivity : AppCompatActivity() {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://blockchain.info/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val blockchainApi = retrofit.create(BlockchainApi::class.java)

    val adapter = TransactionsAdapter()


    fun aesDecrypt(): ByteArray {
        val secretKey: SecretKey = SecretKeySpec("PASSPASSPASSPASS".toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val ivParameterSpec = IvParameterSpec(ByteArray(16))
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec)
        return cipher.doFinal(Base64.decode("YMOR1QcVu4tf8JFyz7Ai2Q==".toByteArray(), 0))
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchEditText = findViewById<EditText>(R.id.edit_text_search)
        val balance = findViewById<TextView>(R.id.balance)
        val sent = findViewById<TextView>(R.id.sent)
        val received = findViewById<TextView>(R.id.received)
        val transactionsList = findViewById<RecyclerView>(R.id.transactions_list)
        transactionsList.layoutManager = LinearLayoutManager(this)
        transactionsList.adapter = adapter
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

            override fun afterTextChanged(s: Editable?) {
                val address = s?.toString() ?: return
                blockchainApi.getByAddress(address).enqueue(object : Callback<WalletDTO?> {
                    override fun onResponse(p0: Call<WalletDTO?>, response: Response<WalletDTO?>) {
                        if (response.isSuccessful) {
                            val wallet = response.body()

                            Log.w("RESPONSE_YP", "${response.body()}")
                            wallet?.let {
                                balance.text = (BigDecimal(it.finalBalance).divide(BigDecimal(1000000L))).toString()
                                sent.text = it.totalSent.toString()
                                received.text = it.totalReceived.toString()
                                adapter.data = it.txs
                                adapter.notifyDataSetChanged()
                            }
                        } else {
                            Log.w("RESPONSE_YP", "${response.errorBody()}")
                        }
                    }

                    override fun onFailure(p0: Call<WalletDTO?>, p1: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
            }
        })
    }
}