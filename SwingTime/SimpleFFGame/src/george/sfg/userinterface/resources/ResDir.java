package george.sfg.userinterface.resources;

import java.io.File;

/**
 * Created by Squall on 03/12/2014.
 */
public final class ResDir {
    private static File resDir = new File("");
    public static String testResString = resDir.getAbsolutePath();
    public static String resString = resDir.getAbsolutePath() + File.separator + "SimpleFFGame" + File.separator
            + "src" + File.separator + "george" + File.separator + "sfg" + File.separator + "userinterface" +
            File.separator + "resources" + File.separator;
}
