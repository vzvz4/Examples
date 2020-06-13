package Patterns.Structural.Proxy.some_cool_media_library;

import java.util.Map;

public interface ThirdPartyYouTubeLib {
    Map<String, Video> getPopularVideos();

    Video getVideo(String videoId);
}
