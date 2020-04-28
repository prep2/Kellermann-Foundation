/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Error;
import model.Vht;
import model.Hmis;
import model.Village;



/**
 *
 *
 */
public class ChbDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    public static Date date;

    public static List<Village> Get_Villages() throws SQLException {

        try {
            Connection con;

            Village village;

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");
            date = new java.util.Date();

//            PreparedStatement stmt = con.prepareStatement("select * from subcounty order by SubcountyName ASC");
            PreparedStatement stmt = con.prepareStatement("select * from village Where ParishId In ('PARI001','PARI002','PARI003','PARI004','PARI005','PARI006','PARI007','PARI008','PARI009','PARI010','PARI016','PARI017','PARI047') order by VillageName ASC");

            ResultSet rs = stmt.executeQuery();
            List <Village> village_list = new ArrayList <Village>();

            while (rs.next()) {
                village = new Village(rs.getString("VillageId"),rs.getString("ParishId"),rs.getString("VillageName"));
                village_list.add(village);
            }
            con.close();
            return village_list;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new Error("Reception DAO", "Reception_Get_Subcounties", " Message: " + ex.getMessage(), date));
            return null;
        }
    }

    public static List<Vht> Get_Vht_List() throws SQLException {
        try {
            Connection con;

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");
            date = new java.util.Date();

            PreparedStatement stmt = con.prepareStatement("SELECT * From vht,village Where vht.vhtVillage=village.VillageId");

            ResultSet rs = stmt.executeQuery();
            List <Vht> vht_list = new ArrayList <Vht>();

            while (rs.next()) {

                Vht vht = new Vht();

                vht.setVhtId(rs.getInt("vhtId"));
                vht.setVhtName(rs.getString("vhtName"));
                vht.setAge(rs.getInt("age"));
                vht.setSex(rs.getString("sex"));
                vht.setVhtPhoneNumber(rs.getString("vhtPhoneNumber"));
                vht.setIsCBD(rs.getString("isCBD"));
                vht.setVillageId(rs.getString("vhtVillage"));
                vht.setVillageName(rs.getString("VillageName"));
                vht.setRecordDate(rs.getDate("recordDate"));
                vht.setUserId(rs.getInt("userId"));

                vht_list.add(vht);
            }
            con.close();
            return vht_list;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Get_Vht_List", " Message: " + ex.getMessage(), date));
            return null;
        }
    }

    public static List<Hmis> Get_Hmis_List() throws SQLException {
        try {
            Connection con;

            System.out.println("ChbDAO.Get_Hmis_List");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");


            //PreparedStatement stmt = con.prepareStatement("SELECT * From hmis,village Where hmis.matVillage=village.VillageId");
            PreparedStatement stmt = con.prepareStatement("SELECT * From hmis");


            ResultSet rs = stmt.executeQuery();
            List <Hmis> hmis_list = new ArrayList<Hmis>();

            System.out.println("Null?"+rs.wasNull());
            while (rs.next()) {

                Hmis hmis = new Hmis();

                hmis.setRecordDate(rs.getDate("recordDate"));
                hmis.setIpd(rs.getInt("IPD"));
                hmis.setAncNum(rs.getInt("ancNum"));
                hmis.setAncRef(rs.getString("ancRef"));
                hmis.setMatName(rs.getString("matName"));
                hmis.setVillageId(rs.getString("villageID"));
                hmis.setVillageName(rs.getString("matVillage"));
                hmis.setMatPhoneNumber(rs.getString("matPhoneNumber"));
                hmis.setAge(rs.getInt("age"));
                hmis.setGravida(rs.getInt("gravida"));
                hmis.setParity(rs.getInt("parity"));
                hmis.setGestation(rs.getInt("weeksGestation"));
                hmis.setTerm(rs.getString("term"));
                hmis.setFinalDiagnosis(rs.getInt("finalDiagnosis"));
                hmis.setWhoClinicalStage(rs.getString("whoClinicalStage"));
                hmis.setCd4Count(rs.getString("cd4Count"));
                hmis.setViralLoad(rs.getInt("viralLoad"));
                hmis.setRevisit(rs.getBoolean("revisit"));
                hmis.setDeliveryMode(rs.getString("deliveryMode"));
                hmis.setDeliveryDate(rs.getDate("deliveryDate"));
                hmis.setDeliveryTime(rs.getTime("deliveryTime"));
                hmis.setErgometrine(rs.getBoolean("ergometrine"));
                hmis.setPitocin(rs.getBoolean("pitocin"));
                hmis.setMisoprostol(rs.getBoolean("misoprostol"));
                hmis.setOtherMeds(rs.getString("otherMeds"));
                hmis.setEmtctCode(rs.getString("emtctCode"));
                hmis.setArvs(rs.getString("arvs"));
                hmis.setVitaminA(rs.getBoolean("vitaminA"));
                hmis.setMuacColor(rs.getString("muacColor"));
                hmis.setMuacCM(rs.getInt("muacCM"));
                hmis.setMuacINR(rs.getInt("muacINR"));
                hmis.setApgarScore(rs.getString("apgarScore"));
                hmis.setSexOfBaby(rs.getString("sexOfBaby"));
                hmis.setBreathing(rs.getString("breathing"));
                hmis.setSkinToSkin(rs.getBoolean("skinToSkin"));
                hmis.setBreastFed(rs.getBoolean("breastFed"));
                hmis.setTeo(rs.getBoolean("teo"));
                hmis.setVitK(rs.getBoolean("vitK"));
                hmis.setChlorohexidine(rs.getBoolean("chlorhexidine"));
                hmis.setCounseled(rs.getString("counseled"));
                hmis.setMatNutrCouns(rs.getBoolean("matNutrCouns"));
                hmis.setIycf(rs.getBoolean("iycf"));
                hmis.setIycfFeeding(rs.getString("iycfFeeding"));
                hmis.setWeight(rs.getFloat("weight"));
                hmis.setArvsBaby(rs.getString("arvsBaby"));
                hmis.setImmunized(rs.getBoolean("immunized"));
                hmis.setFamilyPlanning(rs.getInt("familyPlanning"));
                hmis.setMotherCondition(rs.getString("motherCondition"));
                hmis.setBabyCondition(rs.getString("babyCondition"));
                hmis.setDeliveredBy(rs.getString("deliveredBy"));
                hmis.setPostNatalCare(rs.getDate("postNatalCare"));
                hmis.setDateOfDischarge(rs.getDate("dateOfDischarge"));
                hmis.setNameDischarge(rs.getString("nameDischarge"));
                hmis.setUserId(rs.getInt("userID"));
                hmis_list.add(hmis);

            }
            con.close();
            return hmis_list;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Get_Hmis_List", " Message: " + ex.getMessage(), date));
            return null;
        }
    }

    public static List<Vht> Get_Village_Vht_List(String VillageId) throws SQLException {
        try {
            Connection con;

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");
            date = new java.util.Date();

            PreparedStatement stmt = con.prepareStatement("SELECT * From vht Where vhtVillage=?");

            stmt.setString(1, VillageId);

            ResultSet rs = stmt.executeQuery();
            List <Vht> vht_list = new ArrayList <Vht>();

            while (rs.next()) {

                Vht vht = new Vht();

                vht.setVhtId(rs.getInt("vhtId"));
                vht.setVhtName(rs.getString("vhtName"));
                vht.setAge(rs.getInt("age"));
                vht.setSex(rs.getString("sex"));
                vht.setVhtPhoneNumber(rs.getString("vhtPhoneNumber"));
                vht.setIsCBD(rs.getString("isCBD"));
                vht.setVillageId(rs.getString("vhtVillage"));
                vht.setRecordDate(rs.getDate("recordDate"));
                vht.setUserId(rs.getInt("userId"));

                vht_list.add(vht);
            }
            con.close();
            return vht_list;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Get_Vht_List", " Message: " + ex.getMessage(), date));
            return null;
        }
    }

    public static List<Hmis> Get_Village_Hmis_List(String VillageId) throws SQLException {
        try {
            Connection con;

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");
            date = new java.util.Date();

            PreparedStatement stmt = con.prepareStatement("SELECT * From hmis");


            ResultSet rs = stmt.executeQuery();
            List <Hmis> hmis_list = new ArrayList <Hmis>();

            while (rs.next()) {

                Hmis hmis = new Hmis();

                hmis.setRecordDate(rs.getDate("recordDate"));
                hmis.setIpd(rs.getInt("ipd"));
                hmis.setAncNum(rs.getInt("ancNum"));
                hmis.setAncRef(rs.getString("ancRef"));
                hmis.setMatName(rs.getString("matName"));
                hmis.setVillageId(rs.getString("villageId"));
                hmis.setVillageName(rs.getString("villageName"));
                hmis.setMatPhoneNumber(rs.getString("matPhoneNumber"));
                hmis.setAge(rs.getInt("age"));
                hmis.setGravida(rs.getInt("gravida"));
                hmis.setParity(rs.getInt("parity"));
                hmis.setGestation(rs.getInt("gestation"));
                hmis.setTerm(rs.getString("term"));
                hmis.setFinalDiagnosis(rs.getInt("finalDiagnosis"));
                hmis.setWhoClinicalStage(rs.getString("whoClinicalStage"));
                hmis.setCd4Count(rs.getString("cd4Count"));
                hmis.setViralLoad(rs.getInt("viralLoad"));
                hmis.setRevisit(rs.getBoolean("revisit"));
                hmis.setDeliveryMode(rs.getString("deliveryMode"));
                hmis.setDeliveryDate(rs.getDate("deliveryDate"));
                hmis.setErgometrine(rs.getBoolean("ergometrine"));
                hmis.setPitocin(rs.getBoolean("pitocin"));
                hmis.setMisoprostol(rs.getBoolean("misoprostol"));
                hmis.setOtherMeds(rs.getString("otherMeds"));
                hmis.setEmtctCode(rs.getString("emtctCode"));
                hmis.setArvs(rs.getString("arvs"));
                hmis.setVitaminA(rs.getBoolean("vitaminA"));
                hmis.setMuacColor(rs.getString("muacColor"));
                hmis.setMuacCM(rs.getInt("muacCM"));
                hmis.setMuacINR(rs.getInt("muacINR"));
                hmis.setApgarScore(rs.getString("apgarScore"));
                hmis.setSexOfBaby(rs.getString("sexOfBaby"));
                hmis.setBreathing(rs.getString("breathing"));
                hmis.setSkinToSkin(rs.getBoolean("skinToSkin"));
                hmis.setBreastFed(rs.getBoolean("breastFed"));
                hmis.setTeo(rs.getBoolean("teo"));
                hmis.setVitK(rs.getBoolean("vitK"));
                hmis.setChlorohexidine(rs.getBoolean("chlorohexidine"));
                hmis.setCounseled(rs.getString("counseled"));
                hmis.setMatNutrCouns(rs.getBoolean("matNutrCouns"));
                hmis.setIycf(rs.getBoolean("iycf"));
                hmis.setIycfFeeding(rs.getString("iycfFeeding"));
                hmis.setWeight(rs.getFloat("weight"));
                hmis.setArvsBaby(rs.getString("arvsBaby"));
                hmis.setSexOfBaby(rs.getString("sexOfBaby"));
                hmis.setImmunized(rs.getBoolean("immunized"));
                hmis.setFamilyPlanning(rs.getInt("familyPlanning"));
                hmis.setMotherCondition(rs.getString("motherCondition"));
                hmis.setBabyCondition(rs.getString("babyCondition"));
                hmis.setDeliveredBy(rs.getString("deliveredBy"));
                hmis.setPostNatalCare(rs.getDate("postNatalCare"));
                hmis.setDateOfDischarge(rs.getDate("dateOfDischarge"));
                hmis.setNameDischarge(rs.getString("nameDischarge"));
                hmis.setUserId(rs.getInt("userId"));

                hmis_list.add(hmis);
            }
            con.close();
            return hmis_list;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Get_Hmis_List", " Message: " + ex.getMessage(), date));
            return null;
        }
    }

    public static boolean Save_New_Vht(Vht new_vht,Integer userId) throws SQLException {
        try {
            Connection con;

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = new java.util.Date();

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");

            PreparedStatement stmt = con.prepareStatement("insert into "
                    + "vht (vhtName,Age,Sex,vhtPhoneNumber,isCBD,vhtVillage,recordDate,userId) "
                    + "values(?,?,?,?,?,?,?,?)");

            stmt.setString(1, new_vht.getVhtName());
            stmt.setObject(2, new_vht.getAge());
            stmt.setString(3, new_vht.getSex());
            stmt.setString(4, new_vht.getVhtPhoneNumber());
            stmt.setString(5, new_vht.getIsCBD());
            stmt.setString(6, new_vht.getVillageId());
            stmt.setString(7, dateFormat.format(date));
            stmt.setObject(8, userId);
            stmt.executeUpdate();

            con.close();
            return true;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Save_New_Vht", " Message: " + ex.getMessage(), date));
            return false;
        }
    }

    public static boolean Save_New_Hmis(Hmis new_hmis, Integer userId) throws SQLException {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            date = new java.util.Date();
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            Connection con = DriverManager.getConnection(url, "root", "t00r");
            PreparedStatement stmt = con.prepareStatement("insert into hmis (recordDate, IPD, ancNum, ancRef, matName, villageID, " +
                    "matPhoneNumber, age, gravida, parity, weeksGestation, term, finalDiagnosis, whoClinicalStage, cd4Count, viralLoad," +
                    "revisit, deliveryMode, deliveryDate, deliveryTime, ergometrine, pitocin, misoprostol, otherMeds, emtctCode," +
                    "arvs, vitaminA, muacColor, muacCM, muacINR, apgarScore, sexOfBaby, breathing, skinToSkin, breastFed, teo, vitK, chlorhexidine," +
                    "counseled, matNutrCouns, iycf, iycfFeeding, weight, arvsBaby, immunized, familyPlanning, motherCondition, babyCondition," +
                    "deliveredBy, postNatalCare, dateOfDischarge, nameDischarge, userId, dateOfAdmission, matVillage, hivTestDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, dateFormat.format(date));
            stmt.setObject(2, new_hmis.getIpd());
            stmt.setObject(3, new_hmis.getAncNum());
            stmt.setString(4, new_hmis.getAncRef());
            stmt.setString(5, new_hmis.getMatName());
            stmt.setString(6, new_hmis.getVillageId());
            stmt.setString(7, new_hmis.getMatPhoneNumber());
            stmt.setObject(8, new_hmis.getAge());
            stmt.setObject(9, new_hmis.getGravida());
            stmt.setObject(10, new_hmis.getParity());
            stmt.setObject(11, new_hmis.getGestation());
            stmt.setString(12, new_hmis.getTerm());
            stmt.setObject(13, new_hmis.getFinalDiagnosis());
            stmt.setString(14, new_hmis.getWhoClinicalStage());
            stmt.setString(15, new_hmis.getCd4Count());
            stmt.setObject(16, new_hmis.getViralLoad());
            stmt.setObject(17, new_hmis.getRevisit());
            stmt.setString(18, new_hmis.getDeliveryMode());
            if(new_hmis.getDeliveryDate()==null)
            {
                stmt.setNull(19, java.sql.Types.DATE);
            }
            else {
                stmt.setString(19, dateFormat.format(new_hmis.getDeliveryDate()));
            }
            if(new_hmis.getDeliveryTime()==null)
            {
                stmt.setNull(20, java.sql.Types.TIME);
            }
            else {
                stmt.setString(20, timeFormat.format(new_hmis.getDeliveryTime()));
            }
            stmt.setObject(21, new_hmis.getErgometrine());
            stmt.setObject(22, new_hmis.getPitocin());
            stmt.setObject(23, new_hmis.getMisoprostol());
            stmt.setString(24, new_hmis.getOtherMeds());
            stmt.setString(25, new_hmis.getEmtctCode());
            stmt.setString(26, new_hmis.getArvs());
            stmt.setObject(27, new_hmis.getVitaminA());
            stmt.setString(28, new_hmis.getMuacColor());
            stmt.setObject(29, new_hmis.getMuacCM());
            stmt.setObject(30, new_hmis.getMuacINR());
            stmt.setString(31, new_hmis.getApgarScore());
            stmt.setString(32, new_hmis.getSexOfBaby());
            stmt.setString(33, new_hmis.getBreathing());
            stmt.setObject(34, new_hmis.getSkinToSkin());
            stmt.setObject(35, new_hmis.getBreastFed());
            stmt.setObject(36, new_hmis.getTeo());
            stmt.setObject(37, new_hmis.getVitK());
            stmt.setObject(38, new_hmis.getChlorohexidine());
            stmt.setString(39, new_hmis.getCounseled());
            stmt.setObject(40, new_hmis.getMatNutrCouns());
            stmt.setObject(41, new_hmis.getIycf());
            stmt.setString(42, new_hmis.getIycfFeeding());
            stmt.setObject(43, new_hmis.getWeight());
            stmt.setString(44, new_hmis.getArvsBaby());
            stmt.setObject(45, new_hmis.getImmunized());
            stmt.setObject(46, new_hmis.getFamilyPlanning());
            stmt.setString(47, new_hmis.getMotherCondition());
            stmt.setString(48, new_hmis.getBabyCondition());
            stmt.setString(49, new_hmis.getDeliveredBy());

            if(new_hmis.getPostNatalCare()==null)
            {
                stmt.setNull(50, java.sql.Types.DATE);
            }
            else {
                stmt.setString(50, dateFormat.format(new_hmis.getPostNatalCare()));
            }
            if(new_hmis.getDateOfDischarge()==null)
            {
                stmt.setNull(51, java.sql.Types.DATE);
            }
            else {
                stmt.setString(51, dateFormat.format(new_hmis.getDateOfDischarge()));
            }

            stmt.setString(52, new_hmis.getNameDischarge());
            stmt.setObject(53, userId);
            if(new_hmis.getDateOfAdmission()==null)
            {
                stmt.setNull(54, java.sql.Types.DATE);
            }
            else {
                stmt.setString(54, dateFormat.format(new_hmis.getDateOfAdmission()));
            }

            PreparedStatement villagestmt = con.prepareStatement("SELECT * From village Where village.VillageId=?");
            villagestmt.setObject(1, new_hmis.getVillageId());
            ResultSet rs = villagestmt.executeQuery();
            if(rs.next()) {
                stmt.setString(55, rs.getString("VillageName"));
            }

            if(new_hmis.getHivTestDate()==null)
            {
                stmt.setNull(56, java.sql.Types.DATE);
            }
            else {
                stmt.setString(56, dateFormat.format(new_hmis.getHivTestDate()));
            }
            stmt.executeUpdate();
            con.close();
            return true;
        } catch (Exception var6) {
            //for debugging
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR: "+ var6.getMessage(), "Success"));
            ErrorDAO.Error_Add(new Error("ChbDAO", "Save_New_Hmis", " Message: " + var6.getMessage(), date));
            return false;
        }
    }

    public static Vht Get_Existing_Vht(Integer VhtId) throws SQLException {
        try {
            Connection con;

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");
            date = new java.util.Date();

            PreparedStatement stmt = con.prepareStatement("SELECT * From vht,village Where vht.vhtVillage=village.VillageId and vhtId=?");

            stmt.setObject(1, VhtId);

            ResultSet rs = stmt.executeQuery();

            Vht vht = new Vht();
            while (rs.next()) {

                vht.setVhtId(rs.getInt("vhtId"));
                vht.setVhtName(rs.getString("vhtName"));
                vht.setAge(rs.getInt("age"));
                vht.setSex(rs.getString("sex"));
                vht.setVhtPhoneNumber(rs.getString("vhtPhoneNumber"));
                vht.setIsCBD(rs.getString("isCBD"));
                vht.setVillageId(rs.getString("vhtVillage"));
                vht.setVillageName(rs.getString("VillageName"));
                vht.setRecordDate(rs.getDate("recordDate"));
                vht.setUserId(rs.getInt("userId"));

            }
            con.close();
            return vht;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Get_Existing_Vht", " Message: " + ex.getMessage(), date));
            return null;
        }
    }

    public static Hmis Get_Existing_Hmis(Integer ipd) throws SQLException {
        try {
            Connection con;

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");
            date = new java.util.Date();
            PreparedStatement stmt = con.prepareStatement("SELECT * From hmis,village Where hmis.villageID=village.VillageId and ipd=?");
            stmt.setObject(1, ipd);

            ResultSet rs = stmt.executeQuery();
            Hmis hmis = new Hmis();
            while (rs.next()) {
                hmis.setRecordDate(rs.getDate("recordDate"));
                hmis.setDateOfAdmission(rs.getDate("dateOfAdmission"));
                hmis.setIpd(rs.getInt("IPD"));
                hmis.setAncNum(rs.getInt("ancNum"));
                hmis.setAncRef(rs.getString("ancRef"));
                hmis.setMatName(rs.getString("matName"));
                hmis.setVillageId(rs.getString("villageID"));
                hmis.setVillageName(rs.getString("matVillage"));
                hmis.setMatPhoneNumber(rs.getString("matPhoneNumber"));
                hmis.setAge(rs.getInt("age"));
                hmis.setGravida(rs.getInt("gravida"));
                hmis.setParity(rs.getInt("parity"));
                hmis.setGestation(rs.getInt("weeksGestation"));
                hmis.setTerm(rs.getString("term"));
                hmis.setFinalDiagnosis(rs.getInt("finalDiagnosis"));
                hmis.setWhoClinicalStage(rs.getString("whoClinicalStage"));
                hmis.setCd4Count(rs.getString("cd4Count"));
                hmis.setViralLoad(rs.getInt("viralLoad"));
                hmis.setRevisit(rs.getBoolean("revisit"));
                hmis.setDeliveryMode(rs.getString("deliveryMode"));
                hmis.setDeliveryDate(rs.getDate("deliveryDate"));
                hmis.setDeliveryTime(rs.getTime("deliveryTime"));
                hmis.setErgometrine(rs.getBoolean("ergometrine"));
                hmis.setPitocin(rs.getBoolean("pitocin"));
                hmis.setMisoprostol(rs.getBoolean("misoprostol"));
                hmis.setOtherMeds(rs.getString("otherMeds"));
                hmis.setEmtctCode(rs.getString("emtctCode"));
                hmis.setArvs(rs.getString("arvs"));
                hmis.setVitaminA(rs.getBoolean("vitaminA"));
                hmis.setMuacColor(rs.getString("muacColor"));
                hmis.setMuacCM(rs.getInt("muacCM"));
                hmis.setMuacINR(rs.getInt("muacINR"));
                hmis.setApgarScore(rs.getString("apgarScore"));
                hmis.setSexOfBaby(rs.getString("sexOfBaby"));
                hmis.setBreathing(rs.getString("breathing"));
                hmis.setSkinToSkin(rs.getBoolean("skinToSkin"));
                hmis.setBreastFed(rs.getBoolean("breastFed"));
                hmis.setTeo(rs.getBoolean("teo"));
                hmis.setVitK(rs.getBoolean("vitK"));
                hmis.setChlorohexidine(rs.getBoolean("chlorhexidine"));
                hmis.setCounseled(rs.getString("counseled"));
                hmis.setMatNutrCouns(rs.getBoolean("matNutrCouns"));
                hmis.setIycf(rs.getBoolean("iycf"));
                hmis.setIycfFeeding(rs.getString("iycfFeeding"));
                hmis.setWeight(rs.getFloat("weight"));
                hmis.setArvsBaby(rs.getString("arvsBaby"));
                hmis.setImmunized(rs.getBoolean("immunized"));
                hmis.setFamilyPlanning(rs.getInt("familyPlanning"));
                hmis.setMotherCondition(rs.getString("motherCondition"));
                hmis.setBabyCondition(rs.getString("babyCondition"));
                hmis.setDeliveredBy(rs.getString("deliveredBy"));
                hmis.setPostNatalCare(rs.getDate("postNatalCare"));
                hmis.setDateOfDischarge(rs.getDate("dateOfDischarge"));
                hmis.setNameDischarge(rs.getString("nameDischarge"));
                hmis.setUserId(rs.getInt("userId"));


            }
            con.close();
            return hmis;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Get_Existing_Hmis", " Message: " + ex.getMessage(), date));
            return null;
        }
    }

    public static boolean Update_Existing_Vht(Vht existing_vht) throws SQLException {
        try {
            Connection con;

            date = new java.util.Date();

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            con = DriverManager.getConnection(url, "root", "t00r");

            PreparedStatement stmt = con.prepareStatement("UPDATE vht SET "
                    + "Age=?,Sex=?,vhtPhoneNumber=?,isCBD=? Where vhtId=?");

            stmt.setObject(1, existing_vht.getAge());
            stmt.setString(2, existing_vht.getSex());
            stmt.setString(3, existing_vht.getVhtPhoneNumber());
            stmt.setString(4, existing_vht.getIsCBD());
            stmt.setObject(5, existing_vht.getVhtId());
            stmt.executeUpdate();

            con.close();
            return true;
        } catch (Exception ex) {
            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Update_Existing_Vht", " Message: " + ex.getMessage(), date));
            return false;
        }
    }

    public static boolean Update_Existing_Hmis(Hmis existing_hmis) throws SQLException {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            date = new java.util.Date();

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
            Connection con = DriverManager.getConnection(url, "root", "t00r");
            PreparedStatement stmt = con.prepareStatement("UPDATE hmis SET dateOfAdmission=?,matVillage=?,ancNum=?,ancRef=?, matName=?, villageID=?, matPhoneNumber=?," +
                    "age=?, gravida=?, parity=?, weeksGestation=?, term=?, finalDiagnosis=?, whoClinicalStage=?, cd4Count=?, viralLoad=?, revisit=?, deliveryMode=?, " +
                    "deliveryDate=?, deliveryTime=?, ergometrine=?, pitocin=?, misoprostol=?, otherMeds=?, emtctCode=?, arvs=?, vitaminA=?," +
                    "muacColor=?, muacCM=?, muacINR=?, apgarScore=?, sexOfBaby=?, breathing=?, skinToSkin=?, breastFed=?, teo=?, vitK=?, chlorhexidine=?," +
                    "counseled=?, matNutrCouns=?, iycf=?, iycfFeeding=?, weight=?, arvsBaby=?, immunized=?, familyPlanning=?, motherCondition=?, babyCondition=?," +
                    "deliveredBy=?, postNatalCare=?, dateOfDischarge=?, nameDischarge=?, userId=?, hivTestDate=? Where ipd=?");

            if(existing_hmis.getDateOfAdmission()==null)
            {
                stmt.setNull(1, java.sql.Types.DATE);
            }
            else {
                stmt.setString(1, dateFormat.format(existing_hmis.getDateOfAdmission()));
            }

            PreparedStatement villagestmt = con.prepareStatement("SELECT * From village Where village.VillageId=?");
            villagestmt.setObject(1, existing_hmis.getVillageId());
            ResultSet rs = villagestmt.executeQuery();

            if(rs.next()) {
                stmt.setString(2, rs.getString("VillageName"));
            }
            stmt.setObject(3, existing_hmis.getAncNum());
            stmt.setString(4, existing_hmis.getAncRef());
            stmt.setString(5, existing_hmis.getMatName());
            stmt.setString(6, existing_hmis.getVillageId());
            stmt.setString(7, existing_hmis.getMatPhoneNumber());
            stmt.setObject(8, existing_hmis.getAge());
            stmt.setObject(9, existing_hmis.getGravida());
            stmt.setObject(10, existing_hmis.getParity());
            stmt.setObject(11, existing_hmis.getGestation());
            stmt.setString(12, existing_hmis.getTerm());
            stmt.setObject(13, existing_hmis.getFinalDiagnosis());
            stmt.setString(14, existing_hmis.getWhoClinicalStage());
            stmt.setString(15, existing_hmis.getCd4Count());
            stmt.setObject(16, existing_hmis.getViralLoad());
            stmt.setObject(17, existing_hmis.getRevisit());
            stmt.setString(18, existing_hmis.getDeliveryMode());
            if(existing_hmis.getDeliveryDate()==null)
            {
                stmt.setNull(19, java.sql.Types.DATE);
            }
            else {
                stmt.setString(19, dateFormat.format(existing_hmis.getDeliveryDate()));
            }
            if(existing_hmis.getDeliveryTime()==null)
            {
                stmt.setNull(20, java.sql.Types.TIME);
            }
            else {
                stmt.setString(20, timeFormat.format(existing_hmis.getDeliveryTime()));
            }
            stmt.setObject(21, existing_hmis.getErgometrine());
            stmt.setObject(22, existing_hmis.getPitocin());
            stmt.setObject(23, existing_hmis.getMisoprostol());
            stmt.setString(24, existing_hmis.getOtherMeds());
            stmt.setString(25, existing_hmis.getEmtctCode());
            stmt.setString(26, existing_hmis.getArvs());
            stmt.setObject(27, existing_hmis.getVitaminA());
            stmt.setString(28, existing_hmis.getMuacColor());
            stmt.setObject(29, existing_hmis.getMuacCM());
            stmt.setObject(30, existing_hmis.getMuacINR());
            stmt.setString(31, existing_hmis.getApgarScore());
            stmt.setString(32, existing_hmis.getSexOfBaby());
            stmt.setString(33, existing_hmis.getBreathing());
            stmt.setObject(34, existing_hmis.getSkinToSkin());
            stmt.setObject(35, existing_hmis.getBreastFed());
            stmt.setObject(36, existing_hmis.getTeo());
            stmt.setObject(37, existing_hmis.getVitK());
            stmt.setObject(38, existing_hmis.getChlorohexidine());
            stmt.setString(39, existing_hmis.getCounseled());
            stmt.setObject(40, existing_hmis.getMatNutrCouns());
            stmt.setObject(41, existing_hmis.getIycf());
            stmt.setString(42, existing_hmis.getIycfFeeding());
            stmt.setObject(43, existing_hmis.getWeight());
            stmt.setString(44, existing_hmis.getArvsBaby());
            stmt.setObject(45, existing_hmis.getImmunized());
            stmt.setObject(46, existing_hmis.getFamilyPlanning());
            stmt.setString(47, existing_hmis.getMotherCondition());
            stmt.setString(48, existing_hmis.getBabyCondition());
            stmt.setString(49, existing_hmis.getDeliveredBy());
            if(existing_hmis.getPostNatalCare()==null)
            {
                stmt.setNull(50, java.sql.Types.DATE);
            }
            else {
                stmt.setString(50, dateFormat.format(existing_hmis.getPostNatalCare()));
            }
            if(existing_hmis.getDateOfDischarge()==null)
            {
                stmt.setNull(51, java.sql.Types.DATE);
            }
            else {
                stmt.setString(51, dateFormat.format(existing_hmis.getDateOfDischarge()));
            }
            stmt.setString(52, existing_hmis.getNameDischarge());
            stmt.setObject(53, existing_hmis.getUserId());
            if(existing_hmis.getHivTestDate()==null)
            {
                stmt.setNull(54, java.sql.Types.DATE);
            }
            else {
                stmt.setString(54, dateFormat.format(existing_hmis.getHivTestDate()));
            }
            stmt.setObject(55, existing_hmis.getIpd());

            stmt.executeUpdate();
            con.close();
            return true;
        } catch (Exception var4) {
            //use for debugging
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR: "+var4, "Success"));

            ErrorDAO.Error_Add(new Error("ChbDAO", "Update_Existing_HMIS", " Message: " + var4.getMessage(), date));
            return false;
        }
    }



    @SuppressWarnings("unused") //no obvious use for this function but no harm in keeping it in
    private static java.sql.Date stringToSQLDate(String startDate)
    {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
            java.util.Date date = formatter.parse(startDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            return sqlStartDate;
        }catch (ParseException e)
        {
           e.printStackTrace();
        }
        return null;
    }

    //###############################################################################################################
}
