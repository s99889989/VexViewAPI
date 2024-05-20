package lk.vexview.tag.components;

import lk.vexview.tag.TagDirection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexSpiltImageTag extends VexTag{

    private String url;
    //圖片實際寬度
    private int realWidth;
    //圖片實際高度
    private int realHeight;
    //圖片顯示寬度（與Gui不同，如1代表1格寬）
    private float xs;
    //圖片顯示高度
    private float ys;

    private int uWidth;

    private int vHeight;

    private int u;

    private int v;

    public VexSpiltImageTag(String id, String url, double x, double y, double z, int realWidth, int realHeight, float xs, float ys, int uWidth, int vHeight, int u, int v, TagDirection td){
        super(x, y, z, td, id.toString(), "\ti4e6");
        this.url = url;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        this.xs = xs;
        this.ys = ys;
        this.uWidth = uWidth;
        this.vHeight = vHeight;
        this.u = u;
        this.v= v;
    }

}
