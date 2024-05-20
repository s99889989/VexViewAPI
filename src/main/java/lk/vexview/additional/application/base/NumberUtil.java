package lk.vexview.additional.application.base;

import java.util.Random;

public class NumberUtil {

    public static int generateRandomDecimal(int numberOfBits) {
        if (numberOfBits <= 0) {
           numberOfBits = 3;
        }

        // 创建一个随机数生成器
        Random random = new Random();

        // 计算生成随机数的上限和下限
        int lowerBound = (int) Math.pow(2, numberOfBits - 1); // 最小的 numberOfBits 位二进制数对应的十进制数
        int upperBound = (int) Math.pow(2, numberOfBits) - 1; // 最大的 numberOfBits 位二进制数对应的十进制数

        // 生成一个介于lowerBound到upperBound之间的随机整数
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        return randomNumber;
    }

}
