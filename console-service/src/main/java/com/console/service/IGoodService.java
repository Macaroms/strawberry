package com.console.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.console.entity.Good;
import com.console.model.Result;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-29 16:47
 **/
public interface IGoodService extends IService<Good> {

    Page<Good> page(Page<Good> page);

    Result<String> decrease(Long id, int count);

}
