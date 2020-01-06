package com.cskaoyan;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.UUID;

@SpringBootTest
class AliyunDemoPracticeApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        String accessKeyId = "LTAI4FdavgeBRvaCR8MKjgde";
        String accessKeySecret = "AL2pxAIC89k71m5lTc9XXnKOjy7xOU";
        String bucket = "yuanchuan-test";
        String endPoint = "oss-cn-hangzhou.aliyuncs.com";
        /*准备一个文件*/
        File file = new File("C:\\Users\\admin\\Desktop", "a.jpg");
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        PutObjectResult putObjectResult = ossClient.putObject(bucket, fileName, file);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(putObjectResult);
        System.out.printf(s);
    }


    @Test
    public void test2() {
        String accessKeyId = "LTAI4Fr5gfYhcVjLMqeRGbuT";
        String accessKeySecret = "IrkcHu6dZyrjPZRushgO76P5392HJ1";
        String signName = "stone4j";
        String templateCode = "SMS_173765187";
        String phoneNumber = "13260604399";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient defaultAcsClient = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\"65536\"}");
        try {
            CommonResponse response = defaultAcsClient.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

}
