package model;

import java.io.Serializable;

public class Subcounty
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String subcountyId;
  private String subcountyName;

  public String getSubcountyId()
  {
    return this.subcountyId;
  }

  public void setSubcountyId(String subcountyId) {
    this.subcountyId = subcountyId;
  }

  public String getSubcountyName() {
    return this.subcountyName;
  }

  public void setSubcountyName(String subcountyName) {
    this.subcountyName = subcountyName;
  }

  public Subcounty() {
  }

  public Subcounty(String subcountyId, String subcountyName) {
    this.subcountyId = subcountyId;
    this.subcountyName = subcountyName;
  }
}