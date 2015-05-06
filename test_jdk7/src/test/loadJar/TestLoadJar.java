package test.loadJar;

import java.util.jar.JarFile;
import java.util.jar.Manifest;

class TestLoadJar {
    public static void main(String[] args) {
        try {
            JarFile jarFile = new JarFile(
                    "G:/workspace/my_test/lib/antsoldier-agent-handler-autoinventory-3.0.0-SNAPSHOT.jar");
            Manifest manifest = jarFile.getManifest();
            String mainClass = manifest.getMainAttributes().getValue("Main-Class");
            Class a = Thread.currentThread().getContextClassLoader().loadClass(mainClass);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
