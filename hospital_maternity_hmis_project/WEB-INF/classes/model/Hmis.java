package model;

import java.io.Serializable;
import java.util.Date;

public class Hmis implements Serializable{
    private static final long serialVersionUID = 1L;
    private Date recordDate;
    private Date dateOfAdmission;
    private Integer ipd;
    private Integer ancNum;
    private String ancRef;
    private String matName;
    private String villageId;
    private String villageName;
    private String matPhoneNumber;
    private Integer age;
    private Integer gravida;
    private Integer parity;
    private Integer gestation;
    private String term;
    private Integer finalDiagnosis;
    private Date hivTestDate;
    private String whoClinicalStage;
    private String cd4Count;
    private Integer viralLoad;
    private Boolean revisit;
    private String deliveryMode;
    private Date deliveryDate;
    //could not get dates to work, some kind of java.sql error
    //switched to string for testing purposes
    //private String deliveryDate;
    private Date deliveryTime;
    private Boolean ergometrine;
    private Boolean pitocin;
    private Boolean misoprostol;
    private String otherMeds;
    private String emtctCode;
    private String arvs;
    private Boolean vitaminA;
    private String muacColor;
    private Integer muacCM;
    private Integer muacINR;
    private String apgarScore;
    private String sexOfBaby;
    private String breathing;
    private Boolean skinToSkin;
    private Boolean breastFed;
    private Boolean teo;
    private Boolean vitK;
    private Boolean chlorohexidine;
    private String counseled;
    private Boolean matNutrCouns;
    private Boolean iycf;
    private String iycfFeeding;
    private Float weight;
    private String arvsBaby;
    private Boolean immunized;
    private Integer familyPlanning;
    private String motherCondition;
    private String babyCondition;
    private String deliveredBy;
    private Date postNatalCare;
    private Date dateOfDischarge;
    private String nameDischarge;
    private Integer userId;

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Date getDateOfAdmission() { return dateOfAdmission;}

    public void setDateOfAdmission(Date dateOfAdmission) { this.dateOfAdmission = dateOfAdmission;}


    public Integer getIpd() {
        return ipd;
    }

    public void setIpd(Integer ipd) {
        this.ipd = ipd;
    }

    public Integer getAncNum() {
        return ancNum;
    }

    public void setAncNum(Integer ancNum) {
        this.ancNum = ancNum;
    }

    public String getAncRef() {
        return ancRef;
    }

    public void setAncRef(String ancRef) {
        this.ancRef = ancRef;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getMatPhoneNumber() {
        return matPhoneNumber;
    }

    public void setMatPhoneNumber(String matPhoneNumber) {
        this.matPhoneNumber = matPhoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGravida() {
        return gravida;
    }

    public void setGravida(Integer gravida) {
        this.gravida = gravida;
    }

    public Integer getParity() {
        return parity;
    }

    public void setParity(Integer parity) {
        this.parity = parity;
    }

    public Integer getGestation() {
        return gestation;
    }

    public void setGestation(Integer gestation) {
        this.gestation = gestation;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(Integer finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis;
    }

    public Date getHivTestDate() {
        return hivTestDate;
    }

    public void setHivTestDate(Date hivTestDate) {
        this.hivTestDate=hivTestDate;
    }

    public String getWhoClinicalStage() {
        return whoClinicalStage;
    }

    public void setWhoClinicalStage(String whoClinicalStage) {
        this.whoClinicalStage = whoClinicalStage;
    }

    public String getCd4Count() {
        return cd4Count;
    }

    public void setCd4Count(String cd4Count) {
        this.cd4Count = cd4Count;
    }

    public Integer getViralLoad() {
        return viralLoad;
    }

    public void setViralLoad(Integer viralLoad) {
        this.viralLoad = viralLoad;
    }

    public Boolean getRevisit() {
        return revisit;
    }

    public void setRevisit(Boolean revisit) {
        this.revisit = revisit;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /*public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }*/

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getErgometrine() {
        return ergometrine;
    }

    public void setErgometrine(Boolean ergometrine) {
        this.ergometrine = ergometrine;
    }

    public Boolean getPitocin() {
        return pitocin;
    }

    public void setPitocin(Boolean pitocin) {
        this.pitocin = pitocin;
    }

    public Boolean getMisoprostol() {
        return misoprostol;
    }

    public void setMisoprostol(Boolean misoprostol) {
        this.misoprostol = misoprostol;
    }

    public String getOtherMeds() {
        return otherMeds;
    }

    public void setOtherMeds(String otherMeds) {
        this.otherMeds = otherMeds;
    }

    public String getEmtctCode() {
        return emtctCode;
    }

    public void setEmtctCode(String emtctCode) {
        this.emtctCode = emtctCode;
    }

    public String getArvs() {
        return arvs;
    }

    public void setArvs(String arvs) {
        this.arvs = arvs;
    }

    public Boolean getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(Boolean vitaminA) {
        this.vitaminA = vitaminA;
    }

    public String getMuacColor() {
        return muacColor;
    }

    public void setMuacColor(String muacColor) {
        this.muacColor = muacColor;
    }

    public Integer getMuacCM() {
        return muacCM;
    }

    public void setMuacCM(Integer muacCM) {
        this.muacCM = muacCM;
    }

    public Integer getMuacINR() {
        return muacINR;
    }

    public void setMuacINR(Integer muacINR) {
        this.muacINR = muacINR;
    }

    public String getApgarScore() {
        return apgarScore;
    }

    public void setApgarScore(String apgarScore) {
        this.apgarScore = apgarScore;
    }

    public String getSexOfBaby() {
        return sexOfBaby;
    }

    public void setSexOfBaby(String sexOfBaby) {
        this.sexOfBaby = sexOfBaby;
    }

    public String getBreathing() {
        return breathing;
    }

    public void setBreathing(String breathing) {
        this.breathing = breathing;
    }

    public Boolean getSkinToSkin() {
        return skinToSkin;
    }

    public void setSkinToSkin(Boolean skinToSkin) {
        this.skinToSkin = skinToSkin;
    }

    public Boolean getBreastFed() {
        return breastFed;
    }

    public void setBreastFed(Boolean breastFed) {
        this.breastFed = breastFed;
    }

    public Boolean getTeo() {
        return teo;
    }

    public void setTeo(Boolean teo) {
        this.teo = teo;
    }

    public Boolean getVitK() {
        return vitK;
    }

    public void setVitK(Boolean vitK) {
        this.vitK = vitK;
    }

    public Boolean getChlorohexidine() {
        return chlorohexidine;
    }

    public void setChlorohexidine(Boolean chlorohexidine) {
        this.chlorohexidine = chlorohexidine;
    }

    public String getCounseled() {
        return counseled;
    }

    public void setCounseled(String counseled) {
        this.counseled = counseled;
    }

    public Boolean getMatNutrCouns() {
        return matNutrCouns;
    }

    public void setMatNutrCouns(Boolean matNutrCouns) {
        this.matNutrCouns = matNutrCouns;
    }

    public Boolean getIycf() {
        return iycf;
    }

    public void setIycf(Boolean iycf) {
        this.iycf = iycf;
    }

    public String getIycfFeeding() {
        return iycfFeeding;
    }

    public void setIycfFeeding(String iycfFeeding) {
        this.iycfFeeding = iycfFeeding;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getArvsBaby() {
        return arvsBaby;
    }

    public void setArvsBaby(String arvsBaby) {
        this.arvsBaby = arvsBaby;
    }

    public Boolean getImmunized() {
        return immunized;
    }

    public void setImmunized(Boolean immunized) {
        this.immunized = immunized;
    }

    public Integer getFamilyPlanning() {
        return familyPlanning;
    }

    public void setFamilyPlanning(Integer familyPlanning) {
        this.familyPlanning = familyPlanning;
    }

    public String getMotherCondition() {
        return motherCondition;
    }

    public void setMotherCondition(String motherCondition) {
        this.motherCondition = motherCondition;
    }

    public String getBabyCondition() {
        return babyCondition;
    }

    public void setBabyCondition(String babyCondition) {
        this.babyCondition = babyCondition;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public Date getPostNatalCare() {
        return postNatalCare;
    }

    public void setPostNatalCare(Date postNatalCare) {
        this.postNatalCare = postNatalCare;
    }

    public Date getDateOfDischarge() {
        return dateOfDischarge;
    }

    public void setDateOfDischarge(Date dateOfDischarge) {
        this.dateOfDischarge = dateOfDischarge;
    }

    public String getNameDischarge() {
        return nameDischarge;
    }

    public void setNameDischarge(String nameDischarge) {
        this.nameDischarge = nameDischarge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Hmis(){
    }

    public Hmis(Date recordDate, Date dateOfAdmission, Integer ipd, Integer ancNum, String ancRef, String matName, String villageId, String villageName, String matPhoneNumber,
                Integer age, Integer gravida, Integer parity, Integer gestation, String term, Integer finalDiagnosis, Date hivTestDate, String whoClinicalStage,
                String cd4Count, Integer viralLoad, Boolean revisit, String deliveryMode, Date deliveryDate, Date deliveryTime, Boolean ergometrine,
                Boolean pitocin, Boolean misoprostol, String otherMeds, String emtctCode, String arvs, Boolean vitaminA, String muacColor, Integer muacCM,
                Integer muacINR, String apgarScore, String sexOfBaby, String breathing, Boolean skinToSkin, Boolean breastFed, Boolean teo, Boolean vitK,
                Boolean chlorohexidine, String counseled, Boolean matNutrCouns, Boolean iycf, String iycfFeeding, float weight, String arvsBaby, Boolean immunized,
                Integer familyPlanning, String motherCondition, String babyCondition, String deliveredBy, Date postNatalCare, Date dateOfDischarge,
                String nameDischarge, Integer userId) {
        this.recordDate = recordDate;
        this.dateOfAdmission = dateOfAdmission;
        this.ipd = ipd;
        this.ancNum = ancNum;
        this.ancRef = ancRef;
        this.matName = matName;
        this.villageId = villageId;
        this.villageName = villageName;
        this.matPhoneNumber = matPhoneNumber;
        this.age = age;
        this.gravida = gravida;
        this.parity = parity;
        this.gestation = gestation;
        this.term = term;
        this.finalDiagnosis = finalDiagnosis;
        this.hivTestDate=hivTestDate;
        this.whoClinicalStage = whoClinicalStage;
        this.cd4Count = cd4Count;
        this.viralLoad = viralLoad;
        this.revisit = revisit;
        this.deliveryMode = deliveryMode;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.ergometrine = ergometrine;
        this.pitocin = pitocin;
        this.misoprostol = misoprostol;
        this.otherMeds = otherMeds;
        this.emtctCode = emtctCode;
        this.arvs = arvs;
        this.vitaminA = vitaminA;
        this.muacColor = muacColor;
        this.muacCM = muacCM;
        this.muacINR = muacINR;
        this.apgarScore = apgarScore;
        this.sexOfBaby = sexOfBaby;
        this.breathing = breathing;
        this.skinToSkin = skinToSkin;
        this.breastFed = breastFed;
        this.teo = teo;
        this.vitK = vitK;
        this.chlorohexidine = chlorohexidine;
        this.counseled = counseled;
        this.matNutrCouns = matNutrCouns;
        this.iycf = iycf;
        this.iycfFeeding = iycfFeeding;
        this.weight = weight;
        this.arvsBaby = arvsBaby;
        this.immunized = immunized;
        this.familyPlanning = familyPlanning;
        this.motherCondition = motherCondition;
        this.babyCondition = babyCondition;
        this.deliveredBy = deliveredBy;
        this.postNatalCare = postNatalCare;
        this.dateOfDischarge = dateOfDischarge;
        this.nameDischarge = nameDischarge;
        this.userId = userId;
    }

}
