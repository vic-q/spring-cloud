package springcloud;

import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author wangqing
 */
@Aspect
@Component
public class ValidateAspect {

    public ValidateAspect() {
    }

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] arguments = joinPoint.getArgs();
        if (arguments != null) {
            Object[] args = arguments;
            int length = arguments.length;

            for (int i = 0; i < length; ++i) {
                Object argument = args[i];
                if (null != argument && argument instanceof BindingResult) {
                    BindingResult bindingResult = (BindingResult) argument;
                    if (bindingResult.hasErrors()) {
                        ArrayList errorMessages = Lists.newArrayList();
                        Iterator iterator = bindingResult.getAllErrors().iterator();

                        while (iterator.hasNext()) {
                            ObjectError objectError = (ObjectError) iterator.next();
                            errorMessages.add(objectError.getDefaultMessage());
                        }
                        throw new BusinessException(403, "参数校验失败: " + StringUtils.join(errorMessages, " & "));
                    }
                }
            }
        }

        return joinPoint.proceed();
    }

}
