package lk.vexview.item;

import org.bukkit.inventory.ItemStack;

public class VexItemStack {

    private ItemStack itemStack;

    public VexItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public VexItemStack previewItem() {
        return this;
    }

    public ItemStack build() {
        return itemStack;
    }

    public static VexItemStack of(ItemStack itemStack) {
        return new VexItemStack(itemStack);
    }

}
