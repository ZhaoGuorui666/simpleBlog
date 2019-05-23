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

    int testInsert(User user);
}
