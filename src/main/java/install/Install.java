package install;

import Core.Notification;
import Core.Unzipper;
import main.Constants;
import main.InstallConstants;

import java.io.IOException;
import java.util.Scanner;


public class Install{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the installer of WaveUSB! The installer will take you through the installation process of WaveUSB" +
                "\nChoose the Wave USB You want to install.");
        System.out.println("1.WaveUSB\n2.WaveUSBX\n3.WaveUSB-CLI\n4.WaveUSB-JCLI\nChoose an option:");
        byte response = sc.nextByte();
        if (response == 1){
            clearScreen();
            System.out.println("You have the rights to modify the code with the developers permission. Follow the instructions given by the authors of this software\n" +
                    "to claim rights to the software.\n" +
                    "Permission is hereby granted, free of charge, to any person obtaining a copy\n" +
                    "of this software and associated documentation files (the \"Software\"), to deal\n" +
                    "in the Software without restriction, including without limitation the rights\n" +
                    "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n" +
                    "copies of the Software, and to permit persons to whom the Software is\n" +
                    "furnished to do so, subject to the following conditions:\n" +
                    "\n" +
                    "The above copyright notice and this permission notice shall be included in all\n" +
                    "copies or substantial portions of the Software.\n" +
                    "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n" +
                    "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n" +
                    "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n" +
                    "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n" +
                    "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n" +
                    "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n" +
                    "SOFTWARE.");
            System.out.println("----------------------------------------------------------------");
            System.out.println("\n\nDo you agree to this Software Licence?(y/n):");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y'){
                clearScreen();
                System.out.println("Downloading WaveUSB...");
                downloadThrough_wget(InstallConstants.WaveUSB);
                clearScreen();
                copyUsingSudo("./WaveUSB-0.2-Staging","/");
            }
        }
    }
    public static void clearScreen() throws IOException {

        Runtime.getRuntime().exec("cls");
        Runtime.getRuntime().exec("clear");
    }
    public static void downloadThrough_wget(String URL) throws IOException {
        Runtime.getRuntime().exec("wget "+URL);
    }
    public static void copy(String file, String dest) throws IOException {
        Runtime.getRuntime().exec("cp -f "+ file +" " + dest);
    }

    public static void copyUsingSudo(String file, String dest) throws IOException {
        Runtime.getRuntime().exec("sudo cp -f "+ file +" " + dest);
    }
    public static void copyFolder(String folder, String dest) throws IOException {
        Runtime.getRuntime().exec("cp -rf "+ folder +" " + dest);
    }

    public static void copyFolderUsingSudo(String folder, String dest) throws IOException {
        Runtime.getRuntime().exec("cp -rf "+ folder +" " + dest);
    }
    public static void mkdir(String folderDir) throws IOException{
        Runtime.getRuntime().exec("mkdir "+ folderDir);
    }
    public static void goToFolder(String folder) throws IOException {
        Runtime.getRuntime().exec("cd" + folder);
    }
}