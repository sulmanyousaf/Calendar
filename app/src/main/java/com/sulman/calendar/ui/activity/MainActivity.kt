package com.sulman.calendar.ui.activity

//import android.os.Bundle
//import android.view.View
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.cardview.widget.CardView
//import com.sulman.calendar.databinding.ActivityMainBinding
//import java.text.SimpleDateFormat
//import java.util.*
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//    private val calendar: Calendar = Calendar.getInstance()
//    private val sdf = SimpleDateFormat("EEE", Locale.getDefault())
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.apply {
//
//            // Populate Spinner with months
//            val adapter = ArrayAdapter.createFromResource(
//                this@MainActivity,
//                R.array.months_array,
//                android.R.layout.simple_spinner_item
//            )
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            monthSpinner.adapter = adapter
//
//            // Set initial month and year
//            val initialMonth = calendar.get(Calendar.MONTH)
//            val initialYear = calendar.get(Calendar.YEAR)
//
//            // Set current month in the spinner
//            monthSpinner.setSelection(initialMonth)
//
//            // Set up the grid layout
//            setUpGridLayout(initialMonth, initialYear)
//
//            // Set listener for month selection changes
//            monthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                    // Get selected month and year
//                    val selectedYear = calendar.get(Calendar.YEAR)
//
//                    // Set up the grid layout for the selected month and year
//                    setUpGridLayout(position, selectedYear)
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                    // Do nothing
//                }
//            }
//        }
//    }
//
//    private fun setUpGridLayout(selectedMonth: Int, selectedYear: Int) {
//        // Clear existing views in GridLayout
//        binding.calendarRecyclerView.removeAllViews()
//
//        // Set calendar to the selected month and year
//        calendar.set(Calendar.YEAR, selectedYear)
//        calendar.set(Calendar.MONTH, selectedMonth)
//
//        // Set the calendar to the first day of the month
//        calendar.set(Calendar.DAY_OF_MONTH, 1)
//
//        // Get the maximum day of the month
//        val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
//
//        // Add the days of the week as headers
////        for (i in 1..7) {
////            val dayOfWeek = sdf.format(calendar.time)
////            addDayHeader(dayOfWeek)
////            calendar.add(Calendar.DAY_OF_MONTH, 1)
////        }
//
//        // Reset the calendar to the first day of the month
////        calendar.set(Calendar.DAY_OF_MONTH, 1)
//
//        // Add empty cells for days before the 1st of the month
////        for (i in 1 until calendar.get(Calendar.DAY_OF_WEEK)) {
////            addEmptyCell()
////        }
//
//        // Add the dates of the month to the GridLayout
//        for (day in 1..maxDay) {
//            addDateCell(day)
//        }
//    }
//
//    private fun addDayHeader(day: String) {
//        val dayView = layoutInflater.inflate(R.layout.item_date_card, null) as CardView
//        dayView.findViewById<TextView>(R.id.dateTextView).text = day
//        dayView.findViewById<TextView>(R.id.dayTextView).visibility = View.GONE
//        binding.calendarRecyclerView.addView(dayView)
//    }
//
//    private fun addEmptyCell() {
//        val emptyView = layoutInflater.inflate(R.layout.item_date_card, null) as CardView
//        emptyView.visibility = View.INVISIBLE
//        binding.calendarRecyclerView.addView(emptyView)
//    }
//
//    private fun addDateCell(day: Int) {
//        val dateView = layoutInflater.inflate(R.layout.item_date_card, null) as CardView
//        dateView.findViewById<TextView>(R.id.dateTextView).text = day.toString()
//        dateView.findViewById<TextView>(R.id.dayTextView).visibility = View.VISIBLE
//        dateView.findViewById<TextView>(R.id.dayTextView).text = sdf.format(calendar.time)
//        binding.calendarRecyclerView.addView(dateView)
//
//        // Move the calendar to the next day
//        calendar.add(Calendar.DAY_OF_MONTH, 1)
//    }
//}

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.shape.MaterialShapeDrawable
import com.sulman.calendar.R
import com.sulman.calendar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val radiusInDp = 12f
            val radius = resources.displayMetrics.density * radiusInDp

            val bottomBarBackground = bottomAppBar.background as MaterialShapeDrawable
            bottomBarBackground.shapeAppearanceModel = bottomBarBackground.shapeAppearanceModel
                .toBuilder()
                .setAllCornerSizes(radius)
                .build()

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController

            bottomNavigationView.setupWithNavController(navController)

            // Populate Spinner with months
//            val adapter = ArrayAdapter.createFromResource(
//                this,
//                R.array.months_array,
//                android.R.layout.simple_spinner_item
////            R.layout.spinner_layout
//            )
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        binding.monthSpinner.adapter = adapter

            // Inside your MainActivity
//            val spacingInPixels =
//                resources.getDimensionPixelSize(R.dimen.spacing_between_spinner_items) // Adjust as needed
//            binding.calendarRecyclerView.addItemDecoration(ItemSpacingDecoration(spacingInPixels))


            // Set initial month and year
//            val initialMonth = calendar.get(Calendar.MONTH)
//            val initialYear = calendar.get(Calendar.YEAR)

            // Set current month in the spinner
//        binding.monthSpinner.setSelection(initialMonth)

//            // Set the calendar to the first day of the month
//            calendar.set(Calendar.DAY_OF_MONTH, 1)
//
//            // Set up the RecyclerView
//            val dateList = generateDateList()
//            val dateAdapter = DateAdapter(dateList)
//            binding.calendarRecyclerView.adapter = dateAdapter

            // Set listener for month selection changes
//        binding.monthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                // Get selected month and year
////                val selectedYear = calendar.get(Calendar.YEAR)
//
//                // Set calendar to the selected month and year
////                calendar.set(Calendar.YEAR, selectedYear)
//                calendar.set(Calendar.MONTH, position)
//
//                // Set the calendar to the first day of the month
////                calendar.set(Calendar.DAY_OF_MONTH, 1)
//
//                // Update the RecyclerView with the selected month and year
////                val updatedDateList = generateDateList(position, selectedYear)
//                val updatedDateList = generateDateList()
//                dateAdapter.updateList(updatedDateList)
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                // Do nothing
//            }

//            val feelings = resources.getStringArray(R.array.months_array)
//            val arrayAdapter = ArrayAdapter(this@MainActivity, R.layout.dropdown_calendar_item, feelings)
//            autoCompleteCalendar.setAdapter(arrayAdapter)
//
//            autoCompleteCalendar.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
//                if (hasFocus) {
//                    // Dropdown is open, change endIconDrawable to arrow_up
////                    ilCalendar.setEndIconDrawable(R.drawable.arrow_up)
//                    ilCalendar.setEndIconDrawable(R.drawable.arrow_down)
//                } else {
//                    // Dropdown is closed, change endIconDrawable to arrow_down
////                    ilCalendar.setEndIconDrawable(R.drawable.arrow_down)
//                    ilCalendar.setEndIconDrawable(R.drawable.arrow_up)
//                }
//            }
//
//
//            autoCompleteCalendar.setOnItemClickListener { parent, view, position, id ->
//                ilCalendar.setEndIconDrawable(R.drawable.arrow_down)
////                autoCompleteCalendar.setSelection(position)
//            }

//            val initialMonth = calendar.get(Calendar.MONTH)
//            autoCompleteCalendar.setSelection(calendar.get(Calendar.MONTH))
        }

    }


//    private fun generateDateList(selectedMonth: Int, selectedYear: Int): List<DateModel> {
//    private fun generateDateList(): List<DateModel> {
//        val dateList = mutableListOf<DateModel>()
//        // Add logic to calculate and populate dateList based on selectedMonth and selectedYear
//        // ...
//        val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
//        // For demonstration purposes, let's assume a simple array of dates
//        for (i in 1..maxDay) {
//            calendar.set(Calendar.DAY_OF_MONTH, i)
//            dateList.add(DateModel().apply {
////                date = i.toString()
//                date = SimpleDateFormat("dd", Locale.getDefault()).format(calendar.time)
//                day = SimpleDateFormat("E", Locale.getDefault()).format(calendar.time)
//            })
//        }
//
//        return dateList
//    }

}
