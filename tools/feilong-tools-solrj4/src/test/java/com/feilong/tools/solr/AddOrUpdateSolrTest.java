///**
// * Copyright (c) 2008-2014 FeiLong, Inc. All Rights Reserved.
// * <p>
// * 	This software is the confidential and proprietary information of FeiLong Network Technology, Inc. ("Confidential Information").  <br>
// * 	You shall not disclose such Confidential Information and shall use it 
// *  only in accordance with the terms of the license agreement you entered into with FeiLong.
// * </p>
// * <p>
// * 	FeiLong MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, 
// * 	INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
// * 	PURPOSE, OR NON-INFRINGEMENT. <br> 
// * 	FeiLong SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
// * 	THIS SOFTWARE OR ITS DERIVATIVES.
// * </p>
// */
//package com.feilong.tools.solr;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.common.SolrInputDocument;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.feilong.commons.core.util.ObjectUtil;
//
///**
// * @author <a href="mailto:venusdrogon@163.com">金鑫</a>
// * @version 1.0 2012-2-18 下午8:17:03
// */
//public class AddOrUpdateSolrTest{
//
//	private static final Logger	log	= LoggerFactory.getLogger(AddOrUpdateSolrTest.class);
//
//	private String				url	= "http://127.0.0.1:8888/solr-3.5/core0";
//
//	public void addBean(SkuItem skuItem) throws SolrServerException,IOException{
//		CommonsHttpSolrServer server = new CommonsHttpSolrServer(url);
//		server.addBean(skuItem);
//		server.commit();
//	}
//
//	@Test
//	public void testAddBean() throws SolrServerException,IOException{
//		for (int i = 0, j = 50; i < j; ++i){
//			SkuItem skuItem = new SkuItem();
//			long id = ObjectUtil.toLong(i);
//			skuItem.setId(id);
//			skuItem.setCode("25874" + i + "-602");
//			skuItem.setCategoryCode("shoe");
//			skuItem.setCategoryName("鞋");
//			if (i % 2 == 0){
//				skuItem.setBrand("nike");
//			}else{
//				skuItem.setBrand("it");
//			}
//			skuItem.setColor("红色;白色;黑色");
//			skuItem.setDetailedDescription("nike 跑步运动鞋" + id);
//			if (i % 2 == 0){
//				skuItem.setLables("热卖");
//			}
//			if (i % 3 == 0){
//				skuItem.setLables("最新");
//			}else{
//				skuItem.setLables("热卖;最新");
//			}
//			skuItem.setName("NIKE ZOOM HYPERENFORCER 篮球鞋" + id);
//			skuItem.setShowOrder(i + "");
//			addBean(skuItem);
//		}
//	}
//
//	@Test
//	public void add() throws SolrServerException,IOException{
//		/*
//		 * CommonsHttpSolrServer is thread-safe and if you are using the following constructor, you *MUST* re-use the same instance for all
//		 * requests. If instances are created on the fly, it can cause a connection leak. The recommended practice is to keep a static
//		 * instance of CommonsHttpSolrServer per solr server url and share it for all requests. See
//		 * https://issues.apache.org/jira/browse/SOLR-861 for more details
//		 */
//		// SolrServer server = new CommonsHttpSolrServer( url );
//		CommonsHttpSolrServer server = new CommonsHttpSolrServer(url);
//		// server.setSoTimeout(1000); // socket read timeout
//		// server.setConnectionTimeout(100);
//		// server.setDefaultMaxConnectionsPerHost(100);
//		// server.setMaxTotalConnections(100);
//		// server.setFollowRedirects(false); // defaults to false
//		// // allowCompression defaults to false.
//		// // Server side must support gzip or deflate for this to have any effect.
//		// server.setAllowCompression(true);
//		// server.setMaxRetries(1); // defaults to 0. > 1 not recommended.
//		// server.setParser(new XMLResponseParser()); // binary parser is used by default
//		SolrInputDocument doc1 = new SolrInputDocument();
//		doc1.addField("id", "6");
//		doc1.addField("type", "张飞1");
//		doc1.addField("name", "张菲2");
//		SolrInputDocument doc2 = new SolrInputDocument();
//		doc2.addField("id", "8");
//		doc2.addField("type", "张飞1");
//		doc2.addField("name", "张菲2");
//		Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
//		docs.add(doc1);
//		docs.add(doc2);
//		server.add(docs);
//		server.commit();
//	}
//}
