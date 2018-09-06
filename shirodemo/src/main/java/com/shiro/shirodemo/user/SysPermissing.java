package com.shiro.shirodemo.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName SysPermissing
 * @Author qinqinjiang
 * @Date 2018/9/3 10:38
 * @Description 权限
 */
@Entity
public class SysPermissing implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    /**
     * 资源类型
     */
    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;
    /**
     * 资源路径
     */
    private String url;

    private String permission;

    private Long parentId;

    private String parentIds;

    private Boolean available = Boolean.FALSE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "SysPermissing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                '}';
    }
}
