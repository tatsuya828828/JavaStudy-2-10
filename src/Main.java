import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		Hero hero1 = new Hero("ミナト", 75, 30);
		// インスタンスの直列化と保存
		try(FileOutputStream fos = new FileOutputStream("rpgsave.dat")){
			try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(hero1);
			} catch(IOException e) {
				System.out.println("エラーです");
				e.printStackTrace();
			}
		} catch(IOException e) {
			System.out.println("エラーです");
			e.printStackTrace();
		}

		// ファイルからインスタンスを復元
		try(FileInputStream fis = new FileInputStream("rpgsave.dat")) {
			try(ObjectInputStream ois = new ObjectInputStream(fis)) {
				Hero hero2 = (Hero) ois.readObject();
				System.out.println(hero2.toString());
			} catch(IOException e) {
				System.out.println("エラーです");
				e.printStackTrace();
			}
		} catch(IOException e) {
			System.out.println("エラーです");
			e.printStackTrace();
		}
	}
}
// Serializableを実装していないクラス型のフィールドは直列化の対象にはならない
// staticがついたフィールドは直列化の対象にはならない
// transientキーワードで修飾したフィールドは直列化の対象にならない
// といったような例外が、直列化にはある
