package com.example.demo;

import com.baidubce.qianfan.Qianfan;
import com.baidubce.qianfan.model.chat.ChatResponse;

import java.util.Date;
import java.util.UUID;


public class ChatExample {

    public static void main(String[] args) {
        // 使用安全认证AK/SK鉴权，替换下列示例中参数，安全认证Access Key替换your_iam_ak，Secret Key替换your_iam_sk
        // 多轮对话
        String url ="https://www.sohu.com/a/790851605_458722?scm=10001.495_14-200000.0.10006";
        String title = "勇士先签后换从76人得到希尔德联手库里组成水花2.0";
        String text = "北京时间7月5日消息，来自名记Shams的报道称，消息灵通人士透露，勇士队通过先签后换的方式从76人队得到巴迪-希尔德。名记Woj跟进报道，他得到的线报是，希尔德合同前两年的薪水是1800万美元，具有全额保障；第3年保障部分薪水是300万美元，第4年为非保障但包含球员选项。勇士队将1个2031年次轮签（来自独行侠队）送至费城。根据新劳资协议，先签后换必须是至少3年合同。而第3年的小额保障给了勇士队交易的灵活性。有消息指出，希尔德的交易预计将被纳入5队交易，包括克莱-汤普森去独行侠队，凯尔-安德森和希尔德加盟勇士队。这5队分别是黄蜂队、独行侠队、76人队、森林狼队和勇士队。过去5个赛季，希尔德和斯蒂芬-库里是联盟命中三分最多的球员。现在，他俩成为队友，组成水花2.0。某种程度上，希尔德的加盟填补了克莱离去的空缺。数据显示，近5个赛季希尔德一共投进1322个三分（联盟第1），库里1264个三分（联盟第2）。消息源称，希尔德之所以选择勇士队，而不是其他球队报价，是因为他想获得赢球的机会。值得一提的是，23-24赛季跟随76人队打进季后赛，是希尔德职业生涯首次季后赛之旅。上赛季交易截止日，现年31岁的希尔德被步行者队送至76人队。23-24赛季希尔德一共为76人队打了32场球，场均出场25.8分钟，交出12.2分3.2篮板3.0助攻的数据，三分球命中率38.9%。";

        UUID uuid = UUID.randomUUID();
        NbaNews news = new NbaNews(uuid,new Date(),-1,title,url,"",text);
        NbaNews sum_news = summarize(news);

    }
    public static NbaNews summarize(NbaNews news){
        Qianfan qianfan = new Qianfan("ALTAK4AdLl00DCNicK1Gf0xcrZ", "ba0bea1e1787455e95b096561a0ff4d5");
        ChatResponse resp = qianfan.chatCompletion()
                .model("Yi-34B-Chat")
                .addMessage("user", "帮我根据下面这段新闻内容生成对应的摘要\n"+news.newsText)
                .execute();
        news.newsSummary = resp.getResult();
        System.out.println(news.newsSummary);
//        NbaNews my_news = new NbaNews(news.uuid,news.timestep,news.idSubset,news.newsTitle,news.newsUrl,news.newsSummary,news.newsText);
        return news;
    }
}
