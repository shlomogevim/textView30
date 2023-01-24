package com.sg.textview30

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil.DiffResult.NO_POSITION
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


import kotlin.collections.ArrayList


class PostAdapter(val context: Context, val posts: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    //  val util = UtilityPost()
// val base = BaseActivity()
    // val pref = context.getSharedPreferences(SHARPREF_ALMA, Context.MODE_PRIVATE)
// var movingBackgroundMode = pref.getString(SHARPREF_MOVING_BACKGROUND, FALSE)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindImage(posts[position])
        //   pref.edit().putInt(Constants.SHARPREF_CURRENT_POST_POSITION, position).apply()

    }


    override fun getItemCount() = posts.size


    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView?.findViewById<ConstraintLayout>(R.id.itemLayout)

        /*   val layout = itemView?.findViewById<ConstraintLayout>(R.id.itemLayout)
        val image = itemView?.findViewById<ImageView>(R.id.pagerImage)
        val ken = itemView.findViewById<com.flaviofaria.kenburnsview.KenBurnsView>(R.id.tour_image)
        val postVideoBtn = itemView?.findViewById<Button>(R.id.videoBtn)
        val postAudioBtn = itemView?.findViewById<Button>(R.id.audioBtn)*/


        fun bindImage(post: Post) {
            DrawGeneralPost().drawPost(context, post, layout)
        }
    }
}
              /* fun bindImage(post: Post) {
            pref.edit().putString(AUDIO_POSITION, FALSE).apply()
            DrawGeneralPost().drawPost(context, post, layout)
            image.setOnClickListener {
                val editor = pref.edit()
                val gson = Gson()
                val json: String = gson.toJson(post)
                editor.putString(SHARPREF_CURRENT_POST, json)
                editor.apply()
                context.startActivity(Intent(context, PostDetailesActivity::class.java))

            }
            if (post.videoText == Constants.NO_VALUE) {
                postVideoBtn.visibility=View.GONE
            } else {
                postVideoBtn.setOnClickListener {
                    val editor = pref.edit()
                    val gson = Gson()
                    val json: String = gson.toJson(post)
                    editor.putString(SHARPREF_CURRENT_POST, json)
                    editor.apply()
//                 val intent = Intent(context, VideoActivity::class.java)
//                 intent.putExtra(CURRENT_URL, post.videoUrl)
//                 context.startActivity(intent)
                    context.startActivity(Intent(context, VideoActivity::class.java))
                }
                postAudioBtn.setOnClickListener {
                    val textVideo=post.videoText
                    val intent=Intent(context, VideoExplanationActivity::class.java)
                    intent.putExtra(VIDEO_TEXT,textVideo)
                    context.startActivity(intent)
                }*/