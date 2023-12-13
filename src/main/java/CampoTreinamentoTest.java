import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CampoTreinamentoTest {
    static WebDriver driver;

    @BeforeAll
    static void setBrowser() {
//      driver = new ChromeDriver(); // use chrome as default browser

//      driver = new FirefoxDriver(); // use firefox as default browser

        ChromeOptions options = new ChromeOptions(); // needed to set Brave as browser
        options.setBinary("/usr/bin/brave");// needed to set Brave as browser
        driver = new ChromeDriver(options); // use brave as default browser
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @BeforeEach
    void setProjPath() {
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @Test
    public void verifyTitleTest() {
        Assertions.assertEquals("Campo de Treinamento", driver.getTitle());
    }

    @Test
    public void verifyTextFieldTest() {
        WebElement fieldNome = driver.findElement(By.id("elementosForm:nome"));
        WebElement fieldSobreNome = driver.findElement(By.id("elementosForm:sobrenome"));

        fieldNome.clear();
        String nome = "Leonardo";
        fieldNome.sendKeys(nome);
        Assertions.assertEquals(nome, driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

        fieldSobreNome.clear();
        String sobreNome = "Setti";
        fieldSobreNome.sendKeys(sobreNome);
        Assertions.assertEquals(sobreNome, driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
    }

    @Test
    public void verifyRadioBtn() {
        WebElement elementRadioM = driver.findElement(By.id("elementosForm:sexo:0"));
        WebElement elementRadioF = driver.findElement(By.id("elementosForm:sexo:1"));
        Assertions.assertFalse(elementRadioM.isSelected());
        Assertions.assertFalse(elementRadioF.isSelected());

        elementRadioM.click();
        Assertions.assertTrue(elementRadioM.isSelected());
        Assertions.assertFalse(elementRadioF.isSelected());

        elementRadioF.click();
        Assertions.assertFalse(elementRadioM.isSelected());
        Assertions.assertTrue(elementRadioF.isSelected());

        elementRadioM.click();
        Assertions.assertTrue(elementRadioM.isSelected());
        Assertions.assertFalse(elementRadioF.isSelected());
    }

    @Test
    public void verifyCheckBx() {
        WebElement chkCarne = driver.findElement(By.id("elementosForm:comidaFavorita:0"));
        WebElement chkFrango = driver.findElement(By.id("elementosForm:comidaFavorita:1"));
        WebElement chkPizza = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
        WebElement chkVeg = driver.findElement(By.id("elementosForm:comidaFavorita:3"));

        Assertions.assertFalse(chkCarne.isSelected());
        Assertions.assertFalse(chkFrango.isSelected());
        Assertions.assertFalse(chkPizza.isSelected());
        Assertions.assertFalse(chkVeg.isSelected());

        chkCarne.click();
        Assertions.assertTrue(chkCarne.isSelected());
        Assertions.assertFalse(chkFrango.isSelected());
        Assertions.assertFalse(chkPizza.isSelected());
        Assertions.assertFalse(chkVeg.isSelected());
        chkFrango.click();
        Assertions.assertTrue(chkCarne.isSelected());
        Assertions.assertTrue(chkFrango.isSelected());
        Assertions.assertFalse(chkPizza.isSelected());
        Assertions.assertFalse(chkVeg.isSelected());
        chkPizza.click();
        Assertions.assertTrue(chkCarne.isSelected());
        Assertions.assertTrue(chkFrango.isSelected());
        Assertions.assertTrue(chkPizza.isSelected());
        Assertions.assertFalse(chkVeg.isSelected());
        chkVeg.click();
        Assertions.assertTrue(chkCarne.isSelected());
        Assertions.assertTrue(chkFrango.isSelected());
        Assertions.assertTrue(chkPizza.isSelected());
        Assertions.assertTrue(chkVeg.isSelected());

        chkCarne.click();
        Assertions.assertFalse(chkCarne.isSelected());
        Assertions.assertTrue(chkFrango.isSelected());
        Assertions.assertTrue(chkPizza.isSelected());
        Assertions.assertTrue(chkVeg.isSelected());
        chkFrango.click();
        Assertions.assertFalse(chkCarne.isSelected());
        Assertions.assertFalse(chkFrango.isSelected());
        Assertions.assertTrue(chkPizza.isSelected());
        Assertions.assertTrue(chkVeg.isSelected());
        chkPizza.click();
        Assertions.assertFalse(chkCarne.isSelected());
        Assertions.assertFalse(chkFrango.isSelected());
        Assertions.assertFalse(chkPizza.isSelected());
        Assertions.assertTrue(chkVeg.isSelected());
        chkVeg.click();
        Assertions.assertFalse(chkCarne.isSelected());
        Assertions.assertFalse(chkFrango.isSelected());
        Assertions.assertFalse(chkPizza.isSelected());
        Assertions.assertFalse(chkVeg.isSelected());
    }

    @Test
    public void verifyComboBx() {
        WebElement comboBx = driver.findElement(By.id("elementosForm:escolaridade"));
        Select fromList = new Select(comboBx);

        Assertions.assertEquals("1o grau incompleto", fromList.getFirstSelectedOption().getText());

        fromList.selectByIndex(1);
        Assertions.assertEquals("1o grau completo", fromList.getFirstSelectedOption().getText());
        fromList.selectByIndex(2);
        Assertions.assertEquals("2o grau incompleto", fromList.getFirstSelectedOption().getText());
        fromList.selectByIndex(3);
        Assertions.assertEquals("2o grau completo", fromList.getFirstSelectedOption().getText());
        fromList.selectByIndex(4);
        Assertions.assertEquals("Superior", fromList.getFirstSelectedOption().getText());
        fromList.selectByIndex(5);
        Assertions.assertEquals("Especialização", fromList.getFirstSelectedOption().getText());
        fromList.selectByIndex(6);
        Assertions.assertEquals("Mestrado", fromList.getFirstSelectedOption().getText());
        fromList.selectByIndex(7);
        Assertions.assertEquals("Doutorado", fromList.getFirstSelectedOption().getText());
        fromList.selectByIndex(0);
        Assertions.assertEquals("1o grau incompleto", fromList.getFirstSelectedOption().getText());
    }
}