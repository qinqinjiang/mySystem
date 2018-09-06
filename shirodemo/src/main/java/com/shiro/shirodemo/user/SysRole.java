package com.shiro.shirodemo.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName SysRole
 * @Author qinqinjiang
 * @Date 2018/9/3 10:37
 * @Description 角色
 */
@Entity
public class SysRole implements Serializable {
    @Id@GeneratedValue
    private Integer id;
    /**
     * 角色标识，如：admin
     */
    private String role;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 是否可用，不可用不会不会添加给用户
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 角色和权限的关系，多对多关联
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermissing> permissings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermissing> getPermissings() {
        return permissings;
    }

    public void setPermissings(List<SysPermissing> permissings) {
        this.permissings = permissings;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
