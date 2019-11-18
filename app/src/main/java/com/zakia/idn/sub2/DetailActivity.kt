package com.zakia.idn.sub2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.zakia.idn.sub2.Model.Model
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_MOVIE = "movie"
    }

    var model: Model? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        model = intent.getParcelableExtra(KEY_MOVIE)
        supportActionBar?.title = model?.title ?: resources.getString(R.string.text_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title_detail.text = model?.title
        description_detail.text = model?.description
        year_detail.text = "${resources.getString(R.string.text_year)}:${model?.year}"
        img_poster_detail.setImageResource(model?.thumb ?: 0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
