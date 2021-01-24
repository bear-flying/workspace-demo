/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yixiaobai.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Solr工具类
 *
 * @author Storezhang
 */
@Service
public class SolrUtils {

    public static final String SOLR_URL = "http://admin:admin@solr.icoolxue.com:8080/collection1/";
    private final HttpSolrServer server;
    @Autowired
    private IVideoService videoSvc;

    public SolrUtils() {
        server = new HttpSolrServer(SOLR_URL);
        server.setAllowCompression(true);
    }

    public void add(Video video) throws SolrServerException, IOException {
        SolrInputDocument doc = parese(video);
        server.add(doc);
        server.commit();
    }

    public void add(List<Video> videos) throws SolrServerException, IOException {
        List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        for (Video video : videos) {
            SolrInputDocument doc = parese(video);
            docs.add(doc);
        }
        server.add(docs);
        server.commit();
    }

    public List<Video> search(String key, int page, int size) throws SolrServerException {
        SolrQuery query = new SolrQuery();
        String queryString = String.format("name:*%s* description:*%s*", key, key);
        query.setQuery(queryString);
        int start = PageUtils.calIndex(page, size);
        query.setStart(start);
        query.setRows(size);
        QueryResponse res = server.query(query);
        List<Video> videos = new ArrayList<Video>();
        SolrDocumentList results = res.getResults();
        for (SolrDocument doc : results) {
            String sId = doc.getFieldValue("id").toString();
            long id = Long.parseLong(sId);
            Video video = videoSvc.getById(id);
            videos.add(video);
        }
        return videos;
    }

    public SolrInputDocument parese(Video video) {
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", video.getId());
        doc.addField("name", video.getName());
        doc.addField("description", video.getDescription());
        return doc;
    }

    public void update(Video video) throws SolrServerException, IOException {
        add(video);
    }

    public void delete() throws SolrServerException, IOException {
        server.deleteByQuery("*:*");
        server.commit();
    }
}
