package buu.informatics.s59161073.todayknowledge.score

import android.graphics.Color
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59161073.todayknowledge.R
import buu.informatics.s59161073.todayknowledge.database.GameScore

class ScoreAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    var data =  listOf<GameScore>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {

        holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)
        val item = data[position]

        Log.i("ShowHS", "${item.username}")

        holder.textView.text = "\t${item.username} is score ${item.score} \n"

        holder.textView.setTextColor(Color.BLACK)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)