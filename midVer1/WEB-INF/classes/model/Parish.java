package model;

import java.io.Serializable;

public class Parish
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String parishId;
  private String subcountyId;
  private String parishName;

  public String getParishId()
  {
    return this.parishId;
  }

  public void setParishId(String parishId) {
    this.parishId = parishId;
  }

  public String getSubcountyId() {
    return this.subcountyId;
  }

  public void setSubcountyId(String subcountyId) {
    this.subcountyId = subcountyId;
  }

  public String getParishName() {
    return this.parishName;
  }

  public void setParishName(String parishName) {
    this.parishName = parishName;
  }

  public Parish() {
  }

  public Parish(String parishId, String subcountyId, String parishName) {
    this.parishId = parishId;
    this.subcountyId = subcountyId;
    this.parishName = parishName;
  }
}