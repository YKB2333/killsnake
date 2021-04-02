package lol.redScarf.goods.system.config;

import lol.redScarf.system.commons.web.ValidatorDto;
import lol.redScarf.system.utils.validator.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.util.ValidatorUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 接口参数自动校验
 *
 * @author xiebin
 */
@Aspect
@Component
@Slf4j
public class ParameterValidationAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerPointCut() {
    }

    @Before("controllerPointCut()")
    public void before(JoinPoint pjp) {
        //获取所有参数数组
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            if (arg instanceof ValidatorDto) {
                ValidatorDto requestDto = (ValidatorDto) arg;
                requestDto.validate();
            }
        }
    }
}
