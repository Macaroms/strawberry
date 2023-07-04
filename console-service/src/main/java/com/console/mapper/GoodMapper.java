package com.console.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.console.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-29 16:46
 **/

@Mapper
public interface GoodMapper extends BaseMapper<Good> {

    @Update("UPDATE t_good  SET reserve=reserve-#{count} WHERE id = #{id}")
    void decrease(Long id, int count);

}
