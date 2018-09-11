package com.example.administrator.my12306;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class TrainInfo {

    String trainNo,fromCity,toCity,startTime,arriveTime,durationTime;
    HashMap map;

    public TrainInfo(String trainNo, String fromCity, String toCity, String startTime,
                     String arriveTime, String durationTime, HashMap map){//String trainNo,String fromCity,String toCity,String startTime,
            //String arriveTime,String durationTime

        this.trainNo=trainNo;
        this.fromCity=fromCity;
        this.toCity=toCity;
        this.startTime=startTime;
        this.arriveTime=arriveTime;
        this.durationTime=durationTime;
        this.map=map;
    }

    public TrainInfo(){

    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public HashMap getMap() {return map;}

    public void setMap(HashMap map) {this.map = map;
    }
}
