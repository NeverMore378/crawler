package pers.xzj.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author xzj
 * @version 1.0
 * @description
 * @date 2020/11/24 9:08
 */

public class DownloadUtil {

    public static void download(String url,String filename,String path) throws Exception {
        URL url1 = new URL(url);
        URLConnection con = url1.openConnection();
        con.setConnectTimeout(3000);
        InputStream in = con.getInputStream();
        File file = new File(path);
        if (!file.exists())
            file.mkdirs();
        byte[] bytes = new byte[1024];
        int len = 0;
        FileOutputStream os = new FileOutputStream(file.getAbsolutePath()+ "\\" + filename);

        while ((len = in.read(bytes)) != -1)
            os.write(bytes,0,len);

        os.close();
        in.close();
    }

}
