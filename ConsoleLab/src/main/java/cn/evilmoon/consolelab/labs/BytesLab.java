package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.TimeTag;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 一个字节处理的练习(截取一个Byte串，并做 CRC16 校验)
 */
@TimeTag("2018-09-05 21:10")
public class BytesLab implements Lab {
    @Override
    public void run(String[] args) {
        byte[] receivedData = new byte[31];
        ByteBuffer bb = ByteBuffer.wrap(receivedData);
        bb.order(ByteOrder.BIG_ENDIAN);
        // 帧头（0xCC5F）：
        bb.put((byte) 0xCC);
        bb.put((byte) 0x5F);
        // 帧类型（0x81）
        bb.put((byte) 0x81);
        // 标签数目：
        bb.put((byte) 0x01);
        // 标签ID：
        bb.put(new byte[]{0x00, 0x00, 0x00, 0x01});
        // X 轴：
        bb.put(new byte[]{0x00, 0x00, 0x00, 0x0A});
        // Y 轴
        bb.put(new byte[]{0x00, 0x00, 0x00, 0x0F});
        // Z 轴
        bb.put(new byte[]{0x00, 0x05});
        // 保留
        bb.put((byte) 0x00);
        // 电量
        bb.put((byte) 0x05);
        // 休眠标志/充电标志
        bb.put((byte) 0x11);
        // 时间戳：
        bb.put(new byte[]{0x00, 0x00, 0x00, 0x0A});
        // 保留
        bb.put(new byte[]{0x00, 0x00});
        // 校验
        bb.put(new byte[]{(byte)0x8E, (byte)0x2B});
        // 帧尾
        bb.put(new byte[]{(byte) 0xAA, (byte) 0xBB});

        String hexString = bytesToHexString(receivedData);
        System.out.println(hexString);

        int startIndex = 2;
        byte[] measureData = getSubData(receivedData, startIndex,  25);
        String measureHexString = bytesToHexString(measureData);
        System.out.println(measureHexString);

        startIndex = receivedData.length - 2 - 2;
        byte[] crc16Code = getSubData(receivedData, startIndex,  2);
        String crc16CodeHexString = bytesToHexString(crc16Code);
        System.out.println(crc16CodeHexString);

        String crc16Result = make_CRC(measureData);
        System.out.println(crc16Result);
    }

    /**
     * 截断指定的byte[]
     * @param data
     * @param startIndex
     * @param length
     * @return
     */
    private byte[] getSubData(byte[] data, int startIndex, int length) {
        byte[] newData = new byte[length];
        int end = startIndex + length;
        for(int i = startIndex; i < end; i++) {
            newData[i - startIndex] = data[i];
        }
        return newData;
    }

    /**
     * 将 byte[] 数组转为 16 进制的字符串
     *
     * @param src
     * @return 16 进制的字符串
     */
    private String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 计算产生校验码
     *
     * @param data 需要校验的数据
     * @return 校验码
     */
    private String make_CRC(byte[] data) {
        byte[] buf = new byte[data.length];// 存储需要产生校验码的数据
        for (int i = 0; i < data.length; i++) {
            buf[i] = data[i];
        }
        int len = buf.length;
        int crc = 0xFFFF;//16位
        for (int pos = 0; pos < len; pos++) {
            if (buf[pos] < 0) {
                crc ^= (int) buf[pos] + 256; // XOR byte into least sig. byte of
                // crc
            } else {
                crc ^= (int) buf[pos]; // XOR byte into least sig. byte of crc
            }
            for (int i = 8; i != 0; i--) { // Loop over each bit
                if ((crc & 0x0001) != 0) { // If the LSB is set
                    crc >>= 1; // Shift right and XOR 0xA001
                    crc ^= 0xA001;
                } else
                    // Else LSB is not set
                    crc >>= 1; // Just shift right
            }
        }
        String c = Integer.toHexString(crc);
        if (c.length() == 4) {
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 3) {
            c = "0" + c;
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 2) {
            c = "0" + c.substring(1, 2) + "0" + c.substring(0, 1);
        }
        return c;
    }
}
