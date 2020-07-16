import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
	String name;
	int age;

	Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Department implements Serializable {
	String name;
	Employee leader;

	Department(String name, Employee leader) {
		this.name = name;
		this.leader = leader;
	}
}

class Main2 {
	public static void main(String[] args) {
		Employee emp = new Employee("田中太郎", 41);
		Department d = new Department("総務部", emp);
		// データの書き込み
		try(FileOutputStream fos = new FileOutputStream("10_07.dat")){
			try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(d);
			} catch(IOException e) {
				System.out.println("エラーが発生しました");
				e.printStackTrace();
			}
		} catch(IOException e) {
			System.out.println("エラーが発生しました");
			e.printStackTrace();
		}
	}
}
