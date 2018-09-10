package com.example.aurora.t12306;

public class PassagerEntity {

    private String name,type,cardNo;

    public PassagerEntity(String name,String type,String cardNo){
        this.name=name;
        this.type=type;
        this.cardNo=cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
