# Programação Concorrente (CIN0145) — Recursos

Regra deste workspace (ver `CLAUDE.md` em `~/UFPE`): as lições só usam o que está
**explicitamente** no material abaixo. Conhecimento externo só entra com autorização do usuário.

## Knowledge

### Material da disciplina (na pasta raiz)

- [Slides: `11-Concorrencia.pdf` — Paulo Borba, "Conceitos Básicos de Concorrência"](./11-Concorrencia.pdf)
  Introdução conceitual com Java: execução sequencial vs. concorrente, comandos não atômicos,
  não determinismo, interferência, `synchronized`, `Thread`/`Runnable`, `wait`/`notify`/`notifyAll`,
  deadlock e livelock. Use para: fundamentos e concorrência em Java. 41 slides.
- [Slides: `03-ExclusaoMutua.pdf` — André Santos, "O Problema da Exclusão Mútua"](./03-ExclusaoMutua.pdf)
  Seção crítica, pré/pós-protocolo, as 4 tentativas e suas falhas (deadlock, starvation, livelock),
  algoritmo de Dekker, algoritmo da padaria, Test-and-Set e Exchange. Use para: provas de
  exclusão mútua e soluções por software/hardware. 30 slides.
- [Slides: `04-semaforos1.pptx.pdf` — André Santos, "Semáforos (parte 1)"](./04-semaforos1.pptx.pdf)
  P/V, invariante do semáforo, tipos (binário, genérico, blocked-set, blocked-queue, busy-wait,
  strongly/weakly-fair), produtor-consumidor (buffer 1, circular, múltiplos), jantar dos filósofos.
  Use para: raciocinar com invariantes e padrões clássicos. 29 slides.
- [Slides: `05-monitores.pdf` — André Santos, "Monitores"](./05-monitores.pdf)
  Monitores como ADT, exclusão mútua implícita, variáveis de condição (`wait`, `signal`, `empty`),
  produtor-consumidor, leitores-escritores, emulação de semáforos, barbeiro que dorme.
  Use para: sincronização de condição estruturada. 26 slides.
- [Slides: `07-distribprog.pdf` — André Santos, "Programação Distribuída (troca de mensagens)"](./07-distribprog.pdf)
  `send`/`receive`, canais, comunicação síncrona (rendezvous) vs. assíncrona (buffering),
  identificação de processos, criação estática vs. dinâmica, filtros/clientes/servidores/peers.
  Use para: modelo sem memória compartilhada. 21 slides.
- [Slides: `08-Ada.pdf` — André Santos, "Ada (Rendezvous)"](./08-Ada.pdf)
  Tasks, `entry`/`accept`, semântica do `select` (guardas `when`, `else`, `delay`, `terminate`),
  buffer limitado, simulação de semáforo, polling, arrays de tasks, ponte Ada → Go. 26 slides.
- [Slides: `09c-Go.pdf` — André Santos, "Go"](./09c-Go.pdf)
  Goroutines, channels (CSP, Tony Hoare), scheduler M:N, canais uni/bidirecionais,
  buffered channels, `select` com timeout. 14 slides.
- [Slides: `09b-Linda.pdf` — André Santos, "Linda"](./09b-Linda.pdf) (adicionado 2026-11-21)
  Espaço de tuplas, casamento de padrões, `Output`/`Input`/`Read`/`Try_Input`/`Try_Read`, exemplos (job, RPC,
  multiplicação de matrizes com workers), independência de tempo, espaço, nomes e existência dos processos,
  vantagens e desvantagem (eficiência). 12 slides. Use para: Prova 3 Q2 e coluna Linda da Q5 de 2026-1.
- [Slides: `12-erlang-v2.pdf` — André Santos, "Programação Concorrente em Erlang"](./12-erlang-v2.pdf) (adicionado 2026-11-21)
  Por que Erlang, características (comunicação assíncrona e unidirecional), sintaxe, `spawn`/`!`/`receive`,
  caixa-postal e ordem de recebimento, `after` (timeout), processos registrados, cliente-servidor, `link`/EXIT,
  primitivas distribuídas, exemplo de banco. 32 slides. Use para: Q5 e Q6 de 2026-1.
- [Prova: `Exemplo Prova Concorrencia 2026.pdf` — prova de 2026-1, André Santos, 8 jun. 2026](./Exemplo%20Prova%20Concorrencia%202026.pdf)
  7 questões, 10 pontos: deadlock/livelock/starvation, simulação de semáforos, monitores vs. semáforos,
  `synchronized` em Java, tabela Java/Erlang/Ada/Linda, `receive` em Erlang, leitores-escritores em Java.
  Use para: calibrar o estilo das questões e como simulado final. Análise em `reference/guia-da-prova.html`.
- [Provas antigas: `Provas-Concorrencia-antigas.pdf` — "Provas de Concorrência" 1, 2 e 3, sem data nem autor](./Provas-Concorrencia-antigas.pdf)
  13 questões dissertativas: dificuldades da concorrência, monitores (inclusive "em C"), rendezvous,
  monitores vs. mensagens, leitores-escritores (o código do `05` s.17–19), propriedades de uma solução,
  filósofos em Ada, exclusão mútua distribuída, Linda, classificação de sistema distribuído, servidor web.
  Use para: treinar respostas escritas. Análise em `reference/guia-da-prova.html`.
- [Código: `exemplo1.c`](./exemplo1.c)
  Duas pthreads incrementam `shared` 100 vezes cada, com `delay()` entre ler e gravar.
  Use para: observar interferência na prática (compila com `cc -o exemplo1 exemplo1.c`).

### Bibliografia básica (captura de tela na pasta)

1. M. Ben-Ari. *Principles of Concurrent and Distributed Programming*. Addison-Wesley, 2ª ed., 2006.
   (Existe a 1ª edição, mesmo título, 1990, Prentice-Hall.) Indicada como referência principal.
2. Gregory R. Andrews. *Foundations of Multithreaded, Parallel, and Distributed Programming*. Addison-Wesley, 2000.
3. Matthew J. Sottile, Timothy G. Mattson, Craig E. Rasmussen. *Introduction to Concurrency in Programming Languages*. Chapman and Hall/CRC, 2009.

Mapeamento tópico → capítulo (autorizado pelo usuário em 2026-11-03; única informação externa ao material):
ver a seção "Leitura nos livros" em `reference/mapa-do-curso.html`. Sumários obtidos de:
- Ben-Ari, 2ª ed.: caps. 1–5 com seções, da página da Pearson
  (https://www.pearson.com/store/en-gb/p/principles-of-concurrent-and-distributed-programming/P200000003698/9780321312839);
  caps. 6–13 apenas por título, de listagens secundárias (a página do autor estava fora do ar).
- Andrews: sumário completo na página do autor (https://www2.cs.arizona.edu/~greg/mpdbook/contents.html).
- Sottile et al.: só títulos de capítulos, da Routledge (https://www.routledge.com/product/isbn/9781420072136).

### Referências citadas dentro dos slides (`11-Concorrencia.pdf`, slide 41)

- Sérgio Soares. *Desenvolvimento Progressivo de Programas Concorrentes Orientados a Objetos*. Dissertação de Mestrado, 2001.
- Sérgio Soares e Paulo Borba. *Controle de Concorrência com Java e Bancos de Dados Relacionais*. V SBLP, 2001.
- Sérgio Soares e Paulo Borba. *Concurrency Manager*. SugarLoafPLoP 2001.

## Wisdom (Communities)

- Ainda não definido. Candidatas naturais: a própria turma/monitoria da disciplina CIN0145 (CIn-UFPE).
  Perguntar ao usuário se quer sugestões de comunidades externas.

## Gaps

- Seções dos caps. 6–13 do Ben-Ari e seções do Sottile ainda não confirmadas (só títulos de capítulo).
- Não há material na pasta para os módulos numerados 01, 02, 06, 09a/09b, 10 (a numeração sugere que existem).
- **Exclusão mútua em sistema distribuído** (Prova 2 Q4) e **monitores implementados em C** (Prova 1 Q2): sem slide específico.
- ~~Erlang e Linda~~: resolvido em 2026-11-21 com `09b-Linda.pdf` e `12-erlang-v2.pdf`. (Antes: aparecem na prova (Q5, Q6; Linda também na Prova 3 Q2, 2,5 pts) e não há nenhum slide sobre eles na pasta. Pedido ao usuário em 2026-11-03.
- `exemplo1.c` não vem com enunciado; o uso como exercício é decisão deste workspace.
