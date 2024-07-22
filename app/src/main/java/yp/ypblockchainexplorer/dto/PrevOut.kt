package yp.ypblockchainexplorer.dto


import com.google.gson.annotations.SerializedName

data class PrevOut(
    @SerializedName("addr")
    var addr: String, // bc1qm34lsc65zpw79lxes69zkqmk6ee3ewf0j77s3h
    @SerializedName("n")
    var n: Int, // 1
    @SerializedName("script")
    var script: String, // 0014dc6bf86354105de2fcd9868a2b0376d6731cb92f
    @SerializedName("spending_outpoints")
    var spendingOutpoints: List<SpendingOutpoint>,
    @SerializedName("spent")
    var spent: Boolean, // true
    @SerializedName("tx_index")
    var txIndex: Long, // 5101729899408197
    @SerializedName("type")
    var type: Int, // 0
    @SerializedName("value")
    var value: Long // 7160633110
)