#include <stdio.h>

int main()
{
    int a = 0, b = 1, c = 2, d = 3, e = 4;
    a = b - c + d * e;

    // ca le fait sans le % a la fin
    printf("%d\n", a);
    // ca le fait avec le % a la fin
    printf("%d", a);

    // toujours mettre return 0
    return 0;
}