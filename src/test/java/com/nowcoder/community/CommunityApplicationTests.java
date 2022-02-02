package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

//@MapperScan({"com.nowcoder.community.dao"})
//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)//在测试代码中使用main的配置类
public class CommunityApplicationTests implements ApplicationContextAware {//spring容器自动创建，为了得到该容器，可以实现该接口

	private ApplicationContext applicationContext;//记录下该容器的引用
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {//接口set方法
		//ApplicationContext接口就是spring容器，是spring顶层接口BeanFactory的子接口，实现了该接口的set方法，spring容器会检测到并调用其set方法将自身传入容器
		this.applicationContext = applicationContext;
	}

//	@Autowired
//	@Qualifier("AlphaDaoHib")
//	private AlphaDao alphadao;
//
//	@Autowired
//	private AlphaService alphaawevice;

	@Test
	public void testApplicationContext(){//容器的使用，管理bean
		System.out.println(applicationContext);
//		//获取Bean的三种方式
//		AlphaDao  alphadao01= applicationContext.getBean(AlphaDao.class);//按类型获取
//		Object alphadao02 = (AlphaDapHib)applicationContext.getBean("AlphaDapHib");//按名称获取，同时转型
//		AlphaDapHib alphadao03 =
//				applicationContext.getBean("AlphaDapHib",AlphaDapHib.class);//按名称+类型获取
//		//获取容器中所有的Bean的名称
//		String[] name = applicationContext.getBeanDefinitionNames();
//		for (String str : name){
//			System.out.println(str);
//		}
		//AlphaService alphaservice = applicationContext.getBean(AlphaService.class);

	}

	@Test
	public void testService(){
		//AlphaService1 service = applicationContext.getBean(AlphaService1.class);

	}
}
