package com.longmaodi.studyspringcloud.mapper;

import com.longmaodi.studyspringcloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 查询list集合
     *
     * @return
     */
    List<User> queryUserList();

    void batchInsert(List<User> list);

    void updateUserById(User user);

    void updateUserByName(User user);

    User getById(String id);

    List<Map<String, Object>> getTableName(Map<String, Object> params);

    void optimizeTable(@Param("tableName") String tableName);

    List<Map<String, Object>> getDatabaseName(Map<String, Object> params);

    void addOne(@Param("user") User user);
}
