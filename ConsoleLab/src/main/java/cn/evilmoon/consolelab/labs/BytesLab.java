package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.TimeTag;

/**
 * 一个字节处理的练习
 */
@TimeTag("2018-09-03 21:53")
public class BytesLab implements Lab {
    @Override
    public void run(String[] args) {
        char c = 0xcc5f;

    }

    private   byte[] intToByteArray(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    private int byteArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }
}
