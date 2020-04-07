package com.bbcrecipes.extensions;

import com.bbcrecipes.utils.Drivers;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class JunitTestRule extends Drivers {

    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            // Print out the error message:
            log.error(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
            File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            try {
                File currPath = new File(new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "\\screenshot.png");
                log.info("Screenshot at: " + currPath.toString());
                FileHandler.copy(scrFile,  currPath );
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        // This method gets called when the test finishes, regardless of status
        // If the test fails, this will be called after the method above
        @Override
        protected void finished(Description description) {
            if (webDriver != null)
                webDriver.quit();
        }
    };
}
