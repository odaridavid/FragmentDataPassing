package com.github.odaridavid.fragmentdatapassing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(),FragListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragA = AFragment.newInstance("Param from A\n")
        fragmentTransaction.add(R.id.frag_container, fragA)
        fragmentTransaction.commit()
    }

    override fun onNextClicked(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frag_container, fragment)
        fragmentTransaction.commit()
    }

}