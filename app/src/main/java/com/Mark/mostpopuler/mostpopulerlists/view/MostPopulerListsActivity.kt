package com.Mark.mostpopuler.vacation.vacationlists.view

import android.content.Intent

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.Mark.mostpopuler.R
import com.Mark.mostpopuler.application.BaseActivity

import com.Mark.mostpopuler.vacation.vacationlists.adapter.Interaction
import com.Mark.mostpopuler.vacation.vacationlists.di.MostPopulerListDH
import com.Mark.mostpopuler.vacation.vacationlists.viewmodel.MostPopulerViewModel
import com.Mark.mostpopuler.vacation.vacationlists.viewmodel.MostPopulerViewModelFactory
import com.Mark.mostpopuler.mostpopulerlists.view.MostPopulerDetailsActivity
import com.Mark.mostpopuler.vacation.vacationlists.adapter.MostPopulerListAdapter
import com.example.mostpopularapp.ui.mplist.models.Datum
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_mostpop_list.*
import javax.inject.Inject

class MostPopulerListsActivity: BaseActivity(), View.OnClickListener,Interaction {


    private val component by lazy { MostPopulerListDH.listComponent() }
    @Inject
    lateinit var viewModelFactory: MostPopulerViewModelFactory
    private val viewModel: MostPopulerViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MostPopulerViewModel::class.java)
    }

    @Inject
    lateinit var mostPopulerAdapter: MostPopulerListAdapter

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostpop_list)
        component.inject(this)
        bindViewModel()

        mostPopulerAdapter.interaction = this
        rvPosts.adapter = mostPopulerAdapter
        rvPosts.layoutManager = LinearLayoutManager(this)


    }


    private fun bindViewModel() {
        progressBar.setVisibility(View.VISIBLE)
        viewModel.fetchMostPopulerList(7)
        viewModel.mostPopulerCallBack().removeObservers(this)
        viewModel.mostPopulerCallBack().observe(this, Observer {
            initAdapter(it.results!!)
        })

        //fetch data based on the type
    }

    private fun initAdapter(listItems: List<Datum>) {
        //Update list with new list comes from server
        progressBar.setVisibility(View.GONE)
        mostPopulerAdapter?.swapData(listItems!!)
    }

    override fun onStart() {
        super.onStart()

//        button22.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v!!.id) {

        }


    }


    override fun itemsClicked(obj: Datum) {
        val gson = Gson()
        val objS = gson.toJson(obj)
        val i = Intent(this, MostPopulerDetailsActivity::class.java)
        i.putExtra("obj", objS)
        startActivity(i)
    }

}
