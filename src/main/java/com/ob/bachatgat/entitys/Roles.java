package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long roleID;

    @Column(name = "role_name")
    private String roleName;

    public Roles() {
    }

    public Roles(Long roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
