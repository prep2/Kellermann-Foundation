package model;

import java.io.Serializable;

public class Department
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer did;
  private String departmentName;
  private String description;

  public Department()
  {
  }

  public Department(Integer did, String departmentName, String description)
  {
    this.did = did;
    this.departmentName = departmentName;
    this.description = description;
  }

  public Department(Integer did) {
    this.did = did;
  }

  public Integer getDid() {
    return this.did;
  }

  public void setDid(Integer did) {
    this.did = did;
  }

  public String getDepartmentName() {
    return this.departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}