package com.zakia.idn.sub2.fragment


import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zakia.idn.sub2.CatalogueAdapter
import com.zakia.idn.sub2.DetailActivity
import com.zakia.idn.sub2.Model.Model
import com.zakia.idn.sub2.R
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {
    private lateinit var tvShowNames: Array<String>
    private lateinit var tvShowDescription: Array<String>
    private lateinit var tvshowYears: Array<String>
    private lateinit var tvshowThumbs: TypedArray
    private var tvShows = arrayListOf<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv_tv_show.setHasFixedSize(true)
        rv_tv_show.layoutManager = LinearLayoutManager(context)
        rv_tv_show.addItemDecoration(
            DividerItemDecoration(
                rv_tv_show.context,
                DividerItemDecoration.VERTICAL
            )
        )
        val tvShowAdapter = CatalogueAdapter(tvShows) {
            selectedItem(it)
        }
        rv_tv_show.adapter = tvShowAdapter
    }

    private fun selectedItem(it: Model) {
        val movePage = Intent(context, DetailActivity::class.java)
        movePage.putExtra(DetailActivity.KEY_MOVIE, it)
        startActivity(movePage)
    }

    private fun loadData() {
        tvShowNames = resources.getStringArray(R.array.tv_show_names)
        tvShowDescription = resources.getStringArray(R.array.tv_show_descriptions)
        tvshowYears = resources.getStringArray(R.array.tv_show_years)
        tvshowThumbs = resources.obtainTypedArray(R.array.tv_show_thumbs)

        for (position in tvShowNames.indices) {
            val tvShow = Model(
                position,
                tvShowNames[position],
                tvShowDescription[position],
                tvshowYears[position],
                tvshowThumbs.getResourceId(position, -1)
            )
            tvShows.add(tvShow)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }
}
