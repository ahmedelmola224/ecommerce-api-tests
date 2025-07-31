package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Utils {

    private static RequestSpecification req;
    public static RequestSpecification GetRequestSpecification() throws IOException {
        // This method can be used to set up request specifications if needed
        // For example, setting base URI, headers, etc.
        if (req == null) {
            // Clear the log file ONCE per test run
            Path path = Paths.get("logging.txt");
            Files.write(path, new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            PrintStream log = new PrintStream(Files.newOutputStream(path, StandardOpenOption.APPEND));
            req = new RequestSpecBuilder()
                    .setBaseUri(getProperty("baseUrl"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
        }
        return  req;
    }

    public static String getProperty(String key) throws IOException {
        // This method can be used to read properties from a file
        java.util.Properties prop = new java.util.Properties();
        FileInputStream file = new FileInputStream("src/test/java/resources/global.properties");
        prop.load(file);
        return prop.getProperty(key);
    }
}
