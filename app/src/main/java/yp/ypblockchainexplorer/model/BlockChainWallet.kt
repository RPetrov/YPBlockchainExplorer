package yp.ypblockchainexplorer.model


import com.google.gson.annotations.SerializedName

data class BlockChainWallet(
    @SerializedName("address")
    val address: String,
    @SerializedName("final_balance")
    val finalBalance: Long,
    @SerializedName("hash160")
    val hash160: String,
    @SerializedName("n_tx")
    val nTx: Int,
    @SerializedName("n_unredeemed")
    val nUnredeemed: Int,
    @SerializedName("total_received")
    val totalReceived: Long,
    @SerializedName("total_sent")
    val totalSent: Long,
    @SerializedName("txs")
    val txs: List<Tx>
)