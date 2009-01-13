package com.mycompany.page;
 
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.PageLink;
 
public class LinkPage extends WebPage{
    public LinkPage(){
        add(new Link("homePage1"){
            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });
        add(new PageLink("homePage2", HomePage.class));
        add(new BookmarkablePageLink("trainingPage", TrainingPage.class));
        add(new BookmarkablePageLink("linkPage", LinkPage.class));
    }
}