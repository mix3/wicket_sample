package com.mycompany.page;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import com.mycompany.model.ArticleModel;
import com.mycompany.model.CommentModel;
 
public class ExBoardPage extends WebPage{
    private static List<ArticleModel> list = new ArrayList<ArticleModel>();
    
    public ExBoardPage(){
        add(new BoardForm("form"));
        ListView listView = new ListView("articleList", list){
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
                item.add(new CommentForm("form", am));
            }
        };
        add(listView);
    }
    
    private class BoardForm extends Form{
        private ArticleModel am = new ArticleModel();
        public BoardForm(String id) {
            super(id);
            add(new TextField("title", new PropertyModel(am, "title")));
            add(new TextArea("contents", new PropertyModel(am, "contents")));
            add(new Button("submit"){
                @Override
                public void onSubmit() {
                    list.add(am);
                    setResponsePage(ExBoardPage.class);
                }
            });
        }
    }
    private class CommentForm extends Form{
		private CommentModel cm = new CommentModel();
		
    	public CommentForm(String id, final ArticleModel articleModel) {
			super(id);
            add(new TextField("name", new PropertyModel(cm, "name")));
            add(new TextField("contents", new PropertyModel(cm, "contents")));
            add(new Button("submit"){
                @Override
                public void onSubmit() {
                	articleModel.addComment(cm);
                    setResponsePage(ExBoardPage.class);
                }
            });
		}
    }
}