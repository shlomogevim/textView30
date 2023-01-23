package com.sg.textview30


class CreatePosts {

  fun createPost4999071(): Post {
        val post = Post()
        with(post) {
            postNum = 4999071
            lineNum = 4
            imageUri ="https://cdn.pixabay.com/photo/2023/01/10/00/17/italy-7708552_960_720.jpg"

            postText = arrayListOf(
                " זכרון העבר ",
                " זה מה שקרה לך בעבר, ",
                "  טעות היא  ",
                " להכפיף את ההווה שלך לזה. "
            )
            postId = 87

            textLocation = arrayListOf(10,-1,10,10,0,0, 0, 0)  //  Top  o.k.
//            textLocation = arrayListOf(10,0,0,-1,0,0, 0, 0)  //  Button   n.o.k.

            postPadding = arrayListOf(0, 0, 10,0)
            postTransparency =10
            postTextSize = arrayListOf(0, 16)
            val backgroundColor = "#0A174E"
            val textColor = "#F5D042"
            postFontFamily = 103

            postBackground = backgroundColor
            postTextColor = arrayListOf(CONSTANT, textColor)
            videoUrl = "9UVjjcOUJLE"
            //   videoText = util1.getPostExplanation(postNum, postText)
        }
        //  drawPost.drawPostFire(post, layout)
        //  util.sendPostToStringFirestore(post)

        return post
    }

}