import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Logger {
    private static Logger instance;

    String fileName = "log.txt";

    private FileWriter writer;

    private Logger() {
        try {
            File loggerFile = new File(fileName);
            if (loggerFile.createNewFile()) {
                System.out.println("Log file created: " + loggerFile.getName());
            } else {
                System.out.println("Log file already exists.");
            }
            if (!fileName.endsWith(".txt")) {
                fileName += ".txt";
            this.fileName = fileName;
            }
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.out.println("An error occurred while creating the log file.");
            throw new RuntimeException(e);
        }
    }

    public static  Logger getInstance() {
        if  (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String newFileName) {

        if (!newFileName.endsWith(".txt")) {
            newFileName += ".txt";
        }

        if (newFileName.equals(this.fileName)) {
            System.out.println("File name is the same as the current one. No changes made.");
            return;
        }

        if (Files.exists(Paths.get(newFileName))) {
            System.out.println("File with the name " + newFileName + " already exists. No changes made.");
        } else {
            close();
            File file = new File(newFileName);
            try {
                if (file.createNewFile()) {
                    System.out.println("Log file created: " + file.getName());
                    this.fileName = newFileName;
                    writer = new FileWriter(this.fileName, true);
                } else {
                    System.out.println("An error occurred while creating the log file.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void write (String message) {
        try {
            writer.write(System.lineSeparator());
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void close() {
        if  (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                writer = null;
            }
        }
    }
}
