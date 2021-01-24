package cn.itcast.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 来标示方法需不需要进行记录日志，如果该方法在访问时需要记录日志，则在该方法上标示该注解既可。
 */
@Inherited
@Documented
@Target(ElementType.METHOD) //表示 作用在方法上
@Retention(RetentionPolicy.RUNTIME) // 表示 运行时有效
public @interface OperateLog {
}
