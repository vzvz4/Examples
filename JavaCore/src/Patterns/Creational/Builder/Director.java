package Patterns.Creational.Builder;

public class Director {
    private WebSiteBuilder builder;

    public void setBuilder(WebSiteBuilder builder) {
        this.builder = builder;
    }

    public Website buildWebSite(WebSiteBuilder builder) {
        this.builder = builder;
        builder.createWebsite();
        builder.buildCms();
        builder.createName();
        builder.setPrice();
        return builder.getWebsite();
    }
}
