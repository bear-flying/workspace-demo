package cn.itcast.mapper;

import cn.itcast.pojo.OperationLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OperationLogMapper {

    public void insert(OperationLog operationLog);

    public List<OperationLog> selectListByCondition(Map dataMap);

    public Long countByCondition(Map dataMap);




    public void updateLogCounter();

    public Long countLogFromCounter();

}
