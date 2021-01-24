package cn.itcast.mybatisplus.mapper;

import cn.itcast.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMaperTest {

    @Autowired
    private UserMapper userMapper;//没有找到实现类 IDEA识别报错 实际没问题

    @Test
    public void testSelect(){
        List<User> users = this.userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectById(){
        User user = this.userMapper.selectById(3L);
        System.out.println(user);
    }

    @Test
    public void testSelectByLike(){
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.like("name", "o");
		wrapper.le("age", 20);
        List<User> list = this.userMapper.selectList(wrapper);
        for (User user : list) {
            System.out.println(user);
        }
    }


    @Test
    public void testSave(){
        User user = new User();
        user.setAge(25);
        user.setEmail("zhangsan@qq.com");
        user.setName("zhangsan");
        int count = this.userMapper.insert(user);
        System.out.println("新增数据成功! count => " + count);
    }

    @Test
    public void testDelete(){
        this.userMapper.deleteById(7L);
        System.out.println("删除成功!");
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(6L);
        user.setName("lisi");
        this.userMapper.updateById(user);
        System.out.println("修改成功!");
    }

    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(2, 2);
        IPage<User> userIPage = this.userMapper.selectPage(page, null);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        List<User> records = userIPage.getRecords();
        for (User user : records) {
            System.out.println(user);
        }
    }

}
