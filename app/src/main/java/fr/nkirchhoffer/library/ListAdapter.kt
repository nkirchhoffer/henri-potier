package fr.nkirchhoffer.library

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val books: List<Book>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var titleView: TextView? = null

        init {
            titleView = view.findViewById(R.id.bookTitle)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.titleView?.text = books[position].title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bookView = LayoutInflater.from(parent?.context).inflate(R.layout.book_view, parent, false)
        return ViewHolder(bookView)
    }

    override fun getItemCount(): Int = books.size
}