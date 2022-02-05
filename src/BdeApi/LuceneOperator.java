package BdeApi;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import business.data.Site;


public class LuceneOperator {
	
	String indexDir = "/Users/mamadoubelladiallo/newEclipse/COO/agp/jsf/index";
	String dataDir ;
	Indexer indexer; 
	Searcher searcher;
	HashMap<String, Float> lsSites;
	
	Iterator<Site> listSites;

	public LuceneOperator(String folder) throws IOException, ParseException {
		this.dataDir=folder;

	
	}
	public HashMap<String, Float> execute(String query) throws IOException, ParseException{
		return lsSites =  searchLucene(query);
	}
	

	private HashMap<String, Float> searchLucene(String searchQuery) throws IOException, ParseException {
		HashMap<String, Float> result = new HashMap<String, Float>();
		searcher = new Searcher(indexDir);
		long startTime = System.currentTimeMillis();
		TopDocs hits = searcher.search(searchQuery);
		long endTime = System.currentTimeMillis();
		String docName = "";
		
		System.out.println(hits.totalHits + " documents found. Time :" + (endTime - startTime));
		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = searcher.getDocument(scoreDoc);
			float score = scoreDoc.score;
			System.out.println(score);
			docName= doc.get(LuceneConstants.FILE_NAME).split("[.]")[0];
			result.put(docName,score);
	
			System.out.println("File: " + doc.get(LuceneConstants.FILE_PATH));
		}
		
		return result;
	}
	
	public void createIndex() throws IOException {
		indexer = new Indexer(indexDir);
		int numIndexed;
		long startTime = System.currentTimeMillis();
		numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
		long endTime = System.currentTimeMillis();
		indexer.close();
		System.out.println(numIndexed + " File indexed, time taken: " + (endTime - startTime) + " ms");
		
	}

	


}
