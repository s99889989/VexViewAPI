package lk.vexview;

import lombok.Getter;

@Getter
public class VexView {

    private String version = "26.10";

    public static VexView vexView;

    public static VexView getInstance() {
        if (vexView == null) {
            vexView = new VexView();
        }

        return vexView;
    }

}
