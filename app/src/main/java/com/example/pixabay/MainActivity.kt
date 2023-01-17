package com.example.pixabay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pixabay.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var adapter = PixaAdapter(listOf())
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }


    private fun initClicker() {
        with(binding){
            searchBtn.setOnClickListener {
                page = 1
                doRequest(page)
            }
            nextPageBtn.setOnClickListener {
                doRequest(++page)
            }
        }
    }




    private fun ActivityMainBinding.doRequest(page: Int) {
        RetrofitServise().api.searchImage(keyWord = nameEd.text.toString(), page =page )
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(
                    call: Call<PixaModel>,
                    response: Response<PixaModel>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.hits?.let {
                            adapter = PixaAdapter(it)
                            binding.recyclerView.adapter = this@MainActivity.adapter
                        }
                    }
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message} ")
                }
            })
    }
}