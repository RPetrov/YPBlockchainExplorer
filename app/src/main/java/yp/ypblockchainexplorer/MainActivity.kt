package yp.ypblockchainexplorer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import yp.ypblockchainexplorer.model.BlockChainWallet
import yp.ypblockchainexplorer.retrofit.BlockChainApi

class MainActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://blockchain.info/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val blockChainApi = retrofit.create(BlockChainApi::class.java)

    private val editText by lazy {
        findViewById<EditText>(R.id.editText)
    }
    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchInformation("34xp4vRoCGJym3xR7yCVPFHoCNxv4Twseo")

        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchInformation(s.toString())
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })
    }

    private fun searchInformation(wallet: String){
        blockChainApi.getWalletInfo(wallet).enqueue(object : Callback<BlockChainWallet> {
            override fun onResponse(call: Call<BlockChainWallet>, response: Response<BlockChainWallet>) {
                recyclerView.adapter = TransactionsAdapter(response.body()!!.txs)
            }

            override fun onFailure(p0: Call<BlockChainWallet>, p1: Throwable) {
                Log.w("MyTag", "fail", p1)
            }
        })
    }
}