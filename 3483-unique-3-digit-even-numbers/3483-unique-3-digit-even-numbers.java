class Solution {
    public int totalNumbers(int[] digits) {
        int res = 0;

        int[] f = new int[10];
        for(int d : digits) f[d]++;

        for(int i = 1 ; i < 10 ; i++){ if(f[i] == 0) continue; // fir -> [1:9]
            for(int j = 0 ; j < 10 ; j++){ if(f[j] == 0) continue; // sec -> [0:9]
                for(int k = 0 ; k <= 8 ; k+=2){ if(f[k] == 0) continue;// thd -> [2,4,6,8]
                    f[i]--; f[j]--; f[k]--;
                    if(f[i] >= 0 && f[j] >= 0 && f[k] >= 0) res++;
                    f[i]++; f[j]++; f[k]++;
                }
            }
        }

        return res;
    }
}