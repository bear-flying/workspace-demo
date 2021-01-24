/*
 * Copyright (c) 2015 MONKEYK Information Technology Co. Ltd
 * www.monkeyk.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * MONKEYK Information Technology Co. Ltd ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with MONKEYK Information Technology Co. Ltd.
 */
package com.idsmanager.yhm_demo.infrastructure.mongodb;

import com.idsmanager.commons.file.IdsFile;
import com.idsmanager.commons.file.IdsFileRepository;
import com.idsmanager.commons.utils.mongo.AbstractMongoSupport;
import org.springframework.stereotype.Repository;

/**
 * 2016/2/18
 *
 * @author Shengzhao Li
 */
@Repository("idsFileRepository")
public class IdsFileRepositoryMongoDB extends AbstractMongoSupport implements IdsFileRepository {


    @Override
    public void saveIdsFile(IdsFile idsFile) {
        this.mongoTemplate().save(idsFile);
    }

    @Override
    public IdsFile findByGuid(String guid) {
        return findById(IdsFile.class, guid);
    }

    @Override
    public void removeIdsFile(IdsFile idsFile) {
        this.mongoTemplate().remove(idsFile);
    }


}
