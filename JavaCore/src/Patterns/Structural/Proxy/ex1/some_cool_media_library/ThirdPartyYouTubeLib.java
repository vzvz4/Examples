package Patterns.Structural.Proxy.ex1.some_cool_media_library;

import java.util.Map;

public interface ThirdPartyYouTubeLib {
    Map<String, Video> getPopularVideos();

    Video getVideo(String videoId);
}
