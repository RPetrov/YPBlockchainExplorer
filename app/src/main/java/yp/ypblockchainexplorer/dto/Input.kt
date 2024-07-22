package yp.ypblockchainexplorer.dto


import com.google.gson.annotations.SerializedName

data class Input(
    @SerializedName("index")
    var index: Int, // 0
    @SerializedName("prev_out")
    var prevOut: PrevOut,
    @SerializedName("script")
    var script: String,
    @SerializedName("sequence")
    var sequence: Long, // 4294967295
    @SerializedName("witness")
    var witness: String // 0248304502210093d4f9eb2bb7a29b8e51151e80792251714fab1532c242fb5d949d8052b40f7f022046c5470b47066ca13e95a85fb63a95b54c0587f4b3e1fb845e47703297410518012102174ee672429ff94304321cdae1fc1e487edf658b34bd1d36da03761658a2bb09
)