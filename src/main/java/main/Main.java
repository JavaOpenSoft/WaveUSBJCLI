package main;

import Core.Downloader;
import Core.SoftwareInfo;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static main.Constants.appDatamacOS;

public class Main {
    static String os ="";
    static String appData = "";
    static String USBpath = "";
    public static final byte CLOVER = 1;
    public static final byte SYSLINUX = 2;
    static byte response;
    public static void main(String[] args) throws IOException {

        if(SoftwareInfo.getOS().equals("Mac OS X")
                && (SoftwareInfo.getOSVersion().equals("11.6.8")
                || SoftwareInfo.getOSVersion().equals("12.5")
                || SoftwareInfo.getOSVersion().equals("13"))){
            os = "macOS";

        }
        else if(SoftwareInfo.getOS().equals("Windows 11")
                ||  SoftwareInfo.getOS().equals("Windows 10")
                || SoftwareInfo.getOS().equals("Windows 8.1") || SoftwareInfo.getOS().equals("Windows 8")){
            os = "windows";
            appData = Constants.appDataWindows;
        }
        else{
            os = "Linux";
            appData = Constants.appDataWindows;
        }
        Scanner sc = new Scanner(System.in);

        do{
            response = mainMenu(sc);
            if(response == 1){
                clearScreen();
                System.out.println("Choose an Operating System");
                System.out.println("1.Windows");
                System.out.println("2.Linux");
                System.out.println("3.Mac OS X");
                System.out.println("4.Custom Image File from local filesystem");

                System.out.println("Option");
                response = sc.nextByte();
                if(response == 3)macOS(sc,USBpath);
                else if(response == 1)Windows(sc);
                else if(response == 2) Linux(sc);
                else if(response == 4)others(sc);
            }
            else if(response == 4){
                clearScreen();
                System.out.println("Choose a image to download:");
                System.out.println("1.macOS 11.6.8\n" +
                        "2.macOS 12.5\n" +
                        "3.macOS 10.13.6\n" +
                        "4.macOS 10.14.6\n" +
                        "5.macOS 10.15.7\n" +
                        "6.Ubuntu 22.04\n" +
                        "7.Ubuntu Server 22.04\n" +
                        "8.Debian 11 64 bit\n" +
                        "9.Debian Network Installer 11 64bit\n" +
                        "10.Debian 11\n" +
                        "11.Debian Network Installer 11\n" +
                        "12.Deepin\n" +
                        "13.Linux Mint XFCE\n" +
                        "14.Linux Mint Cinnamon\n" +
                        "15.Linux Mint Mate\n" +
                        "16. Fedora Workspace 36 64-bit\n" +
                        "17.Fedora Workspace 36\n" +
                        "18.Fedora Server 64-bit\n" +
                        "19.Fedora Server ARM 64-bit\n" +
                        "20.Fedora Server Network Installer ARM 64-bit\n" +
                        "21.Fedora Server Network Installer 64-bit\n" +
                        "22.Manjaro Gnome\n" +
                        "23.Manjaro XFCE\n" +
                        "24.Manjaro KDE\n" +
                        "25.Solus Gnome\n" +
                        "26.Solus Budgie\n" +
                        "27.Solus Mate\n" +
                        "28.Solus KDE\n" +
                        "29. Arch\n" +
                        "30.Black Arch\n" +
                        "31.Black Arch Minimum\n" +
                        "32.Black Arch Network Installer\n" +
                        "33.ElementaryOS");
                response = sc.nextByte();
                switch (response) {
                    case 1:
                        downloadFileThrough_wget(Constants.macOS11);
                        break;
                    case 2:
                        downloadFileThrough_wget(Constants.macOS12);
                        break;
                    case 3:
                        downloadFileThrough_wget(Constants.macOS1013);
                        break;
                    case 4:
                        downloadFileThrough_wget(Constants.macOS1014);
                        break;
                    case 5:
                        downloadFileThrough_wget(Constants.macOS1015);
                        break;
                    case 6:
                        downloadFileThrough_wget(Constants.ubuntu);
                        break;
                    case 7:
                        downloadFileThrough_wget(Constants.ubuntuServer);
                        break;
                    case 8:
                        downloadFileThrough_wget(Constants.debian64);
                        break;
                    case 9:
                        downloadFileThrough_wget(Constants.debianNet64);
                        break;
                    case 10:
                        downloadFileThrough_wget(Constants.debian);
                        break;
                    case 11:
                        downloadFileThrough_wget(Constants.debianNet);
                        break;
                    case 12:
                        downloadFileThrough_wget(Constants.deepin);
                        break;
                    case 13:
                        downloadFileThrough_wget(Constants.linuxMintXFCE);
                        break;
                    case 14:
                        downloadFileThrough_wget(Constants.linuxMintCinnamon);
                        break;
                    case 15:
                        downloadFileThrough_wget(Constants.linuxMintMate);
                        break;
                    case 16:
                        downloadFileThrough_wget(Constants.fedoraWorkspace64);
                        break;
                    case 17:
                        downloadFileThrough_wget(Constants.fedoraWorkspace);
                        break;
                    case 18:
                        downloadFileThrough_wget(Constants.fedoraServer);
                        break;
                    case 19:
                        downloadFileThrough_wget(Constants.fedoraServer_ARM);
                        break;
                    case 20:
                        downloadFileThrough_wget(Constants.fedoraServerNet_ARM);
                        break;
                    case 21:
                        downloadFileThrough_wget(Constants.fedoraServerNet);
                        break;
                    case 22:
                        downloadFileThrough_wget(Constants.manjaroGnome);
                        break;
                    case 23:
                        downloadFileThrough_wget(Constants.manjaroXFCE);
                        break;
                    case 24:
                        downloadFileThrough_wget(Constants.manjaroKDE);
                        break;
                    case 25:
                        downloadFileThrough_wget(Constants.solusGnome);
                        break;
                    case 26:
                        downloadFileThrough_wget(Constants.solusBudgie);
                        break;
                    case 27:
                        downloadFileThrough_wget(Constants.solusMATE);
                        break;
                    case 28:
                        downloadFileThrough_wget(Constants.solusKDE);
                        break;
                    case 29:
                        downloadFileThrough_wget(Constants.arch);
                        break;
                    case 30:
                        downloadFileThrough_wget(Constants.blackArch);
                        break;
                    case 31:
                        downloadFileThrough_wget(Constants.blackArchMinimum);
                        break;
                    case 32:
                        downloadFileThrough_wget(Constants.blackArchNet);
                        break;
                    case 33:
                        downloadFileThrough_wget(Constants.elementaryOS);
                        break;
                }
                clearScreen();
                System.out.println("Your image has downloaded, What you want to do?:\nQ. Quit\nM.Main menu");
                switch (sc.next().charAt(0)){
                    case 'Q':
                    case 'q': {
                        System.out.println("Thank you for using WaveUSB! Have a nice day ahead..");
                        System.exit(0);
                        break;
                    }
                    case 'M':
                    case 'm':
                        mainMenu(sc);
                        break;

                }

            }
            else if (response == 7){
                System.out.println("Choose Bootloader you want to install:\n1.Clover\n 2.Syslinux\nOption:");
                response = sc.nextByte();
                switch (response) {
                    case 1: {
                        clearScreen();
                        listDisks();
                        System.out.println("Enter USB path to Install");
                        installBootloader(CLOVER, sc.nextLine());
                        break;
                    }
                    case 2: {
                        clearScreen();
                        listDisks();
                        System.out.println("Enter USB path to Install");
                        installBootloader(SYSLINUX, sc.nextLine());
                        break;
                    }
                }

            }
            else if(response == 8){
                clearScreen();
                System.exit(0);
            }
            else if(response == 6){
                clearScreen();

            }
            else if(response == 5){
                listDisks();
            }
        }while(response <= 6);

    }
    public static void macOS(Scanner sc,String outputUSB_Dir) throws IOException {
        System.out.println("Choose the Operating System version");
        System.out.println("1.macOS 12.5");
        System.out.println("2.macOS 11.6.8");
        System.out.println("3.macOS 10.15.7");
        System.out.println("4.macOS 10.14.6");
        System.out.println("5.macOS 10.13.6\nOption:");
        byte response = sc.nextByte();
        if (response == 1) {
            if(new File(appData + "").exists()){
                listDisks();
                System.out.println("Enter  the path of the USB Listed here:");
                USBpath = sc.nextLine();
                installApp(appData +"InstallAssistant.pkg");
                Runtime.getRuntime().exec("sudo /Applications/Install\\ macOS\\ Monterey.app/Contents/Resources/createinstallmedia --volume "+outputUSB_Dir);
            }
            else {
                Downloader.downloadFile(new URL(Constants.macOS11),"InstallAssistant.pkg");
                listDisks();
                System.out.println("Enter  the path of the USB Listed here:");
                USBpath = sc.nextLine();
                installApp(appData +"InstallAssistant.pkg");
            }
        }
        if (response == 2) {
            if(new File(appData + "").exists()){
                listDisks();
                System.out.println("Enter  the path of the USB Listed here:");
                USBpath = sc.nextLine();
                installApp(appData +"Install11Assistant.pkg");
                System.out.println("Creating the macOS Big Sur USB, please stand by...");
                System.out.println("Enter your account password: ");
            }
            else {
                Downloader.downloadFile(new URL(Constants.macOS11),"Install11Assistant.pkg");
                listDisks();
                System.out.println("Enter the path of the USB Listed here:");
                USBpath = sc.nextLine();
                installApp(appData +"Install11Assistant.pkg");
                Runtime.getRuntime().exec("sudo /Applications/Install\\ macOS\\ Big\\ Sur.app/Contents/Resources/createinstallmedia --volume "+outputUSB_Dir);
            }
        }
    }
    public static void Linux(Scanner sc){

    }
    public static void Windows(Scanner sc){

    }
    public static void others(Scanner sc){

    }
    public static void clearScreen() throws IOException {

        Runtime.getRuntime().exec("cls");
        Runtime.getRuntime().exec("clear");
    }
    private static int getFileSize(URL url) {
        URLConnection conn = null;
        try {
            conn = url.openConnection();
            if(conn instanceof HttpURLConnection) {
                ((HttpURLConnection)conn).setRequestMethod("HEAD");
            }
            conn.getInputStream();
            return conn.getContentLength();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(conn instanceof HttpURLConnection) {
                ((HttpURLConnection)conn).disconnect();
            }
        }
    }


    public static void writeImage(String filename, String usbDir) throws IOException {
        if(new File(filename).exists() && new File(usbDir).exists()
        ) {
            Runtime.getRuntime().exec("dd if="+filename+" of="+usbDir+" bs=1M status=progress");
        }
    }
    //Only for macOS users
    public static void installApp(String packageFile) throws IOException {
        Runtime.getRuntime().exec("sudo installer -pkg " + appDatamacOS +"/" +packageFile+" -target CurrentUserHomeDirectory");
    }
    public static void installBootloader(byte type, String outputDir) throws IOException {
        if (type == 1){
            Runtime.getRuntime().exec("mkdir "+ outputDir +"boot");
            Runtime.getRuntime().exec("cp -r "+ appData + "/Bootloaders/Clover " + outputDir);
        }
        if (type == 2){
            Runtime.getRuntime().exec("mkdir "+ outputDir +"boot");
            Runtime.getRuntime().exec("cp -r "+ appData + "/Bootloaders/syslinux-6.03" + outputDir);
        }

    }
    public static void listDisks() throws IOException {
        if(os.equals("macOS")) {
            Runtime.getRuntime().exec("df");
        }
        else if (os.equals("Linux")) {
            Runtime.getRuntime().exec("lsblk");
        }
        else {
            Runtime.getRuntime().exec("wmic diskdrive list");
        }
    }
    public static void downloadFileThrough_wget(String URL) throws IOException {
        Runtime.getRuntime().exec("wget "+ URL);
    }
    public static byte mainMenu(Scanner sc){
        System.out.println("Welcome to WaveUSB JCLI!\nChoose an Option:");
        System.out.println("1.Make a Bootable USB Device");
        System.out.println("2.Format A USB Device");
        System.out.println("3.Edit the settings");
        System.out.println("4.Download a Image");
        System.out.println("5.List Mounted Disks");
        System.out.println("6.Clear Screen");
        System.out.println("7.Install bootloader");
        System.out.println("8.Exit\nOption");
        return sc.nextByte();
    }
    public void addVolume(String volume,int volumeSize) throws IOException {

    }
    public static void formatDevice(String deviceName, String fileSystem, String path) throws IOException {}
}
