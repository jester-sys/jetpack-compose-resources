package com.example.jetpack.ViewPager

import androidx.annotation.DrawableRes
import com.example.jetpack.R

data  class Pager(
     @DrawableRes val image:Int,
     val title:String
 )

val dataList= listOf(
    Pager(R.drawable.img1,"Pages One"),
    Pager(R.drawable.img2,"Page Two")
)