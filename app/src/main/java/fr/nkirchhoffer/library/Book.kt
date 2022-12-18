package fr.nkirchhoffer.library

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(val isbn: String, val title: String, val price: Int, val cover: String, val synopsis: List<String> ) :
    Parcelable {

}