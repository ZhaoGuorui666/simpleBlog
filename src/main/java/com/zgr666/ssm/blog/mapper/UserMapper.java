package com.zgr666.ssm.blog.mapper;

import com.zgr666.ssm.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 添加
     *
     * @param User
     * @return 影响的行数
     */
    int insert(User user);

    /**
     * 通过用户名得到密码
     *
     * @param userName
     * @return password
     */
    String getPassByName(String userName);


    /**
     * 测试sql语句是否正确
     *
     * @param user
     * @return
     */
    int testInsert(User user);
}
