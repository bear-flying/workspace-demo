package cn.itcast.mybatisplus.mapper;

import cn.itcast.mybatisplus.pojo.User;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    //mybatis-plus依然支持mybatis的用法，对mybatis无侵入，只做增强，不做改变
    @Select("select * from tb_user")
    public List<User> selectAll();
}
