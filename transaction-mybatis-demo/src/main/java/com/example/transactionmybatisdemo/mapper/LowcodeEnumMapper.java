package com.example.transactionmybatisdemo.mapper;

import com.asiainfo.lowcode.entity.LowcodeEnum;
import com.asiainfo.lowcode.utils.MybatisRedisCache;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 枚举表 Mapper 接口
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Mapper
@CacheNamespace(implementation= MybatisRedisCache.class,eviction=MybatisRedisCache.class)
public interface LowcodeEnumMapper extends BaseMapper<LowcodeEnum> {

}
