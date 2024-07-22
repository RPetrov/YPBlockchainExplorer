package yp.ypblockchainexplorer.dto


import com.google.gson.annotations.SerializedName

data class SpendingOutpoint(
    @SerializedName("n")
    var n: Int, // 0
    @SerializedName("tx_index")
    var txIndex: Long // 4243536000463176
)