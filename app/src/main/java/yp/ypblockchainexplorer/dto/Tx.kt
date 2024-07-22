package yp.ypblockchainexplorer.dto


import com.google.gson.annotations.SerializedName

data class Tx(
    @SerializedName("balance")
    var balance: Long, // 24859749136640
    @SerializedName("block_height")
    var blockHeight: Int, // 853237
    @SerializedName("block_index")
    var blockIndex: Int, // 853237
    @SerializedName("double_spend")
    var doubleSpend: Boolean, // false
    @SerializedName("fee")
    var fee: Int, // 31200
    @SerializedName("hash")
    var hash: String, // 35918c3ebe8692e643e36959c69577861daee01576c3f5af3f448a31bfc99b78
    @SerializedName("inputs")
    var inputs: List<Input>,
    @SerializedName("lock_time")
    var lockTime: Int, // 0
    @SerializedName("out")
    var `out`: List<Out>,
    @SerializedName("relayed_by")
    var relayedBy: String, // 0.0.0.0
    @SerializedName("result")
    var result: Int, // 65726
    @SerializedName("size")
    var size: Int, // 706
    @SerializedName("time")
    var time: Int, // 1721572068
    @SerializedName("tx_index")
    var txIndex: Long, // 4243536000463176
    @SerializedName("ver")
    var ver: Int, // 1
    @SerializedName("vin_sz")
    var vinSz: Int, // 1
    @SerializedName("vout_sz")
    var voutSz: Int, // 17
    @SerializedName("weight")
    var weight: Int // 2494
)