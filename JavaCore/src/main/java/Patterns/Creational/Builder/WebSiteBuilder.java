package Patterns.Creational.Builder;

public abstract class WebSiteBuilder {
    protected Website website;

    void createWebsite() {
        website = new Website();
    }

    abstract void createName();
    abstract void buildCms();
    abstract void setPrice();

    public Website getWebsite() {
        return website;
    }
}
