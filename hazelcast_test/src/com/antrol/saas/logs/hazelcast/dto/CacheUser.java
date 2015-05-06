/*
 * Copyright (c) 2014-2015 Shandong Antrol Network Technology Co.Ltd. All rights reserved. 版权所有(c) 2014-2015
 * 山东蚁巡网络科技有限公司。保留所有权利。
 */
package com.antrol.saas.logs.hazelcast.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>缓存数据。<p>
 *
 * 创建日期 2015年4月22日<br>
 * @author $Author$<br>
 * @version $Revision$ $Date$
 * @since 1.0.0
 */
public class CacheUser implements Serializable {
    //
    private static final long serialVersionUID = 330941764910453899L;
    // 用户id
    private String userId;
    // 用户名
    private String userName;
    // 角色ID
    private String roleId;
    // 角色名称
    private String roleName;
    // 帐户名
    private String accountName;
    // 邮箱地址
    private String email;
    // 手机号
    private String phone;
    // 微信号
    private String wechat;
    // 租户信息
    private String licensekey;
    // 用户密码
    private String password;
    // 用户描述
    private String description;
    // 用户流量
    private double userFlow;
    // 缓存创建时间
    private long cacheCreateTime = new Date().getTime();

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CacheUser [userId=" + userId + ", userName=" + userName + ", roleId=" + roleId + ", roleName="
                + roleName + ", accountName=" + accountName + ", email=" + email + ", phone=" + phone + ", wechat="
                + wechat + ", licensekey=" + licensekey + ", password=" + password + ", description=" + description
                + ", userFlow=" + userFlow + ", cacheCreateTime=" + cacheCreateTime + "]";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getUserFlow() {
        return userFlow;
    }

    public void setUserFlow(double userFlow) {
        this.userFlow = userFlow;
    }

    public long getCacheCreateTime() {
        return cacheCreateTime;
    }

    public void setCacheCreateTime(long cacheCreateTime) {
        this.cacheCreateTime = cacheCreateTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getLicensekey() {
        return licensekey;
    }

    public void setLicensekey(String licensekey) {
        this.licensekey = licensekey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder implements Serializable {
        // 用户id
        private String userId = null;
        // 用户名
        private String userName = null;
        // 角色ID
        private String roleId = null;
        // 角色名称
        private String roleName = null;
        // 帐户名
        private String accountName = null;
        // 邮箱地址
        private String email = null;
        // 手机号
        private String phone = null;
        // 微信号
        private String wechat = null;
        // 租户信息
        private String licensekey = null;
        // 用户密码
        private String password = null;
        // 用户描述
        private String description = null;
        // 用户流量
        private double userFlow = 0.0;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userId = userName;
            return this;
        }

        public Builder setRoleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder setRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setWechat(String wechat) {
            this.wechat = wechat;
            return this;
        }

        public Builder setLicensekey(String licensekey) {
            this.licensekey = licensekey;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setUserFlow(long userFlow) {
            this.userFlow = userFlow;
            return this;
        }

        public CacheUser build() {
            return new CacheUser(this);
        }
    }

    public CacheUser() {}

    public CacheUser(Builder b) {
        userId = b.userId;
        userName = b.userName;
        roleId = b.roleId;
        roleName = b.roleName;
        accountName = b.accountName;
        email = b.email;
        phone = b.phone;
        wechat = b.wechat;
        licensekey = b.licensekey;
        password = b.password;
        description = b.description;
        userFlow = b.userFlow;
    }
}
