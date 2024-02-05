import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        File path = new File( new File(".").getPath());
        File folder = new File(path, "backup");
        if(!folder.exists()){
            folder.mkdir();
        }
        File []currentFolder = path.listFiles();
        for(File file: currentFolder){
            if(!file.getName().equals("backup")) {
                try {
                    Files.copy(file.toPath(), Path.of("./backup/" + file.getName()));
                    System.out.println("Файл " + file.getName() + " успешно скопирован");
                } catch (FileAlreadyExistsException e) {
                    System.out.println("Файл "+ file.getName() + " уже существует");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}