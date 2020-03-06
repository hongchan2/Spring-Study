package kr.ac.kw.hong.example2;

import java.lang.annotation.*;

/*
    이 어노테이션을 사용하면 성능을 측정해줍니다.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface PerfLogging {
}
