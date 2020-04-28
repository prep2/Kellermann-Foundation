/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ChbDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import model.Village;
import model.Vht;
import model.Hmis;


/**
 *
 *
 */
@ManagedBean(name = "chbBean")
@SessionScoped
public class ChbBean
            implements Serializable {

    private static final long serialVersionUID = 1L;
//    private TabView tabView;
    private Vht new_vht,existing_vht;
    private List<Vht> vht_list;
    private List<Vht> filteredVht_list;
    private List<Vht> village_vht_list;

    private Hmis new_hmis, existing_hmis;
    private List<Hmis> hmis_list;
    private List<Hmis> filteredHmis_list;
    private List<Hmis> village_hmis_list;

    public ChbBean() {
//        tabView = new TabView();
//        tabView.setActiveIndex(0);
        new_vht = new Vht();
        existing_vht = new Vht();
        vht_list = new ArrayList <Vht>();
        village_vht_list = new ArrayList <Vht>();
        //HMIS info
        new_hmis = new Hmis();
        existing_hmis = new Hmis();
        hmis_list = new ArrayList <Hmis>();
        village_hmis_list = new ArrayList <Hmis>();

    }

//    public TabView getTabView() {
//        return tabView;
//    }

//    public void setTabView(TabView tabView) {
//      this.tabView = tabView;
//    }

    public Vht getNew_vht() {
        return new_vht;
    }

    public void setNew_vht(final Vht new_vht) {
        this.new_vht = new_vht;
    }

    public Vht getExisting_vht() {
        return existing_vht;
    }

    public void setExisting_vht(final Vht existing_vht) {
        this.existing_vht = existing_vht;
    }

    public List<Vht> getVht_list() {
        return vht_list;
    }

    public void setVht_list(final List<Vht> vht_list) {
        this.vht_list = vht_list;
    }

    public List<Vht> getFilteredVht_list() {
        return filteredVht_list;
    }

    public void setFilteredVht_list(final List<Vht> filteredVht_list) {
        this.filteredVht_list = filteredVht_list;
    }

    public List<Vht> getVillage_vht_list() {
        return village_vht_list;
    }

    public void setVillage_vht_list(final List<Vht> village_vht_list) {
        this.village_vht_list = village_vht_list;
    }

    //HMIS code
    public Hmis getNew_hmis() {
        return new_hmis;
    }

    public void setNew_hmis(final Hmis new_hmis) {
        this.new_hmis = new_hmis;
    }

    public Hmis getExisting_hmis() {
        return existing_hmis;
    }

    public void setExisting_hmis(final Hmis existing_hmis) {
        this.existing_hmis = existing_hmis;
    }

    public List<Hmis> getHmis_list() {
        return hmis_list;
    }

    public void setHmis_list(final List<Hmis> hmis_list) { this.hmis_list = hmis_list; }

    public List<Hmis> getFilteredHmis_list() {
        return filteredHmis_list;
    }

    public void setFilteredHmis_list(final List<Hmis> filteredHmis_list) {
        this.filteredHmis_list = filteredHmis_list;
    }

    public List<Hmis> getVillage_hmis_list() {
        return village_hmis_list;
    }

    public void setVillage_hmis_list(final List<Hmis> village_hmis_list) {
        this.village_hmis_list = village_hmis_list;
    }


    public List<Village> get_villages() {
        try {
            return ChbDAO.Get_Villages();
        } catch (final Exception ex) {
            System.err.println("vaccineBean Error: Method: get_villages " + ex.getMessage());
        }
        return null;
    }

    public List<Vht> get_vht_list() {
        try {
            return ChbDAO.Get_Vht_List();
        } catch (final Exception ex) {
            System.err.println("ChbBean Error: Method: get_vht_list" + ex.getMessage());
        }
        return null;
    }
    public List<Hmis> get_hmis_list() {
        try {
            System.out.println("HmisList:"+ChbDAO.Get_Hmis_List());
            return ChbDAO.Get_Hmis_List();
        } catch (final Exception ex) {
            System.err.println("ChbBean Error: Method: get_hmis_list" + ex.getMessage());
        }
        return null;
    }

    public void get_village_vht_list() {
        try {
            village_vht_list = ChbDAO.Get_Village_Vht_List(existing_vht.getVillageId());
            existing_vht.setVhtPhoneNumber(null);
            existing_vht.setAge(null);
            existing_vht.setSex(null);
            existing_vht.setIsCBD(null);
        } catch (final Exception ex) {
            System.err.println("ChbBean Error: Method: get_village_vht_list" + ex.getMessage());
        }
    }

    public void get_village_hmis_list() {
        try {
            System.out.println("get_village_hmis_list");
            this.village_hmis_list = ChbDAO.Get_Village_Hmis_List(this.existing_hmis.getVillageId());
            this.existing_hmis.setIpd((Integer)null);
            this.existing_hmis.setAncNum((Integer)null);
            this.existing_hmis.setAncRef((String)null);
            this.existing_hmis.setMatName((String)null);
            this.existing_hmis.setVillageId((String)null);
            this.existing_hmis.setVillageName((String)null);
            this.existing_hmis.setMatPhoneNumber((String)null);
            this.existing_hmis.setAge((Integer)null);
            this.existing_hmis.setGravida((Integer)null);
            this.existing_hmis.setParity((Integer)null);
            this.existing_hmis.setGestation((Integer)null);
            this.existing_hmis.setTerm((String)null);
            this.existing_hmis.setFinalDiagnosis((Integer)null);
            this.existing_hmis.setWhoClinicalStage((String)null);
            this.existing_hmis.setCd4Count((String)null);
            this.existing_hmis.setViralLoad((Integer)null);
            this.existing_hmis.setRevisit((Boolean)null);
            this.existing_hmis.setDeliveryMode((String)null);
            this.existing_hmis.setDeliveryDate(null);
            this.existing_hmis.setDeliveryTime(null);
            this.existing_hmis.setErgometrine((Boolean)null);
            this.existing_hmis.setPitocin((Boolean)null);
            this.existing_hmis.setMisoprostol((Boolean)null);
            this.existing_hmis.setOtherMeds((String)null);
            this.existing_hmis.setEmtctCode((String)null);
            this.existing_hmis.setArvs((String)null);
            this.existing_hmis.setVitaminA((Boolean)null);
            this.existing_hmis.setMuacColor((String)null);
            this.existing_hmis.setMuacCM((Integer)null);
            this.existing_hmis.setMuacINR((Integer)null);
            this.existing_hmis.setApgarScore((String)null);
            this.existing_hmis.setSexOfBaby((String)null);
            this.existing_hmis.setBreathing((String)null);
            this.existing_hmis.setSkinToSkin((Boolean)null);
            this.existing_hmis.setBreastFed((Boolean)null);
            this.existing_hmis.setTeo((Boolean)null);
            this.existing_hmis.setVitK((Boolean)null);
            this.existing_hmis.setChlorohexidine((Boolean)null);
            this.existing_hmis.setCounseled((String)null);
            this.existing_hmis.setMatNutrCouns((Boolean)null);
            this.existing_hmis.setIycf((Boolean)null);
            this.existing_hmis.setIycfFeeding((String)null);
            this.existing_hmis.setWeight((Float)null);
            this.existing_hmis.setArvsBaby((String)null);
            this.existing_hmis.setImmunized((Boolean)null);
            this.existing_hmis.setFamilyPlanning((Integer)null);
            this.existing_hmis.setMotherCondition((String)null);
            this.existing_hmis.setBabyCondition((String)null);
            this.existing_hmis.setDeliveredBy(null);this.existing_hmis.setPostNatalCare(null);
        } catch (final Exception var2) {
            System.err.println("ChbBean Error: Method: get_village_vht_list" + var2.getMessage());
        }

    }

    public void save_new_vht(final Integer userId,final String Action) {
        try {
//            System.out.println("ChbBean.save_new_vht" + userId);
            if(Action.equals("Save")) {
                if(ChbDAO.Save_New_Vht(new_vht,userId)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "VHT Details Saved Successfully", "Success"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Transaction Error. Contact System Administrator If Error Persists", "Failure"));
                }
            }
            new_vht = new Vht();
//            tabView.setActiveIndex(0);
        } catch (final Exception ex) {
            System.err.println("ChbBean Error: Method: save_new_vht " + ex.getMessage());
        }
    }

    public void save_new_hmis(final Integer userId,final String Action) {
        try {
            System.out.println("ChbBean.save_new_hmis" + userId);
            if(Action.equals("Save")) {
                if(ChbDAO.Save_New_Hmis(new_hmis,userId)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "HMIS Details Saved Successfully", "Success"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Transaction Error. Contact System Administrator If Error Persists", "Failure"));
                }
            }
            new_hmis = new Hmis();
//            tabView.setActiveIndex(0);
        } catch (final Exception ex) {
            System.err.println("ChbBean Error: Method: save_new_hmis " + ex.getMessage());
        }
    }

    public String get_existing_vht(final Integer vhtId,final String destination) {
        try {
//            existing_vht = ChbDAO.Get_Existing_Vht(existing_vht.getVhtId());
            existing_vht = ChbDAO.Get_Existing_Vht(vhtId);
            return destination;
        } catch (final Exception ex) {
            System.err.println("ChbBean Error: Method: get_existing_vht" + ex.getMessage());
            return null;
        }
    }

    public String get_existing_hmis(final Integer ipd,final String destination) {
        try {
            existing_hmis = ChbDAO.Get_Existing_Hmis(ipd);
            return destination;
        } catch (final Exception ex) {
            System.err.println("ChbBean Error: Method: get_existing_hmis" + ex.getMessage());
            return null;
        }
    }

    public String update_existing_vht(final String Action) {
        try {
            System.out.println("ChbBean.update_existing_vht");
            if(Action.equals("Update")) {
                if(ChbDAO.Update_Existing_Vht(existing_vht)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "VHT Details Updated Successfully", "Success"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Transaction Error. Contact System Administrator If Error Persists", "Failure"));
                }
            }
//            tabView.setActiveIndex(0);
            existing_vht = new Vht();
            existing_vht.setVillageId("");
            existing_vht.setVhtId(null);
            existing_vht.setSex("");
            existing_vht.setAge(null);
            existing_vht.setVhtPhoneNumber("");
            existing_vht.setIsCBD("");
            return "vht";
        } catch (final Exception ex) {
            System.err.println("ChbBean Error: Method: update_existing_vht " + ex.getMessage());
            return null;
        }
    }

    public String update_existing_hmis(final String Action) {
        try {
            if (Action.equals("Update")) {
                if (ChbDAO.Update_Existing_Hmis(this.existing_hmis)) {
                    FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_INFO, "HMIS Details Updated Successfully", "Success"));
                } else {
                    FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Transaction Error. Contact System Administrator If Error Persists", "Failure"));
                }
            }

            this.existing_hmis = new Hmis();
            this.existing_hmis.setDateOfAdmission(null);
            this.existing_hmis.setRecordDate(null);
            this.existing_hmis.setIpd(null);
            this.existing_hmis.setAncNum(null);
            this.existing_hmis.setMatName("");
            this.existing_hmis.setVillageId("");
            this.existing_hmis.setVillageName("");
            this.existing_hmis.setMatPhoneNumber("");
            this.existing_hmis.setAge(null);
            this.existing_hmis.setGravida(null);
            this.existing_hmis.setParity(null);
            this.existing_hmis.setGestation(null);
            this.existing_hmis.setTerm("");
            this.existing_hmis.setFinalDiagnosis(null);
            this.existing_hmis.setHivTestDate(null);
            this.existing_hmis.setWhoClinicalStage("");
            this.existing_hmis.setCd4Count("");
            this.existing_hmis.setViralLoad(null);
            this.existing_hmis.setRevisit(null);
            this.existing_hmis.setDeliveryMode("");
            this.existing_hmis.setDeliveryDate(null);
            this.existing_hmis.setDeliveryTime(null);
            this.existing_hmis.setErgometrine(null);
            this.existing_hmis.setPitocin(null);
            this.existing_hmis.setMisoprostol(null);
            this.existing_hmis.setOtherMeds("");
            this.existing_hmis.setEmtctCode("");
            this.existing_hmis.setArvs("");
            this.existing_hmis.setVitaminA(null);
            this.existing_hmis.setMuacColor("");
            this.existing_hmis.setMuacCM(null);
            this.existing_hmis.setMuacINR(null);
            this.existing_hmis.setApgarScore("");
            this.existing_hmis.setSexOfBaby("");
            this.existing_hmis.setBreathing("");
            this.existing_hmis.setSkinToSkin(null);
            this.existing_hmis.setBreastFed(null);
            this.existing_hmis.setTeo(null);
            this.existing_hmis.setVitK(null);
            this.existing_hmis.setChlorohexidine(null);
            this.existing_hmis.setCounseled("");
            this.existing_hmis.setMatNutrCouns(null);
            this.existing_hmis.setIycf(null);
            this.existing_hmis.setIycfFeeding("");
            this.existing_hmis.setWeight((Float)null);
            this.existing_hmis.setArvsBaby("");
            this.existing_hmis.setImmunized(null);
            this.existing_hmis.setFamilyPlanning(null);
            this.existing_hmis.setMotherCondition("");
            this.existing_hmis.setBabyCondition("");
            this.existing_hmis.setDeliveredBy("");
            this.existing_hmis.setPostNatalCare(null);
            this.existing_hmis.setDateOfDischarge(null);
            this.existing_hmis.setNameDischarge("");
            this.existing_hmis.setUserId(null);
            return "hmis";
        } catch (final Exception var3) {
            System.err.println("ChbBean Error: Method: update_existing_hmis " + var3.getMessage());
            return null;
        }
    }

}
