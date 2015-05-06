package filetest;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.Executors;

public class WatchServiceTest {
    public static void main(String[] args) {
        // Path path = Paths.get("/");
        System.out.println(System.getProperty("user.dir"));
        Executors.newCachedThreadPool().submit(new Runnable() {
            public void run() {
                try {
                    WatchService watchService = FileSystems.getDefault().newWatchService();
                    Path path = Paths.get(System.getProperty("user.dir"));
                    // 注册监听器
                    path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                            StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
                    while (true) {
                        // 阻塞方式，消费文件更改事件
                        WatchKey key = watchService.take();
                        for (WatchEvent<?> event : key.pollEvents()) {
                            System.out.println(event.context() + "发生了" + event.kind() + "事件");
                        }
                        if (!key.reset()) {
                            break;
                        }
                    }
                } catch (Exception e) {}
            }
        });
    }
}
