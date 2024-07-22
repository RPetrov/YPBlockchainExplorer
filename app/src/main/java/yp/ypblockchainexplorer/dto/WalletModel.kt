package yp.ypblockchainexplorer.dto


import com.google.gson.annotations.SerializedName

data class WalletModel(
    @SerializedName("address")
    var address: String, // 34xp4vRoCGJym3xR7yCVPFHoCNxv4Twseo
    @SerializedName("final_balance")
    var finalBalance: Long, // 24859749136640
    @SerializedName("hash160")
    var hash160: String, // 23e522dfc6656a8fda3d47b4fa53f7585ac758cd
    @SerializedName("n_tx")
    var nTx: Int, // 916
    @SerializedName("n_unredeemed")
    var nUnredeemed: Int, // 430
    @SerializedName("total_received")
    var totalReceived: Long, // 119037520063248
    @SerializedName("total_sent")
    var totalSent: Long, // 94177770926608
    @SerializedName("txs")
    var txs: List<Tx>
)