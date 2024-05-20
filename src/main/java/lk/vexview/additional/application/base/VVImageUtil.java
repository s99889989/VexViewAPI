package lk.vexview.additional.application.base;

public class VVImageUtil {

    public static String getImage(String url){
        if(url.startsWith("[local]") || url.startsWith("[Local]")){
            url = url.replace("[local]", "").replace("[Local]", "");
        }

        if(!url.startsWith("https://") && !url.startsWith("http://") && url.contains("//")){
            url = url.replace("//", "/");
        }

        return url.replace("\\", "/");
    }

}
