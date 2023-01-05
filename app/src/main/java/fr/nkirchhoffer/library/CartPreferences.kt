package fr.nkirchhoffer.library

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CartPreferences(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("cart_preferences", Context.MODE_PRIVATE)
    private val gson = Gson()

    // Enregistrer la liste de produits
    fun addToCart(book: Book) {
        val editor = sharedPreferences.edit()
        val cart = getCart()
        cart.add(book)
        val json = gson.toJson(cart)
        editor.putString("cart", json)
        editor.apply()
    }

    // Récupérer la liste de produits
    fun getCart(): ArrayList<Book> {
        val json = sharedPreferences.getString("cart", null)
        return if (json == null) {
            ArrayList<Book>()
        } else {
            gson.fromJson(json, object : TypeToken<ArrayList<Book>>() {}.type)
        }
    }
}
