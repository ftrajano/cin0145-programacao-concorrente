// Demonstração de start() e join(). Thread.sleep não está no material:
// serve só para deixar a execução lenta o bastante para ser vista.
class Trabalhador extends Thread {
  private String nome;
  Trabalhador(String n) { nome = n; }
  public void run() {
    for (int i = 1; i <= 3; i++) {
      System.out.println("   " + nome + ": passo " + i);
      try { Thread.sleep(100); } catch (InterruptedException e) {}
    }
    System.out.println("   " + nome + ": terminei");
  }
}

public class StartJoin {
  public static void main(String[] args) throws InterruptedException {
    boolean usarJoin = args.length == 0 || !args[0].equals("semjoin");
    Thread a = new Trabalhador("A");
    Thread b = new Trabalhador("B");
    System.out.println("main: criei A e B (nada rodou ainda)");
    a.start();
    System.out.println("main: chamei a.start() e já voltei");
    b.start();
    System.out.println("main: chamei b.start() e já voltei");
    if (usarJoin) {
      System.out.println("main: vou esperar no join...");
      a.join();
      b.join();
      System.out.println("main: join voltou, A e B terminaram");
    }
    System.out.println("main: fim do main");
  }
}
