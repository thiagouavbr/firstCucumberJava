package iterasys;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Consulta {
	
	String url;
	WebDriver driver;
	
	@Before 
	public void iniciar() {
		
		url="https://www.iterasys.com.br";
		//Not used because I have all drivers installed on the machine
		//System.setProperty("webdriver.chrome.driver", value)
		driver = new ChromeDriver();
	}
	
	@After 
	public void finalizar() {	
		driver.quit();
	}
	
	@Dado("^que o usuario acessa o site da Iterasys$")
	public void que_o_usuario_acessa_o_site_da_Iterasys() throws Throwable {
		driver.get(url);
	}

	@Quando("^realizo uma busca por \"([^\"]*)\"$")
	public void realizo_uma_busca_por(String termo) throws Throwable {
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(termo));
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
	}

	@Entao("^exibe um conjunto de cursos$")
	public void exibe_um_conjunto_de_cursos() throws Throwable {
		System.out.print(driver.findElements(By.xpath("//*[@id=\"all_courses_search\"]/li")));
		
	}

	@Quando("^o usuario clica no Curso Inicio Rapido em Teste de Software$")
	public void o_usuario_clica_no_Curso_Inicio_Rapido_em_Teste_de_Software() throws Throwable {
		driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@title='Lista de Espera - Início Rápido em Teste de Software']")).click();
	}
	@Entao("^valido que a duracao do curso sera de \"([^\"]*)\"$")
	public void valido_que_a_duracao_do_curso_sera_de_horas(String horas) throws Throwable {
		String meuElemento = driver.findElement(By.cssSelector("li.carga-horaria")).getText();
		//System.out.println(horas+meuElemento);
		assertEquals("060 Horas de duração", meuElemento);
	}
	

}
