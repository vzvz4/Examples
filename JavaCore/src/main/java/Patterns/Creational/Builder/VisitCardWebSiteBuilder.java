package Patterns.Creational.Builder;

public class VisitCardWebSiteBuilder extends WebSiteBuilder {
    @Override
    void createName() {
        website.setName("Hello! This is my portfolio web site");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    @Override
    void setPrice() {
        website.setPrice(100);
    }
}
