package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import static utilities.PropertyReader.readingFromPropertyFile;

/**
 * Created by Osanda on 4/26/2017.
 */

public abstract class AndroidSetup {

    public static AndroidDriver driver;

        public static void prepareAndroidForAppium() throws IOException {

             String APPIUM_HOST = readingFromPropertyFile("appium_host");
             String APPIUM_PORT = readingFromPropertyFile("appium_port");
             String ANDROID_VERSION = readingFromPropertyFile("android_version");
             String APPIUM_SERVER_URL = "http://" + APPIUM_HOST + ":" + APPIUM_PORT + "/wd/hub";

            // Set APK file path
            String PROJECT_ROOT = System.getProperty("user.dir");
            String APK_PATH="\\resources\\Orator.apk";
            File app=new File(PROJECT_ROOT+APK_PATH);
            System.out.println("Installing APK from the path "+PROJECT_ROOT+APK_PATH);

            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Mandatory capabilities
            capabilities.setCapability("deviceName","Android");
            capabilities.setCapability("platformName","Android");

            // Install APK file from the above path
            try {
                capabilities.setCapability("app", app.getAbsolutePath());
                System.out.println("Successfully installed Orator in the device");
            } catch (Exception ex) {
                System.out.println("Installing Orator failed");
                System.out.println(ex.getMessage());
            }


            // Set android VERSION desired capability. Set your mobile device's OS version.
            capabilities.setCapability(CapabilityType.VERSION, ANDROID_VERSION);

            // Set android appPackage desired capability. It is
            // com.android.calculator2 for calculator application.
            // Set your application's appPackage if you are using any other app.
            capabilities.setCapability("appPackage", "maxsoft.osanda.com.oratortextreader");

            // Other caps
            driver =  new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities);
        }

}
