package com.github.odaridavid.fragmentdatapassing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class AFragment : Fragment(), FragListener {

    lateinit var v: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            v.findViewById<TextView>(R.id.frag_a).text = getString("A", "None")
            v.findViewById<Button>(R.id.a_next_button).setOnClickListener {
                val prev = getString("A", "None")
                onNextClicked(BFragment.newInstance("$prev\n Params For B\n"))
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_a, container, false)
        return v
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            AFragment().apply {
                arguments = Bundle().apply {
                    putString("A", param1)
                }
            }
    }

    override fun onNextClicked(fragment: Fragment) {
        (context as MainActivity).onNextClicked(fragment)
    }
}