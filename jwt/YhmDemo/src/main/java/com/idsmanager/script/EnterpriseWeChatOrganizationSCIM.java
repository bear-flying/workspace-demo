/*
 * Copyright (c) 2016 BeiJing JZYT Technology Co. Ltd
 * www.idsmanager.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * BeiJing JZYT Technology Co. Ltd ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with BeiJing JZYT Technology Co. Ltd.
 */
package com.idsmanager.script;

import java.io.Serializable;

public class EnterpriseWeChatOrganizationSCIM implements Serializable {

    private String organizationUuid;
    private String organization;
    private String parentUuid;

    public String getOrganizationUuid() {
        return organizationUuid;
    }

    public void setOrganizationUuid(String organizationUuid) {
        this.organizationUuid = organizationUuid;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    //
//    /**
//     * 组织机构名称
//     */
//    private String organization;
//    /**
//     * IDP PUSH TO SP USE
//     * 组织机构ID
//     */
//    private String organizationUuid;
//
//    private String parentUuid;
//
//    // 钉钉部门id
//    private String enterpriseWeChatDepartId;
//
//    // 父部门的钉钉id
//    private String parentEnterpriseWeChatDepartId;
//
//    private boolean rootNode;
//
//    public EnterpriseWeChatOrganizationSCIM() {
//    }
//
//
//    public boolean isRootNode() {
//        return rootNode;
//    }
//
//    public void setRootNode(boolean rootNode) {
//        this.rootNode = rootNode;
//    }
//
//    public String getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(String organization) {
//        this.organization = organization;
//    }
//
//    public String getOrganizationUuid() {
//        return organizationUuid;
//    }
//
//    public void setOrganizationUuid(String organizationUuid) {
//        this.organizationUuid = organizationUuid;
//    }
//
//    public String getParentUuid() {
//        return parentUuid;
//    }
//
//    public void setParentUuid(String parentUuid) {
//        this.parentUuid = parentUuid;
//    }
//
//    public String getEnterpriseWeChatDepartId() {
//        return enterpriseWeChatDepartId;
//    }
//
//    public void setEnterpriseWeChatDepartId(String enterpriseWeChatDepartId) {
//        this.enterpriseWeChatDepartId = enterpriseWeChatDepartId;
//    }
//
//    public String getParentEnterpriseWeChatDepartId() {
//        return parentEnterpriseWeChatDepartId;
//    }
//
//    public void setParentEnterpriseWeChatDepartId(String parentEnterpriseWeChatDepartId) {
//        this.parentEnterpriseWeChatDepartId = parentEnterpriseWeChatDepartId;
//    }
}
