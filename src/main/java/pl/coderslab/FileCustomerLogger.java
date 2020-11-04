package pl.coderslab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class FileCustomerLogger implements CustomerLogger{
    @Value("${filename}")
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log() {
        try (FileWriter fileWriter = new FileWriter(fileName, true)){
            fileWriter.append(LocalDateTime.now()+": Customer operation\n");
        } catch (IOException ex) {
            System.out.println("Błąd zapisu do pliku.");
        }

    }
}
