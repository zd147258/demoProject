package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> stringList = restoreIpAddresses.restoreIpAddresses("25525511135");
        System.out.println(stringList);
    }

    public List<String> restoreIpAddresses(String s){
        List<String> ipList = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12){
            return ipList;
        }

        return ipList;
    }
}
