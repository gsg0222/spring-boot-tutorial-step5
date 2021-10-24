package blog.tsuchiya.tutorial.step5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import blog.tsuchiya.tutorial.step5.service.MainService;

@Controller
public class MainController {

	private static final String TEXT = "テスト対象文字列";

	/** 
	 * 今回DIする対象。コンストラクタでSpring Bootが自動的に代入してくれる。
	 * Qualifierアノテーションで対象のクラスを特定している。
	 * 今回はMainServiceを実装したコンクリートクラスが2つあるのでこの
	 * アノテーションが必要になった。
	 * MainServiceを実装したクラスが1つしかなかったらQualifierは不要。
	 * フィールドにAutowiredアノテーションを付けるフィールドインジェクションは
	 * 非推奨なのだが、今回は練習のためあえて利用した。
	 * 公式サイトではコンストラクタインジェクションが推奨されている。
	 */
	@Autowired
	@Qualifier("mainServiceImpl1")
	private MainService service1;
	
	/**
	 * 同じくDI対象を指定。
	 */
	@Autowired
	@Qualifier("mainServiceImpl2")
	private MainService service2;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("value1", this.service1.decorate(TEXT));
		model.addAttribute("value2", this.service2.decorate(TEXT));
		return "index";
	}
}
