import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
	public static void main(String[] args) {

	}

	public void saveHeroToFile(Hero h) throws IOException {
		Writer w = new BufferedWriter(new FileWriter("rpgsave.dat"));
		// このデータの保存形式のルール
		// ファイルには文字情報として勇者の情報を保存する
		// 1行目には名前を、2行目にはHPを、そして3行目にMPを保存する。
		// このように複数のデータをどのような形式・順序で保存するかと言うことを定めたルールのことをデータフォーマットという
		// もしデータフォーマットに従わず順番を間違って読み込んでしまうと重大な不具合になる
		// また、ファイル内のデータ構造を規定するものはファイルフォーマット
		// ネットワーク経由で伝送される一塊りのメッセージのデータ構造を規定するものはメッセージフォーマットまたは、電文フォーマットと呼ばれている
		w.write(h.name +"\n"); // 末尾に改行をつけて保存
		w.write(h.hp +"\n");
		w.write(h.mp +"\n");
		w.flush();
		w.close();
	}
}
