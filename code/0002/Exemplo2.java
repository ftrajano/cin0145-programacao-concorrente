// Lição 2 — versão Java do exemplo1.c, seguindo o padrão dos slides
// (subclasse de Thread com run(), start() e join()).
// Tarefa: rode 3 vezes; depois acrescente "synchronized" em incrementar() e rode de novo.

class Contador {
  private int valor = 0;

  void incrementar() {        // <- acrescente synchronized aqui na 2ª etapa
    int tmp = valor;          // 1
    tmp = tmp + 1;            // 2
    valor = tmp;              // 3
  }

  int getValor() { return valor; }
}

class Incrementador extends Thread {
  private Contador c;
  Incrementador(Contador c) { this.c = c; }
  public void run() {
    for (int i = 1; i <= 100000; i++) c.incrementar();
  }
}

public class Exemplo2 {
  public static void main(String[] args) {
    Contador c = new Contador();
    Thread a = new Incrementador(c);
    Thread b = new Incrementador(c);
    a.start(); b.start();                       // a.incrementar()*100000 || b.incrementar()*100000
    try { a.join(); b.join(); } catch (InterruptedException e) {}
    System.out.println("--> " + c.getValor());
  }
}
