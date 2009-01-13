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
import com.mycompany.model.CommentModel;
 
public class ExStaticBoardPage extends WebPage{
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
    
    public ExStaticBoardPage(){
        list.add(new ArticleModel("title1","contents1\ncontents1",
        		Arrays.asList(
        				new CommentModel("name1", "contents1"),
        				new CommentModel("name2", "contents2"),
        				new CommentModel("name3", "contents3")
        		)));
        list.add(new ArticleModel("title1","contents2\ncontents3",
        		Arrays.asList(
        				new CommentModel("name1", "contents1"),
        				new CommentModel("name2", "contents2"),
        				new CommentModel("name3", "contents3")
        		)));
        list.add(new ArticleModel("title1","contents3\ncontents3",
        		Arrays.asList(
        				new CommentModel("name1", "contents1"),
        				new CommentModel("name2", "contents2"),
        				new CommentModel("name3", "contents3")
        		)));
        
        ListView listView = new ListView("articleList", new Model((Serializable) list)){
            @Override
            protected void populateItem(ListItem item) {
                ArticleModel am = (ArticleModel)item.getModelObject();
                item.add(new Label("title", new PropertyModel(am, "title")));
                item.add(new MultiLineLabel("contents", new PropertyModel(am, "contents")));
                ListView listView = new ListView("commentList", new PropertyModel(am, "commentList")){
                    @Override
                    protected void populateItem(ListItem item) {
                        CommentModel cm = (CommentModel)item.getModelObject();
                        item.add(new Label("name", new PropertyModel(cm, "name")));
                        item.add(new Label("contents", new PropertyModel(cm, "contents")));
                    }
                };
                item.add(listView);
            }
        };
        add(listView);
    }
}