package yp.ypblockchainexplorer.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import yp.ypblockchainexplorer.model.BlockChainWallet

interface BlockChainApi {
    @GET("rawaddr/{bitcoin_address}")
    fun getWalletInfo(@Path("bitcoin_address") bitcoinAddress: String): Call<BlockChainWallet>
}