package com.tyh.java.base_lib.class_collector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/12
 * 描述:注解-->可以被h5打开,提供标记
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassCollectorAnnotation {
    /**
     * {@link ClassCollectorTag.TAG}
     *
     * @return 详细名
     */
    @ClassCollectorTag.TAG String value();

    /**
     * @return 分组名
     */
    @ClassCollectorTag.GROUP String group() default ClassCollectorTag.GROUP_DEF;
}
