package com.stupacki.sample.app.home.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.stupacki.sample.app.home.R
import com.stupacki.sample.app.home.injection.HomeComponent
import com.stupacki.sample.app.home.viewmodel.HomeViewModel
import com.stupacki.sample.app.navigation.home.HomeNavigator
import kotlinx.android.synthetic.main.fragment_home.*
import org.rewedigital.katana.androidx.viewmodel.viewModel

internal class HomeFragment : Fragment(), HomeNavigator {

    private val component by lazy { HomeComponent() }
    private val viewModel by component.viewModel<HomeViewModel>(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.fragment_home, container, false)


    @SuppressLint("LogNotTimber")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.text.observe(this.viewLifecycleOwner, Observer {
            homeTextView.text = it
        })

        toHomeDetailButton.setOnClickListener {
            navigateToHomeDetail()
        }

        Log.i("Fragment", "Instance: $this")
    }
}
