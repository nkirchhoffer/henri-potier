package fr.nkirchhoffer.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.ActionBar
import android.graphics.drawable.Drawable

class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        var book: Book? = intent.getParcelableExtra<Book>("book")
        var actionBar: ActionBar? = getActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setHomeAsUpIndicator(com.google.android.material.R.drawable.material_ic_keyboard_arrow_left_black_24dp)
    }
}