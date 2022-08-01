package Core;

public class SoftwareInfo {
    static String version = "0.1 GUI Staging";
    static String About = "GUI Edition of WaveUSB, A complete USB writer designed mostly in Java.";
    public static String getVersion() {
        return version;
    }
    public static String getAbout()
    {
        return About;
    }
    public static String getOS(){
        return System.getProperty("os.name");
    }
    public static String getOSVersion(){
        return System.getProperty("os.version");
    }
    public static String getHomeDirectory(){return System.getProperty("user.home");}

}
