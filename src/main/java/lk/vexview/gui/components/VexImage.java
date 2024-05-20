package lk.vexview.gui.components;

import com.daxton.unrealcore.application.base.StringUtil;
import com.daxton.unrealcore.application.base.YmlFileUtil;
import com.daxton.unrealcore.display.content.module.display.ImageModule;
import lk.vexview.additional.application.base.VVImageUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
public class VexImage extends VexComponents implements DynamicComponent, ScrollingListComponent, HoverTextComponent, ExtraComponent {

    private String id;

    private String url;

    private int w;

    private int h;

    private int xs;

    private int ys;

    private VexHoverText hov;

    private ImageModule imageModule;

    public VexImage(String id, FileConfiguration fileConfiguration) {
        this.id = id;
        this.url = VVImageUtil.getImage(YmlFileUtil.getString(fileConfiguration, "image", "gui.png"));
        this.x = YmlFileUtil.getInt(fileConfiguration, "x", 0);
        this.y = YmlFileUtil.getInt(fileConfiguration, "y", 0);
        this.w = YmlFileUtil.getInt(fileConfiguration, "xshow", 50);
        this.h = YmlFileUtil.getInt(fileConfiguration, "yshow", 50);
        if(fileConfiguration.contains("hovertext")){
            List<String> hoverList = new LinkedList<>();
            YmlFileUtil.getStringList(fileConfiguration, "hovertext", "").forEach(s -> {
                hoverList.add(s.replace("&", "§"));
            });
            this.hov = new VexHoverText(hoverList);
        }
    }

    public VexImage(String url, int x, int y, int xs, int ys) {
        this.id = StringUtil.generateRandomString(3);
        this.url = VVImageUtil.getImage(url);
        this.x = x;
        this.y = y;
        this.w = xs;
        this.h = ys;
        this.xs = xs;
        this.ys = ys;
    }

    public VexImage(String url, int x, int y, int w, int h, int xs, int ys) {
        this.id = StringUtil.generateRandomString(3);
        this.url = VVImageUtil.getImage(url);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xs = xs;
        this.ys = ys;
    }

    public VexImage(String url, int x, int y, int w, int h, int xs, int ys, VexHoverText hov) {
        this.id = StringUtil.generateRandomString(3);
        this.url = VVImageUtil.getImage(url);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xs = xs;
        this.ys = ys;
        this.hov = hov;
    }

    public VexImage(String url, int x, int y, int xs, int ys, VexHoverText hov) {
        this.id = StringUtil.generateRandomString(3);
        this.url = VVImageUtil.getImage(url);
        this.x = x;
        this.y = y;
        this.w = xs;
        this.h = ys;
        this.xs = xs;
        this.ys = ys;
        this.hov = hov;
    }

    @Override
    public void setHover(VexHoverText hov) {
        this.hov = hov;
    }
    @Override
    public void setHover(List<String> l) {
        this.hov = new VexHoverText(l);
    }

}
