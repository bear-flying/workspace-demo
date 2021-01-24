package com.idsmanager.yhm_demo.infrastructure.mongodb;

import com.idsmanager.commons.utils.mongo.AbstractMongoSupport;
import com.idsmanager.idp.core.domain.*;
import com.idsmanager.idp.core.domain.authentication.IDPAuthenticationCode;
import com.idsmanager.idp.core.dto.*;
import com.idsmanager.idp.core.dto.api.account.DDtalkAccount;
import com.idsmanager.idp.core.dto.api.organization.AbstractApplicationUDOrganizationSCIM;
import com.idsmanager.idp.core.dto.api.organization.DDtalkDepart;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Repository("enterpriseApplicationRepositoryMongoDB")
public class EnterpriseApplicationRepositoryMongoDB extends AbstractMongoSupport implements EnterpriseApplicationRepository {
    @Override
    public String getUserNameByUserExternalId(String s) {
        return null;
    }

    @Override
    public String getOrgExternalValueByOrgUuidAndExternalName(String s, String s1) {
        return null;
    }

    @Override
    public boolean rootNode(String s) {
        return false;
    }

    @Override
    public ApplicationInformation findApplicationInformationByPurchaseId(String s) {
        return null;
    }

    @Override
    public ApplicationInformation findApplicationInformationByPurchaseId(String s, String s1) {
        return null;
    }

    @Override
    public List<ApplicationInformation> findApplicationInformationByApplicationId(String s, String s1) {
        return null;
    }

    @Override
    public ApplicationInformation findApplicationInformationByApplicationUuid(String s) {
        return null;
    }

    @Override
    public void saveEnterpriseApplication(EnterpriseApplication enterpriseApplication) {

    }

    @Override
    public List<IDPLinkingTemplateDto> findEnabledIDPLinkingTemplateDtos() {
        return null;
    }

    @Override
    public String currentUsername() {
        return null;
    }

    @Override
    public boolean enableApplicationInformation(String s, boolean b) {
        return false;
    }

    @Override
    public <T extends EnterpriseApplication> T findEnterpriseApplicationByUuid(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public <T extends ApplicationConfigData> T findApplicationConfigDataByUuid(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public <T extends EnterpriseApplication> List<T> findAllApplicationInfo(Class<T> aClass) {
        return null;
    }

    @Override
    public <T extends ApplicationConfigData> List<T> findEnterpriseApplicationConfigDataList(Class<T> aClass) {
        return null;
    }

    @Override
    public void saveApplicationConfigData(ApplicationConfigData applicationConfigData) {

    }

    @Override
    public IDPLinkingTemplateDto findIDPLinkingTemplateDtoByUuid(String s) {
        return null;
    }

    @Override
    public void saveIDPAuthenticationCode(IDPAuthenticationCode idpAuthenticationCode) {

    }

    @Override
    public String idpDomain() {
        return null;
    }

    @Override
    public IDPAuthenticationCode findIDPAuthenticationCode(String s) {
        return null;
    }

    @Override
    public IDPAuthenticationCode findApplicationSubstanceAuthenticationCode(String s) {
        return null;
    }

    @Override
    public IDPAccountLinkingDto findIDPAccountLinkingDto(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<IDPAccountLinkingDto> findIDPAccountLinkingDtos(String s, String s1) {
        return null;
    }

    @Override
    public List<IDPAuthenticationCode> findIDPAuthenticationsCodeByGroupUuid(String s) {
        return null;
    }

    @Override
    public void removeIDPAuthenticationCode(IDPAuthenticationCode idpAuthenticationCode) {

    }

    @Override
    public List<IDPLinkingTemplateDto> findUsernamePasswordIDPLinkingTemplateDtos() {
        return null;
    }

    @Override
    public List<IDPLinkingTemplateDto> findUsernameIDPLinkingTemplateDtos() {
        return null;
    }

    @Override
    public void updateApplicationInformation(ApplicationInformation applicationInformation) {

    }

    @Override
    public <T extends EnterpriseApplication> void updateEnterpriseApplication(Class<T> aClass, String s, Map<String, Object> map) {

    }

    @Override
    public String enterpriseHost() {
        return null;
    }

    @Override
    public IDPAccountLinkingDto findIDPAccountLinkingDtoByUuid(String s, String s1) {
        return null;
    }

    @Override
    public void createApplicationLog(String s, String s1) {

    }

    @Override
    public void createApplicationLog(String s, String s1, String s2) {

    }

    @Override
    public void saveAPPOauthClientDetails(String s, String s1, String s2) {

    }

    @Override
    public String getAppOauthClientSecretByApplicationUuid(String s, String s1) {
        return null;
    }

    @Override
    public String findApplicationUuidByKeyId(String s) {
        return null;
    }

    @Override
    public void updateApplicationSubstanceAuthenticationCode(IDPAuthenticationCode idpAuthenticationCode) {

    }

    @Override
    public boolean validateUsernamePassword(String s, String s1, String s2) {
        return false;
    }

    @Override
    public boolean validateUsernamePassword(String s, String s1) {
        return false;
    }

    @Override
    public boolean archiveApplicationInformation(String s, boolean b) {
        return false;
    }

    @Override
    public boolean removeApplication(ApplicationInformation applicationInformation) {
        return false;
    }

    @Override
    public ApplicationInformation findArchivedApplicationInformationByApplicationUuid(String s) {
        return null;
    }

    @Override
    public <T extends EnterpriseApplication> boolean removeEnterpriseApplication(Class<T> aClass, String s) {
        return false;
    }

    @Override
    public Locale currentLocale() {
        return null;
    }

    @Override
    public List<RadiusEnterpriseDto> findCurrentRadiusEnterpriseDtos() {
        return null;
    }

    @Override
    public String retrieveRadiusUserPassword(String s, String s1) {
        return null;
    }

    @Override
    public String createEnterpriseOAuthClientDetails(Map<String, Object> map, String s) {
        return null;
    }

    @Override
    public Map<String, Object> findEnterpriseOAuthClientDetails(String s) {
        return null;
    }

    @Override
    public void updateEnterpriseOAuthClientDetails(Map<String, Object> map, String s) {

    }

    @Override
    public Map<String, Object> currentUserInformation() {
        return null;
    }

    @Override
    public UDAccountDto findUDAccountByUserEmail(String s) {
        return null;
    }

    @Override
    public String findEnterpriseUUIDByEnterpriseId(String s) {
        return null;
    }

    @Override
    public boolean validateApplicationUserByUDAccountUuidAndEnterpriseUuid(String s, String s1, String s2) {
        return false;
    }

    @Override
    public SecurityContext authenticateByUsername(String s, String s1) {
        return null;
    }

    @Override
    public EnterpriseMICASApereoApplicationDto findGlobalMICASApplication() {
        return null;
    }

    @Override
    public void addSPSessionMap(String s) {

    }

    @Override
    public boolean validateUserInfoByUsernameAndPassword(String s, String s1, boolean b) {
        return false;
    }

    @Override
    public <T extends ApplicationSession> T findApplicationSessionByApplicationUUID(String s) {
        return null;
    }

    @Override
    public void saveApplicationSession(ApplicationSession applicationSession) {

    }

    @Override
    public void updateApplicationSession(ApplicationSession applicationSession) {

    }

    @Override
    public boolean allowAuthScope(String s, String s1) {
        return false;
    }

    @Override
    public <T extends EnterpriseApplication> T findEnterpriseApplicationByPurchaseId(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public void saveOrUpdateDDtalkDepartId(String s, String s1) {

    }

    @Override
    public void saveOrUpdateEnterpriseWeChatDepartId(String s, String s1) {

    }

    @Override
    public <T extends EnterpriseApplication> T findEnterpriseApplicationByPurchaseIdAndEnterpriseId(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public String findUserIdentityValueByUserNameAndExternalId(String s, String s1) {
        return null;
    }

    @Override
    public <T extends EnterpriseApplication> void removeEnterpriseIDPApplicationByPurchaseId(String s, Class<T> aClass) {

    }

    @Override
    public void saveAccountLinkingDto(IDPAccountLinkingDto idpAccountLinkingDto) {

    }

    @Override
    public IDPAccountLinkingDto findIDPAccountLinkingDtoByIdpUsernameAndApplicationUsername(String s, String s1, String s2, String s3) {
        return null;
    }

    @Override
    public void deleteIDPAccountLinkingDtoByUuid(String s) {

    }

    @Override
    public String findOrganizationByExternalId(String s) {
        return null;
    }

    @Override
    public void saveOrganizationUnit(AbstractApplicationUDOrganizationSCIM abstractApplicationUDOrganizationSCIM) {

}

    @Override
    public void updateUDAccountEmail(String s, String s1) {

    }

    @Override
    public String getSubCompany(String s) {
        return null;
    }

    @Override
    public String getSubCompanyCode(String s) {
        return null;
    }

    @Override
    public String getDepartment(String s) {
        return null;
    }

    @Override
    public Map<String, String> findAccount(String s) {
        return null;
    }

    @Override
    public Map<String, String> findDepOrSubCInfo(String s, String s1) {
        return null;
    }

    @Override
    public String generateOrgCode(String s, String s1) {
        return null;
    }

    @Override
    public String generateOrgCodeForK3(String s) {
        return null;
    }

    @Override
    public List<ApplicationInformation> findApplicationInformationByApplicationName(String s) {
        return null;
    }

    @Override
    public void changeOUExternalId(String s, String s1) {

    }

    @Override
    public String loadSystemUserUuidFromApplicationUser(String s, String s1) {
        return null;
    }

    @Override
    public boolean validateSystemUserOTP(String s, String s1) {
        return false;
    }

    @Override
    public String findExternalIdByCurrentAccount(String s) {
        return null;
    }

    @Override
    public String getKPIUserAccessToken(String s, String s1) {
        return null;
    }

    @Override
    public void changeCurrentOUDataDictoryExternalId(String s, String s1, String s2) {

    }

    @Override
    public String findOrganizationDataDictioryByExternalId(String s, String s1) {
        return null;
    }

    @Override
    public String findOuDictionaryValueByCurrentAccount(String s, String s1) {
        return null;
    }

    @Override
    public void updateAccountDictionary(String s, String s1, String s2) {

    }

    @Override
    public void saveWeaverWorkflowNotification(Map<String, String> map) {

    }

    @Override
    public String getPasswordFromSystemUser() {
        return null;
    }

    @Override
    public boolean handleDDtalkAccountInfo(List<DDtalkAccount> list, String s, String s1) {
        return false;
    }

    @Override
    public boolean handleDDtalkDepartInfo(List<DDtalkDepart> list, String s, String s1) {
        return false;
    }

    @Override
    public void syncUDDataFromUpstream(String s) {

    }

    @Override
    public Map<String, String> findDeleteAccount(String s) {
        return null;
    }

    @Override
    public void deleteAccount(String s) {

    }

    public EnterpriseApplicationRepositoryMongoDB() {
        super();
    }
}
