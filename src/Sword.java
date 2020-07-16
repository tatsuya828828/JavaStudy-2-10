import java.io.Serializable;
// Swordクラスも直列化する
public class Sword implements Serializable {
	String name;
	int atk;

	public Sword() {
		this.name = "木の棒";
		this.atk = 5;
	}

	public String getName() {
		return this.name;
	}
}
