package helixlab.hu;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {

    public static void fileMakerWithContent(String filePlace, String content, String fileName) {
        // fout inicializálás
        FileOutputStream fout = null;
        // file mentési helyének megadása, valamint a file nevének megadása
        try {
            fout = new FileOutputStream(filePlace + fileName);
            //string konvertálás és beleírása a file-ba
            byte b[] = content.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("success...");
            // kivétel általános hiba esetén
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    // 1 feladat könyvtárak listázása

    public static void printDirsInDirectory(String filePlace) throws IOException {
        File f = new File(filePlace);
        FileFilter directoryFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        File[] files = f.listFiles(directoryFilter);
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
            }
            System.out.println(file.getCanonicalPath());
        }
    }
    // 2 feladat file-ok listázása az alkönyvtárakból is
    public static void printFilesInDirectory(String filePlace) {

        File directory = new File(filePlace);
        //az adott könyvtárból az összes file-t lekérjük
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                printFilesInDirectory(file.getAbsolutePath());
            }
        }
    }
}