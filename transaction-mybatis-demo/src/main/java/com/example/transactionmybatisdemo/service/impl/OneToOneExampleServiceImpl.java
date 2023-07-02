package com.example.transactionmybatisdemo.service.impl;

import com.asiainfo.lowcode.entity.OneToOneExample;
import com.asiainfo.lowcode.mapper.OneToOneExampleMapper;
import com.asiainfo.lowcode.service.OneToOneExampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 一对一的关联表 服务实现类
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Service
public class OneToOneExampleServiceImpl extends ServiceImpl<OneToOneExampleMapper, OneToOneExample> implements OneToOneExampleService {

}
