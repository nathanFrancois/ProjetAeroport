package aeroport.metier;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Nathan on 16/06/2016.
 */
@Entity
public class Users {
    private String username;
    private String nomusers;
    private String prenomusers;
    private String password;
    private Byte enabled;

    @Id
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "NOMUSERS")
    public String getNomusers() {
        return nomusers;
    }

    public void setNomusers(String nomusers) {
        this.nomusers = nomusers;
    }

    @Basic
    @Column(name = "PRENOMUSERS")
    public String getPrenomusers() {
        return prenomusers;
    }

    public void setPrenomusers(String prenomusers) {
        this.prenomusers = prenomusers;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ENABLED")
    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
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
