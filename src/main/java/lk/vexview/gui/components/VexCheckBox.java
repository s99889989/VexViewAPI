package lk.vexview.gui.components;

import com.daxton.unrealcore.display.content.module.control.CheckModule;
import lk.vexview.additional.application.base.VVImageUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class VexCheckBox extends VexComponents implements ScrollingListComponent, HoverTextComponent {

    private int id;

    private String url;

    private String url2;

    private int w;

    private int h;

    private boolean checked;

    private CheckModule checkModule;

    private VexHoverText hov;

    public VexCheckBox(int id, String url, String url2, int x, int y, int width, int height, boolean default_check) {
        this.id = id;
        this.url = VVImageUtil.getImage(url);
        this.url2 = VVImageUtil.getImage(url2);
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;
        this.checked = default_check;
    }

    @Override
    public void setHover(VexHoverText hov) {
        this.hov = hov;
    }
    @Override
    public void setHover(List<String> l) {
        this.hov = new VexHoverText(l);
    }

    public boolean isChecked(){
        if(checkModule != null){
            return checkModule.getCheck();
        }
        return this.checked;
    }

    public Object getID() {
        return id;
    }

    public int getHeight(){
        return this.h;
    }

    public int getWidth(){
        return this.w;
    }

}
