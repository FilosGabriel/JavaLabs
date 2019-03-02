package ex1;

public class Main {

    public static int computeNumber()
    {
        int n = (int)(Math.random() * 1_000_000);
        n = (n*3 + 0b10101 + 0xFF) * 6;
        return n;
    }

    public static int sumOfNumber(int n)
    {
        int sum=0;
        while (n>0)
        {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};
        int n = computeNumber();
        int sum = 0;
        while (n > 9)
            n = sumOfNumber(n);
        System.out.println("Willy-nilly, this semester i will learn " + languages[n]);
    }
}
