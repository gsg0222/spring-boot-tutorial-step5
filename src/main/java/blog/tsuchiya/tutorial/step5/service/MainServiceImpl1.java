package blog.tsuchiya.tutorial.step5.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl1 implements MainService {

	private static final String DECORATOR = "*";
	/**
	 * 引数の文字列の前後に*をつける。
	 * 引数がnullだった場合は空の文字列を返す
	 */
	@Override
	public String decorate(String target) {
		if(Objects.isNull(target)) {
			return "";
		}
		return DECORATOR + target + DECORATOR;
	}

}
