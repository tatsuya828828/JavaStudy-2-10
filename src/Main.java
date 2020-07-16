import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		String s = "ミナト,アサカ,スガワラ";
		// StringTokenizerクラスは、指定したデリミタで文字列分割して、それぞれのデータを順次取得する機能を提供する
		StringTokenizer st = new StringTokenizer(s, ","); // カンマをデリミタ指定
		// hasMoreTokenで次のトークンがあるか検査
		while(st.hasMoreTokens()) {
			// nextTokenで次のトークンを指定
			String t = st.nextToken();
			System.out.println(t);
		}

		// より厳密なCSVの操作には、opencsvやOrangeSignal CSVなどCSV処理専用の機能を持つライブラリを利用した方が良い
	}

	public void saveHeroToFile(Hero h) throws IOException {
		Writer w = new BufferedWriter(new FileWriter("rpgsave.dat"));
		// 複数のデータを間まで区切って順に格納するデータフォーマットの形式をCSV形式と呼ぶ
		// CSV内でデータを区切るために使うもじはデリミタと呼ばれる
		// デリミタには、通常カンマが使われるが、スペースやタブ文字などを使うこともできる
		w.write(h.name);
		w.write(",");
		w.write(h.hp);
		w.write(",");
		w.write(h.mp);
		w.flush();
		w.close();
	}
}
