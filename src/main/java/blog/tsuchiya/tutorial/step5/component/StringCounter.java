package blog.tsuchiya.tutorial.step5.component;

import java.util.Objects;

import org.springframework.stereotype.Component;

/**
 * ComponentとしてSpring Bootに登録するクラス。
 * 存在意義はないけど、勉強用に必要なので作成。
 */
@Component
public class StringCounter {

	/**
	 * 引数の文字列の長さを返す。nullの場合は長さ0を返す
	 * @param target 長さを調べる文字列
	 * @return
	 */
	public int length(String target) {
		if(Objects.isNull(target)) {
			return 0;
		}
		return target.length();
	}
}
