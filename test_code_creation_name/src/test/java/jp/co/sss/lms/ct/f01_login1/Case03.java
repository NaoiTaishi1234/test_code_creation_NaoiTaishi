package jp.co.sss.lms.ct.f01_login1;

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
 * 結合テスト ログイン機能①
 * ケース03
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース03 受講生 ログイン 正常系")
public class Case03 {

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
		}, "_03_login_page");
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		// 初回ログイン済みのユーザーID、パスワード入力
		webDriver.findElement(By.id("loginId")).sendKeys("StudantAA01");
		webDriver.findElement(By.id("password")).sendKeys("StudantAA01");

		// ログインボタンを押す
		webDriver.findElement(By.cssSelector("input[type='submit'][value='ログイン']")).click();

		// コース詳細画面に遷移できているか
		assertEquals(" | LMS", webDriver.getTitle());

		// 開いたページのキャプチャを取得する
		WebDriverUtils.getEvidence(new Object() {
		}, "login_clear");
	}

}
