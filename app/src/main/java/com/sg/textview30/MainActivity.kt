package com.sg.textview30

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {
    val helper=Helper()
//    lateinit var currentPost:Post
    var position1=""
    var margin1=0
    var dis1=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()
        val constraintLayout = ConstraintLayout(this)
       // constraintSet.clone(constraintLayout)
        setContentView(constraintLayout)
        val currentPost = CreatePosts().createPost4999071()
        setCurrentParameters(currentPost)
        loadImage(constraintLayout, currentPost)
        createText(constraintLayout,currentPost)


    }


    private fun setCurrentParameters(currentPost:Post) {
        //    textLocation = arrayListOf(10,-1, 33,10,0,0, 0, 0)
        val dataAr =currentPost.textLocation
         dis1 = dataAr[2]
       if (dataAr[1] == -1) {
           position1 =TOP
            margin1= dataAr[3]
        }
        if (dataAr[3] == -1) {
            position1 = BOTTOM
           margin1= dataAr[1]
        }
//        logi("56 dis1=$dis1        position1=$position1     margin1=$margin1")
    }

    private fun createText(constraintLayout: ConstraintLayout, post:Post) {
      //    textLocation = arrayListOf(10,-1, 33,10,0,0, 0, 0)
//        val mainLayout = createMainLayout(this,post)
        val mainLayout = createLinearLayout(this,post)
        mainLayout.id = View.generateViewId()
        constraintLayout.addView(mainLayout)
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(mainLayout.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(mainLayout.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        if (position1 == TOP) {
            constraintSet.connect(mainLayout.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, dpToPx(margin1))
        } else {
            constraintSet.connect(mainLayout.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, dpToPx(margin1))
        }
        constraintSet.applyTo(constraintLayout)
        setContentView(constraintLayout)
    }

    fun createLinearLayout(context: Context,post:Post): LinearLayout {
        val ll1 = LinearLayout(context)
        ll1.orientation = LinearLayout.VERTICAL
        ll1.gravity= Gravity.CENTER_HORIZONTAL
        val textViews = createTextViews(context,post)
        for (i in textViews) {
            ll1.addView(i)
        }
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        when (position1) {
           TOP -> layoutParams.topMargin = dpToPx(margin1)
           BOTTOM -> layoutParams.bottomMargin = dpToPx(margin1)
        }
        ll1.layoutParams = layoutParams
        return ll1
    }

//    fun createMainLayout(context: Context,post:Post): LinearLayout {
//        val ll1 = createLinearLayout(context, post)
//        val layoutParams = ConstraintLayout.LayoutParams(
//            ConstraintLayout.LayoutParams.WRAP_CONTENT,
//            ConstraintLayout.LayoutParams.WRAP_CONTENT
//        )
//        when (position1) {
//            TOP -> layoutParams.topMargin = dpToPx(margin1)
//            BOTTOM -> layoutParams.bottomMargin = dpToPx(margin1)
//        }
//        ll1.layoutParams = layoutParams
//        return ll1
//    }

    private fun createTextViews(context: Context, post:Post): Array<TextView?> {
           //original version
            val textViews = arrayOfNulls<TextView>(post.postText.size)
        for (index in 0 until post.postText.size) {
            textViews[index] = TextView(context)
            textViews[index]!!.id = View.generateViewId()
            val st="זוהי הודעה מספר : "
            textViews[index]!!.text = post.postText[index]
            textViews[index]!!.textSize = post.postTextSize[1].toFloat()
            textViews[index]!!.setTextColor(Color.parseColor(updateColor(post.postTextColor[1])))
            val shape = GradientDrawable()
            shape.cornerRadius =post.postRadiuas.toFloat()
            shape.setColor(Color.parseColor(updateColor(post.postBackground)))
            textViews[index]!!.background = shape
            // textView.setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
            val pad =post.postPadding
            textViews[index]!!.setPadding(pad[0].toPx(), pad[1].toPx(), pad[2].toPx(), pad[3].toPx())
            textViews[index]!!.alpha =post.postTransparency / 10f
            val typeface = helper.getFamilyFont(post.postFontFamily)
            textViews[index]!!.typeface = ResourcesCompat.getFont(this, typeface)
            textViews[index]!!.setLineSpacing(0f, post.lineSpacing)
//          The first parameter is the extra space that will be added to the height of each line of text,
//            and the second parameter is the multiplication factor that will be applied to the default line spacing.
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0,dis1.toPx(), 0, 0)
            textViews[index]!!.layoutParams = layoutParams
        }
        return textViews
    }
    private fun loadImage(layout: ConstraintLayout, post: Post) {
        val imageView = ImageView(layout.context)
        imageView.id = View.generateViewId()
        val params = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
//        params.dimensionRatio = "H,1:1"
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        imageView.layoutParams = params
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        layout.addView(imageView)
        Glide.with(layout.context)
            .load(post.imageUri)
            .into(imageView)
    }

    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun updateColor(str: String): String {
    return "#" + str.replace("[^A-Za-z0-9]".toRegex(), "")
}
    fun logi(message: String) {
        Log.i("gg", message)
    }

  /*  private fun createTextViews(lines: ArrayList<String>): List<TextView> {
        val textViews = mutableListOf<TextView>()
        for (index in 0 until lines.size) {
            val textView = TextView(this)
            textView.text = lines[index]
            textView.textSize = post.postTextSize[1].toFloat()
            textView.setTextColor(Color.parseColor(updateColor(post.postTextColor[1])))
            val shape = GradientDrawable()
            shape.cornerRadius = post.postRadiuas.toFloat()
            shape.setColor(Color.parseColor(updateColor(post.postBackground)))
            textView.background = shape
            // textView.setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
            val pad = post.postPadding
            textView.setPadding(pad[0].toPx(), pad[1].toPx(), pad[2].toPx(), pad[3].toPx())
            textView.alpha = post.postTransparency / 10f
            val typeface = helper.getFamilyFont(post.postFontFamily)
            textView.typeface = ResourcesCompat.getFont(this, typeface)
            textView.setLineSpacing(0f, post.lineSpacing)
            *//*The first parameter is the extra space that will be added to the height of each line of text,
             and the second parameter is the multiplication factor that will be applied to the default line spacing.*//*
            val layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            textView.layoutParams = layoutParams
            textViews.add(textView)
        }
        return textViews
    }*/
    /**/
    fun dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }



}