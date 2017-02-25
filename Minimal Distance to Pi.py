#!/bin/python
# your code goes here
import math

pi_frac = [3,7,15,1,292,1,1,1,2,1,3,1,14,2,1,1,2,2,2,2,1,84,
 2,1,1,15,3,13,1,4,2,6,6,99,1,2,2,6,3,5,1,1,6,8,1,
 7,1,2,3,7,1,2,1,1,12,1,1,1,3,1,1,8,1,1,2,1,6,1,1,
 5,2,2,3,1,2,4,4,16,1,161,45,1,22,1,2,2,1,4,1,2,24,
 1,2,1,3,1,2,1]

approximations = []

def display(n, d, exact,min,max):
    approximations.append([n,d, n/d-exact])

def approx(a, exact,min,max):
    # initialize the recurrence
    n0 = a[0]
    d0 = 1
    n1 = a[0]*a[1] + 1
    d1 = a[1]

    display(n0, d0, exact,min,max)
    display(n1, d1, exact,min,max)

    for x in a[2:]:
        n = x*n1 + n0 # numerator
        d = x*d1 + d0 # denominator
        display(n, d, exact,min,max)
        n1, n0 = n, n1
        d1, d0 = d, d1


approx(pi_frac, math.pi,min,max)

min,max = raw_input().strip().split(' ')
min,max = [long(min),long(max)]

pi=3.1415926535897932384626433832795028841971693993751
approx = pi
num = ""
den = ""
for i in approximations:
    if min <= i[1] <= max:
        if approx >= i[2]:
            approx = i[2]
            num = str(i[0])
            den = str(i[1])
 
print num + "/" + den
