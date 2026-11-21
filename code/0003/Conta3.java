// Lição 3: debitar espera (wait) até haver saldo; creditar avisa (notifyAll).
// Uso: java Conta3 <valor do crédito>     ex.: java Conta3 100   ou   java Conta3 60
//
// Cenário: saldo começa em 0. Duas threads tentam debitar 50 cada; só depois
// uma terceira thread credita o valor passado na linha de comando.
//
// Tarefas (lição 3, Prática 3):
//   Etapa 1: rode como está com 100 e com 60.
//   Etapa 2: troque notifyAll() por notify() e rode com 100.
//   Etapa 3: volte para notifyAll() e troque o while por if. Rode com 60.

class Conta {
  private double saldo = 0;

  synchronized void debitar(String quem, double v) throws InterruptedException {
    while (saldo < v) {                 // <- Etapa 3: troque while por if
      System.out.println(quem + ": saldo " + saldo + " < " + v + ", vou esperar (wait)");
      wait();
      System.out.println(quem + ": fui notificada, saldo agora " + saldo);
    }
    saldo = saldo - v;
    System.out.println(quem + ": debitei " + v + ", saldo agora " + saldo);
  }

  synchronized void creditar(double v) {
    saldo = saldo + v;
    System.out.println("C: creditei " + v + ", saldo agora " + saldo);
    notifyAll();                        // <- Etapa 2: troque por notify()
  }

  synchronized double getSaldo() { return saldo; }
}

class Debito extends Thread {
  private Conta conta; private double val; private String nome;
  Debito(String n, Conta c, double v) { nome = n; conta = c; val = v; }
  public void run() {
    try { conta.debitar(nome, val); } catch (InterruptedException e) {}
  }
}

class Credito extends Thread {
  private Conta conta; private double val;
  Credito(Conta c, double v) { conta = c; val = v; }
  public void run() { conta.creditar(val); }
}

public class Conta3 {
  public static void main(String[] args) throws InterruptedException {
    double credito = Double.parseDouble(args[0]);
    Conta c = new Conta();
    Thread d1 = new Debito("D1", c, 50);
    Thread d2 = new Debito("D2", c, 50);
    d1.start(); d2.start();

    // Fora do material, só para a demonstração: dar tempo para D1 e D2
    // chegarem ao wait() antes do crédito.
    Thread.sleep(300);

    Thread cr = new Credito(c, credito);
    cr.start();
    cr.join();

    // Fora do material: em vez de join() nas threads de débito (que poderia
    // esperar para sempre), espera um pouco e mostra quem ainda está parada.
    Thread.sleep(300);
    System.out.println("--> saldo final: " + c.getSaldo());
    System.out.println("--> D1 ainda esperando? " + d1.isAlive());
    System.out.println("--> D2 ainda esperando? " + d2.isAlive());
    System.exit(0);
  }
}
