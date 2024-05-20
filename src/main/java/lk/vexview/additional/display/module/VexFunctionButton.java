package lk.vexview.additional.display.module;

import com.daxton.unrealcore.application.base.YmlFileUtil;
import lk.vexview.gui.components.VexButton;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

@Setter
@Getter
@ToString
public class VexFunctionButton  extends VexButton {

    //指令
    private List<String> commands;
    //是否繞過執行上面指令的權限執行
    private boolean asop;
    //按下按鈕後是否關閉GUI
    private boolean close;
    //按下按鈕後轉入另一個GUI介面 (設定為 - 則不啟用)
    private String to;

    public VexFunctionButton(String id, FileConfiguration fileConfiguration) {
        super(id, fileConfiguration);
        this.commands = fileConfiguration.getStringList("commands");
        this.asop = fileConfiguration.getBoolean("asop");
        this.close = fileConfiguration.getBoolean("close");
        this.to = YmlFileUtil.getString(fileConfiguration, "to", "-");
    }

}
