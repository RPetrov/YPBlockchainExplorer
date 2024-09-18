package yp.ypblockchainexplorer.model


import com.google.gson.annotations.SerializedName

data class SpendingOutpoint(
    @SerializedName("n")
    val n: Int,
    @SerializedName("tx_index")
    val txIndex: Long
)