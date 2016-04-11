public:
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    int reverseInteger(int n) {
        // Write your code here
        bool isNeg = (n<0);
        if(isNeg) n *= -1;
        int r = n%10;
        
        for(int i = n/10; i > 0; i = i/10) {
            r *= 10;
            r += i%10;
            if(r >INT_MAX/10 ) {return 0;}
        }
        
        if(isNeg) r = -1*r;
        return r;
    }
};
