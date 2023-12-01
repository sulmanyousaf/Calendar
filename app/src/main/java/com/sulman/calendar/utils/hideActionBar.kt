package com.sulman.calendar.utils

import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sulman.calendar.R

fun Fragment.showBottomComponents() {

    changeFragmentBottomMarginToActionBarSize()

    requireActivity().findViewById<BottomAppBar>(R.id.bottomAppBar).apply {
        visible()
    }
    requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView).apply {
        visible()
    }
    requireActivity().findViewById<FloatingActionButton>(R.id.fab).apply {
        visible()
    }
}

fun Fragment.hideBottomComponents() {

    changeFragmentBottomMargin()

    requireActivity().findViewById<BottomAppBar>(R.id.bottomAppBar).apply {
        gone()
    }
    requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView).apply {
        gone()
    }
    requireActivity().findViewById<FloatingActionButton>(R.id.fab).apply {
        gone()
    }
}

fun View?.gone() {
    this?.let { it.visibility = View.GONE }
}

fun View?.visible() {
    this?.let { it.visibility = View.VISIBLE }
}

fun Fragment.changeFragmentBottomMargin(){
    val fragmentContainerView = requireActivity().findViewById<FragmentContainerView>(R.id.fragmentContainerView)
    val layoutParams = fragmentContainerView.layoutParams as ViewGroup.MarginLayoutParams
    layoutParams.bottomMargin = 0 // Set bottom margin to 0dp
    fragmentContainerView.layoutParams = layoutParams
}

fun Fragment.changeFragmentBottomMarginToActionBarSize() {
    val typedValue = TypedValue()
    if (requireActivity().theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
        val actionBarHeight = TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)

        val fragmentContainerView = requireActivity().findViewById<FragmentContainerView>(R.id.fragmentContainerView)
        val layoutParams = fragmentContainerView.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.bottomMargin = actionBarHeight
        fragmentContainerView.layoutParams = layoutParams
    }
}