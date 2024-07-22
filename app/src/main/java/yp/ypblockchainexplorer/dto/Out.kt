package yp.ypblockchainexplorer.dto


import com.google.gson.annotations.SerializedName

data class Out(
    @SerializedName("addr")
    var addr: String?, // bc1qv62jq35wl5rw5d9d7z2pgmk4q396e59uazrvja
    @SerializedName("n")
    var n: Int, // 0
    @SerializedName("script")
    var script: String, // 0014669520468efd06ea34adf094146ed5044bacd0bc
    @SerializedName("spending_outpoints")
    var spendingOutpoints: List<SpendingOutpointX>,
    @SerializedName("spent")
    var spent: Boolean, // true
    @SerializedName("tx_index")
    var txIndex: Long, // 4243536000463176
    @SerializedName("type")
    var type: Int, // 0
    @SerializedName("value")
    var value: Long // 4880000000
)