package yp.ypblockchainexplorer.model


import com.google.gson.annotations.SerializedName

data class Out(
    @SerializedName("addr")
    val addr: String,
    @SerializedName("n")
    val n: Int,
    @SerializedName("script")
    val script: String,
    @SerializedName("spending_outpoints")
    val spendingOutpoints: List<SpendingOutpoint>,
    @SerializedName("spent")
    val spent: Boolean,
    @SerializedName("tx_index")
    val txIndex: Long,
    @SerializedName("type")
    val type: Int,
    @SerializedName("value")
    val value: Int
)