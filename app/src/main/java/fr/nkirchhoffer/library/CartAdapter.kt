package fr.nkirchhoffer.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CartAdapter(private val bookList: List<Book>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cartBookName: TextView = itemView.findViewById(R.id.cart_book_name)
        val cartBookPrice: TextView = itemView.findViewById(R.id.cart_book_price)
        val cartBookCover: ImageView = itemView.findViewById(R.id.cart_book_cover)
        val cartRemoveButton: Button = itemView.findViewById(R.id.cart_remove_button)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val vue = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(vue)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val book = bookList[position]
        holder.cartBookName.text = book.title
        holder.cartBookPrice.text = book.price.toString()

        Picasso.get().load(book.cover).into(holder.cartBookCover)

        holder.cartRemoveButton.setOnClickListener {
            // Supprimer le produit du panier
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}
