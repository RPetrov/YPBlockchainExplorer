package yp.ypblockchainexplorer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import yp.ypblockchainexplorer.model.Tx
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.Date

class TransactionsAdapter(var listTransacctions: List<Tx>) :
    RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {

    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(tx: Tx) {
            val idData = itemView.findViewById<TextView>(R.id.id_data)
            val date = itemView.findViewById<TextView>(R.id.date)
            val amount = itemView.findViewById<TextView>(R.id.amount)
            val fee = itemView.findViewById<TextView>(R.id.fee)

            idData.text = "${tx.hash.substring(0, 4)}-${tx.hash.substring(tx.hash.length - 4)}"
            date.text = SimpleDateFormat("dd.MM.YYYY HH:mm").format(Date(tx.time * 1000L))
            amount.text = BigDecimal(tx.balance).divide(BigDecimal(100000000)).toString()
            fee.text = tx.fee.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(listTransacctions[position])
    }

    override fun getItemCount() = listTransacctions.size


}