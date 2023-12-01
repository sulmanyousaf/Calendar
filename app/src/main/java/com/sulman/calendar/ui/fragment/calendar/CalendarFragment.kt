package com.sulman.calendar.ui.fragment.calendar

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.sulman.calendar.R
import com.sulman.calendar.data.adapter.DateAdapter
import com.sulman.calendar.data.adapter.ListItemAdapter
import com.sulman.calendar.data.helper.EqualSpacingItemDecoration
import com.sulman.calendar.data.model.DateModel
import com.sulman.calendar.data.model.ListItemModel
import com.sulman.calendar.databinding.FragmentCalendarBinding
import com.sulman.calendar.utils.hideBottomComponents
import com.sulman.calendar.utils.showBottomComponents
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CalendarFragment : Fragment(R.layout.fragment_calendar) {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private val calendar: Calendar = Calendar.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCalendarBinding.bind(view)

        binding.apply {

            ivSetting.setOnClickListener {
                hideBottomComponents()
            }

            tvHeading.setOnClickListener{
                showBottomComponents()
            }

            // Set the calendar to the first day of the month
            calendar.set(Calendar.DAY_OF_MONTH, 1)

            // Set up the RecyclerView
            calendarRecyclerView.adapter = DateAdapter(generateDateList())

            val calendarList = resources.getStringArray(R.array.months_array)
            val arrayAdapter = ArrayAdapter(requireContext(),
                R.layout.dropdown_calendar_item, calendarList)
            autoCompleteCalendar.setAdapter(arrayAdapter)

            autoCompleteCalendar.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    ilCalendar.setEndIconDrawable(R.drawable.arrow_down)
                } else {
                    ilCalendar.setEndIconDrawable(R.drawable.arrow_up)
                }
            }

            autoCompleteCalendar.setOnItemClickListener { parent, view, position, id ->
                ilCalendar.setEndIconDrawable(R.drawable.arrow_down)
            }

            val itemList = listOf(
                ListItemModel(
//                    icon = getResourceUri(R.drawable.spotify_logo),
                    icon = R.drawable.spotify_logo,
                    title = "Spotify",
                    price = "$5.99"
                ),
                ListItemModel(
//                    icon = getResourceUri(R.drawable.youtube_premium_logo),
                    icon = R.drawable.youtube_premium_logo,
                    title = "Youtube Premium",
                    price = "$18.99"
                ),
                ListItemModel(
//                    icon = getResourceUri(R.drawable.cloud),
                    icon = R.drawable.cloud,
                    title = "Cloud Storage",
                    price = "$15.49"
                ),
                ListItemModel(
//                    icon = getResourceUri(R.drawable.netflix),
                    icon = R.drawable.netflix,
                    title = "Netflix",
                    price = "$8.99"
                )
            )

            val spacingInPixels = requireActivity().resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._4sdp)
            var layoutManagerRV = GridLayoutManager(requireContext(), 2)
            val itemDecoration = EqualSpacingItemDecoration(spacingInPixels)
            rv.apply {
                layoutManager = layoutManagerRV
                adapter = ListItemAdapter(itemList)
                addItemDecoration(itemDecoration)
            }
        }

    }

    private fun generateDateList(): List<DateModel> {
        val dateList = mutableListOf<DateModel>()
        // Add logic to calculate and populate dateList based on selectedMonth and selectedYear
        // ...
        val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        // For demonstration purposes, let's assume a simple array of dates
        for (i in 1..maxDay) {
            calendar.set(Calendar.DAY_OF_MONTH, i)
            dateList.add(DateModel().apply {
//                date = i.toString()
                date = SimpleDateFormat("dd", Locale.getDefault()).format(calendar.time)
                day = SimpleDateFormat("E", Locale.getDefault()).format(calendar.time)
            })
        }

        return dateList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}