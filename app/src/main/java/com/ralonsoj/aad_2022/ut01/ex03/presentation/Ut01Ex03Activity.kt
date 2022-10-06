package com.ralonsoj.aad_2022.ut01.ex03.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ralonsoj.aad_2022.ut01.ex03.data.NewsLocalSource
import com.ralonsoj.aad_2022.ut01.ex03.domain.News
import kotlinx.coroutines.newSingleThreadContext

class Ut01Ex03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initWithList()
    }

    private fun init(){
        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        val news1 = News(1,"Titulo 1","Subtitulo 1","Summary 1")
        newsLocalSource.setNews(news1)
        val news2 = News(2,"Titulo 2","Subtitulo 2","Summary 2")
        newsLocalSource.setNews(news2)
        val news3 = News(3,"Titulo 3","Subtitulo 3","Summary 3")
        newsLocalSource.setNews(news3)

        val newNews1 = newsLocalSource.findById(1)
        Log.d("@dev","$newNews1")

    }

    private fun initWithList(){
        val newsList: MutableList<News> = mutableListOf<News>(
            News(1,"Titulo 1","Subtitulo 1","Summary 1"),
            News(2,"Titulo 2","Subtitulo 2","Summary 2"),
            News(3,"Titulo 3","Subtitulo 3","Summary 3")
        )

        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        newsLocalSource.setNewsList(newsList)

    }

}