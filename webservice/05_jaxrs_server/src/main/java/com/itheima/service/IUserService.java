package com.itheima.service;

import com.itheima.entity.User;

import javax.ws.rs.*;
import java.util.List;

@Path("/userService")//  访问当前服务接口对应的路径
@Produces("*/*")  // 服务器支持的返回的数据格式类型
public interface IUserService {

	@POST// 表示处理的请求的类型，post 对应的是insert新增操作
	@Path("/user")// 访问当前服务接口方法对应的路径。 【....../userService/user】
	@Consumes({ "application/xml", "application/json" })//  服务器支持的请求的数据格式类型
	public void saveUser(User user);

	@PUT// 表示处理的请求的类型，put 对应的是update修改操作
	@Path("/user")
	@Consumes({ "application/xml", "application/json" })
	public void updateUser(User user);

	@GET// 表示处理的请求的类型，get 对应的是查询操作
	@Path("/user/{id}")
	@Consumes("application/xml")
	@Produces({ "application/xml", "application/json" })// 服务器支持的返回的数据格式类型
	public User finUserById(@PathParam("id") Integer id);


	@Path("/user")
	// 服务器支持的返回的数据格式类型
	@Produces({ "application/xml", "application/json" })
	public List<User> findAllUsers();

	// 表示处理的请求的类型，delete 对应的是删除操作
	@DELETE
	@Path("/user/{id}")
	@Consumes({"application/xml", "application/json"})
	public void deleteUser(@PathParam("id") Integer id);
}
