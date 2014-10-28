package exam.sjcp.q049;

import java.util.List;

public class Person {

	private String name;
	public Person(String name){
		this.name = name;
	}
	public boolean equals(Person p){
		return p.name.equals(this.name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	List<boolean> a = new ArrayList<boolean>();
}
/*
EffecitveJava_改写equals方法应该遵循的原则
分类： EffecitveJava 2009-08-17 13:53 325人阅读 评论(0) 收藏 举报
equalsfileobjectclassjavanull
改写equals一定要遵循的原则：



1，自反性（refexive）。对于任意的引用值x，x.equals(x)一定为true。

2，对称性（symmetric）。对于任意的引用值x和y，当且仅当x.equals(y)时，y.equals(x)也一定为true。

3，传递性（transitive）。对于任意的引用值x，y和z，如果x.equals(y)为true，y.equals(x)为true，那么x.equals(z)也一定返回 

    true。

4，一致性（consistent）。如果x.equals(y)为true，并且x，y一直没有改变，则x.equals(y)为true.

5，x.equals(null)为false。

6，改写equals方法一定要改变hashcode方法



java中关于hashcode的规范：

1，在一个应用程序执行期间，如果一个对象的equals方法作比较所用到的信息没有被修改的话，那么，对该对象调用hashcode多次，他应

    该始终如一地返回同一个整数。

2，如果两个对象根据equals（Object）方法是相等的，那么调用者两个对象任一一个对象的hashcode方法必须产生同样的整数结果。

3，如果两个对象根据equals（Object）方法是不相等的，那么并不要求调用者两个对象任一一个对象的hashcode方法必须产生不同样的整数结果。



一个完整的例子：

public class EqualOverride {
private int file1;

private int file2;

private int file3;

public boolean equals(EqualOverride e) {
 if (e == this)
  return true;
 if (!(e instanceof EqualOverride)) {
  return false;
 }
 EqualOverride e1 = (EqualOverride) e;
 return e1.file1 == this.file1 && e1.file2 == this.file2
   && e.file3 == this.file3;
}

public int hashcode() {
 int result = 17;
 result = 37 * result + file1;
 result = 37 * result + file2;
 result = 37 * result + file3;
 return result;
}
}
http://see.xidian.edu.cn/cpp/html/1755.html*/

