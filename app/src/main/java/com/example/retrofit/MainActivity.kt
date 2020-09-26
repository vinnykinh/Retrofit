package com.example.retrofit

import android.annotation.SuppressLint
import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi::class.java)
        val listCall = jsonPlaceholderApi.getPosts()
        listCall.enqueue(object : Callback<List<Post>> {
            //onresponse invoked when the response from server is successful
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (!response.isSuccessful) {
                    textView.text = response.code().toString()
                } else {
                    val posts = response.body()
                    if (posts != null) {
                        for (post in posts) {
                            var content: String = ""
                            content += "UserId" + post.getUserId() + "\n"
                            content += "Id" + post.getUserId() + "\n"
                            content += "Title" + post.getTitle() + "\n"
                            content += "Body" + post.getBody() + "\n"
                            textView.text = content
                        }
                    }
                }
            }

            //envoked when URL is not valid or URL is permanently removed
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                textView.text = t.message
            }

        })


    }
}