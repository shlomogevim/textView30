package com.sg.textview30

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()
        val constraintLayout = ConstraintLayout(this)
       // constraintSet.clone(constraintLayout)
        setContentView(constraintLayout)
        val post = CreatePosts().createPost4999071()
        //createText(constraintLayout,5,"Bottom",200,90)
        createText(constraintLayout,post)

        /*



        setData(post)
        loadImage(constraintLayout, post)
        //  setText(constraintLayout, post)

        setText1(constraintLayout)
        constraintSet.applyTo(constraintLayout)*/


    }


  //  private fun createText(constraintLayout: ConstraintLayout, items:Int, position: String, margin: Int, dis: Int) {
    private fun createText(constraintLayout: ConstraintLayout, post:Post) {
      //    textLocation = arrayListOf(10,-1, 33,10,0,0, 0, 0)
        val items=post.postText.size
      val dataAr = post.textLocation
      val dis= dataAr[2]
      var position=""
      var margin=0
      if (dataAr[1] == -1) {
          position ="Bottom"
          margin = dataAr[3]
      } else {
          position= "Top"
          margin = dataAr[1]
      }



        val mainLayout = createMainLayout(this, items, position, margin, dis)
        mainLayout.id = View.generateViewId()
        constraintLayout.addView(mainLayout)
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(mainLayout.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(mainLayout.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        if (position == "Top") {
            constraintSet.connect(mainLayout.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, dpToPx(margin))
        } else {
            constraintSet.connect(mainLayout.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, dpToPx(margin))
        }
        constraintSet.applyTo(constraintLayout)
        setContentView(constraintLayout)
    }



    fun createLinearLayout(context: Context, textViewsCount: Int, margin: Int, position: String): LinearLayout {
        val ll1 = LinearLayout(context)
        ll1.orientation = LinearLayout.VERTICAL
        val textViews = createTextViews(context, textViewsCount, margin)
        for (i in textViews) {
            ll1.addView(i)
        }
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        when (position) {
            "Top" -> layoutParams.topMargin = dpToPx(margin)
            "Bottom" -> layoutParams.bottomMargin = dpToPx(margin)
        }
        ll1.layoutParams = layoutParams
        return ll1
    }

    fun createMainLayout(context: Context, textViewsCount: Int, position: String, margin: Int, distance: Int): LinearLayout {
        val ll1 = createLinearLayout(context, textViewsCount, distance, position)
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        when (position) {
            "Top" -> layoutParams.topMargin = dpToPx(margin)
            "Bottom" -> layoutParams.bottomMargin = dpToPx(margin)
        }
        ll1.layoutParams = layoutParams
        return ll1
    }

    private fun createTextViews(context: Context, textViewsCount: Int, margin: Int): Array<TextView?> {
        val textViews = arrayOfNulls<TextView>(textViewsCount)
        for (i in 0 until textViewsCount) {
            textViews[i] = TextView(context)
            textViews[i]!!.id = View.generateViewId()
            textViews[i]!!.text = "TextView $i"
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, margin, 0, 0)
            textViews[i]!!.layoutParams = layoutParams
        }
        return textViews
    }

    fun dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }



}