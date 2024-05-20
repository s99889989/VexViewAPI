package lk.vexview.gui.components;

import com.daxton.unrealcore.display.content.module.control.SlotModule;
import com.daxton.unrealcore.nms.NMSItem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


@Getter
@Setter
@ToString
public class VexSlot extends VexComponents implements ScrollingListComponent, DynamicComponent, ExtraComponent {

    private int id;

    private ItemStack itemStack;

    private Player player;

    private SlotModule slotModule;

    public VexSlot(int id, int x, int y, ItemStack itemStack) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.itemStack = itemStack;
    }

    public byte[] getNbt(){
        String nbtString = NMSItem.itemNBTtoString(this.itemStack);
        return nbtString.getBytes();
    }

    public void setItem(ItemStack itemStack){
        this.itemStack = itemStack;
    }

    public ItemStack getItem() {
        if(player != null){
            return player.getOpenInventory().getItem(0);
        }
        return itemStack;
    }

    public Object getID() {
        return id;
    }

    public String getType() {
        return "V?_2";
    }


}
