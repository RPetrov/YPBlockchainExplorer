package yp.ypblockchainexplorer.blockchainapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BlockchainApi {
    @GET("rawaddr/{address}")
    fun getByAddress(@Path("address") address: String): Call<WalletDTO>
}