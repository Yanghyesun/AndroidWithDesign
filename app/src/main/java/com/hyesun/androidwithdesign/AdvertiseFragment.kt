package com.hyesun.androidwithdesign

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_advertise.*

/**
 * A simple [Fragment] subclass.
 */
class AdvertiseFragment : Fragment() {
    var view_id = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advertise, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view_id = arguments!!.getInt("id")
        init()
    }

    private fun init(){
        when(view_id){
            0 -> {
                img_ad.setBackgroundColor(Color.GRAY)
                txt_ad.text="광고1"
            }
            1 -> {
                img_ad.setBackgroundColor(Color.BLUE)
                txt_ad.text="광고2"
            }
            2 -> {
                img_ad.setBackgroundColor(Color.CYAN)
                txt_ad.text="광고3"
            }
            3 -> {
                img_ad.setBackgroundColor(Color.MAGENTA)
                txt_ad.text="광고4"
            }
        }

    }
}
