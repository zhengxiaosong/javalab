package cn.evilmoon.consolelab.models;
import java.io.Serializable;

public class Person implements Serializable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGradeInfo() { return gradeInfo; }

    public void setGradeInfo(String gradeInfo) {
        this.gradeInfo = gradeInfo;
    }

    public int getArriveTimes() {
        return arriveTimes;
    }

    public void setArriveTimes(int arriveTimes) {
        this.arriveTimes = arriveTimes;
    }

    public int getTradeTimes() {
        return tradeTimes;
    }

    public void setTradeTimes(int tradeTimes) {
        this.tradeTimes = tradeTimes;
    }

    public float getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(float tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String url) { this.imageUrl = url;}

    public boolean isFirstPerson() {
        return isFirstPerson;
    }

    public void setFirstPerson(boolean firstPerson) {
        isFirstPerson = firstPerson;
    }

    public boolean isLastPerson() {
        return isLastPerson;
    }

    public void setLastPerson(boolean lastPerson) {
        isLastPerson = lastPerson;
    }

    public Person() {
        isFirstPerson = false;
        isLastPerson = false;
        labels = new String[0];
    }

    public Person(String name, String gradeInfo, int arriveTimes, int tradeTimes, float tradeAmount) {
        this.name = name;
        this.gradeInfo = gradeInfo;
        this.arriveTimes = arriveTimes;
        this.tradeTimes = tradeTimes;
        this.tradeAmount = tradeAmount;
        isFirstPerson = false;
        isLastPerson = false;
        labels = new String[0];
    }

    public Person(String name, String gradeInfo, int arriveTimes, int tradeTimes, float tradeAmount, String imageUrl) {
        this.name = name;
        this.gradeInfo = gradeInfo;
        this.arriveTimes = arriveTimes;
        this.tradeTimes = tradeTimes;
        this.tradeAmount = tradeAmount;
        this.imageUrl = imageUrl;
        isFirstPerson = false;
        isLastPerson = false;
        labels = new String[0];
    }

    public Person(String name, String gradeInfo, int arriveTimes, int tradeTimes, float tradeAmount, String imageUrl, String[] labels) {
        this.name = name;
        this.gradeInfo = gradeInfo;
        this.arriveTimes = arriveTimes;
        this.tradeTimes = tradeTimes;
        this.tradeAmount = tradeAmount;
        this.imageUrl = imageUrl;
        isFirstPerson = false;
        isLastPerson = false;
        this.labels = labels;
    }

    private String name;
    private String gradeInfo;
    private int arriveTimes;
    private int tradeTimes;
    private float tradeAmount;
    private String[] labels;
    private String imageUrl;
    private boolean isFirstPerson;
    private boolean isLastPerson;
}