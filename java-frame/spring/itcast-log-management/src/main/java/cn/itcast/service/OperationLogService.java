package cn.itcast.service;

import cn.itcast.mapper.OperationLogMapper;
import cn.itcast.pojo.OperationLog;
import cn.itcast.pojo.PageResult;
import cn.itcast.utils.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OperationLogService {

    //private static Logger logger = Logger.getLogger(OperationLogService.class);

    @Autowired
    private OperationLogMapper operationLogMapper;

    public void insert(OperationLog operationLog){
        operationLogMapper.insert(operationLog);
        operationLogMapper.updateLogCounter();
    }

    public PageResult selectListByCondition(Map dataMap, Integer pageNum , Integer pageSize){

        if(dataMap!=null){
            dataMap.put("start", (pageNum-1)*pageSize);
            dataMap.put("size", pageSize);
        }

        System.out.println(dataMap);


        long countStart = System.currentTimeMillis();
        //Long count = operationLogMapper.countByCondition(dataMap);
        Long counter = operationLogMapper.countLogFromCounter();
        long countEnd = System.currentTimeMillis();
        System.out.println("Count Cost Time : " + (countEnd-countStart)+" ms");


        List<OperationLog> list = operationLogMapper.selectListByCondition(dataMap);
        long queryEnd = System.currentTimeMillis();
        System.out.println("Query Cost Time : " + (queryEnd-countEnd)+" ms");

        return new PageResult(counter,list);

    }

}
