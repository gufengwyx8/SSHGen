import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

/*
 * @(#)Generator.java 2015-4-19 ÏÂÎç12:07:22 SSHGen
 */

/**
 * Generator
 * @author wang
 * @version 1.0
 *
 */
public class Generator {

    public static final String PACKAGE = "res\\com\\tagmanager\\";

    public static final List<String> EXCLUDE = Arrays.asList("Product", "User",
        "UserType");

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        FileUtils.deleteDirectory(new File("res\\com"));
        Generator g = new Generator();
        File dir = new File("src\\com\\tagmanager\\model");
        for (File f : dir.listFiles()) {
            String name = f.getName()
                    .substring(0, f.getName().lastIndexOf('.'));
            if (!EXCLUDE.contains(name)) {
                g.gen(Class.forName("com.tagmanager.model." + name), !name
                        .contains("Detail"));
            }
        }
    }

    public void gen(Class<?> cls, boolean struts) {
        genDao(cls);
        genDaoImpl(cls);
        genService(cls);
        genServiceImpl(cls);
        if (struts) {
            genStruts(cls);
            genAction(cls);
            genPage(cls);
        }
        genHibernate(cls);
        genBaseAction(cls);
    }

    private void genPage(Class<?> cls) {
        String upper = cls.getSimpleName();
        String lower = Character.toLowerCase(upper.toCharArray()[0])
                + upper.substring(1);
        genUTF8(upper, lower, "res\\list.jsp", PACKAGE + "page\\" + lower,
            "list" + upper + ".jsp");
        genUTF8(upper, lower, "res\\listDetail.jsp",
            PACKAGE + "page\\" + lower, "list" + upper + "Detail.jsp");
    }

    private void gen(String upper, String lower, String srcPath,
            String destDir, String destName) {
        String str = FileUtil.readFile(srcPath);
        str = str.replaceAll("\\$\\{Upper\\}", upper).replaceAll(
            "\\$\\{Lower\\}", lower);
        FileUtil.writeFile(destDir, destName, str, false);
    }

    private void genUTF8(String upper, String lower, String srcPath,
            String destDir, String destName) {
        String str = FileUtil.readUTF8File(srcPath);
        str = str.replaceAll("\\$\\{Upper\\}", upper).replaceAll(
            "\\$\\{Lower\\}", lower);
        FileUtil.writeUTF8File(destDir, destName, str, false);
    }

    private void genDao(Class<?> cls) {
        String upper = cls.getSimpleName();
        String lower = Character.toLowerCase(upper.toCharArray()[0])
                + upper.substring(1);
        gen(upper, lower, "res\\BaseDao.java", PACKAGE + "dao", upper
                + "Dao.java");
    }

    private void genDaoImpl(Class<?> cls) {
        String upper = cls.getSimpleName();
        String lower = Character.toLowerCase(upper.toCharArray()[0])
                + upper.substring(1);
        gen(upper, lower, "res\\BaseDaoImpl.java", PACKAGE + "dao\\impl", upper
                + "DaoImpl.java");
    }

    private void genService(Class<?> cls) {
        String upper = cls.getSimpleName();
        String lower = Character.toLowerCase(upper.toCharArray()[0])
                + upper.substring(1);
        gen(upper, lower, "res\\BaseService.java", PACKAGE + "service", upper
                + "Service.java");
    }

    private void genServiceImpl(Class<?> cls) {
        String upper = cls.getSimpleName();
        String lower = Character.toLowerCase(upper.toCharArray()[0])
                + upper.substring(1);
        gen(upper, lower, "res\\BaseServiceImpl.java", PACKAGE + "service\\impl",
            upper + "ServiceImpl.java");
    }

    private void genStruts(Class<?> cls) {
        String str = FileUtil.readFile("res\\struts.xml");
        String upper = cls.getSimpleName();
        String lower = Character.toLowerCase(upper.toCharArray()[0])
                + upper.substring(1);
        str = str.replaceAll("\\$\\{Upper\\}", upper).replaceAll(
            "\\$\\{Lower\\}", lower);
        FileUtil.writeFile(PACKAGE, "struts", str + "\n", true);
    }

    private void genHibernate(Class<?> cls) {
        FileUtil.writeFile(PACKAGE, "hibernate", "<mapping class=\""
                + cls.getName() + "\" />\n", true);
    }

    private void genBaseAction(Class<?> cls) {
        String upper = cls.getSimpleName();
        String lower = Character.toLowerCase(upper.toCharArray()[0])
                + upper.substring(1);
        FileUtil.writeFile(PACKAGE, "baseaction", "@Resource(name = \"" + lower
                + "Service\")\nprotected " + upper + "Service " + lower
                + "Service;\n", true);
    }

    private void genAction(Class<?> cls) {
        String upper = cls.getSimpleName();
        String lower = Character.toLowerCase(upper.toCharArray()[0])
                + upper.substring(1);
        gen(upper, lower, "res\\BaseAction.java", PACKAGE + "action", upper
                + "Action.java");
    }

}
