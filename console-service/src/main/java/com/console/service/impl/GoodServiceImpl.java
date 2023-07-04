package com.console.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.console.entity.Good;
import com.console.mapper.GoodMapper;
import com.console.model.Result;
import com.console.service.IGoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-29 16:48
 **/

@Service
@Slf4j
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements IGoodService {

    @Resource
    private GoodMapper goodMapper;

    @Override
    public Page<Good> page(Page<Good> page) {
        return this.page(page, null);
    }

    @Override
    public Result<String> decrease(Long id, int count) {
        try {
            goodMapper.decrease(id, count);
            return Result.ok("success");
        } catch (Exception e){
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
