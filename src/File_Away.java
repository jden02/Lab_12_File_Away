import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class File_Away {

    public static void main(String[] args) {
        int lines = 0;
        int words = 0;
        int chars = 0;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a text file to process");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        int result = fileChooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = fileChooser.getSelectedFile();
        String filename = file.getName();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;

                String[] parts = line.split("\\s+");
                words += parts.length;

                chars += line.length();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("File name: " + filename);
        System.out.println("Number of lines: " + lines);
        System.out.println("Number of words: " + words);
        System.out.println("Number of characters: " + chars);
    }
}
