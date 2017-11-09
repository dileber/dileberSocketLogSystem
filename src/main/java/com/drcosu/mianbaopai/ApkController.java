package com.drcosu.mianbaopai;

import aixiao.uproduct.*;
import aixiao.uproduct.uemail.UEmail;
import com.drcosu.mianbaopai.model.ApkResult;
import com.drcosu.mianbaopai.model.Result;
import main.Config;
import main.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uproduct.*;
import uproduct.UConfig;
import uproduct.UGradle;
import uproduct.UProperties;
import uproduct.upackage.UPackage;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by DELL on 2017/10/20.
 */
@RestController
@RequestMapping("/apk")
public class ApkController {
    @Resource
    private ServletContext servletContext;
    @Value("${file.ip}")
    public  String ip; //这里变量不能定义成static

    @Value("${file.down}")
    public  String down;

    @Value("${file.uphtml}")
    public  String uphtml;

    @Value("${file.sql}")
    public  String sql;
    @RequestMapping("/apkchange/{keym}")
    public ApkResult apkchange(@PathVariable String keym) throws IOException {
        if(keym==null){
            ApkResult apkResult = new ApkResult(null,-1,"key is null");
            return apkResult;
        }
        InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/config/"+keym+".properties");
        UProperties.config = new HashMap<String, String>();
        Properties prop = new Properties();
        try{
            //读取属性文件a.properties
            InputStreamReader in = new InputStreamReader(inputStream);
            prop.load(in);     ///加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key = it.next();
                UProperties.config.put(key,prop.getProperty(key));
                //System.out.println(key+":"+prop.getProperty(key));
            }
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
            ApkResult apkResult = new ApkResult(null,-1,"key is error");
            return apkResult;
        }
        Config.config(UProperties.config.get("dir") + UProperties.config.get("src"));

        Constants.APPTEMP = down;
        UConfig.start();
        UGradle.start();
        UInitialize.start();
        UString.start();
        UAndroidManifest.start();
        UImage.start();
        UPackage.toPackage();
        String apkName = getBaonahaoAPK();
        if(apkName==null){
            ApkResult apkResult = new ApkResult(null,-1,"\u5931\u8d25");
            return apkResult;
        }
        ApkResult apkResult = new ApkResult("http://"+ip+"/temp"+UPackage.class.getName()+"/"+apkName,1,"\u521b\u5efa\u6210\u529f");

        return apkResult;


    }

    public static String getBaonahaoAPK() {
        String tempPackage = Constants.APPTEMP+UPackage.class.getName();

        File file=new File(tempPackage);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数：" + tempList.length);
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                //System.out.println("文     件："+tempList[i]);
                File s = tempList[i];
                if(s.getName().indexOf("com.baonahao.parents")!=-1){
                    return s.getName();
                }
            }
        }
        return null;
    }

    public static boolean aixiaoUp = true;
    @RequestMapping("/aixiaoUp")
    public Result aixiaoUp(){
        aixiaoUp = true;
        return new Result(1,"SUCCESS");
    }

    @RequestMapping("/aixiao")
    public ApkResult aixiao() throws IOException {
        if(aixiaoUp){
            InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/config/aixiao.properties");
            aixiao.uproduct.UProperties.config = new HashMap<String, String>();
            Properties prop = new Properties();
            try{
                //读取属性文件a.properties
                InputStreamReader in = new InputStreamReader(inputStream);
                prop.load(in);     ///加载属性列表
                Iterator<String> it=prop.stringPropertyNames().iterator();
                while(it.hasNext()){
                    String key = it.next();
                    aixiao.uproduct.UProperties.config.put(key,prop.getProperty(key));
                    //System.out.println(key+":"+prop.getProperty(key));
                }
                in.close();
            }
            catch(Exception e){
                e.printStackTrace();
                ApkResult apkResult = new ApkResult(null,-1,"key is error");
                return apkResult;
            }
            aixiao.main.Config.config(aixiao.uproduct.UProperties.config.get("dir") + aixiao.uproduct.UProperties.config.get("src"));

            aixiao.main.Constants.APPTEMP = down;
            aixiao.uproduct.UConfig.start();
            aixiao.uproduct.UGradle.start();
            aixiao.main.Constants.TEMPLET_UPDATE =  uphtml;
            aixiao.main.Constants.TEMPLET_SQL = sql;

            UUpdate.start();
            USql.start();
            aixiao.uproduct.upackage.UPackage.toPackage();
            try {
                UEmail.toSendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
            aixiaoUp = false;
        }

        String apkName = UEmail.getAixiaoAPK();
        if(apkName==null){
            aixiaoUp = true;
            ApkResult apkResult = new ApkResult(null,-1,"\u5931\u8d25");
            return apkResult;
        }
        ApkResult apkResult = new ApkResult("http://"+ip+"/temp"+aixiao.uproduct.upackage.UPackage.class.getName()+"/"+apkName,1,"\u521b\u5efa\u6210\u529f");

        return apkResult;


    }
}
