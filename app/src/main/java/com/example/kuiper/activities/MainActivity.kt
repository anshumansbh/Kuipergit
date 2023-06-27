package com.example.kuiper.activities

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.kuiper.fragments.NewsSummaryFragment
import com.example.kuiper.R
import com.example.kuiper.utils.OnSwipeTouchListener
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private var headlines = arrayOfNulls<String>(5)
    private var newsBody = arrayOfNulls<String>(5)
    private var newsImageUrl = arrayOfNulls<String>(5)
    private var newsFooter = arrayOfNulls<String>(5)

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
        loadFragment()


         findViewById<FragmentContainerView>(R.id.fragmentContainerView).setOnTouchListener(object: OnSwipeTouchListener(this@MainActivity) {
            override fun onSwipeTop() {
                displaySnackbar("Swipe up")
            }

             override fun onSwipeBottom() {
                 displaySnackbar("Swipe Down")
             }

             private fun displaySnackbar(message: String) {
                 val snackbar = Snackbar.make(
                     findViewById(R.id.fragmentContainerView), message,
                     Snackbar.LENGTH_LONG
                 ).setAction("Action", null)
                 snackbar.setActionTextColor(Color.BLUE)
                 val snackbarView = snackbar.view
                 snackbarView.setBackgroundColor(Color.LTGRAY)
                 val textView =
                     snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                 textView.setTextColor(Color.BLUE)
                 textView.textSize = 28f
                 snackbar.show()
             }

         })

    }


    private fun getNews()
    {
        headlines[0] = "morbi enim nunc faucibus a pellentesque sit amet porttitor eget"
        newsBody[0] = "vulputate enim nulla aliquet porttitor lacus luctus accumsan tortor posuere ac ut consequat semper viverra nam libero justo laoreet sit amet cursus sit amet dictum sit amet justo donec enim diam vulputate ut pharetra sit amet aliquam id diam maecenas ultricies mi eget mauris pharetra et ultrices neque ornare aenean"
        newsImageUrl[0] = "https://image.cnbcfm.com/api/v1/image/103138464-GettyImages-552736101.jpg?v=1446649877"
        newsFooter[0] = "ornare massa eget egestas purus viverra accumsan"
    }

    private fun loadFragment(){
        val fragment: Fragment?
        fragment = NewsSummaryFragment.newInstance(
            headlines[0],
            newsBody[0],
            newsImageUrl[0],
            newsFooter[0]
        )
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
    }

}