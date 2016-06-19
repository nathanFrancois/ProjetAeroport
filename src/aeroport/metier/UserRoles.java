package aeroport.metier;

import javax.persistence.*;

/**
 * Created by Nathan on 16/06/2016.
 */
@Entity
@Table(name = "USER_ROLES", schema = "baseaeroport")
public class UserRoles {

    @Id
    @Column(name = "USER_ROLE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer userRoleId;


    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne(fetch = FetchType.EAGER)
    private Users users;

    @Basic
    @Column(name = "ROLE")
    private String role;


    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (userRoleId != null ? !userRoleId.equals(userRoles.userRoleId) : userRoles.userRoleId != null) return false;
        if (users != null ? !users.equals(userRoles.users) : userRoles.users != null) return false;
        if (role != null ? !role.equals(userRoles.role) : userRoles.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId != null ? userRoleId.hashCode() : 0;
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
