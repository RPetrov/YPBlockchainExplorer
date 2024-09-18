package yp.ypblockchainexplorer.model


import com.google.gson.annotations.SerializedName

data class Tx(
    @SerializedName("balance")
    val balance: Long,
    @SerializedName("block_height")
    val blockHeight: Int,
    @SerializedName("block_index")
    val blockIndex: Int,
    @SerializedName("double_spend")
    val doubleSpend: Boolean,
    @SerializedName("fee")
    val fee: Int,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("inputs")
    val inputs: List<Input>,
    @SerializedName("lock_time")
    val lockTime: Int,
    @SerializedName("out")
    val `out`: List<Out>,
    @SerializedName("rbf")
    val rbf: Boolean,
    @SerializedName("relayed_by")
    val relayedBy: String,
    @SerializedName("result")
    val result: Int,
    @SerializedName("size")
    val size: Int,
    @SerializedName("time")
    val time: Int,
    @SerializedName("tx_index")
    val txIndex: Long,
    @SerializedName("ver")
    val ver: Int,
    @SerializedName("vin_sz")
    val vinSz: Int,
    @SerializedName("vout_sz")
    val voutSz: Int,
    @SerializedName("weight")
    val weight: Int
)