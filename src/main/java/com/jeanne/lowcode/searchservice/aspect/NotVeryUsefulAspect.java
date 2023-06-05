package com.jeanne.lowcode.searchservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/5/29
 **/
@Aspect
@Slf4j
@Component
public class NotVeryUsefulAspect {

    @Pointcut("execution(* transfer(..))") // the pointcut expression
    private void anyOldTransfer() {
    } // the pointcut signature

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
    }

    @Around("anyOldTransfer()")
    @AdviceName("en-tr-sssss")
    public Object enhanceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("<-----------------enhanceAround1----------------------->");
        Object r = joinPoint.proceed();
        log.info("<-----------------enhanceAround2----------------------->");

        return r;
    }


    @Before("anyOldTransfer()")
    public void enhanceBefore() {
        log.info("<----------------before-anyOldTransfer----------------------->");
    }


    @After("anyOldTransfer()")
    public void enhanceAfter() {
        log.info("<-----------------enhanceAfter----------------------->");
    }

    @AfterReturning("anyOldTransfer()")
    public void enhancAfterReturning() {
        log.info("<-----------------enhancAfterReturning----------------------->");
    }

    @AfterThrowing("anyOldTransfer()")
    public void enhancAfterThrowing() {
        log.info("<-----------------enhancAfterThrowing----------------------->");
    }


    /*
     *  * within: Limits matching to join points within certain types (the execution of a method declared within a matching type when using Spring AOP).
     */
//    @Pointcut("within(com.jeanne.lowcode.searchservice.service..*)")
//    public void inTrading() {
//    }
//
//    @Before("inTrading()")
//    public void beoforeWithin() {
//        log.info("<-----------------beofore--Within----------------------->");
//    }

//    @Pointcut("within(com.jeanne.lowcode.searchservice.service.NotVeryUsefulService)")
//    public void inTrading2() {
//    }
//
//    @Before("inTrading()")
//    public void beoforeWithin2() {
//        log.info("<-----------------beofore--Within2----------------------->");
//    }


    /**
     * * this: Limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type.
     * *必须全限定名
     * * target: Limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type.
     * *
     */
//    @Pointcut("this(com.jeanne.lowcode.searchservice.service.NotVeryUsefulService)")
//    public void thisDemoPointcut() {
//    }
//    @Before("thisDemoPointcut()")
//    public void beoforeThisDemoPointcut() {
//        log.info("<-----------------before---NotVeryUsefulService--this----------------------->");
//    }
    @Pointcut("this(com.jeanne.lowcode.searchservice.service.NotVeryUsefulInterface)")
    public void thisDemoPointcut2() {
    }

    @Before("thisDemoPointcut2()")
    public void beoforeThisDemoPointcut2() {
        log.info("<-----------------before---This--interface----------------------->");
    }

    @Pointcut("this(com.jeanne.lowcode.searchservice.service.NotVeryUsefulService)")
    public void thisService() {
    }

    @Before("thisService()")
    public void beoforeThisService() {
        log.info("<-----------------before---This--service----------------------->");
    }

    @Pointcut("anyOldTransfer() && @args(com.jeanne.lowcode.searchservice.aspect.permission.PermissionAnnotation)")
    private void runtimeArgAnnotation() {
    }

    @Before("runtimeArgAnnotation()")
    public void beoforehasArgAnnotations() {
        log.info("<-----------------before---beoforehasArgAnnotations----------------------->");
    }

    @Pointcut("anyOldTransfer() && args(java.lang.Integer)")
    private void hasArgs() {
    }

    @Before("hasArgs()")
    public void beoforehasArgs() {
        log.info("<-----------------before---hasArgs----------------------->");
    }

    /**
     * @target要求对象的运行时类型与被注解的类型是同一个类型
     * @within要求对象的运行时类型是被注解的类型的子类
     */
    @Pointcut("anyOldTransfer() && @within(com.jeanne.lowcode.searchservice.aspect.permission.PermissionAnnotation)")
    private void hasWithinAnno() {
    }

    @Before("hasWithinAnno()")
    public void beoforeWithinAnno() {
        log.info("<-----------------before---hasWithinAnno----------------------->");
    }

//    @Pointcut("this(com.jeanne.lowcode.searchservice.service.CommonService)")
//    public void thisDemoPointcut3() {
//    }
//
//    @Before("thisDemoPointcut3()")
//    public void beoforeThisDemoPointcut3() {
//        log.info("<-----------------before---ThisDemoPointcut3----------------------->");
//    }
//    @Pointcut("target(com.jeanne.lowcode.searchservice.service.NotVeryUsefulService)")
//    public void targetDemoPointcut() {
//    }
//
//    @Before("targetDemoPointcut()")
//    public void beforeTargetDemoPointcut() {
//        log.info("<-----------------before---NotVeryUsefulService--target----------------------->");
//    }

    @Pointcut("target(com.jeanne.lowcode.searchservice.service.NotVeryUsefulInterface)")
    public void targetDemoPointcut2() {
    }

    @Before("targetDemoPointcut2()")
    public void beoforeTargetDemoPointcut2() {
        log.info("<-----------------before---target---interface----------------------->");
    }

    @Pointcut("target(com.jeanne.lowcode.searchservice.service.NotVeryUsefulService)")
    public void targetService() {
    }

    @Before("targetService()")
    public void beoforeTargetService() {
        log.info("<-----------------before---target--service----------------------->");
    }


    @Pointcut("@annotation(com.jeanne.lowcode.searchservice.aspect.permission.PermissionAnnotation)")
    private void hasAnnotation() {
    }

    @Pointcut("@target(com.jeanne.lowcode.searchservice.aspect.permission.PermissionAnnotation)")
    private void runtimeAnnotation() {
    }

//    @Pointcut("target(com.jeanne.lowcode.searchservice.service.CommonService)")
//    public void targetDemoPointcut3() {
//    }
//
//    @Before("targetDemoPointcut3()")
//    public void beforeTargetDemoPointcut3() {
//        log.info("<-----------------before---Target--DemoPointcut3----------------------->");
//    }


//    @Pointcut("publicMethod() && inTrading()")
//    public void tradingOperation() {
//    }


    /**
     * execution: For matching method execution join points. This is the primary pointcut designator to use when working with Spring AOP.
     *
     *
     * args: Limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types.
     *
     * @target: Limits matching to join points (the execution of methods when using Spring AOP) where the class of the executing object has an annotation of the given type.
     *
     * @args: Limits matching to join points (the execution of methods when using Spring AOP) where the runtime type of the actual arguments passed have annotations of the given types.
     *
     * @within: Limits matching to join points within types that have the given annotation (the execution of methods declared in types with the given annotation when using Spring AOP).
     *
     * @annotation: Limits matching to join points where the subject of the join point (the method being run in Spring AOP) has the given annotation.
     */

    /**
     * The full AspectJ pointcut language supports additional pointcut designators that are not supported in Spring: call, get, set, preinitialization, staticinitialization, initialization, handler, adviceexecution, withincode, cflow, cflowbelow, if, @this, and @withincode. Use of these pointcut designators in pointcut expressions interpreted by Spring AOP results in an IllegalArgumentException being thrown.
     */


}
