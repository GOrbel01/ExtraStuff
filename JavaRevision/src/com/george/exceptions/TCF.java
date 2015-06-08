package com.george.exceptions;

/**
 * Created by Cloud on 08/06/2015.
 */
public class TCF {
    public static void main(String[] args) {
        try {
            System.out.println(getTested());
        }
        catch (OwnException ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("Block Over");
        }
    }

    public static String getTested() throws OwnException {
        return "Found It!";
    }
}
