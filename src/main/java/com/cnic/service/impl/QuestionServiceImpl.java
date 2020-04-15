package com.cnic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cnic.core.ModelProcess;
import com.cnic.repository.QuestionRepository;
import com.cnic.service.QuestionService;

@Service
@Primary
public class QuestionServiceImpl implements QuestionService {

	@Value("${rootDirPath}")
	private String rootDictPath;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private ModelProcess queryProcess;

	@Override
	public void showDictPath() {
		System.out.println("HanLP分词字典及自定义问题模板根目录：" + rootDictPath);
	}

	@Override
	public String answer(String question) throws Exception {

		ArrayList<String> reStrings = queryProcess.analyQuery(question);
		int modelIndex = Integer.valueOf(reStrings.get(0));
		String answer = null;
		String comName = "";
		/**
		 * 匹配问题模板
		 */
		switch (modelIndex) {
			case 0:
				/**
				 * nc 主营产品 == 公司的主营产品
				 */
				comName = reStrings.get(1);
				List<String> products = questionRepository.getProductByComName(comName);
				if (products != null && products.size() == 0) {
					answer = null;
				} else {
					answer = products.toString().replace("[", "").replace("]", "");
				}
				break;
			case 1:
				/**
				 * nc 上游原材料 == 公司的上游原材料
				 */
				comName = reStrings.get(1);
				List<String> materials = questionRepository.getMaterialByComName(comName);
				if (materials != null && materials.size() == 0) {
					answer = null;
				} else {
					answer = materials.toString().replace("[", "").replace("]", "");
				}
				break;
			default:
				break;
		}

		System.out.println(answer);
		if (answer != null && !answer.equals("") && !answer.equals("\\N")) {
			return answer;
		} else {
			return "sorry,我没有找到你要的答案";
		}
	}


}
