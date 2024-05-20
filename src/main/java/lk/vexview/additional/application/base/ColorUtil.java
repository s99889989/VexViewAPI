package lk.vexview.additional.application.base;

public class ColorUtil {

    //將包含透明度的顏色數字  取出顏色  轉成顏色字串
    public static String toColor(int colorHex){
        int colorWithoutAlpha = colorHex & 0x00FFFFFF;  // 去除透明度部分

        // 將顏色部分（不包括透明度）轉換為十六進位字串（不包括前綴0x）
        return Integer.toHexString(colorWithoutAlpha).toUpperCase();
    }

    //將包含透明度的顏色數字轉成  取出透明度  轉成256數字
    public static int toTransparent(int colorHex){
        return (colorHex >> 24) & 0xFF;
    }


}
