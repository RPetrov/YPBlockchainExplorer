package yp.ypblockchainexplorer.dto


import com.google.gson.annotations.SerializedName

data class SpendingOutpointX(
    @SerializedName("n")
    var n: Int, // 8
    @SerializedName("tx_index")
    var txIndex: Long // 5952497750643643
)