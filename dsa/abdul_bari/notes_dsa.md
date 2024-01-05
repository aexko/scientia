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
