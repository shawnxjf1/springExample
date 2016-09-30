package com.mybatis.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lakala.soa.examples.mybatis.model.IndexMeta;
import com.packStructure.dao.IndexMetaDao;

public class TestIndexMeta {
	private static ApplicationContext ctx;

	@Before
	public void before() throws IOException {
		ctx = new ClassPathXmlApplicationContext("classpath:spring/databaseSetting.xml");
	}

	@Test
	public void testAddIndexMeta() {
		IndexMeta indexMeta = new IndexMeta();
		indexMeta.setIndexName("solrToesIndex");
		indexMeta.setTypeName("solrToesType");
		IndexMetaDao indexMetaService = (IndexMetaDao) ctx.getBean("indexMetaService");
		indexMetaService.addIndexMeta(indexMeta);
	}

	@Test
	public void testQueryByIndexName() {
		IndexMetaDao IndexMetaService = (IndexMetaDao) ctx.getBean("indexMetaService");
		IndexMeta IndexMeta = IndexMetaService.searchIndexMetaByIndexName("solrToesIndex_3");
		Assert.assertEquals("solrToesIndex_3", IndexMeta.getIndexName());
	}

	@Test
	public void deleteIndexMetaById() {
		IndexMetaDao IndexMetaService = (IndexMetaDao) ctx.getBean("indexMetaService");
		IndexMeta IndexMeta = new IndexMeta();
		IndexMeta.setmId(1);
		int delResult = IndexMetaService.deleteIndexMeta(IndexMeta);
		Assert.assertEquals(delResult, 1);
	}

	/**
	 * 测试通过indexName删除。 java.lang.AssertionError: expected:<0> but was:<1>
	 * 暂时的结论删除只能通过rId主键来删除
	 * 
	 * 在mysql控制台执行结果如下：delete from IndexMeta where indexName = 'solrToesIndex';
	 * Query OK, 1 row affected (0.00 sec)
	 */
	@Test
	public void deleteIndexMetaByIndeName() {
		IndexMetaDao IndexMetaService = (IndexMetaDao) ctx.getBean("indexMetaService");
		IndexMeta IndexMeta = new IndexMeta();
		IndexMeta.setIndexName("solrToesIndex_3");
		int delResult = IndexMetaService.deleteIndexMeta(IndexMeta);
		Assert.assertEquals(delResult, 1);
	}

	@Test
	public void testUpdateIndexMeta() {
		IndexMetaDao IndexMetaService = (IndexMetaDao) ctx.getBean("indexMetaService");

		IndexMeta indexMeta = new IndexMeta();
		indexMeta.setmId(1);
		indexMeta.setIndexName("solrToesIndex_3");
		indexMeta.setTypeName("solrToesType_3");
		int updateResult = IndexMetaService.updateIndexMeta(indexMeta);
		Assert.assertEquals(updateResult, 0);
	}

	/********************** 以上都测试通过 ********************/

}