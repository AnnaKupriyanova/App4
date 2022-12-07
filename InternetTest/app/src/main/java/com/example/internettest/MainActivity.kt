package com.example.internettest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.net.URLConnection


class MainActivity : AppCompatActivity() {
    private val TAG = "Flickr cats"
    private val TAG1 = "Flickr Okcats"
    val URL = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
    var okHttpClient: OkHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun Connection() {
            Log.i(TAG, "${URL.readText()}")
        }

        fun ConnectionOk() {
            val request: Request = Request.Builder().url(URL).build()
            okHttpClient.newCall(request).enqueue(object: Callback {
                override fun onFailure(call: Call?, e: IOException?) {
                }

                override fun onResponse(call: Call?, response: Response?) {
                    val json = response?.body()?.string()
                    Log.i(TAG1, "$json")
                }
            })
        }

        var btnHTTP = findViewById<Button>(R.id.btnHTTP)
        btnHTTP.setOnClickListener{
            Thread(Runnable { Connection() }).start()
            //Connection()
        }

        var btnOkHttp = findViewById<Button>(R.id.btnOkHTTP)
        btnOkHttp.setOnClickListener{
            Thread(Runnable { ConnectionOk() }).start()
            //ConnectionOk()
        }
    }

}