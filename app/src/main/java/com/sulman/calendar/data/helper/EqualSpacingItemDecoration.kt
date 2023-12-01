package com.sulman.calendar.data.helper

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

//class ItemSpacingDecoration(private val spaceInPixels: Int) : RecyclerView.ItemDecoration() {
//
//    override fun getItemOffsets(
//        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
//    ) {
//        outRect.left = spaceInPixels
//        outRect.right = spaceInPixels
//    }
//}

class EqualSpacingItemDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = spacing
        outRect.left = spacing
        outRect.right = spacing
        outRect.bottom = spacing
    }
}
