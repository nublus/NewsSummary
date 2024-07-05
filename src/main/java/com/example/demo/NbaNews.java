package com.example.demo;

import java.util.Date;
import java.util.UUID;

public class NbaNews{
    UUID uuid = UUID.randomUUID(); // 生成唯一的id。

    Date timestep = new Date(); // 时间戳

    int idSubset = -1; //子集内id，便于筛选

    String newsTitle = ""; // 新闻标题

    String newsUrl = ""; // URL

    String newsSummary = ""; // 摘要

    String newsText = ""; //全文

    public NbaNews(UUID my_uuid,Date my_date, int id, String title, String url, String summary, String text){
        this.uuid = my_uuid;
        this.timestep = my_date;
        this.idSubset = id;
        this.newsTitle = title;
        this.newsUrl = url;
        this.newsSummary = summary;
        this.newsText = text;
    }


}