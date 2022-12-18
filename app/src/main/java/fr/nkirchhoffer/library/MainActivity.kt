package fr.nkirchhoffer.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getBooks()
    }

    fun getBooks() {
        var bookService = HenriPotierService()
        bookService.getApi().listBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                var books: List<Book>? = response.body()
                println("SIZE : " + books?.size);
                val recyclerView = findViewById<RecyclerView>(R.id.bookList)
                recyclerView.adapter = books?.let { ListAdapter(it) }
                recyclerView.layoutManager = GridLayoutManager(applicationContext, resources.getInteger(R.integer.cols))
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                System.err.println(t.message)
            }

        })
    }
}