package com.person.test;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.nestedQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import com.lakala.indexsearch.spring.data.es.entity.Book;
import com.lakala.indexsearch.spring.data.es.entity.UserEntity;
import com.lakala.indexsearch.spring.data.es.entity.builder.UserEntityBuilder;

/**
 * 写测试用例需要注意的地方： 首先描述出要测试的场景 在预置数据 再写测试用例，比如测试spring elasticsearch：有如下数据<br>
 * <p>
 * userEntities1=[UserEntity [userId=99, userName=null, age=0, city=null,
 * province=null, car=null, books=[Book(bookNumber=1, price=1.0,
 * author=author_1), Book(bookNumber=2, price=2.0, author=author_2),
 * Book(bookNumber=3, price=3.0, author=author_3)]] <br>
 * UserEntity [userId=123, userName=null, age=0, city=null, province=null,
 * car=null, books=[Book(bookNumber=1, price=1.0, author=author_1),
 * Book(bookNumber=2, price=2.0, author=author_2), Book(bookNumber=3, price=3.0,
 * author=author_3)]]]
 * </p>
 * 需要测试如下场景：1.两个must都存在：must userid=99 must books.author=author_2,<br>
 * 2.一个must存在一个must不存在 must userid=99 must books.author=author_8,<br>
 * 3.有一个should存在另一个should不存在should userid=10000 should books.author=author_2<br>
 * 4.两个should都不存在 should userid=10000 should books.author=author_9,<br>
 * 
 * attention:从大角度划分清楚了，就不会乱写或者写多了测试用例，也不知道那个测试用例干什么用的
 * 
 * @author lakala-shawn
 *
 */
public class TestExample {

	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	// OK
	// 通过template indexQuery接口插入nested数据
	@Before
	public void addNestObjectByEsTemplate() {

		List<Book> books = new ArrayList<Book>();
		final Book b1 = new Book();
		final Book b2 = new Book();
		final Book b3 = new Book();

		// 从1加到3 author_1,author_2,author_3<br>
		int i = 1;
		b1.setBookNumber(String.valueOf(i));
		b1.setAuthor("author_" + String.valueOf(i));
		b1.setPrice(i);

		i++;
		b2.setBookNumber(String.valueOf(i));
		b2.setAuthor("author_" + String.valueOf(i));
		b2.setPrice(i);

		i++;
		b3.setBookNumber(String.valueOf(i));
		b3.setAuthor("author_" + String.valueOf(i));
		b3.setPrice(i);

		books.add(b1);
		books.add(b2);
		books.add(b3);

		UserEntity ue = new UserEntityBuilder("99").books(books).build();

		IndexQuery indexQuery = new IndexQuery();
		indexQuery.setId(ue.getUserId());
		indexQuery.setObject(ue);

		List<IndexQuery> indexs = new ArrayList<IndexQuery>();
		indexs.add(indexQuery);
		elasticsearchTemplate.bulkIndex(indexs);
		elasticsearchTemplate.refresh(UserEntity.class);
	}

	/**
	 * 处理must,must查询
	 */
	@Test
	public void testMustMustSearch() {
		// addNestObjectByEsTemplate();

		final QueryBuilder builder = nestedQuery("books",
				boolQuery().must(termQuery("books.author", "author_2")).must(termQuery("books.price", 2)));

		final SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
		final List<UserEntity> userEntities = elasticsearchTemplate.queryForList(searchQuery, UserEntity.class);

		System.out.println("userEntities=" + userEntities);

	}

	/**
	 * 测试should下面还有should<br>
	 */
	@Test
	public void testshould_should_shouldshould() {
		// addNestObjectByEsTemplate();

		// 一个must和一个should
		/*
		 * userEntities=[UserEntity [userId=99, userName=null, age=0, city=null,
		 * province=null, car=null, books=[Book(bookNumber=1, price=1.0,
		 * author=author_1), Book(bookNumber=2, price=2.0, author=author_2),
		 * Book(bookNumber=3, price=3.0, author=author_3)]], UserEntity
		 * [userId=123, userName=null, age=0, city=null, province=null,
		 * car=null, books=[Book(bookNumber=1, price=1.0, author=author_1),
		 * Book(bookNumber=2, price=2.0, author=author_2), Book(bookNumber=3,
		 * price=3.0, author=author_3)]]]
		 */ /*
			 * final QueryBuilder builder = nestedQuery("books",
			 * boolQuery().should(termQuery("books.author", "author_5"))
			 * .should(termQuery("books.author", "author_4")));
			 * 
			 */
		BoolQueryBuilder shouldQueryBuilder = boolQuery().should(termQuery("books.author", "author_3"))
				.should(termQuery("books.author", "author_2"));

		BoolQueryBuilder boolBuilder = boolQuery().should(termQuery("userId", "99")).should(shouldQueryBuilder);

		final QueryBuilder builder = nestedQuery("books", boolBuilder);

		final SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
		final List<UserEntity> userEntities = elasticsearchTemplate.queryForList(searchQuery, UserEntity.class);

		System.out.println("userEntities=" + userEntities);

	}

	/**
	 * 测试结果：通过返回了响应的值<br>
	 * 测试must,must(should,should)测试must里面套两个子Should(该两个should只要有一个通过即行)，测试OK<br>
	 * userEntities=[UserEntity [userId=99, userName=null, age=0, city=null,
	 * province=null, car=null, books=[Book(bookNumber=1, price=1.0,
	 * author=author_1), Book(bookNumber=2, price=2.0, author=author_2),
	 * Book(bookNumber=3, price=3.0, author=author_3)]], UserEntity [userId=123,
	 * userName=null, age=0, city=null, province=null, car=null,
	 * books=[Book(bookNumber=1, price=1.0, author=author_1), Book(bookNumber=2,
	 * price=2.0, author=author_2), Book(bookNumber=3, price=3.0,
	 * author=author_3)]]]
	 * 
	 */
	@Test
	public void testmust_must_shouldshould() {
		BoolQueryBuilder shouldQueryBuilder = boolQuery().should(termQuery("books.bookNumber", "9"))
				.should(termQuery("books.author", "author_2"));

		BoolQueryBuilder boolBuilder = boolQuery().must(termQuery("books.price", "2.0")).must(shouldQueryBuilder);

		final QueryBuilder builder = nestedQuery("books", boolBuilder);

		final SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
		final List<UserEntity> userEntities = elasticsearchTemplate.queryForList(searchQuery, UserEntity.class);

		System.out.println("userEntities=" + userEntities);

	}

	/**
	 * 结果：should(must,must)测试通过,需要里面两个must都存在才返回。<br>
	 * 1.注意如果是nestedQuery()则nestedQuery()里面不能出现
	 * termQuery(userId)这样的形式，必须是嵌套的形式如termQuery("books.bookNumber","3")<br>
	 * 2.must(termQuery("books.author", "3")).must(termQuery("books.author",
	 * "author_2"));会返回空因为没有对象books.author即是author_2又是author_3.<br>
	 * 
	 */
	@Test
	public void testshould_mustmust() {
		BoolQueryBuilder shouldQueryBuilder = boolQuery().must(termQuery("books.bookNumber", "3"))
				.must(termQuery("books.author", "author_2"));

		BoolQueryBuilder boolBuilder = boolQuery().should(shouldQueryBuilder);

		final QueryBuilder builder = nestedQuery("books", boolBuilder);

		final SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
		final List<UserEntity> userEntities = elasticsearchTemplate.queryForList(searchQuery, UserEntity.class);

		System.out.println("userEntities=" + userEntities);

	}

	/**
	 * 两个should 有一个存在就OK（测试通过）
	 */
	@Test
	public void testOnlyOneshouldExist() {
		BoolQueryBuilder shouldQueryBuilder = boolQuery().should(termQuery("books.author", "author_9"))
				.should(termQuery("books.author", "author_2"));
		final QueryBuilder builder = nestedQuery("books", shouldQueryBuilder);

		final SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
		final List<UserEntity> userEntities = elasticsearchTemplate.queryForList(searchQuery, UserEntity.class);

		System.out.println("userEntities=" + userEntities);
	}

	/**
	 * 两个should 没有一个存在，返回了空[]<br>
	 */
	@Test
	public void testNoShouldExist() {
		BoolQueryBuilder shouldQueryBuilder = boolQuery().should(termQuery("books.author", "author_9"))
				.should(termQuery("books.author", "author_8"));

		// BoolQueryBuilder boolBuilder = boolQuery().must(termQuery("userId",
		// "99")).must(shouldQueryBuilder);

		final QueryBuilder builder = nestedQuery("books", shouldQueryBuilder);

		final SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
		final List<UserEntity> userEntities = elasticsearchTemplate.queryForList(searchQuery, UserEntity.class);

		System.out.println("userEntities=" + userEntities);

	}

}
