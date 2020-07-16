import java.io.Serializable;
// あるインスタンスの内容(全フィールド)を1つの命令呼び出しで丸ごとそのままバイト列に変換したり、
// その逆にバイト列をインスタンスに戻したりするための仕組みをを直列化という
// 直列化されるクラスはSerializableを実装しなければならない
public class Hero implements Serializable {
	private String name;
	private int hp, mp;
	// 直列化したSwordクラスをフィールドに使うと、Swordインスタンスも連鎖して直列化される
	private Sword sword;

	public Hero(String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.sword = new Sword();
	}

	public Hero(String name) {
		this(name, 100, 50);
	}

	public Hero() {
		this("たかし", 100, 50);
	}

	public String toString() {
		return "名前:"+ this.name + "/HP:"+ this.hp + "/MP:"+ this.mp
				+"\n武器:"+ this.sword.getName();
	}
}
