package lk.vexview.gui.components;

import com.daxton.unrealcore.application.base.YmlFileUtil;
import com.daxton.unrealcore.display.content.module.control.ButtonModule;
import lk.vexview.additional.application.base.VVImageUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@ToString
public class VexButton extends VexComponents implements DynamicComponent, ScrollingListComponent, HoverTextComponent, ExtraComponent {

    private Object id;

    private String name;

    private String url;

    private String url2;

    private int w;

    private int h;

    private ButtonFunction f;

    private VexHoverText hov;

    private ButtonModule buttonModule;

    private String webUrl;

    public VexButton(String id, FileConfiguration fileConfiguration) {
        this.id = id;
        this.name = YmlFileUtil.getString(fileConfiguration, "name", "");
        this.x = YmlFileUtil.getInt(fileConfiguration, "x", 0);
        this.y = YmlFileUtil.getInt(fileConfiguration, "y", 0);
        this.w = YmlFileUtil.getInt(fileConfiguration, "width", 50);
        this.h = YmlFileUtil.getInt(fileConfiguration, "high", 50);
        this.url = VVImageUtil.getImage(YmlFileUtil.getString(fileConfiguration, "url", ""));
        this.url2 = VVImageUtil.getImage(YmlFileUtil.getString(fileConfiguration, "url2", ""));
        this.webUrl = YmlFileUtil.getString(fileConfiguration, "click_url", "");
        if(fileConfiguration.contains("hovertext")){
            List<String> hoverList = new LinkedList<>();
            YmlFileUtil.getStringList(fileConfiguration, "hovertext", "").forEach(s -> {
                hoverList.add(s.replace("&", "§"));
            });
            this.hov = new VexHoverText(hoverList);
        }
    }

    public VexButton(Object id, String name, String url, String url2, int x, int y, int w, int h) {
        this.id = id;
        this.name = name;
        this.url = VVImageUtil.getImage(url);
        this.url2 = VVImageUtil.getImage(url2);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public VexButton(Object id, String name, String url, String url2, int x, int y, int w, int h, ButtonFunction f) {
        this.id = id;
        this.name = name;
        this.url = VVImageUtil.getImage(url);
        this.url2 = VVImageUtil.getImage(url2);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.f = f;
    }

    public VexButton(Object id, String name, String url, String url2, int x, int y, int w, int h, ButtonFunction f, VexHoverText hov) {
        this.id = id;
        this.name = name;
        this.url = VVImageUtil.getImage(url);
        this.url2 = VVImageUtil.getImage(url2);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.f = f;
        this.hov = hov;
    }

    public VexButton(Object id, String name, String url, String url2, int x, int y, int w, int h, VexHoverText hov) {
        this.id = id;
        this.name = name;
        this.url = VVImageUtil.getImage(url);
        this.url2 = VVImageUtil.getImage(url2);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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

    public ButtonFunction getFunction(){
        return f;
    }

    public void setFunction(ButtonFunction f){
        this.f = f;
    }

    public VexHoverText getHover(){
        return hov;
    }

    public void run(Player player){
        if(f != null){
            f.run(player);
        }
    }

    public Object getId() {
        return id;
    }

    public Object getID() {
        return id;
    }
}
