package com.idsmanager.yhm_demo.service.impl;

import com.idsmanager.commons.file.IdsFile;
import com.idsmanager.commons.file.IdsFileRepository;
import com.idsmanager.yhm_demo.service.IdsFileService;
import com.idsmanager.yhm_demo.service.dto.IdsFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2016/2/18
 *
 * @author Shengzhao Li
 */
@Service("idsFileService")
public class IdsFileServiceImpl implements IdsFileService {

    @Autowired
    private IdsFileRepository fileRepository;

    @Override
    public IdsFileDto loadFileByGuid(String guid) {
        final IdsFile file = fileRepository.findByGuid(guid);
        return new IdsFileDto(file, true);
    }

}
