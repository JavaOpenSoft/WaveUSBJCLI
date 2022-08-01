package main;
import Core.Downloader;
import Core.SoftwareInfo;
import Core.Unzipper;

import javax.crypto.Mac;
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
    public final byte CLOVER = 1;
    public final byte SYSLINUX = 2;
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
            os = "windows";
            appData = Constants.appDataWindows;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to WaveUSB JCLI!\nChoose an Option:");
        System.out.println("1.Make a Bootable USB Device");
        System.out.println("2.Format A USB Device");
        System.out.println("3.Edit the settings");
        System.out.println("4.Download a Image");
        System.out.println("5.Exit\nOption");
        byte response = sc.nextByte();
        if(response == 1){
            System.out.println("Choose an Operating System");
            System.out.println("1.Windows");
            System.out.println("2.Linux");
            System.out.println("3.Mac OS X");
            System.out.println("4.Custom Image File from local filesystem");
            System.out.println("Option");
            response = sc.nextByte();
            if(response == 3)macOS(sc);
            else if(response == 1)Windows(sc);
            else if(response == 2) Linux(sc);
            else if(response == 4)others(sc);
        }


    }
    public static void macOS(Scanner sc) throws IOException {
        System.out.println("Choose the Operating System version");
        System.out.println("1.macOS 12.5");
        System.out.println("2.macOS 11.6.8");
        System.out.println("3.macOS 10.15.7");
        System.out.println("4.macOS 10.14.6");
        System.out.println("5.macOS 10.13.6\nOption:");
        byte response = sc.nextByte();
        if (response == 1) {
            if(new File(appData + "").exists()){
                Runtime.getRuntime().exec("lblk && wmic diskdrive list\n");
                System.out.println("Enter  the path of the USB Listed here:");
                USBpath = sc.nextLine();
                installApp(appData +"InstallAssistant.pkg");
            }
            else {
                Downloader.downloadFile(new URL(Constants.macOS11),"InstallAssistant.pkg");
                Runtime.getRuntime().exec("lblk && wmic diskdrive list\n");
                System.out.println("Enter  the path of the USB Listed here:");
                USBpath = sc.nextLine();
                installApp(appData +"InstallAssistant.pkg");
            }
        }
        if (response == 2) {
            if(new File(appData + "").exists()){
                Runtime.getRuntime().exec("lblk && wmic diskdrive list\n");
                System.out.println("Enter  the path of the USB Listed here:");
                USBpath = sc.nextLine();
                installApp(appData +"Install11Assistant.pkg");
            }
            else {
                Downloader.downloadFile(new URL(Constants.macOS11),"Install11Assistant.pkg");
                Runtime.getRuntime().exec("lblk && wmic diskdrive list\n");
                System.out.println("Enter the path of the USB Listed here:");
                USBpath = sc.nextLine();
                installApp(appData +"Install11Assistant.pkg");
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
}
