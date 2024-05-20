package lk.vexview.gui.components.expand;

import lk.vexview.additional.application.base.ColorUtil;
import lk.vexview.gui.components.VexTextField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexColorfulTextField extends VexTextField {

    private int mainColor;

    private int sideColor;

    public VexColorfulTextField(int x, int y, int width, int height, int maxText, int id, int mainColor, int sideColor, String text) {
        super(x, y, width, height, maxText, id, text);
        this.mainColor = mainColor;
        this.sideColor = sideColor;
    }

    public VexColorfulTextField(int x, int y, int width, int height, int maxText, int id, int mainColor, int sideColor) {
        super(x, y, width, height, maxText, id);
        this.mainColor = mainColor;
        this.sideColor = sideColor;
    }

    //獲取主顏色字串
    public String getMainColor(){
        return ColorUtil.toColor(mainColor);
    }

    //獲取主顏色透明度
    public int getMainTransparent(){
        return ColorUtil.toTransparent(mainColor);
    }

    //獲取副顏色字串
    public String getSideColor(){
        return ColorUtil.toColor(sideColor);
    }

    //獲取副顏色透明度
    public int getSideTransparent(){
        return ColorUtil.toTransparent(mainColor);
    }

}
