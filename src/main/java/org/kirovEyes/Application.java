package org.kirovEyes;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.kirovEyes.splash.DemoSplash;
import org.kirovEyes.view.DemoView;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@EnableAutoConfiguration // 作用: 开启自动配置 初始化spring环境 springmvc环境
//@ComponentScan // 作用: 用来扫描相关注解 扫描范围 当前入口类所在的包及子包(com.yusal及其子包)
@SpringBootApplication
public class Application extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        // springApplication: spring应用类    作用: 用来启动springboot应用
        // 参数1: 传入入口类 类对象   参数2: main函数的参数
//        SpringApplication.run(Application.class, args);

        //对应的启动页面，过场动画
        launch(Application.class, DemoView.class,new DemoSplash(), args);
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        stage.setTitle("MD5转化工具");
        stage.setWidth(500);
        stage.setHeight(500);
    }
}
