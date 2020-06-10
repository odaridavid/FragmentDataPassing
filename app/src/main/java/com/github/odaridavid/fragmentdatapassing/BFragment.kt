package com.github.odaridavid.fragmentdatapassing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class BFragment : Fragment(), FragListener {

    lateinit var v: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            v.findViewById<TextView>(R.id.frag_b).text = getString("B", "None")
            v.findViewById<Button>(R.id.b_next_button).setOnClickListener {
                val prev = getString("B", "None")
                onNextClicked(CFragment.newInstance("$prev \n Params For C"))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_b, container, false)
        return v
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            BFragment().apply {
                arguments = Bundle().apply {
                    putString("B", param1)
                }
            }
    }

    override fun onNextClicked(fragment: Fragment) {
        (context as MainActivity).onNextClicked(fragment)
    }
}