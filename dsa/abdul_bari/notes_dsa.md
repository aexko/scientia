# Abdul Bari's class on DSA

## 1.1 - Priori analysis and Posteriori Testing

### Priori Analysis
1. Algorithm
2. Language independent
3. Hardware independent
4. Time and space function

### Posteriori Testing
1. Program
2. Language depedent
3. Hardware dependent
4. Watch time & bytes

## 1.2 - Characteristics of Algorithm
1. Input - 0 or more inputs
2. Output - at least 1 output
    - like in C functions
3. Definiteness
    - should not be ambiguous
    - sqrt(-1) is not good
4. Finiteness
5. Effectiveness
    - no unnecessary statements

## 1.3 - How to write and analyze an algorithm

AlgorithmSwap(a,b)
{
    temp = a;
    a = b;
    b = temp;
}

Different symbols can be used depending the programming language, but the general syntax looks like this:

### How to analyze an algorithm
1. Time
    - how much time does it take for the function to run
2. Space
    - how much space does the function take
3. Network consumption
    - how much data is being transferred
4. Power
    - how much power is it consuming
5. CPU registers
    - for system level programming
    - how many registers is it consuming

#### Space analysis
- a, b, temp, this is O(1)

## 1.4 Frequency Count method

### Sum of array
Algorithm_Sum(A, n)
{
    sum = 0;                  # this is done once
    for (i = 0; i < n; i++)   # this is n + 1 because i < n is checked n + 1 (6 times here), and it's the highest. i = 0 is 1. i++ is n.
    {
        sum = sum + A[i];     # this is n because the statement is executed 5 times
    }
    return sum;               # this is done once
}
So the answer for the time complexity would be f(n)=2n+3, so O(n) and that means order of n for now (we are going to see the Big O notation later)

#### Space complexity
A is n
n is 1
sum is 1
i is 1
So the answer for space complexity would be s(n)=n+3, so O(n)

### Sum of 2 matrices
Assume it's 3 * 3 (n * n)
Algorithm_Add(A,B,n)
{
    for (i = 0; i < n; i++)            # n + 1
    {
        for (j = 0; j < n; j++)        # n * (n+1)
        {
            [i,j] = A[i,j] + B[i,j];   # n * n
        }
    }
}

So time complexity: f(n)=2n^2+2n+1, the biggest degree is ^2, so we write O(n^2) 
#### Space complexity
A is n^2 
B is n^2 
C is n^2 
n is 1 
i is 1 
j is 1 
So space complexity: s(n)=3n^2+3, so O(n^2)

### Multiplication of 2 matrices
Algorithm_Multiply(A,B,n)
{
    for (i = 0; i < n; i++)                   # n + 1
    {
        for (j = 0; j < n; j++)               # n (n+1)
        {
            for (k = 0; k < n; k++)           # n * n (n+1)
            {
                c[i,j]=c[i,j]+A[i,k] * B[k,j]   # n * n * n
            }
        }
    }
}

So time complexity: 2^3 + 3n^2 + 2n + 1, so O(n^3)
#### Space complexity
A is n^2 
B is n^2 
C is n^2 
n is 1 
i is 1
j is 1 
k is 1
So space complexity: s(n)=3n^2+4, so O(n^2)

## 1.5.1 Time complexity #1 

for (i = 0; i < n; i++) --- n + 1
{
    smt; --- n
}
so it's O(n)

for (i = n; i > 0; i--)
{
    smt; --- n
}
so it's 0(n) too

for (i = 1; i < n; i=i+2)
{
    smt; --- n/2
}
f(n) = n/2, still O(n)

for (i = 0; i < n; i++) ---- n+1 
{
    smt; ------ n*n
}
so it's O(n^2)

for (i = 0; i < n; i++)
{
    for (j = 0; j < i, j++)
    {
        smt;
    }
}

| i    | j    | nb of times |
|----- | ---- | ------------|
| 0    | 0 x  | 0           |
| 1    | 0    |             |
|      | 1 x  | 1           |
| 2    | 0    |             |
|      | 1    |             |
|      | 2 x  | 2           |
| 3    | 0    |             |
|      | 1    |             |
|      | 2    |             |
|      | 3 x  | 3           |

1 + 2 + 3 + ... + n = (n(n+1)) / 2
f(n)= (n^2 + 1)/2


for (i = 1; p <= n; i++)
{
    p = p + i;
}

| i | p            |
|---|--------------|
| 1 | 0+1=1        |
| 2 | 1+2=3        |
| 3 | 1+2+3        |
| 4 | 1+2+3+4      |
| k | 1+2+3+4+...+k|

Assume p > n, the condition stops
so, p = (k(k+1))/2 
      = (k(k+1))/2 > n
      = k^2 > n
      = k   > sqrt(n)
      O(sqrt(n))
