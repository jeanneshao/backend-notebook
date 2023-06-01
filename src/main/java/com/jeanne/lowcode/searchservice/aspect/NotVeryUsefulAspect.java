package com.jeanne.lowcode.searchservice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Jeanne 2023/5/29
 **/
@Aspect
public class NotVeryUsefulAspect {
    @Pointcut("execution(* transfer(..))") // the pointcut expression
    private void anyOldTransfer() {} // the pointcut signature

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {}

    @Pointcut("within(com.jeanne.lowcode.searchservice..*)")
    public void inTrading() {}

    @Pointcut("publicMethod() && inTrading()")
    public void tradingOperation() {}



    /**
     * execution: For matching method execution join points. This is the primary pointcut designator to use when working with Spring AOP.
     *
     * within: Limits matching to join points within certain types (the execution of a method declared within a matching type when using Spring AOP).
     *
     * this: Limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type.
     *
     * target: Limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type.
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
