package com.hy.ly.mapper;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.po.Items;
import com.hy.ly.po.ItemsExample;
import com.hy.ly.po.ItemsExample.Criteria;

public class ItemsMapperTest {

	private ApplicationContext applicationContext;

	private ItemsMapper itemsMapper;

	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
	}

	// 自定义条件查询
	@Test
	public void testSelectByExample() {
		ItemsExample itemsExample=new ItemsExample();
		//通过Criteria构造查询条件
		Criteria criteria=itemsExample.createCriteria();
		criteria.andNameEqualTo("小米");
		//可能返回多条记录
		List<Items> list=itemsMapper.selectByExample(itemsExample);
		for(Items item:list){
			System.out.println(item);
		}
	}

	// 按主键查询
	@Test
	public void testSelectByPrimaryKey() {
		Items items = itemsMapper.selectByPrimaryKey(5);
		System.out.println(items);
	}

	
	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	//插入一条记录
	@Test
	public void testInsert() {
		Items items=new Items();
		items.setName("中兴");
		items.setPrice(1000f);
		items.setDetail("中兴智能机");
		items.setCreatetime(new Date());
		itemsMapper.insert(items);
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExampleWithBLOBs() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

	//更新数据
	@Test
	public void testUpdateByPrimaryKeySelective() {
		
		Items items=itemsMapper.selectByPrimaryKey(7);
		items.setName("诺基亚");
		items.setPrice(100f);
		items.setDetail("历史巅峰的手机");
		items.setCreatetime(new Date());
		//对所有字段进行更新
		itemsMapper.updateByPrimaryKey(items);
		//对所有传入的字段不为空的进行更新,一般在批量更新中使用此方法，不需要先查询，直接更新
		//itemsMapper.updateByPrimaryKeySelective(items)
	}

	@Test
	public void testUpdateByPrimaryKeyWithBLOBs() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
