import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

public class Main {
	public static void main(String[] args) {
		// プロパティファイル形式の書き込み
		// Propertiesクラスは、全てのデータを文字列として扱う
		// 各行にはキーと値をペアとして、それらをペアデリミタで区切って記述する
		// ペアデリミタは、イコール、コロン、空白のいずれかの文字
		// シャープまたは感嘆符(!)で始まる行はコメントとして無視される
		// ファイルの拡張子には.propertiesが用いられるといったルールなどがある

		try(Writer fw = new FileWriter("rpgsave.properties")){
			Properties p = new Properties();
			p.setProperty("heroName", "アサカ"); // データのセット
			p.setProperty("heroHp", "62");
			p.setProperty("heroMp", "45");
			// setPropertyメソッドは呼び出すだけでファイルには書き込まないので必ずstoreメソッドで保存を行う
			p.store(fw, "勇者の情報"); // ファイルへ書きだす、引数はファイルの先頭にコメントとして出力される
		} catch(IOException e) {
			System.out.println("セーブに失敗しました");
			e.printStackTrace();
		}

		// プロパティファイル形式の読み込み
		try(Reader fr = new FileReader("rpgsave.properties")){
			Properties p2 = new Properties();
			p2.load(fr); // ファイルの内容を読み込む
			String name = p2.getProperty("heroName"); // キーを指定し取り出す
			String strHp = p2.getProperty("heroHp");
			int hp = Integer.parseInt(strHp);
			System.out.println("勇者の名前:"+ name);
			System.out.println("勇者のHP:"+ hp);
		} catch(IOException e) {
			System.out.println("読み込みに失敗しました");
			e.printStackTrace();
		}
	}
}
