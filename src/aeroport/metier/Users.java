package aeroport.metier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 16/06/2016.
 */
@Entity
public class Users {

    public Users(){
        this.userRolesList = new ArrayList<UserRoles>();
    }

    @Id
    @Column(name = "USERNAME")
    private String username;

    @Basic
    @Column(name = "NOMUSERS")
    private String nomusers;

    @Basic
    @Column(name = "PRENOMUSERS")
    private String prenomusers;

    @Basic
    @Column(name = "PASSWORD")
    private String password;

    @Basic
    @Column(name = "ENABLED")
    private Byte enabled;

    @OneToMany(mappedBy="users", cascade=CascadeType.ALL)
    private List<UserRoles> userRolesList;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomusers() {
        return nomusers;
    }

    public void setNomusers(String nomusers) {
        this.nomusers = nomusers;
    }

    public String getPrenomusers() {
        return prenomusers;
    }

    public void setPrenomusers(String prenomusers) {
        this.prenomusers = prenomusers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        Byte monByte = new Byte("0");
        return !enabled.equals(monByte);
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public List<UserRoles> getUserRolesList() {
        return userRolesList;
    }

    public void setUserRolesList(List<UserRoles> userRolesList) {
        this.userRolesList = userRolesList;
    }

    public void addUserRoles(UserRoles userRoles) {
        if(!this.userRolesList.contains(userRoles)){
            this.userRolesList.add(userRoles);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (nomusers != null ? !nomusers.equals(users.nomusers) : users.nomusers != null) return false;
        if (prenomusers != null ? !prenomusers.equals(users.prenomusers) : users.prenomusers != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (enabled != null ? !enabled.equals(users.enabled) : users.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (nomusers != null ? nomusers.hashCode() : 0);
        result = 31 * result + (prenomusers != null ? prenomusers.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }
}
