package com.example.kuiper.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kuiper.R
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 * Use the [NewsSummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsSummaryFragment : Fragment() {
    private val HEADLINE_PARAM = "headline_param"
    private val NEWS_BODY_PARAM = "news_body_param"
    private val NEWS_IMAGE_URL_PARAM = "news_image_url_param"
    private val NEWS_FOOTER_TEXT_PARAM = "news_footer_text_param"

    private var headline_param: String? = null
    private var news_body_param: String? = null
    private var news_image_url_param: String? = null
    private var news_footer_param : String? = null

    private lateinit var ivNewsImage : ImageView
    private lateinit var tvHeadline : TextView
    private lateinit var tvNewsBody : TextView
    private lateinit var tvNewsFooter : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            headline_param = it.getString(HEADLINE_PARAM)
            news_body_param = it.getString(NEWS_BODY_PARAM)
            news_image_url_param = it.getString(NEWS_IMAGE_URL_PARAM)
            news_footer_param = it.getString(NEWS_FOOTER_TEXT_PARAM)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragBase = inflater.inflate(R.layout.fragment_news_summary, container, false)
        initViews(fragBase)
        initStaticVars()
        populateViews()
        return fragBase
    }

    private fun populateViews() {
        Picasso.get().load(news_image_url_param)
            .placeholder(com.google.android.material.R.drawable.ic_mtrl_checked_circle)
            .fit()
            .into(ivNewsImage)

        tvHeadline.setText(headline_param)
        tvNewsBody.setText(news_body_param)
        tvNewsFooter.setText(news_footer_param)
    }

    private fun initStaticVars() {
        headline_param = arguments?.getString(HEADLINE_PARAM)
        news_body_param = arguments?.getString(NEWS_BODY_PARAM)
        news_image_url_param = arguments?.getString(NEWS_IMAGE_URL_PARAM)
        news_footer_param = arguments?.getString(NEWS_FOOTER_TEXT_PARAM)
    }

    private fun initViews(fragBase: View) {
        ivNewsImage = fragBase.findViewById(R.id.ivNewsImage)
        tvHeadline = fragBase.findViewById(R.id.tvHeadline)
        tvNewsBody = fragBase.findViewById(R.id.tvNewsBody)
        tvNewsFooter = fragBase.findViewById(R.id.tvNewsFooter)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param headline_param Parameter 1.
         * @param news_body_param Parameter 2.
         * @return A new instance of fragment NewsSummaryFragment.
         */
        @JvmStatic
        fun newInstance(headline_param: String?, news_body_param: String?, news_image_url_param: String?, news_footer_param : String?) =
            NewsSummaryFragment().apply {
                arguments = Bundle().apply {
                    putString(HEADLINE_PARAM, headline_param)
                    putString(NEWS_BODY_PARAM, news_body_param)
                    putString(NEWS_IMAGE_URL_PARAM, news_image_url_param)
                    putString(NEWS_FOOTER_TEXT_PARAM, news_footer_param)
                }
            }
    }
}