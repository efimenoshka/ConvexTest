class Main {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        while (true) {
            convex.add(new R2Point());  //метод переменной класса(новая точка)
            System.out.println("S = " + convex.area() + " , P = " + convex.perimeter());

        }
    }
}