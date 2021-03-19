package com.hadi.dogsapp.presentation.views.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hadi.dogsapp.R
import com.hadi.dogsapp.presentation.utils.ViewState
import com.hadi.kwg.presentation.view.home.BreedListAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.content_home.breed_recycler_view_list
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        lifecycle.addObserver(homeViewModel)
        val homePostAdapter = BreedListAdapter()
        breed_recycler_view_list.adapter = homePostAdapter
        homeViewModel.allBreeds.observe(this, Observer {

            when (it.status) {
                ViewState.Status.LOADING -> {
                    Log.e("posts", "loading")
                }
                ViewState.Status.ERROR -> {
                    Log.e("posts", it.message!!)
                }
                ViewState.Status.SUCCESS -> {
                    Log.e("posts", it.data!!.size.toString())
                    homePostAdapter.provideList(it.data)
                    //post_loading.visibility = View.GONE
                }
            }
        })



    }
}
