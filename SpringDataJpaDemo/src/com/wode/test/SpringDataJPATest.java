package com.wode.test;

import java.util.Iterator;

import javax.print.attribute.standard.PagesPerMinute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import com.wode.entity.GoodsEntity;
import com.wode.entity.UserEntity;
import com.wode.service.GoodsService;
import com.wode.service.UserService;

/**
 * SpringData测试类
 * @author jiangqinqin
 *
 */
public class SpringDataJPATest {
	private ApplicationContext applicationContext;
	
	public SpringDataJPATest(){
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	//测试Repository接口
	public void testRepository(){
		UserService userService = (UserService)applicationContext.getBean("userService");
		UserEntity userEntity = userService.findUserById(1);
		System.out.println(userEntity);
	}
	
	//测试JPA接口
	public void testJpa(){
		GoodsService goodsService = (GoodsService)applicationContext.getBean("goodsService");
		GoodsEntity goods = new GoodsEntity("酸奶",5.0);
		//插入
		goodsService.addAndModifyGoods(goods);
		
		System.out.println(goodsService.getGoodsCount());
	}
	
	//测试接口的分页功能
	public void testPage(){
		GoodsService goodsService = (GoodsService)applicationContext.getBean("goodsService");
		Page<GoodsEntity> page = goodsService.getPageGoodsByPrice(4.0, 0, 3);
		Iterator<GoodsEntity> iterable = page.iterator();
		while(iterable.hasNext()){
			System.out.println(iterable.next());
		}
		
	}
	
	public static void main(String[] args) {
		SpringDataJPATest test = new SpringDataJPATest();
		test.testRepository();
		test.testJpa();
		test.testPage();
	}
}
