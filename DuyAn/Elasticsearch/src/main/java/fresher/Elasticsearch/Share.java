package fresher.Elasticsearch;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.util.Map;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.search.SearchHit;

public class Share {

public static void main(String[] args)
{
	try
	{
	Client client=EmbeddedElasticServer.getInstance("D:\\ESIndexes1","local-test").getClient();

	//index Creation
	XContentBuilder xcb=jsonBuilder().startObject().startObject("properties").startObject("name").field("type","text").endObject().startObject("tile").field("type","object").endObject().endObject().endObject();	
	CreateIndexResponse cir=client.admin().indices().prepareCreate("test").setSource(xcb).execute().actionGet();
	System.out.println(cir.isAcknowledged());

	//Data
	Dummy d=new Dummy("one","two-to","THREE","four");

	XContentBuilder xcb1=jsonBuilder().startObject().field("name","username").field("tile",d).endObject();
	System.out.println(xcb1.prettyPrint().string());
	IndexResponse ir=client.prepareIndex("test", "dum")
    .setSource(xcb1)
    .execute()
    .actionGet();

	//Searching
	SearchResponse response = client.prepareSearch("test").execute().actionGet();
	SearchHit[] results = response.getHits().getHits();
	for (SearchHit hit : results) {
		System.out.println("------------------------------");
		Map<String,Object> result = hit.getSource(); 
		System.out.println(result);
	}
	client.close();


	}catch(Exception e)
	{
		e.printStackTrace();
	}
//	Dummy d = new Dummy("one", "two-to", "THREE", "four");
//	ObjectMapper mapper = new ObjectMapper();
//	Map<String,Object> mmp=new LinkedHashMap<String,Object>();
//	mmp.put("name", "username");
//	mmp.put("tile", d);


}