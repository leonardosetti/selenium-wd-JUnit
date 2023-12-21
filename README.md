# Selenium 4.0 - WebDriver

## Usando Java e JUnit

Aqui vou tratar de como fiz minhas configurações iniciais para começar a usar Selenium WebDriver com a linguagem Java e o framework JUnit 5.

> _**Observação**_: Como uma preferência pessoal eu estou utilizando Linux, portanto a maioria dos passos aqui descritos tem como alvo este SO.
> Com um pouco de web-search é possível encontrar passos semelhantes tanto para MSWindows quanto macOS

### Começando

Selenium é um conjunto de ferramentas e bibliotecas que podem ser usadas para criar Frameworks de automação de testes de
software. 

Tudo o que for possível realizar por um navegador web, o Selenium consegue tornar estas atividades
repetíveis de forma automática.

Por exemplo, acessar e preencher formulários, validar páginas, ações, APIs e muito mais.

### Como conseguir o Selenium WebDriver

Visite a página de [Downloads](https://www.selenium.dev/downloads) no site oficial do [Selenium](https://www.selenium.dev/) e escolha a última versão _Stable_ para a linguagem Java.

Aqui eu usei a versão [*4.16.1*](https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.16.0/selenium-java-4.16.1.zip)

> ***Observação***: Se você estiver usando uma linguagem de programação diferente do Java, precisará instalar o driver apropriado para o navegador que deseja usar. Por exemplo, para usar o Selenium com o Google Chrome, você precisará instalar o ChromeDriver, que pode ser encontrado no site oficial do [Selenium](https://www.selenium.dev/)

Após baixar o Selenium, descompacte-o em uma pasta de sua preferência.
Ex.

```bash
# Define o caminho para a pasta Selenium em uma variável de ambiente temporária
export SL="$USER/Selenium"  
# cria a pasta Selenium de acordo com o caminho escolhido
mkdir -vp $SL  
#extrai o arquivo zip baixado para a pasta Selenium (verifique a versão baixada)
unzip selenium-java-4.XX.X.zip -d $SL
```

Caso prefira baixar via terminal use [curl](https://man.cx/curl) ou [wget](https://man.cx/wget):

```bash
# Define o caminho para a pasta Selenium em uma variável de ambiente temporária
export SL="$HOME/Selenium"  
# cria a pasta Selenium de acordo com o caminho escolhido
mkdir -vp $SL  
# Realiza o download da versão 4.16.1 e extrai para a pasta Selenium com curl
curl -fsSL https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.16.0/selenium-java-4.16.1.zip -o temp.zip && unzip -d $SL temp.zip && rm temp.zip
```

```bash
# Define o caminho para a pasta Selenium em uma variável de ambiente temporária
export SL="$HOME/Selenium"  
# cria a pasta Selenium de acordo com o caminho escolhido
mkdir -vp $SL  
# Realiza o download da versão 4.16.1 e extrai para a pasta Selenium com wget
wget -qO - https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.16.0/selenium-java-4.16.1.zip > temp.zip && unzip -d $SL temp.zip && rm temp.zip
```

Para automação com Selenium é recomendado instalar os [WebDrivers](#o-que-são-webdrivers) apropriados para os navegadores que você deseja controlar.

Embora no caso do Selenium com Java não seja obrigatório o uso de WebDrivers, mesmo assim podem ser úteis. Os WebDrivers fornecem uma série de recursos que podem tornar mais fácil e eficiente controlar um navegador da web. Por exemplo, eles fornecem métodos para localizar elementos na página da web, interagir com elementos na página da web e manipular o estado do navegador.

### Maven, eu escolho você!

Existem opções de configuração de dependências para serem utilizadas com o Selenium, seja via [![`pom.xml`]](/pom.xml_template) através do [Apache Maven](https://maven.apache.org/) ou [Gradle](https://gradle.org/).
Escolhi usar o Maven por ser uma ferramenta de fácil utilização e já é integrada a algumas IDEs para desenvolvimento Java como [IntelliJ](https://download-cdn.jetbrains.com/idea/ideaIC-2023.3.1.tar.gz), [Eclipse](https://archive.eclipse.org/technology/epp/downloads/release/kepler/SR1/eclipse-java-kepler-SR1-linux-gtk-x86_64.tar.gz) e [NetBeans](https://dlcdn.apache.org/netbeans/netbeans/20/netbeans-20-bin.zip)

```bash
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <groupId>org.your_project.name</groupId>
    <artifactId>SeleniumTraining01</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-commons</artifactId>
            <version>1.10.1</version>
        </dependency>
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-launcher</artifactId>
            <version>1.10.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.9.0</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0</version>
                <configuration>
                    <systemProperties>
                        <property>
                            <key>webdriver.gecko.driver</key>
                            <value>/path/to/your/drivers/folder</value>
                        </property>
                    </systemProperties>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
#### O que são WebDrivers?

WebDrivers são softwares que permitem que você controle um navegador da web usando um software. Eles são usados em uma variedade de aplicações, incluindo automação de testes de software, desenvolvimento web e pesquisa.

Cada navegador da web tem seu próprio WebDriver. Por exemplo, o Google Chrome tem o [ChromeDriver](https://chromedriver.chromium.org/downloads), o Mozilla Firefox tem o [GeckoDriver](https://github.com/mozilla/geckodriver/releases) e o Microsoft Edge tem o [EdgeDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/?ch=1&form=MA13LH).

Os WebDrivers fornecem uma série de recursos que podem tornar mais fácil e eficiente controlar um navegador da web. Por exemplo, os WebDrivers fornecem métodos para localizar elementos na página da web, interagir com elementos na página da web e manipular o estado do navegador.
