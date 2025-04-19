import org.openqa.selenium.edge.EdgeOptions;
import java.nio.file.Files;
import java.nio.file.Path;

public class WebDriverFactory {
    public static WebDriver setDriver() {
        EdgeOptions options = new EdgeOptions();

        // Headless for CI environment
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        // Generate unique user data dir
        try {
            Path tempProfile = Files.createTempDirectory("edge-profile");
            options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new EdgeDriver(options);
    }
}
