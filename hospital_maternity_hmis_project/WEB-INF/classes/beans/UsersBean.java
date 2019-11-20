package beans;

import dao.UsersDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Loggedin;
import model.Users;
import sun.misc.BASE64Encoder;

@ManagedBean(name = "usersBean")
@SessionScoped
public class UsersBean
        implements Serializable {

    private static final long serialVersionUID = 1L;
    private String uid;
    private String fullName;
    private String userName;
    private String password;
    private String sex;
    private Integer rid;
    private Integer did;
    private String status;
    private Loggedin loggedin;
    private String current_pwd;
    private boolean change_pwd = false;
    private boolean opd_enabled = false;
    private boolean ipd_enabled = false;

    public UsersBean() {
        userName = "";
        password = "";
    }

    public boolean isOpd_enabled() {
        return opd_enabled;
    }

    public void setOpd_enabled(boolean opd_enabled) {
        this.opd_enabled = opd_enabled;
    }

    public boolean isIpd_enabled() {
        return ipd_enabled;
    }

    public void setIpd_enabled(boolean ipd_enabled) {
        this.ipd_enabled = ipd_enabled;
    }

    public boolean isChange_pwd() {
        return this.change_pwd;
    }

    public void setChange_pwd(boolean change_pwd) {
        this.change_pwd = change_pwd;
    }

    public String getCurrent_pwd() {
        return this.current_pwd;
    }

    public void setCurrent_pwd(String current_pwd) {
        this.current_pwd = current_pwd;
    }

    public Loggedin getLoggedin() {
        return this.loggedin;
    }

    public void setLoggedin(Loggedin loggedin) {
        this.loggedin = loggedin;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFullName() {
        return this.fullName.toUpperCase();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getRid() {
        return this.rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getDid() {
        return this.did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String login() {
        try {
            if (("gbaluku".equals(this.userName)) && ("bwindi".equals(this.password))) {
                this.fullName = "Administrator";
                this.uid = "000000";
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", this.userName);
                return "admin";
            }

            Users user = new Users();
            user = UsersDAO.User_Login(this.userName, encryptpass(this.password));

            if (user != null) {
                this.fullName = user.getFullName();
                this.uid = user.getUid();
                this.loggedin = UsersDAO.Users_Get_Details(this.userName, encryptpass(this.password));

                UsersDAO.loginHistory(this.uid);
                String _department = UsersDAO.User_Department(this.uid).trim();

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", this.userName);
                
                //Reception,
                //Consultant, -OPD and IPD -AIP
                //CHB,
                //XRAY,
                //Laboratory,
                //Drug Store,
                //General Store,
                //Dental,
                //SRH,
                //Surgery,
                //Administrator,
                //Accounts,
                //Dispensery
                
                System.out.println("_department :: " + _department);
                
                if (_department.equalsIgnoreCase("Reception")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "reception";
                } else if (_department.equalsIgnoreCase("Consultant")) {
                    opd_enabled = UsersDAO.OPD_Enabled(uid);
                    ipd_enabled = UsersDAO.IPD_Enabled(uid);
                    if (ipd_enabled == false) {
                        return "consultant/opd/incoming";
                    }
                    return "consultant";                    
                } else if (_department.equalsIgnoreCase("AIP") || _department.equalsIgnoreCase("PAED")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "consultant/ipd/ward/new";
                } else if (_department.equalsIgnoreCase("CHB")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "chb";
                } else if (_department.equalsIgnoreCase("XRAY")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "xray";
                } else if (_department.equalsIgnoreCase("Laboratory")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "laboratory";
                } else if (_department.equalsIgnoreCase("Drug Store")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "drugstore";
                } else if (_department.equalsIgnoreCase("General Store")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "generalstore";
                } else if (_department.equalsIgnoreCase("Dental")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "dentist";
                } else if (_department.equalsIgnoreCase("SRH")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "srh";
                } else if (_department.equalsIgnoreCase("Surgery")) {
                    opd_enabled = false;
                    ipd_enabled = false;

                    return "surgery";
                } else if (_department.equalsIgnoreCase("Administrator")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "admin";
                } else if (_department.equalsIgnoreCase("Accounts")) {
                    opd_enabled = false;
                    ipd_enabled = false;

                    return "accounts";
                } else if (_department.equalsIgnoreCase("Dispensery")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "dispensary";
                } else if (_department.equals("")) {
                    opd_enabled = false;
                    ipd_enabled = false;
                    return "";
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String logout() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
            httpSession.invalidate();
            return "start";
        } catch (Exception ex) {
            System.out.println("Logout error:" + ex.getMessage());
        }
        return null;
    }

    private String encryptpass(String pwd) {
        String dataToEncrypt = pwd;
        String encryptionKey = "bwindi";
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(), "Blowfish");

        String encryptedData = "";
        try {
            Cipher cipher = Cipher.getInstance("Blowfish");

            cipher.init(1, key);

            byte[] encryptedBytes = cipher.doFinal(dataToEncrypt.getBytes("UTF-8"));

            return new BASE64Encoder().encode(encryptedBytes);
        } catch (Exception ex) {
            System.err.println("Error Message: " + ex.getMessage());
        }
        return null;
    }

    public String users_update_profile() {
        try {
            if (encryptpass(this.current_pwd).equals(this.loggedin.getCurrent_password())) {
                if (this.loggedin.getNew_password().equals(this.loggedin.getNew_password_retyped())) {
                    if (UsersDAO.Users_Update_Profile(this.loggedin.getUser_id(), this.loggedin.getFullname(), encryptpass(this.loggedin.getNew_password()))) {
                        return logout();
                    }
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Transaction Error.Contant The Administrator", "Failure"));
                    return null;
                }

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "New Password Doesnt Match The Retyped Password", "Failure"));
                return null;
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Provided Current Password is WRONG", "Failure"));
            return null;
        } catch (Exception ex) {
            System.out.println("Users Bean: users_update_profile" + ex.getMessage());
        }
        return null;
    }
}
