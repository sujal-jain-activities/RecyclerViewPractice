package com.sujaljain.recyclerviewnewspage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var MyRecyclerView: RecyclerView
    lateinit var NewsArrayList : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        MyRecyclerView = findViewById(R.id.recylerview)
        var newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4
        )
        var newsHeadingArray = arrayOf(
            "PM Modi Launches C-295 Aircraft Facility in Gujarat",
            "Biden meets with G20 leaders in Rio de Janeiro, warning them about the importance of climate action",
            "Stability and Controversy: Giorgia Meloni’s Unwavering Grip on Power",
            "Disqualification as Lok Sabha Member"
        )
        // layout manager sets halat of recyclerview (i.e vertically scrolling or horizontally scrolling)
        MyRecyclerView.layoutManager = LinearLayoutManager(this)
        NewsArrayList = arrayListOf<News>()
        for (index in newsImageArray.indices) {
            var news = News(newsHeadingArray[index], newsImageArray[index])
            NewsArrayList.add(news)

        }
        MyRecyclerView.adapter = MyAdapter(NewsArrayList,this)

    }
}