package blog.tsuchiya.tutorial.step5.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import blog.tsuchiya.tutorial.step5.component.StringCounter;
import lombok.RequiredArgsConstructor;

@Service
// finalなフィールドを引数に取るコンストラクタを自動で生成するアノテーション
@RequiredArgsConstructor
public class MainServiceImpl2 implements MainService {

	/** DI対象のクラス内で更にDIすることも可能 */
	private final StringCounter counter;
	
	/**
	 * 文字列の後に文字列の長さを付け加える。
	 * nullの場合は空文字列を返す
	 * 
	 * @param target 装飾対象の文字列
	 * @return targetに数値を付け加えた文字列
	 */
	@Override
	public String decorate(String target) {
		if(Objects.isNull(target)) {
			return "";
		}
		return target + counter.length(target);
	}

}
