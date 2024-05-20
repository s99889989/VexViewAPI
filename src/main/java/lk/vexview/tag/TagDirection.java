package lk.vexview.tag;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TagDirection {

    //圖片沿X軸旋轉的角度
    private float angle_x;
    //圖片沿Y軸旋轉的角度
    private float angle_y;
    //圖片沿Z軸旋轉的角度
    private float angle_z;
    //跟隨玩家（跟隨顯示該Tag的玩家轉向而轉向）,否則跟隨視野（如同玩家名稱，始終朝向另一個玩家看他的視野）
    private boolean for_player;
    //擁有這個Tag玩家是否可以自己的Tag（就是除了自己以外其他所有人都能看到）
    private boolean player_can_see;

    public TagDirection(float angle_x, float angle_y, float angle_z, boolean for_player, boolean player_can_see) {
        this.angle_x = angle_x - 90;
        this.angle_y = angle_y;
        this.angle_z = angle_z;
        this.for_player = for_player;
        this.player_can_see = player_can_see;
    }

    public float getAngleX() {
        return angle_x;
    }

    public float getAngleY() {
        return angle_y;
    }

    public float getAngleZ() {
        return angle_z;
    }

    public boolean isForPlayer() {
        return for_player;
    }

    public boolean isPlayerCanSee() {
        return player_can_see;
    }
}
