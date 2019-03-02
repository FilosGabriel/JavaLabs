package ex2;

public class Main {

    private static int max(int[] k)
    {
        int max=Integer.MIN_VALUE;
        for (int i1 : k)
            if (max < i1)
                max = i1;
        return max;
    }

    private static int min(int[] k)
    {
        int min=Integer.MAX_VALUE;
        for (int i1 : k)
            if (min > i1)
                min = i1;
        return min;
    }

    private static int sum(int[] k)
    {
        int sum=0;
        for (int i1 : k) sum += i1;
        return sum;
    }

    public static void main(String[] args)
    {
        GraphGenerator graph = new GraphGenerator();
        if (args.length<2)
        {
            System.out.println("Nu ati introdus destui parametrii ");
            System.exit(-1);
        }
        graph.n=Integer.parseInt(args[0]);
        if (graph.n%2==0)
            System.out.println("Numarul este par.");
        graph.m=new int[graph.n][graph.n];
        graph.degreeVertex=new int[graph.n];
        switch (args[1]) {
            case "complete":
                graph.generateComplete();
                break;
            case "cycle":
                graph.generateCycle();
                break;
            case "random":
                graph.generateRandom();
                break;
            default:
                System.out.println("Trebuie sa introduceti complete, cycle sau random pentru al doilea parametru");
                System.exit(-1);
        }
        graph.afisare();
        System.out.println("Suma gradelor = " + sum(graph.degreeVertex) + " = dublul numarului de muchii = " + graph.nrOfEdges*2);
        System.out.println("\u0394(G) = " + max(graph.degreeVertex) + " and \u03B4(G) = " + min(graph.degreeVertex));
        if (max(graph.degreeVertex) == min(graph.degreeVertex))
            System.out.println("Graful este regular");
        else System.out.println("Graful nu este regular");

    }

}
