package cn.itcast.aop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.itcast.mapper.OperationLogMapper;
import cn.itcast.pojo.OperationLog;
import cn.itcast.service.OperationLogService;
import cn.itcast.utils.DataUtils;
import cn.itcast.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 定义通知类
 */
@Component
@Aspect
public class OperateAdvice {
	
	private static Logger log = Logger.getLogger(OperateAdvice.class);
	
	@Autowired
	private OperationLogService operationLogService;
	
	//拦截指定包下的,并且带有@OperateLog注解的方法：
	@Around("execution(* cn.itcast.controller.*.*(..)) && @annotation(operateLog)")
	public Object insertLogAround(ProceedingJoinPoint pjp , OperateLog operateLog) throws Throwable{
		System.out.println(" *********************************** 记录日志 [start]  ****************************** ");
		
		OperationLog op = new OperationLog();

		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		op.setOperateTime(sdf.format(new Date()));
		op.setOperateUser(DataUtils.getRandStr(8));
		
		op.setOperateClass(pjp.getTarget().getClass().getName());
		op.setOperateMethod(pjp.getSignature().getName());
		
		Object[] args = pjp.getArgs();
		op.setParamAndValue(Arrays.toString(args));

		long start_time = System.currentTimeMillis();

		//放行
		Object object = pjp.proceed();

		long end_time = System.currentTimeMillis();
		op.setCostTime(end_time - start_time);

		if(object != null){
			op.setReturnClass(object.getClass().getName());
			op.setReturnValue(object.toString());
		}else{
			op.setReturnClass("java.lang.Object");
			op.setParamAndValue("void");
		}

		log.error(JsonUtils.obj2JsonString(op));

		operationLogService.insert(op);
		
		System.out.println(" *********************************** 记录日志 [end]  ****************************** ");
		
		return object;
	}
	
}
