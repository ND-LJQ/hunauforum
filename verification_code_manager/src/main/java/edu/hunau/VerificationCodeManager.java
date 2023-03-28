package edu.hunau;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class VerificationCodeManager
{
    public static void main( String[] args )
    {
        //        配置类传入机器id
        IdGeneratorOptions options = new IdGeneratorOptions((short) 5);
        // 默认值6，限定 WorkerId 最大值为2^6-1，即默认最多支持64个节点。
        // options.WorkerIdBitLength = 10;

        // 默认值6，限制每毫秒生成的ID个数。若生成速度超过5万个/秒，建议加大 SeqBitLength 到 10。
        // options.SeqBitLength = 6;

        // 如果要兼容老系统的雪花算法，此处应设置为老系统的BaseTime。
        // options.BaseTime = Your_Base_Time;
        // ...... 其它参数参考 IdGeneratorOptions 定义。

        // 保存参数（务必调用，否则参数设置不生效）：
        YitIdHelper.setIdGenerator(options);
        SpringApplication.run(VerificationCodeManager.class,args);
    }
}
