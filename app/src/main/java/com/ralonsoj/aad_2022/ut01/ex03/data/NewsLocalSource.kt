package com.ralonsoj.aad_2022.ut01.ex03.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ralonsoj.aad_2022.ut01.ex03.domain.News
import java.lang.reflect.Type

class NewsLocalSource (val sharedPref: SharedPreferences) {

    private val gson = Gson()

    fun setNews(news: News){

        val jsonNews = gson.toJson(news, News::class.java)

        val edit = sharedPref.edit()
        edit.putString(news.id.toString(),jsonNews)
        edit.apply() //De forma asíncrona
    }

    fun findById(newsId: Int): News {
        val gson = Gson()

        val jsonNews = sharedPref.getString(newsId.toString(),"")

        return gson.fromJson(jsonNews, News::class.java)

    }

    fun setNewsList(newsList: MutableList<News>){
        newsList.forEach { news ->
            setNews(news)
        }
    }

    fun setNewsListV2(newsList: MutableList<News>){
        val jsonNews = gson.toJson(newsList)
        val edit = sharedPref.edit()
        edit.putString("ALL",jsonNews)
        edit.apply()
    }

    fun findAll() : MutableList<News>{
        //Buscar y devolver todas las noticias
        val newsList = mutableListOf<News>()
        sharedPref.all.forEach { entry ->
            //entry.key
            //entry.value
            val news = gson.fromJson(entry.value as String, News::class.java)
            newsList.add(news)
        }
        return newsList
    }

    fun findAllV2():MutableList<News> {
        val gson = Gson()
        val jsonNews = sharedPref.getString("ALL","")

        val typeNews: Type = object  : TypeToken<MutableList<News>>() {}.type
        return gson.fromJson(jsonNews, typeNews)
    }

    fun findAllKotlin(): MutableList<News>{
        return sharedPref.all.map { entry ->
            gson.fromJson(entry.value as String, News::class.java)
        }.toMutableList()
    }

}