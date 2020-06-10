package com.github.odaridavid.fragmentdatapassing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class CFragment : Fragment(), FragListener {
    lateinit var v: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            v.findViewById<TextView>(R.id.frag_c).text = getString("C", "None")
            v.findViewById<Button>(R.id.c_submit_button).setOnClickListener {
                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_c, container, false)
        return v
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            CFragment().apply {
                arguments = Bundle().apply {
                    putString("C", param1)
                }
            }
    }

    override fun onNextClicked(fragment: Fragment) {
            //no-op
    }
}