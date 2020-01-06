package com.cskaoyan.mapper;

import com.cskaoyan.bean.Course;
import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    String selectUsernameById(@Param("id") int id);

    //如果传入的年龄参数大于20 就执行查询大于20的user 21 age>20
    //如果传入的年龄参数小于20 就执行查询小于20的user 15 age<20
    List<User> selectUserByAgeCondition(@Param("age") int age);

    //如果username 为caixukun就查询username为caixukun的用户 select id,username,password,age from j18_user_t where username = 'caixukun'
    //如果不等于，则查询全部用户 select id,username,password,age from j18_user_t
    List<User> selectUserByUsername(@Param("username") String username, @Param("password") String password);

    //如果传入的年龄参数大于20 就执行查询大于20的user 21 age>20
    //如果传入的年龄参数小于20 就执行查询小于20的user 15 age<20
    List<User> selectUserByAgeChooseWhen(@Param("age") int age);

    //trim标签
    int updateUser(@Param("user") User user);

    //set标签
    int updateUserSet(@Param("user") User user);

    //根据id的集合查询出来在该范围内的user数据 1、2、3、4、5、6
    //select id,username,password,age from j18_user_t where id in (1,2,3,4,5,6)
    //无注解数组
    List<User> selectUsersInArray(int[] id);

    //无注解list
    List<User> selectUsersInList(List<Integer> id);

    //有注解数组
    List<User> selectUsersInArrayAnnotation(@Param("ids") int[] id);

    //有注解list
    List<User> selectUsersInListAnnotation(@Param("ids") List<Integer> id);

    //插入多条user数据
    //insert into j18_user_t (username,password,age) values (?,?,?),(?,?,?),(?,?,?)

    int insertUsers(@Param("users") User[] users);

    //int hobbys(@Param("user") User user); //user.hobbys
    int insertUser(@Param("user") User user);

    int insertUserBefore(@Param("user") User user);


    /*
     * 关系表
     * */
    /* 一对一 */

    User queryUserByIdOne2One(@Param("id") Integer id);

    User queryUserByIdOne2OneLeft(@Param("id") Integer id);


    /*  一对多 */
    List<User> queryUsersByIdOne2Many(@Param("id") Integer id);


    /*多对多*/

    List<Course> queryUserByCouserIdMany2Many(@Param("id") Integer id);

    List<User> queryCoursesByUserIdMany2Many(@Param("id") Integer id);



    /*  homework */

    User findUserByParams(@Param("id") Integer id, @Param("username") String username, @Param("password") String password);


    List<User> findUserListByParams(@Param("id") Integer id, @Param("username") String username, @Param("password") String password);

    int insertUserBatch(@Param("userList") List<User> userList);

    /* selectKey */

    int insertTestSelectKey(@Param("user") User user);

    int insertTestUseGenerateKey(@Param("user") User user);
}
