package model;

import java.io.Serializable;
import java.util.Date;

public class Vht
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer vhtId;
  private String vhtName;
  private Integer age;
  private String sex;
  private String vhtPhoneNumber;
  private String isCBD;
  private String villageId;
  private String villageName;
  private Date recordDate;
  private Integer userId;
  

  public Integer getVhtId()
  {
    return this.vhtId;
  }

  public void setVhtId(Integer vhtId) {
    this.vhtId = vhtId;
  }

  public String getVhtName() {
    return this.vhtName;
  }

  public void setVhtName(String vhtName) {
    this.vhtName = vhtName;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getVhtPhoneNumber() {
    return this.vhtPhoneNumber;
  }

  public void setVhtPhoneNumber(String vhtPhoneNumber) {
    this.vhtPhoneNumber = vhtPhoneNumber;
  }

  public String getIsCBD() {
    return this.isCBD;
  }

  public void setIsCBD(String isCBD) {
    this.isCBD = isCBD;
  }

  public String getVillageId() {
    return this.villageId;
  }

  public void setVillageId(String villageId) {
    this.villageId = villageId;
  }

  public String getVillageName() {
    return this.villageName;
  }

  public void setVillageName(String villageName) {
    this.villageName = villageName;
  }

  public Date getRecordDate() {
    return this.recordDate;
  }

  public void setRecordDate(Date recordDate) {
    this.recordDate = recordDate;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Vht() {
  }

  public Vht(Integer vhtId, String vhtName, Integer age, String sex, String vhtPhoneNumber, String isCBD, String villageId, String villageName, Date recordDate, Integer userId) {
    this.vhtId = vhtId;
    this.vhtName = vhtName;
    this.age = age;
    this.sex = sex;
    this.vhtPhoneNumber = vhtPhoneNumber;
    this.isCBD = isCBD;
    this.villageId = villageId;
    this.villageName = villageName;
    this.recordDate = recordDate;
    this.userId = userId;
  }
}