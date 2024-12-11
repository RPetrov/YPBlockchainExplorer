package yp.ypblockchainexplorer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import yp.ypblockchainexplorer.dto.Wallet

/**
 * https://blockchain.info/rawaddr/34xp4vRoCGJym3xR7yCVPFHoCNxv4Twseo
 */
interface BlockchainService {
    @GET("rawaddr/{address}")
    fun getWalletInfo(@Path("address") string: String): Call<Wallet>
}