package lk.vexview.chat;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class VexChatChannel {

    private String name;

    private List<UUID> bloackList = new ArrayList<>();

    private List<UUID> whiteList;

    public VexChatChannel(String name) {
        this.name = name;
    }

    public boolean isWhiteEnable() {
        return whiteList != null;
    }

    //設定白名單開啟狀態（預設為關閉）
    public void setWhiteList(boolean enable) {
        if(enable){
            whiteList = new ArrayList<>();
        }else {
            whiteList = null;
        }
    }

    //黑名單玩家 移除
    public void removeBlackPlayer(Player player) {
        bloackList.remove(player.getUniqueId());
    }

    //白名單玩家 移除
    public void removeWhitePlayer(Player player){
        if(whiteList == null){return;}
        whiteList.remove(player.getUniqueId());
    }

    //白名單玩家 增加
    public void addWhitePlayer(Player player) {
        whiteList.add(player.getUniqueId());
    }

    //黑名單玩家 增加
    public void addBlackPlayer(Player player) {
        if(whiteList == null){return;}
        whiteList.add(player.getUniqueId());
    }

}
