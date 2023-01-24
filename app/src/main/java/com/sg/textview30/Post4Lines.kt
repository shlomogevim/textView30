package com.sg.textview30

import android.app.Activity
import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout



class Post4Lines(val context: Context) {

    fun loadPost400():Post {
        val post = Post()
        with(post) {
            postNum = 400
            imageUri = "https://cdn.pixabay.com/photo/2020/01/21/11/39/running-4782722_1280.jpg"
            postText = arrayListOf(
                "על תהיה הכי טוב",
                "זה לא יצליח לך לאורך זמן,",
                " לך על משהו יותר ממשי",
                "תהיה הכי אתה."
            )
        }
        return post
    }

    fun loadPost401():Post {
        val post = Post()
        with(post) {
            postNum = 401
            imageUri =
                "https://cdn.pixabay.com/photo/2017/01/09/22/24/guy-playing-billiard-1967834_1280.jpg"
            postText = arrayListOf(
                " הבלים הם דברים אמיתיים, ",
                " מה שהופך אותם להבלים לגביך ",
                " זו היכולת שלהם ",
                " למנוע ממך להתפתח. "
            )
        }
       return post
    }

    fun loadPost402() :Post{
        val post = Post()
        with(post) {
            postNum = 402
           imageUri = "https://cdn.pixabay.com/photo/2020/01/25/09/28/woman-4792042_1280.jpg"
            postText = arrayListOf(
                " פסימיות ",
                " זה לחשוב שיש מישהו מאושר ממך, ",
                " אופטימיות ",
                " זה להבין שאין אחד כזה. "
            )
        }
        return post
    }
  }





