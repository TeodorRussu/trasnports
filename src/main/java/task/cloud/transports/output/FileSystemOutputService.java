package task.cloud.transports.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import task.cloud.transports.model.dataobject.TransportSummary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@Slf4j
@Data
public class FileSystemOutputService implements OutputService {

    public static final String DELIMITER = "/";
    private final String OUTPUT_JSON_FILENAME_PREFIX = "output_";

    @Value("${output.directory}")
    private String path;

    @Override
    public void processOutput(String fileName, TransportSummary filesSummary) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String outputPath = path + DELIMITER + OUTPUT_JSON_FILENAME_PREFIX + fileName;
            Files.createDirectories(Paths.get(path));
            mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(outputPath), filesSummary);
            log.info("Success! Output file path: {}", outputPath);
        } catch (IOException exception) {
            log.error(exception.getMessage());
        }
    }

}
