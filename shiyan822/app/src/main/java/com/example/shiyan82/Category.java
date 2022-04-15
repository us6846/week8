package com.example.shiyan82;
public class Category {
  private int cid;
  private  String cname;
  private  int code;
  public Category(int cid,String cname,int code){
    this.cid=cid;
    this.cname=cname;
    this.code=code;
  }

  public int getCid(){return cid; }
  public String getCname(){return cname;}
  public int getCode(){return code;}


}
