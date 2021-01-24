package com.idsmanager.yhm_demo.service;

import com.idsmanager.yhm_demo.service.dto.IdsFileDto;

/**
 * 2016/2/18
 *
 * @author Shengzhao Li
 */

public interface IdsFileService {

    IdsFileDto loadFileByGuid(String guid);
}