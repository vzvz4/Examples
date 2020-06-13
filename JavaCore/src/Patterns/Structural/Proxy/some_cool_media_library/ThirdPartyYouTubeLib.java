package Patterns.Structural.Proxy;

public interface ThirdPartyYouTubeLib {
    void listVideos();
    String getVideoInfo(int id);
    void downloadVideo(int id);
}
