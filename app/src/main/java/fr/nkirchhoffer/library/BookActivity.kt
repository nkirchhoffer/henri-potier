package fr.nkirchhoffer.library

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso


class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        var book: Book? = intent.getParcelableExtra<Book>("book")
        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        val title = findViewById<TextView>(R.id.bookDetailsTitle)
        val bookCover = findViewById<ImageView>(R.id.bookCover)
        val bookSynopsis = findViewById<TextView>(R.id.bookSynopsis)
        val isbn = findViewById<TextView>(R.id.bookIsbn)
        val price = findViewById<TextView>(R.id.priceText)
        val cartButton = findViewById<Button>(R.id.addToCartButton)

        title.text = book?.title
        bookSynopsis.text = book?.synopsis?.joinToString("\n\n")

        Picasso.get().load(book?.cover).into(bookCover)

        isbn.text = "ISBN : " + book?.isbn

        price.text = book?.price.toString() + "€"

        val color = if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            ContextCompat.getColor(this, R.color.white)
        } else {
            ContextCompat.getColor(this, R.color.black)
        }
        price.setTextColor(color)

        cartButton.setOnClickListener{
            val cart = CartPreferences(this)
            book?.let{
                cart.addToCart(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cart, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.action_cart -> {
                val intent = Intent(this, CartActivity::class.java)
                startActivity( intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}