package com.ssafy.h_exception.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResource {

    public static void main(String[] args) {
        TryWithResource test = new TryWithResource();
        test.useStream();
        test.useStreamNewStye();

    }

    public void useStream() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("abc.txt");
            fileInput.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void useStreamNewStye() {
        // TODO: useStream을 try~with~resource 문장으로 변경하세요.
    	try(FileInputStream fis= new FileInputStream("abc.txt")) {
    		fis.read();
    	}
        // END
    	catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
