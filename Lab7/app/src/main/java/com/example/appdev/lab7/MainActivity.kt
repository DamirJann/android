package com.example.appdev.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val catApi = NetworkModule.catApi

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var catsRv: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefreshLayout = findViewById(R.id.swipe_refresh)
        catsRv = findViewById(R.id.cat_list)
        catsRv.setHasFixedSize(true)
        progressBar = findViewById(R.id.progressBar)

        catAdapter = CatAdapter()
        catsRv.adapter = catAdapter
    }
    override fun onResume() {
        super.onResume()

        repeat(10) {
            progressBar.isVisible = true
            val catsCall: Call<List<CatResponse>> = catApi.getCats()

            catsCall.enqueue(object : Callback<List<CatResponse>> {
                override fun onFailure(call: Call<List<CatResponse>>, t: Throwable) {
                    t.printStackTrace()
                    progressBar.isVisible = false
                    Toast.makeText(applicationContext, "shit happens", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<CatResponse>>,
                    response: Response<List<CatResponse>>
                ) {
                    progressBar.isVisible = false
                    val cats: List<CatResponse> = response.body() ?: emptyList()
                    swipeRefreshLayout.isRefreshing = false
                    catAdapter.addCats(cats)
                }

            })
        }

        swipeRefreshLayout.setOnRefreshListener {
            catAdapter.clearCharacters()
            repeat(10) {
                swipeRefreshLayout.isRefreshing = true
                val catsCall: Call<List<CatResponse>> = catApi.getCats()
                catsCall.enqueue(object : Callback<List<CatResponse>> {
                    override fun onFailure(call: Call<List<CatResponse>>, t: Throwable) {
                        swipeRefreshLayout.isRefreshing = false
                        Toast.makeText(applicationContext, "shit happens", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<List<CatResponse>>,
                        response: Response<List<CatResponse>>
                    ) {
                        val characters: List<CatResponse> = response.body() ?: emptyList()
                        swipeRefreshLayout.isRefreshing = false
                        catAdapter.addCats(characters)
                    }

                })
            }
        }
    }
}
