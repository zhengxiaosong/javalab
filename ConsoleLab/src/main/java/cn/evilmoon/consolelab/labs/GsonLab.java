package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.TimeTag;
import cn.evilmoon.consolelab.models.Person;
import com.google.gson.*;

@TimeTag("2019-02-13 14:49")
public class GsonLab implements Lab {
    @Override
    public void run(String[] args) {
        String userJson = "{'name':'范金泉','gradeInfo':null,'arriveTimes':9,'tradeTimes':2,'tradeAmount':100.0000000000,'labels':['苹果粉','小米粉'],'imageUrl':'https://prodretailnextstorage.blob.core.chinacloudapi.cn/retailnext-originalimages-bg00/2019011818a2a460bc-1b09-11e9-93a5-74da38e2884b.jpg'}";
        //JsonObject jsonObject = new JsonParser().parse(userJson).getAsJsonObject();
        //JsonArray jsonArray = jsonObject.getAsJsonArray("labels");
        //JsonArray jsonArray = jsonObject.getAsJsonArray("labels");

        Gson gson = new Gson();
        Person userObject = gson.fromJson(userJson, Person.class);
        System.out.println(userObject.getLabels().length);
    }
}

