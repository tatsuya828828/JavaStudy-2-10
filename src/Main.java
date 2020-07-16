import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

public class Main {
	public static void main(String[] args) {
		try(Writer fw = new FileWriter("pref.properties")){
			Properties p = new Properties();
			p.setProperty("tokyo.capital", "東京");
			p.setProperty("tokyo.food", "寿司");
			p.setProperty("aichi.capital", "名古屋");
			p.setProperty("aichi.food", "味噌カツ");
			p.store(fw, "名物");
		} catch(IOException e) {
			System.out.println("エラーです");
			e.printStackTrace();
		}

		try(Reader fr = new FileReader("pref.properties")){
			Properties p = new Properties();
			p.load(fr);
			String capital = p.getProperty("aichi.capital");
			String food = p.getProperty("aichi.food");
			System.out.println(capital +":"+ food);
		} catch(IOException e) {
			System.out.println("エラーです");
			e.printStackTrace();
		}
	}
}
