package com.example.ygo;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.util.ClassUtils.getDefaultClassLoader;

/**
 * Hello world!
 *
 */
public class GeneratorApplication
{
    private static final Logger LOG = Logger.getLogger(GeneratorApplication.class.getName());

    public static void main(String[] args) {
        try (InputStream is = getDefaultClassLoader().getResourceAsStream("generatorConfig.xml")) {
            List<String> warnings = new ArrayList<>();
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            if (warnings.isEmpty()) {
                System.out.println("MyBatis文件生成成功！！");
            } else {
                System.err.println(warnings);
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "IP 数据库加载出错：", e);
        }
    }
}
