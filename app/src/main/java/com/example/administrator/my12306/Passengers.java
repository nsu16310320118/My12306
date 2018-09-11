package com.example.administrator.my12306;

class Passenger{
    private String name,HumanType,IdNumber,tel,idType;

    public Passenger(String idNumber, String name, String idType,String tel,String humanType){
        this.IdNumber=idNumber;
        this.name=name;
        this.idType=idType;
        this.tel=tel;
        this.HumanType=humanType;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public String getHumanType() {
        return HumanType;
    }

    public String getTel() {
        return tel;
    }

    public String getIdType() {
        return idType;
    }
}