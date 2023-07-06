package com.example.transactionmybatisdemo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.baomidou.mybatisplus.annotation.DbType;

import java.util.Date;

/**
 * @author Jeanne 2023/5/13
 **/
@EnableTransactionManagement()
@Configuration
public class MyBatisPlusConfig implements MetaObjectHandler {



    /**
     * insertFill updateFill 自动给字段赋值
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", new Date(), metaObject);
//        setFieldValByName("createTime", new Date(), metaObject);
//        setFieldValByName("dealTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(), metaObject);
    }

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    /**
     * 配合字段上的@Version使用，更新时的乐观锁
     */
    public MybatisPlusInterceptor optimisticLockerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }
}
