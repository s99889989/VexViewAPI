package lk.vexview.tag.components;

import com.daxton.unrealcore.UnrealCore;
import lk.vexview.additional.application.base.VVImageUtil;
import lk.vexview.tag.TagDirection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexImageTag extends VexTag{


    private String url;
    //圖片實際寬度
    private int width;
    //圖片實際高度
    private int height;
    //圖片顯示寬度（與Gui不同，如1代表1格寬）
    private float xs;
    //圖片顯示高度
    private float ys;

    public VexImageTag(Object id, double x, double y, double z, String url, int width, int height, float xs, float ys, TagDirection td) {
        super(x, y, z, td, id.toString(), "\ti4e6");
        this.url = VVImageUtil.getImage(url);
        this.width = width;
        this.height = height;
        this.xs= xs;
        this.ys = ys;

    }

    public VexImageTag(int id, double x, double y, double z, String url, int width, int height, float xs, float ys, TagDirection td) {
        super(x, y, z, td, id+"", "\ti4e6");
        this.url = VVImageUtil.getImage(url);
        this.width = width;
        this.height = height;
        this.xs= xs; //*16
        this.ys = ys;
//        UnrealCore.sendLogger(x+" : "+y+" : "+xs+" : "+ys);
        UnrealCore.sendLogger(id+" : "+x+" : "+y+" : "+z+" : "+this.url +" : "+this.width+" : "+this.height+" : "+this.xs+" : "+this.ys+" TagDirection: "+td.toString());
    }

    public VexImageTag(String id, double x, double y, double z, String url, int width, int height, float xs, float ys, TagDirection td) {
        super(x, y, z, td, id, "NIsEq");
        this.url = VVImageUtil.getImage(url);
        this.width = width;
        this.height = height;
        this.xs= xs;
        this.ys = ys;
    }

}
