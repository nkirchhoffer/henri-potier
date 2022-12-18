package fr.nkirchhoffer.library

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle.parent

class ListAdapter(private val books: List<Book>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var titleView: TextView? = null
        var coverView: ImageView? = null

        init {
            titleView = view.findViewById(R.id.bookTitle)
            coverView = view.findViewById(R.id.bookCover)
        }

    }

    @OptIn(InternalCoroutinesApi::class)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.titleView?.text = books[position].title
        Picasso.get().load(books[position].cover).into(holder?.coverView)
        holder.itemView.setOnClickListener{
            var intent: Intent = Intent(holder.itemView.context, BookActivity::class.java)
            intent.putExtra("book", books[position])
            startActivity(holder.itemView.context, intent, null)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bookView = LayoutInflater.from(parent?.context).inflate(R.layout.book_view, parent, false)
        return ViewHolder(bookView)
    }

    override fun getItemCount(): Int = books.size
}