import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileUtil {
    /**
     * 1111111111
     * @param path
     * @return
     */
    public static String readFile(String path) {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(path));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str + "\n");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                br = null;
            }
        }
        return sb.toString();
    }

    /**
     * 
     * @param path
     * @return
     */
    public static String readUTF8File(String path) {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(
                    path), "utf-8"));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str + "\n");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                br = null;
            }
        }
        return sb.toString();
    }

    public static void writeFile(String dir, String path, String str,
            boolean append) {
        BufferedWriter bw = null;
        try {
            File f = new File(dir);
            f.mkdirs();
            bw = new BufferedWriter(new FileWriter(dir + "\\" + path, append));
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void writeUTF8File(String dir, String path, String str,
            boolean append) {
        BufferedWriter bw = null;
        try {
            File f = new File(dir);
            f.mkdirs();
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(dir + "\\" + path, append), "utf-8"));
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    
    public static void main(String[] args) {
		System.out.println(123);
	}
}
