package Patterns.Structural.Proxy.ex1;

import Patterns.Structural.Proxy.ex1.downloader.YouTubeDownloader;
import Patterns.Structural.Proxy.ex1.proxy.YouTubeCacheProxy;
import Patterns.Structural.Proxy.ex1.some_cool_media_library.ThirdPartyYouTubeImpl;

public class Client {
    public static void main(String[] args) {

        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeImpl());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy(new ThirdPartyYouTubeImpl()));

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
