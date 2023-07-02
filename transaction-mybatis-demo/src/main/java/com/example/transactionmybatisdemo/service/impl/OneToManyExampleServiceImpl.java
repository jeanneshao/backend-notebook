package com.example.transactionmybatisdemo.service.impl;

import com.asiainfo.lowcode.entity.OneToManyExample;
import com.asiainfo.lowcode.mapper.OneToManyExampleMapper;
import com.asiainfo.lowcode.service.OneToManyExampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 一对多的关联表 服务实现类
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Service
public class OneToManyExampleServiceImpl extends ServiceImpl<OneToManyExampleMapper, OneToManyExample> implements OneToManyExampleService {

}
