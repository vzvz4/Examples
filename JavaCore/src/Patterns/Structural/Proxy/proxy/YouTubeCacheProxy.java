package Patterns.Structural.Proxy;

public class CachedYouTubeClass implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib service;

    public CachedYouTubeClass(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

    @Override
    public void listVideos() {

    }

    @Override
    public String getVideoInfo(int id) {
        return null;
    }

    @Override
    public void downloadVideo(int id) {
    }
}
