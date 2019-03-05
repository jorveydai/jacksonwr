package com.dz.json;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JacksonInit {
	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) throws Exception{
		String jsonStr = " {\"jcr:primaryType\":\"nt:unstructured\",\"sling:resourceType\":\"foundation/components/parsys\",\"header\":{\"jcr:primaryType\":\"nt:unstructured\",\"titleText\":\"Publication Date Test\",\"jcr:lastModifiedBy\":\"gstead\",\"jcr:lastModified\":\"Tue Jan 15 2019 22:02:06 GMT+0000\",\"sling:resourceType\":\"patternlibrary/components/content/header\",\"image\":{\"jcr:primaryType\":\"nt:unstructured\",\"sling:resourceType\":\"patternlibrary/components/content/customImage\"}},\"section\":{\"jcr:primaryType\":\"nt:unstructured\",\"jcr:createdBy\":\"gstead\",\"spacingBottom\":\"none\",\"jcr:lastModifiedBy\":\"gstead\",\"layout\":\"100\",\"mp4Src\":\"\",\"jcr:created\":\"Tue Jan 15 2019 22:02:35 GMT+0000\",\"type\":\"railed\",\"backgroundOverflow\":\"visible\",\"spacingTop\":\"none\",\"jcr:lastModified\":\"Tue Jan 15 2019 22:02:35 GMT+0000\",\"webmSrc\":\"\",\"sling:resourceType\":\"patternlibrary/components/content/section\",\"backgroundColor\":\"none\",\"backgroundImage\":{\"jcr:primaryType\":\"nt:unstructured\",\"sling:resourceType\":\"patternlibrary/components/content/customImage\"},\"columns\":{\"jcr:primaryType\":\"nt:unstructured\",\"sling:resourceType\":\"foundation/components/parsys\",\"column_78701280\":{\"jcr:primaryType\":\"nt:unstructured\",\"jcr:createdBy\":\"gstead\",\"jcr:lastModifiedBy\":\"gstead\",\"textAlign\":\"left\",\"jcr:created\":\"Tue Jan 15 2019 22:02:57 GMT+0000\",\"indentLeft\":\"\",\"jcr:lastModified\":\"Tue Jan 15 2019 22:02:57 GMT+0000\",\"sling:resourceType\":\"patternlibrary/components/content/section/column\",\"indentRight\":\"\",\"content\":{\"jcr:primaryType\":\"nt:unstructured\",\"sling:resourceType\":\"foundation/components/parsys\",\"publicationdate\":{\"jcr:primaryType\":\"nt:unstructured\",\"jcr:createdBy\":\"gstead\",\"jcr:lastModifiedBy\":\"gstead\",\"jcr:created\":\"Tue Jan 15 2019 22:03:09 GMT+0000\",\"date\":\"Tue Jan 15 2019 14:03:00 GMT-0800\",\"jcr:lastModified\":\"Tue Jan 15 2019 22:03:34 GMT+0000\",\"sling:resourceType\":\"patternlibrary/components/content/publicationDate\"}}},\"column\":{\"jcr:primaryType\":\"nt:unstructured\",\"textAlign\":\"left\",\"indentLeft\":\"\",\"sling:resourceType\":\"patternlibrary/components/content/section/column\",\"indentRight\":\"\",\"content\":{\"jcr:primaryType\":\"nt:unstructured\",\"sling:resourceType\":\"foundation/components/parsys\",\"text\":{\"jcr:primaryType\":\"nt:unstructured\",\"jcr:createdBy\":\"gstead\",\"readMoreText\":\"Read More\",\"jcr:lastModifiedBy\":\"gstead\",\"textColor\":\"dark\",\"jcr:created\":\"Tue Jan 15 2019 22:02:45 GMT+0000\",\"text\":\"<p>test &nbsp;</p>\\r\\n\",\"readLessText\":\"Read Less\",\"jcr:lastModified\":\"Tue Jan 15 2019 22:02:52 GMT+0000\",\"sling:resourceType\":\"patternlibrary/components/content/text\",\"textIsRich\":[\"true\",\"true\"]}}}},\"animationSystem\":{\"jcr:primaryType\":\"nt:unstructured\",\"sling:resourceType\":\"foundation/components/parsys\"}}}";
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> article = mapper.readValue(jsonStr, HashMap.class);
		JsonNode nodes = mapper.readTree(jsonStr);
		jsonLeaf(nodes);
		String dateString = "Thu Sep 07 2017 00:00:00 GMT+0800 (中国标准时间) 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
		Date dd = sdf.parse(dateString); //将字符串改为date的格式
 		String resDate= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dd);
		System.out.println(resDate);


		//JSONObject jo = JSONObject.fromObject(article);
		//analysisJson(jo);
		/*Set entrySet = article.entrySet();
		Iterator it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String,Object> entry = (Map.Entry<String,Object>)it.next();
			String key = entry.getKey();
			Object val = entry.getValue();
			System.out.println(key+"####"+val);
		}*/
	
	}
	
	public static void  jsonLeaf(JsonNode node){
		if (node.isValueNode())
        {
			
            System.out.println("********"+node.toString());
            return;
        }

        if (node.isObject())
        {
            Iterator<Entry<String, JsonNode>> it = node.getFields();
            while (it.hasNext())
            {
                Entry<String, JsonNode> entry = it.next();
                System.out.println(entry.getKey());
                jsonLeaf(entry.getValue());
            }
        }

        if (node.isArray())
        {
            Iterator<JsonNode> it = node.iterator();
            while (it.hasNext())
            {
                jsonLeaf(it.next());
            }
        }
	    }
//	System.out.println("ok");
}
