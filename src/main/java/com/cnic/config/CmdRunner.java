package com.cnic.config;

import com.hankcs.hanlp.dictionary.CustomDictionary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * <p>初始化项目时，执行命令，将相关额外的自定义词典加载下</p>
 */
@Component
public class CmdRunner implements CommandLineRunner {

    @Value("${HanLP.CustomDictionary.path.companyDict}")
    private String companyDict;

    @Value("${HanLP.CustomDictionary.path.industryDict}")
    private String industryDict;

    @Value("${HanLP.CustomDictionary.path.materialDict}")
    private String materialDict;
    
    @Value("${HanLP.CustomDictionary.path.productDict}")
    private String productDict;

    @Override
    public void run(String... args) throws Exception {

    	System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作开始<<<<<<<<<<<<<");
        /**
         * 加载自定义的公司名称字典 == 设置词性 nc 0
         * 类型type=0
         */
    	loadDefineDict(companyDict, 0);
    	/**
    	 * 加载自定义的行业字典 == 设置词性  ni 0
    	 * 类型type=1
    	 */
    	loadDefineDict(industryDict, 1);
    	/**
    	 * 加载自定义的材料字典 == 设置词性 nm
    	 * 类型type=2
    	 */
    	loadDefineDict(materialDict, 2);
    	/**
    	 * 加载自定义的产品字典 == 设置词性 np
    	 * 类型type=3
    	 */
    	loadDefineDict(productDict, 3);

    	System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作结束<<<<<<<<<<<<<");
    }
    /**
     * 加载自定义字典
     * @param path
     * @param type
     */
    public void loadDefineDict(String path, int type) {
		File file = new File(path);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			addCustomDictionary(br, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

    /**
     * 添加自定义分词及其词性，注意数字0表示频率，不能没有
     *
     * @param br
     * @param type
     */
    public void addCustomDictionary(BufferedReader br, int type) {

        String word;
        try {
            while ((word = br.readLine()) != null) {
                switch (type) {
                    /**
                     * 设置公司名称名词词性 == nc 0
                     */
                    case 0:
                        CustomDictionary.add(word, "nc 0");
                        break;
                     /**
                      * 设置行业名称名词词性 == ni 0
                      */
                    case 1:
                    	
                    	CustomDictionary.add(word, "ni 0");
                    	break;
                    /**
                     * 设置材料名词词性 == nm 0
                     */
                    case 2:
                    	CustomDictionary.add(word, "nm 0");
                    	break;
                    /**
                     * 设置产品名词词性 == np 0
                     */
                    case 3:
                    	CustomDictionary.add(word, "np 0");
                    	break;
                    default:
                        break;
                }
            }
            br.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
