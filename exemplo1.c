#include <stdio.h>
#include <pthread.h>

/* #define LIMIT 10000 */
#define LIMIT 10000 

int shared = 0;        /* variavel compartilhada pelas threads */

void delay() {
  for (int m=0; m<=LIMIT;m++) {}
}

void prog1 (int * k) { /* prog1 sera' uma das threads */
  int j,m,tmp;
  for (j=1;j<=*k;j++) {
    delay(); /* apenas para demorar um pouco */
    tmp = shared;
    tmp = tmp + 1;
    delay(); /* apenas para demorar um pouco */
      printf(".%d.\n",tmp);
    shared = tmp;
    delay(); /* apenas para demorar um pouco */
  }
  printf(".-> %d\n",shared);
}

void prog2 (int * k) {
  int j,m,tmp;
  for (j=1;j<=*k;j++) {
    delay(); /* apenas para demorar um pouco */
    tmp = shared;
    tmp = tmp + 1;
    delay(); /* apenas para demorar um pouco */
      printf("*%d*",tmp);
    shared = tmp;
    delay(); /* apenas para demorar um pouco */
  }
  printf("*-> %d\n",shared);
}

int main (void) {
  pthread_t thread1, thread2;
  pthread_attr_t attr;
  int a;
  pthread_attr_init(&attr); /* initialize attr with default attributes */
  pthread_attr_setscope(&attr, PTHREAD_SCOPE_SYSTEM);  /* system-wide 
                                                          contention */
  a = 100;
  /* cria as duas threads */
  pthread_create(&thread1, &attr, (void *) prog1, (void *) &a);
  pthread_create(&thread2, &attr, (void *) prog2, (void *) &a);
  /* espera as threads terminarem */
  pthread_join(thread1, NULL);
  pthread_join(thread2, NULL);
  printf("--> %d\n",shared);
}
