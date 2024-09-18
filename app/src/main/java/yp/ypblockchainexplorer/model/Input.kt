package yp.ypblockchainexplorer.model


import com.google.gson.annotations.SerializedName

data class Input(
    @SerializedName("index")
    val index: Int,
    @SerializedName("prev_out")
    val prevOut: PrevOut,
    @SerializedName("script")
    val script: String,
    @SerializedName("sequence")
    val sequence: Long,
    @SerializedName("witness")
    val witness: String
)