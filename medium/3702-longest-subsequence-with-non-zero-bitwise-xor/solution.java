            for(int j = 0; j <= i; j++){
                xor^= nums[j]; 
            xor = 0;
                if(xor>max_xor){
                    max_xor = xor;
                }
                    length = j;
            }
        }
    }
        return length;
}
        for(int i = 0; i < nums.length; i++){
