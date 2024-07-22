package yp.ypblockchainexplorer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import yp.ypblockchainexplorer.dto.WalletModel

interface BlockchainApi {
    @GET("rawaddr/{address}")
    fun get(@Path("address") address: String): Call<WalletModel>
}