package yp.ypblockchainexplorer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yp.ypblockchainexplorer.blockchainapi.Tx
import java.math.BigDecimal

class TransactionViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tx_item, parent, false)) {

    val hashTextView = itemView.findViewById<TextView>(R.id.hash)
    val balance = itemView.findViewById<TextView>(R.id.balance)
    fun bind(tx: Tx) {
        val hash = tx.hash
        hashTextView.text = "${hash.substring(0..4)}-${hash.substring(hash.length - 4)}"
        balance.text = BigDecimal(tx.balance).divide(BigDecimal(1000000L)).toString()
    }
}

class TransactionsAdapter : RecyclerView.Adapter<TransactionViewHolder>() {

    var data: List<Tx> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}