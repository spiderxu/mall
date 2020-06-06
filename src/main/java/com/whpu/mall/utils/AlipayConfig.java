package com.whpu.mall.utils;

public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102300743260";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCg906ifwQJ0JTtn6CUDbw+R9cOwg/7vbqrEAyJ6vCUwNwIBgGgfzWrcFJ2DYg+Q/Gf1jtJ2Zus7c2iSxvgFeLeKc5xRzRNGZ94nP6hMYtOP3d5hDZfjXHZhpzGncRykUir+t8OQzNYdSdApHmpdY3Nxnp7st8lgI7KNcI/RkE4am9H64PXxGUt8gsSz4iQcFyC6r1PFgX1YlVg6NKG+CIgNOOf9fW8cqpKxV1N1nGajVTzYAttf3X8YVeZhTixNaIT/uGdIb+CZTKoN2GMsZMr+dUEa9K7+/WeYz1JmyFrKT9nyA21faJOWTFeYl5MkMB9HXVp0nlUjq87MW/Yq0ZfAgMBAAECggEBAI43UpuRW1EMn7h+05JbvFjOgj0Ayrxh+j5PVLS6Bct3xi+0ltVl71ZETCcPd7ODtkTBM+rgv4F/LbLZZ4yJ6cLd7w74mUYRgGtBUlu6+ViuDHIplRzBTLijDXsSQ1Hx+OIyKcdhKklaYM7lQrStLxeC6A7IkA2DUyVnb/MVsGQVhlTQabFYsumXFpurLBELXBKf6xXMkYIhXnF0MwjQ2DZ1k5qYxAYzdWDugamY2q1TBdsmbVUVFCdyjkW53WI3X+ebfsoruVbKZ7yFPJRCuVZgc43BbB82Ea8Yxw/8EyZxQ4+SOyw76TQ/xlXVqkTccxHFqYciXMoGbRzGpCRvVcECgYEA17AiRMvsLO5lxrHA3tdsQI8scEGxIrkO6TeAb8Yes1ptglnZo0Z5r5QJGTozSds3EyIV35NFopinEfRLsAeQQ53uZso5Z9RnwzgRlP7jlrk/w/krWxat5gwFqrUuB4PZu1Izmd8RBkZ4kYLX9LaCY0sRbdpX5W7OfQtOQ30Ibz8CgYEAvwzuV5tmGVD7DEQ5J/tl9npr7l6Sstjap74RPNHIdIlVUmi49AP84XVQzCkPY55LWEWgqk81a9NJ6coh2DnbeZXTDNAccsd89AnlAY/Pfbkk3XYHLHpzE1H25y9HFBC3tcZV4Eqrj5NZKmAGpbiHg4NQY3t1zZ1F9n7naLzegOECgYEAmzD1h1C/D5k9C9lMMEsKbe1WiTMLNDO5Yd74f/QqlNwk3Vyu9wc3eTjnzwoMa0DbAN5OpL6/pP13gLipWPAoQi65oaYx5d50BogqRm2b7hA+rFB1fKX13AeccDbK9sdM+7ZqwHU7N6uvBuwBXOeRK8aQtN0cz02KL3jaCD9HuVsCgYEAkWwpW/wIikqu3VZs3zcoFKZ401efeI1CWp59hnr0h2glzvWxmuQSMBdZah3y/dP26/kL47cpJasNvuxCONFJc1IM9NrQXLnmLef+LeMmgD9WhVAbA8stHs6sDqtZAjf7blzK71BHKKFzJKM1TB2a4QsqPJ80O090er18LaheAWECgYEAspNEUCZk+bEmjw17bryg6yAZFOHjr0Gmgrbt2jBQEFHnHlqQzgB31p8UxAOGU08P7X+AXeOg9RBfoEGSwaTQ7Hhu2nzlofvIQvmKvvyL5LRtkOC2xUveTJTX6sTbvj0zrNaAo6QuhdHQe67XxEyhNX4Q/VtnVhodoCHLV2sL8hg=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnqvIZ2fjKuoSvaIpzySQ3DXMJuzomFvBFDVdeFcM9m+M2jT2NRsgg7cvrTZkB5ZYgGc0dN3oP5BgYj/8sV0Uo8k5YecFKgMjJcyV/3iJIkAJHpClUZi0nwmvv1ZkZCAqcnN+aDtg2CUwgJHp0AoMAcF/Br6uiEOKRWWmXGls5+ugrwO0Z6PoSdFLoUiVDExKp0wzLV13szVH+hDpmKE84M+brXsJIcAEMSZ9nBJ5kwGXx43PANcFPBfmqPnh5fbXj+v0BTgWmW6sLRjbWpUDrS5QWf+1MKUJT3s9oiiEEymczU5IY34wdqZPuByA49zuEMegHpWm6BB3Bw3zddTrDQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:82/pay/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:82/pay/alipayReturnNotice";

    // 签名方式
    public static String sign_type = "RSA2";

    // 返回格式
    public static String FORMAT = "json";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关日志
    public static String log_path = "F:\\支付资料\\alipay支付宝\\log";
}
