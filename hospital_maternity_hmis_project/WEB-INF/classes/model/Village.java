package model;

import java.io.Serializable;

public class Village
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String villageId;
  private String parishId;
  private String villageName;

  public String getVillageId()
  {
    return this.villageId;
  }

  public void setVillageId(String villageId) {
    this.villageId = villageId;
  }

  public String getParishId() {
    return this.parishId;
  }

  public void setParishId(String parishId) {
    this.parishId = parishId;
  }

  public String getVillageName() {
    return this.villageName;
  }

  public void setVillageName(String villageName) {
    this.villageName = villageName;
  }

  public Village() {
  }

  public Village(String villageId, String parishId, String villageName) {
    this.villageId = villageId;
    this.parishId = parishId;
    this.villageName = villageName;
  }
}