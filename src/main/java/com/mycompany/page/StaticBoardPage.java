package com.mycompany.page;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.mycompany.model.ArticleModel;
 
public class StaticBoardPage extends WebPage{
//	private static List<ArticleModel> list = new ArrayList<ArticleModel>｛｛
//		add(new ArticleModel("title1","contents1\ncontents1"));
//		add(new ArticleModel("title2","contents2\ncontents2"));
//		add(new ArticleModel("title3","contents3\ncontents3"));
//	｝｝;
    
//	private static List<ArticleModel> list = Arrays.asList(
//			new ArticleModel("title1","contents1\ncontents1"),
//			new ArticleModel("title1","contents2\ncontents3"),
//			new ArticleModel("title1","contents3\ncontents3")
//			);
    
    private List<ArticleModel> list = new ArrayList<ArticleModel>();
    
    public StaticBoardPage(){
        list.add(new ArticleModel("title1","contents1\ncontents1"));
        list.add(new ArticleModel("title1","contents2\ncontents3"));
        list.add(new ArticleModel("title1","contents3\ncontents3"));
        
        ListView listView = new ListView("articleList", new Model((Serializable) list)){
            @Override
            protected void populateItem(ListItem item) {
                ArticleModel am = (ArticleModel)item.getModelObject();
                item.add(new Label("title", new PropertyModel(am, "title")));
                item.add(new MultiLineLabel("contents", new PropertyModel(am, "contents")));
            }
        };
        add(listView);
    }
}
