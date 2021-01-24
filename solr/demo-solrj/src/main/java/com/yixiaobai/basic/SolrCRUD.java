package com.yixiaobai.basic;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class SolrCRUD {



    //删除文档
    public void deleteDocument() throws Exception {
        //1、创建一个连接solr服务的客户端对象SolrServer对象。
        SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
        //根据id删除
        //solrServer.deleteById(id);
        //根据查询删除
        solrServer.deleteByQuery("*:*");

        solrServer.commit();
    }


}
