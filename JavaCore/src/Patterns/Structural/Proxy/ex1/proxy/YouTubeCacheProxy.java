package Patterns.Structural.Proxy.ex1.proxy;

import Patterns.Structural.Proxy.ex1.some_cool_media_library.ThirdPartyYouTubeLib;
import Patterns.Structural.Proxy.ex1.some_cool_media_library.Video;

import java.util.HashMap;
import java.util.Map;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private Map<String, Video> cachePopular = new HashMap<>();
    private Map<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy(ThirdPartyYouTubeLib youtubeService) {
        this.youtubeService = youtubeService;
    }

    @Override
    public Map<String, Video> getPopularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.getPopularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}