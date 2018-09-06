package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.TimeTag;
import com.tsingoal.com.*;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@TimeTag("2018-09-06 18:10")
public class LocalSenseLab implements Lab {
    @Override
    public void run(String[] args) {
        //如果websocket服务端带授权认证，请传入用于名密码，否则采用空的构造函数
        //注意：如果在OnPosInfo，OnCapacityInfo，OnSimpleAlarm，OnRichAlarm函数内有比较耗时的操作，会导致数据接收堆积迟滞，请用多线程方式处理，
        // 将RtlsWsManager移到一个线程，通过共享对接将解析后的数据交给主线程
        String pwd = md5Password("20180906");
        System.out.println(pwd);
        RtlsWsManager ws = new RtlsWsManager("gdtz_1m", pwd){
            //通过重写RtlsWsManager几个虚函数获取相关数据
            public  void OnCapacityInfo(List<TCapacityInfo> tagCapcityList){
                /*
                for(TCapacityInfo cap:tagCapcityList) {
                    System.out.println("===capacity===: "+cap.toString());
                }
                */
            }

            public  void OnPosInfo(List<TPosInfo> posList) {
                for(TPosInfo pos:posList) {
                    System.out.println("===position===: "+pos.toString());
                }
                System.out.println("============================================: \n\n");
            }


            public void OnSimpleAlarm(TSimpleAlarmInfo alarm) {
                //System.out.println("===simple alarm===: "+alarm);
            }

            public void OnRichAlarm(TRichAlarmInfo alarm) {
                //System.out.println("===rich alarm===: "+alarm);
            }

            public void OnPersonStatistics(TPersonStatistics statisticsInfo) {
                //System.out.println("===statisticsInfo===: "+statisticsInfo);
            }

            @Override
            public void OnUnknownMessage(ByteBuffer blob) {

            }

            @Override
            public void OnMessage(String s) {

            }

        };
        //设置websocket服务地址
        ws.setHost("120.27.12.74");
        //设置websocket服务端口
        ws.setServerPort(9001);
        //设置websocket子协议
        ws.setProtocal("localSensePush-protocol");
        //连接websocket
        ws.connectToServer();
    }

    private String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    String md5Password(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }
}
