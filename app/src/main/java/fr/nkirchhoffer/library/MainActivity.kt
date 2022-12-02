package fr.nkirchhoffer.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val books = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setData()

        val recyclerView = findViewById<RecyclerView>(R.id.bookList)
        recyclerView.adapter = ListAdapter(books)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    fun setData() {
        books.add(Book("dlsdls", "oui", 30, "https://sss", "oui"))
        books.add(Book("dlsdls", "non", 30, "https://sss", "oui"))
        books.add(Book("dlsdls", "peut-être", 30, "https://sss", "oui"))
        books.add(Book("dlsdls", "nan", 30, "https://sss", "oui"))
    }
}