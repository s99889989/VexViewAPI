package lk.vexview.additional.display.module;

import com.daxton.unrealcore.application.base.YmlFileUtil;
import lk.vexview.gui.components.DynamicComponent;
import lk.vexview.gui.components.ExtraComponent;
import lk.vexview.gui.components.ScrollingListComponent;
import lk.vexview.gui.components.VexComponents;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

@Getter
@Setter
@ToString
public class VexItem extends VexComponents implements ScrollingListComponent, DynamicComponent, ExtraComponent {

    private ItemStack itemStack;

    private String id;

    public VexItem(String id, FileConfiguration fileConfiguration) {
        this.id = id;
        this.x = YmlFileUtil.getInt(fileConfiguration, "x", 0);
        this.y = YmlFileUtil.getInt(fileConfiguration, "y", 0);
        try {
            Material itemMaterial = Enum.valueOf(Material.class, YmlFileUtil.getString(fileConfiguration, "item.material", "STONE").replace(" ","").toUpperCase());
            itemStack = new ItemStack(itemMaterial, YmlFileUtil.getInt(fileConfiguration, "item.amount", 1));
        }catch (Exception exception){
            itemStack = new ItemStack(Material.STONE);
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            if(fileConfiguration.contains("item.name")){
                itemMeta.setDisplayName(YmlFileUtil.getString(fileConfiguration, "item.name", "STONE"));
            }
            if(fileConfiguration.contains("item.durability")){
                ((Damageable) itemMeta).setDamage(YmlFileUtil.getInt(fileConfiguration, "item.durability", 1));
            }
            if(fileConfiguration.contains("item.lore")){
                itemMeta.setLore(YmlFileUtil.getStringList(fileConfiguration, "item.lore", ""));
            }
            itemStack.setItemMeta(itemMeta);
        }

    }

}
