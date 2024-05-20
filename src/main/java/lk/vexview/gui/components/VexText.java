package lk.vexview.gui.components;

import com.daxton.unrealcore.application.base.StringUtil;
import com.daxton.unrealcore.application.base.YmlFileUtil;
import com.daxton.unrealcore.display.content.module.display.TextModule;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class VexText extends VexComponents implements DynamicComponent, ScrollingListComponent, HoverTextComponent, ExtraComponent {

    private String id;

    private int x;

    private int y;

    private List<String> l;

    private int textWidth;

    private double scale = 1;

    private VexHoverText hov;

    private TextModule textModule;

    public VexText(String id, FileConfiguration fileConfiguration) {
        this.id = id;
        this.x = YmlFileUtil.getInt(fileConfiguration, "x", 0);
        this.y = YmlFileUtil.getInt(fileConfiguration, "y", 0);
        this.scale = YmlFileUtil.getFloat(fileConfiguration, "scale", 1);
        List<String> stringList = new LinkedList<>();
        YmlFileUtil.getStringList(fileConfiguration, "text", "").forEach(s -> {
            stringList.add(s.replace("&", "§"));
        });
        this.l = stringList;

        if(fileConfiguration.contains("hovertext")){
            List<String> hoverList = new LinkedList<>();
            YmlFileUtil.getStringList(fileConfiguration, "hovertext", "").forEach(s -> {
                hoverList.add(s.replace("&", "§"));
            });
            this.hov = new VexHoverText(hoverList);
        }
    }

    public VexText(int x, int y, List<String> l) {
        this.id = StringUtil.generateRandomString(3);
        this.x = x;
        this.y = y;
        List<String> stringList = new LinkedList<>();
        l.forEach(s -> {
            stringList.add(s.replace("&", "§"));
        });
        this.l = stringList;
    }

    public VexText(int x, int y, List<String> l, double scale) {
        this.id = StringUtil.generateRandomString(3);
        this.x = x;
        this.y = y;
        List<String> stringList = new LinkedList<>();
        l.forEach(s -> {
            stringList.add(s.replace("&", "§"));
        });
        this.l = stringList;
        this.scale = scale;
    }

    public VexText(int x, int y, List<String> l, double scale, VexHoverText hov, int textWidth) {
        this.id = StringUtil.generateRandomString(3);
        this.x = x;
        this.y = y;
        List<String> stringList = new LinkedList<>();
        l.forEach(s -> {
            stringList.add(s.replace("&", "§"));
        });
        this.l = stringList;
        this.scale = scale;
        this.hov = hov;
        this.textWidth = textWidth;
    }

    public VexText(int x, int y, List<String> l, VexHoverText hov) {
        this.id = StringUtil.generateRandomString(3);
        this.x = x;
        this.y = y;
        List<String> stringList = new LinkedList<>();
        l.forEach(s -> {
            stringList.add(s.replace("&", "§"));
        });
        this.l = stringList;
        this.hov = hov;
    }

    public VexText(int x, int y, List<String> l, VexHoverText hov, int textWidth) {
        this.id = StringUtil.generateRandomString(3);
        this.x = x;
        this.y = y;
        List<String> stringList = new LinkedList<>();
        l.forEach(s -> {
            stringList.add(s.replace("&", "§"));
        });
        this.l = stringList;
        this.hov = hov;
        this.textWidth = textWidth;
    }

    public List<String> getText() {
        return l;
    }

    @Override
    public void setHover(VexHoverText hov) {
        this.hov = hov;
    }

    @Override
    public void setHover(List<String> l) {
        this.hov = new VexHoverText(l);
    }

    public String getType() {
        return"InIs";
    }

}
