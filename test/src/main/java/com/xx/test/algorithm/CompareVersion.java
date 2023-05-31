package com.xx.test.algorithm;


public class CompareVersion {
    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
//        System.out.println(compareVersion.compareVersion("1.0.1", "1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        for (int i = 0; i < Math.min(split1.length, split2.length); i++) {
            if (Integer.parseInt(split1[i]) == Integer.parseInt(split2[i])){continue;}
            else if (Integer.parseInt(split1[i]) > Integer.parseInt(split2[i])){return 1;}
            else {return -1;}
        }
        if (split1.length > split2.length){
            for (int i = split2.length; i < split1.length; i++) {
                if (Integer.parseInt(split1[i]) > 0){
                    return 1;
                }
            }
        }
        if (split1.length < split2.length){
            for (int i = split1.length; i < split2.length; i++) {
                if (Integer.parseInt(split2[i]) > 0){
                    return -1;
                }
            }
        }
        //精简版
        for(int n = 0; n < Math.max(split1.length, split2.length); n++){
            int i = (n < split1.length ? Integer.valueOf(split1[n]) : 0);
            int j = (n < split2.length ? Integer.valueOf(split2[n]) : 0);
            if(i < j) {return -1;}
            else if(i > j) {return 1;}
        }
        return 0;
    }
}
