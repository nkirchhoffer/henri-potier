package fr.nkirchhoffer.library

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_cart)

        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val cart = CartPreferences(this)
        val adapter: CartAdapter = CartAdapter(cart.getCart())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}
