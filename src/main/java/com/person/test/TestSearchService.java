package com.person.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/**
 * 这里为纯粹的客户端请求，将来提供给客户端当做例子<br>
 * 所以这里不需要获取spring容器<br>
 * 
 * @author lakala-shawn
 *
 */
public class TestSearchService
{
	
	/**
	 * 重要：一定要 记录成果：2016-10-25测试OK  
	 * Get ("/list")
	 */
	@Test
	public void testReadListWithOutPage()
	{
		String fq = "LOG_NO = \"123456789322\" and TXNTIM = 20151209000000";
		String url = "http://localhost:8080/dssp/services/rest/common/list?bizType=posp&fq=" + fq;

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		Response response = target.request().get();// .put(Entity.json(jsonObject));
		try
		{
			if (response.getStatus() != 200)
			{
				throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
			}
			JSONObject rsJson = response.readEntity(JSONObject.class);
			System.out.println("Successfully got result: " + rsJson);
		} finally
		{
			response.close();
			client.close();
		}
		
		/**
		 * 2016-10-25结果：
		 *  [25/10/16 07:18:36:036 CST] main DEBUG http.wire: <<
		 *   "{"mesg":"00000","mesgDesc":"succeed","totalNum":0,"results":
		 *   [{"bizType":"posp","CRD_NO":"6226150283816922","MERCID":"822290055980006","CITY":"beijing",
		 *   "_version_":"1510151525252464600","LOG_NO":"123456789321","LOGDAT":"20150720",
		 *   "TXNTIM":"20151208000000","FORCOD":"48220000"}],"stats":null}"
		 */
	}

}
