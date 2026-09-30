package jp.co.sss.lms.ct.f02_faq;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import jp.co.sss.lms.ct.util.WebDriverUtils;

/**
 * 結合テスト よくある質問機能
 * ケース04
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース04 よくある質問画面への遷移")
public class Case04 {

	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		// URLでログインページにアクセス
		webDriver.get("http://localhost:8080/lms");

		assertEquals("ログイン | LMS", webDriver.getTitle());

		// 開いたページのキャプチャを取得する
		WebDriverUtils.getEvidence(new Object() {
		}, "login_page");
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		// 登録済のユーザーID、パスワード入力
		webDriver.findElement(By.id("loginId")).sendKeys("StudentAA09");
		webDriver.findElement(By.id("password")).sendKeys("StudentAA09a");
		// ログインボタンを押す
		webDriver.findElement(By.cssSelector("input[type='submit'][value='ログイン']")).click();

		// コース詳細画面に遷移できているか
		assertEquals("コース詳細 | LMS", webDriver.getTitle());
		WebDriverUtils.getEvidence(new Object() {
		}, "login_success");

	}

	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「ヘルプ」リンクからヘルプ画面に遷移")
	void test03() {
		//ドロップダウンを開く
		webDriver.findElement(By.cssSelector("a.dropdown-toggle")).click();
		//ヘルプをクリック
		webDriver.findElement(By.xpath("//ul[contains(@class, 'dropdown-menu')]//a[normalize-space()='ヘルプ']")).click();

		// コース詳細画面に遷移できているか
		assertEquals("ヘルプ | LMS", webDriver.getTitle());
		WebDriverUtils.getEvidence(new Object() {
		}, "help_page");
	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「よくある質問」リンクからよくある質問画面を別タブに開く")
	void test04() {
		//
		webDriver.findElement(By.cssSelector("a[href$='/faq']")).click();

		//よくある質問ページを別タブで開けたか
		assertEquals("ヘルプ | LMS", webDriver.getTitle());
		WebDriverUtils.getEvidence(new Object() {
		}, "question_page");
	}

}
