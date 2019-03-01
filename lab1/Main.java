

public class Main {

	public static int calculare(int n) { return (n * 3 + 0b10101 + 0XFF) * 6; }

	public static int sumOfDigits(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		if (sum > 9)
			return sumOfDigits(sum);
		return sum;
	}


	public static void main(String[] args) {
		System.out.println("Hello World!");
		String[] languages = {"C", "C++", "c#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};
		int n = (int) (Math.random() * 1_000_000);
		int result = sumOfDigits(calculare(n));
		System.out.println(result);
		System.out.println("Willy-nilly,this semester I will learn " + languages[result]);
	}
}
//
//1231*3+
